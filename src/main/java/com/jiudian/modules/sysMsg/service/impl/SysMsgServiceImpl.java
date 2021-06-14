package com.jiudian.modules.sysMsg.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.sysMsg.dao.SysMsgDao;
import com.jiudian.modules.sysMsg.entity.SysMsgEntity;
import com.jiudian.modules.sysMsg.service.SysMsgService;

@Service("sysMsgService")
public class SysMsgServiceImpl extends ServiceImpl<SysMsgDao, SysMsgEntity> implements SysMsgService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Wrapper<SysMsgEntity> wrapper = new EntityWrapper<SysMsgEntity>();
		String toType;
		if(( toType = getMapValues(params, "toType")) != null) {
			wrapper.eq("to_type", toType);
		}
		String msgType;
		if(( msgType = getMapValues(params, "msgType")) != null) {
			wrapper.eq("msg_type", msgType);
		}
		String startDatetime;
		String endDatetime;
		if ((startDatetime = getMapValues(params, "startDatetime")) != null
				&& (endDatetime = getMapValues(params, "endDatetime")) != null) {
			wrapper.between("last_send_date", startDatetime, endDatetime);
		}
		Page<SysMsgEntity> page = this.selectPage(new Query<SysMsgEntity>(params).getPage(), wrapper);

		return new PageUtils(page);
	}
	
	private String getMapValues(Map<String, Object> params,String key) {
		if(params.containsKey(key) && !StringUtils.isEmpty(params.get(key))) {
			return params.get(key).toString();
		}else {
			return null;
		}
	}

}
