package com.jiudian.modules.album.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.album.dao.AlbumClassDao;
import com.jiudian.modules.album.entity.AlbumClassEntity;
import com.jiudian.modules.album.service.AlbumClassService;


@Service("albumClassService")
public class AlbumClassServiceImpl extends ServiceImpl<AlbumClassDao, AlbumClassEntity> implements AlbumClassService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AlbumClassEntity> page = this.selectPage(
                new Query<AlbumClassEntity>(params).getPage(),
                new EntityWrapper<AlbumClassEntity>()
        );

        return new PageUtils(page);
    }

}
