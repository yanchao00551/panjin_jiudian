package com.jiudian.modules.cms.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.cms.entity.CmsArticleSimpleEntity;

/**
 * 
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:19:57
 */
public interface CmsArticleSimpleService extends IService<CmsArticleSimpleEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    PageUtils queryWithSort(Map<String, String> params);
}

