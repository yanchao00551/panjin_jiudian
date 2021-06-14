package com.jiudian.modules.cms.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.cms.entity.NcCmsTopicEntity;

import java.util.Map;

/**
 * 专题
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:19:57
 */
public interface NcCmsTopicService extends IService<NcCmsTopicEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

