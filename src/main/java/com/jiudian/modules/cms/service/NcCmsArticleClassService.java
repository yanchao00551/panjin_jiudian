package com.jiudian.modules.cms.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.cms.entity.NcCmsArticleClassEntity;

import java.util.Map;

/**
 * cms文章分类表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:19:57
 */
public interface NcCmsArticleClassService extends IService<NcCmsArticleClassEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

