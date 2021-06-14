package com.jiudian.modules.sms.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.sms.dao.SysNoticeRecordsDao;
import com.jiudian.modules.sms.entity.SysNoticeRecordsEntity;
import com.jiudian.modules.sms.service.SysNoticeRecordsService;

import com.alibaba.fastjson.JSONObject;
import net.sf.json.xml.XMLSerializer;


@Service("sysNoticeRecordsService")
public class SysNoticeRecordsServiceImpl extends ServiceImpl<SysNoticeRecordsDao, SysNoticeRecordsEntity>
		implements SysNoticeRecordsService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String sendAccount = (String) params.get("sendAccount");

		Page<SysNoticeRecordsEntity> page = this.selectPage(new Query<SysNoticeRecordsEntity>(params).getPage(),
				new EntityWrapper<SysNoticeRecordsEntity>().like(StringUtils.isNotBlank(sendAccount), "send_account",
						sendAccount));

		return new PageUtils(page);
	}

	@Override
	public Boolean noticeSmsSend(Integer noticeId, String sendAccount, String sendConfig, String noticeParams,String templateCode) {

		return true;
	}
	
	/**
	 * 判断是否为json格式
	 * @param content
	 * @return
	 */
	private boolean isJson(String content){
	    try {
	        JSONObject jsonStr= JSONObject.parseObject(content);
	        return  true;
	   } catch (Exception e) {
	        return false;
	   }
	}
	
	/**
	* XML转换为JSON
	* 2017-4-27 15:32:53
	* @param xml
	* @return
	*/
	private static String xmlToJson(String xml) {
		XMLSerializer serializer = new XMLSerializer();
		return serializer.read(xml).toString();
	}

}
