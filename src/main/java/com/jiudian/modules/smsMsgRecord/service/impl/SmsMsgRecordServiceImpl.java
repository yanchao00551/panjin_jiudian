package com.jiudian.modules.smsMsgRecord.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.smsMsgRecord.dao.SmsMsgRecordDao;
import com.jiudian.modules.smsMsgRecord.entity.SmsMsgRecordEntity;
import com.jiudian.modules.smsMsgRecord.service.SmsMsgRecordService;


@Service("smsMsgRecordService")
public class SmsMsgRecordServiceImpl extends ServiceImpl<SmsMsgRecordDao, SmsMsgRecordEntity> implements SmsMsgRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SmsMsgRecordEntity> page = this.selectPage(
                new Query<SmsMsgRecordEntity>(params).getPage(),
                new EntityWrapper<SmsMsgRecordEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public SmsMsgRecordEntity queryNewestRecord(Map<String, String> params) {
		return baseMapper.queryNewestRecord(params);
	}
	
	@Override
	public Integer querySentCount(Map<String, String> params) {
		return baseMapper.querySentCount(params);
	}

}
