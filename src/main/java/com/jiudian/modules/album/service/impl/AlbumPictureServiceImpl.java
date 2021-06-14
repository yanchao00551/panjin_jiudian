package com.jiudian.modules.album.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.album.dao.AlbumPictureDao;
import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.album.service.AlbumPictureService;


@Service("albumPictureService")
public class AlbumPictureServiceImpl extends ServiceImpl<AlbumPictureDao, AlbumPictureEntity> implements AlbumPictureService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AlbumPictureEntity> page = this.selectPage(
                new Query<AlbumPictureEntity>(params).getPage(),
                new EntityWrapper<AlbumPictureEntity>()
        );

        return new PageUtils(page);
    }

}
