package com.jiudian.modules.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.member.dao.MemberRechargeDao;
import com.jiudian.modules.member.entity.MemberRechargeEntity;
import com.jiudian.modules.member.service.MemberRechargeService;


@Service("memberRechargeService")
public class MemberRechargeServiceImpl extends ServiceImpl<MemberRechargeDao, MemberRechargeEntity> implements MemberRechargeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MemberRechargeEntity> page = this.selectPage(
                new Query<MemberRechargeEntity>(params).getPage(),
                new EntityWrapper<MemberRechargeEntity>()
        );

        return new PageUtils(page);
    }

}
