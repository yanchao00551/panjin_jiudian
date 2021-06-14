package com.jiudian.modules.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.member.dao.MemberBankAccountDao;
import com.jiudian.modules.member.entity.MemberBankAccountEntity;
import com.jiudian.modules.member.service.MemberBankAccountService;


@Service("memberBankAccountService")
public class MemberBankAccountServiceImpl extends ServiceImpl<MemberBankAccountDao, MemberBankAccountEntity> implements MemberBankAccountService {

    @Override
    public PageUtils queryPage(Map<String, Object> params,Integer userId) {
        Page<MemberBankAccountEntity> page = this.selectPage(
                new Query<MemberBankAccountEntity>(params).getPage(),
                new EntityWrapper<MemberBankAccountEntity>().eq("uid", userId)
        );

        return new PageUtils(page);
    }

}
