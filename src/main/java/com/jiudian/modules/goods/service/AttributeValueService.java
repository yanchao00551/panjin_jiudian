package com.jiudian.modules.goods.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.goods.entity.AttributeValueEntity;
import com.jiudian.modules.goods.entity.FormDynamic;

/**
 * 商品属性值
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 15:31:36
 */
public interface AttributeValueService extends IService<AttributeValueEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 实时更新属性值
     * @param attrValueId
     * @param fieldName
     * @param fieldValue
     * @return
     * @throws SecurityException 
     * @throws NoSuchFieldException 
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
	Integer modifyAttributeValueService(Integer attrValueId, String fieldName, String fieldValue) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException;

	/**
	 * 根据属性ID获取属性列表
	 * @param attrId
	 * @return
	 */
	List<FormDynamic> getGoodsAttrSpecQuery(Integer attrId);

}

