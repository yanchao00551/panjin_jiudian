package com.jiudian.modules.goods.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.goods.entity.AttributeEntity;

import java.util.Map;

/**
 * 商品相关属性
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 15:31:36
 */
public interface AttributeService extends IService<AttributeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    /**
     * 根据属性ID获取属性值
     * @param attrId
     * @return
     */
	AttributeEntity getAttributeServiceDetail(Integer attrId);
}

