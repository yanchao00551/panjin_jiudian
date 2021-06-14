package com.jiudian.modules.cms.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.cms.entity.NcCmsCommentEntity;

import java.util.Map;

/**
 * CMS评论表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:19:57
 */
public interface NcCmsCommentService extends IService<NcCmsCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

