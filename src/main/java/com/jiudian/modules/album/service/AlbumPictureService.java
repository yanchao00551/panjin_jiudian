package com.jiudian.modules.album.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.album.entity.AlbumPictureEntity;

import java.util.Map;

/**
 * 相册图片表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-11 17:15:11
 */
public interface AlbumPictureService extends IService<AlbumPictureEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

