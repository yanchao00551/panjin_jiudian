package com.jiudian.modules.app.service.impl;


import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.exception.RRException;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;
import com.jiudian.common.utils.SMSConfig;
import com.jiudian.common.utils.SMSMessage;
import com.jiudian.common.validator.Assert;
import com.jiudian.modules.app.dao.UserDao;
import com.jiudian.modules.app.entity.UserEntity;
import com.jiudian.modules.app.form.LoginForm;
import com.jiudian.modules.app.service.UserService;
import com.jiudian.modules.configthree.entity.SysConfigThreeEntity;
import com.jiudian.modules.configthree.service.SysConfigThreeService;
import com.jiudian.modules.sms.entity.SysNoticeRecordsEntity;
import com.jiudian.modules.sms.entity.SysNoticeTemplateEntity;
import com.jiudian.modules.sms.service.SysNoticeRecordsService;
import com.jiudian.modules.sms.service.SysNoticeTemplateService;
import com.jiudian.modules.smsMsgRecord.entity.SmsMsgRecordEntity;
import com.jiudian.modules.smsMsgRecord.service.SmsMsgRecordService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	SysConfigThreeService sysConfigThreeService;
	@Autowired
	SysNoticeTemplateService sysNoticeTemplateService;
	@Autowired
	SysNoticeRecordsService sysNoticeRecordsService;
	@Autowired
	private SmsMsgRecordService smsMsgRecordService;
	
	@Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserEntity> page = this.selectPage(
                new Query<UserEntity>(params).getPage(),
                new EntityWrapper<UserEntity>()
        );

        return new PageUtils(page);
    }
	
	@Override
	public UserEntity queryByMobile(String mobile) {
		UserEntity userEntity = new UserEntity();
		userEntity.setMobile(mobile);
		return baseMapper.selectOne(userEntity);
	}

	@Override
	public long login(LoginForm form) {
		UserEntity user = queryByMobile(form.getMobile());
		Assert.isNull(user, "手机号或密码错误");

		//密码错误
		if(!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))){
			throw new RRException("手机号或密码错误");
		}

		return user.getUserId();
	}
	
	
	@Override
	public int sendMsg(String templateCode,String mobile,String replaceName) {
		Map<String,Object> map = new HashMap<>();
		map.put("`key`", "MOBILEMESSAGE");
		List<SysConfigThreeEntity> list = sysConfigThreeService.selectByMap(map);
		int getIsUse = list.get(0).getIsUse();
		String config = list.get(0).getValue();
		if(getIsUse == 1) {
			List<SysNoticeTemplateEntity> sysNoticeTemplateList = sysNoticeTemplateService.selectList(new EntityWrapper<SysNoticeTemplateEntity>());
			for(int i=0;i<=sysNoticeTemplateList.size();i++) {
				String tmlpCode = sysNoticeTemplateList.get(i).getTemplateCode();
				if(tmlpCode == templateCode) {
					Integer isEnable = sysNoticeTemplateList.get(i).getIsEnable();
					if(isEnable != 1) {
						return 2;   //未开启短信发送事件
					}
					SysNoticeRecordsEntity sysNoticeRecordsModel = new SysNoticeRecordsEntity();
					sysNoticeRecordsModel.setIsSend("0");
					sysNoticeRecordsModel.setCreateDate((int) (System.currentTimeMillis() / 1000));
					sysNoticeRecordsModel.setSendType(1);
					sysNoticeRecordsModel.setSendAccount(mobile);
					sysNoticeRecordsModel.setNoticeTitle(sysNoticeTemplateList.get(0).getTemplateTitle());
					if(sysNoticeTemplateList.get(0).getSignName() != null) {
						JSONObject jsonObject = JSONObject.parseObject(config); 
						jsonObject.put("freeSignName",sysNoticeTemplateList.get(0).getSignName());
						config = jsonObject.toJSONString();
					}
					sysNoticeRecordsModel.setSendConfig(config);
					sysNoticeRecordsModel.setNoticeContext(replaceName);
					sysNoticeRecordsService.insert(sysNoticeRecordsModel);
					
					boolean rst = this.noticeSmsSend(sysNoticeRecordsModel.getId(), sysNoticeRecordsModel.getSendAccount(),
							sysNoticeRecordsModel.getSendConfig(), sysNoticeRecordsModel.getNoticeContext(), sysNoticeRecordsModel.getNoticeTitle());
					if (!rst) {
						logger.debug("---短信发送失败---");
						logger.debug("发送参数:" + (sysNoticeRecordsModel.getId() + "||" + sysNoticeRecordsModel.getSendAccount() + "||"
								+ sysNoticeRecordsModel.getSendConfig() + "||" + sysNoticeRecordsModel.getNoticeContext() + "||"
								+ sysNoticeRecordsModel.getNoticeTitle()));
					}
					
				}
			}
		}else {
			return 1;  //短信配置未开启
		}
		return 0;
	}
	
	/**
	 * 发送短信
	 * 
	 * @param id
	 * @param sendAccount
	 * @param sendConfig
	 * @param noticeContext
	 * @return
	 */
	private boolean noticeSmsSend(Integer id, String sendAccount, String sendConfig, String noticeContext,
			String templateCode) {
		return sysNoticeRecordsService.noticeSmsSend(id, sendAccount, sendConfig, noticeContext, templateCode);
	}

	@Override
	public int sendValiMsg(String mobile, String valiNum, String remoteIp,String sendType) {
		boolean res = false;
		Map<String, String> params = new HashMap<String, String>();
		params.put("remoteIp", remoteIp);
		params.put("sendType", sendType);
		SmsMsgRecordEntity smsMsgRecordEntity = smsMsgRecordService.queryNewestRecord(params);
		if(smsMsgRecordEntity != null) {
			Date lastDate = smsMsgRecordEntity.getSendTime();
			Date currentDate = Calendar.getInstance().getTime();
			if(currentDate.getTime() - lastDate.getTime() < SMSConfig.SEND_INTERVALS * 1000) {//相同IP相同sendType50s内不能重复发送
				return 1;
			}
		}
		int sentCount = smsMsgRecordService.querySentCount(params);
		if(sentCount >= SMSConfig.MAX_TIMES) {//相同IP相同sendType当天最多发送5条
			return 2;
		}
		Map<String, String> tplMap = new HashMap<String, String>();
		tplMap.put(SMSConfig.KEY_CODE, valiNum);
		tplMap.put(SMSConfig.KEY_MINUTE, "5");
		res = SMSMessage.mobileQuery(mobile, SMSConfig.TPL_CODE, tplMap);
		smsMsgRecordEntity = new SmsMsgRecordEntity();
		smsMsgRecordEntity.setRemoteIp(remoteIp);
		smsMsgRecordEntity.setSendTime(Calendar.getInstance().getTime());
		smsMsgRecordEntity.setSendType(Integer.parseInt(sendType));
		smsMsgRecordService.insert(smsMsgRecordEntity);
		return res ? 0 : 3;
	}


}
