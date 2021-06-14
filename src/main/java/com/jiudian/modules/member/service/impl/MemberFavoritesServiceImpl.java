package com.jiudian.modules.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.member.dao.MemberFavoritesDao;
import com.jiudian.modules.member.entity.MemberFavoritesEntity;
import com.jiudian.modules.member.service.MemberFavoritesService;


@Service("memberFavoritesService")
public class MemberFavoritesServiceImpl extends ServiceImpl<MemberFavoritesDao, MemberFavoritesEntity> implements MemberFavoritesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MemberFavoritesEntity> page = this.selectPage(
                new Query<MemberFavoritesEntity>(params).getPage(),
                new EntityWrapper<MemberFavoritesEntity>()
        );

        return new PageUtils(page);
    }

}
