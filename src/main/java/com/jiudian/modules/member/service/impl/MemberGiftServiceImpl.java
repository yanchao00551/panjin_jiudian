package com.jiudian.modules.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.member.dao.MemberGiftDao;
import com.jiudian.modules.member.entity.MemberGiftEntity;
import com.jiudian.modules.member.service.MemberGiftService;


@Service("memberGiftService")
public class MemberGiftServiceImpl extends ServiceImpl<MemberGiftDao, MemberGiftEntity> implements MemberGiftService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MemberGiftEntity> page = this.selectPage(
                new Query<MemberGiftEntity>(params).getPage(),
                new EntityWrapper<MemberGiftEntity>()
        );

        return new PageUtils(page);
    }

}
