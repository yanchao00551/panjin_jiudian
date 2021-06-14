package com.jiudian.modules.imgCode.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.imgCode.dao.ImgCodeDao;
import com.jiudian.modules.imgCode.entity.ImgCodeEntity;
import com.jiudian.modules.imgCode.service.ImgCodeService;


@Service("imgCodeService")
public class ImgCodeServiceImpl extends ServiceImpl<ImgCodeDao, ImgCodeEntity> implements ImgCodeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ImgCodeEntity> page = this.selectPage(
                new Query<ImgCodeEntity>(params).getPage(),
                new EntityWrapper<ImgCodeEntity>()
        );

        return new PageUtils(page);
    }

}
