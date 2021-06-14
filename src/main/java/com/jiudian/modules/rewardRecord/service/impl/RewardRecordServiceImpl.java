package com.jiudian.modules.rewardRecord.service.impl;

import org.springframework.stereotype.Service;

import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.rewardRecord.dao.RewardRecordDao;
import com.jiudian.modules.rewardRecord.entity.RewardRecordEntity;
import com.jiudian.modules.rewardRecord.service.RewardRecordService;


@Service("rewardRecordService")
public class RewardRecordServiceImpl extends ServiceImpl<RewardRecordDao, RewardRecordEntity> implements RewardRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RewardRecordEntity> page = this.selectPage(
                new Query<RewardRecordEntity>(params).getPage(),
                new EntityWrapper<RewardRecordEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public RewardRecordEntity querySumGroupByFromUid(Map<String, String> params) {
		return baseMapper.querySumGroupByFromUid(params);
	}

}
