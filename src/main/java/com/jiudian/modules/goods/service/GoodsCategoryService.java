package com.jiudian.modules.goods.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.goods.entity.GoodsCategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品分类表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
public interface GoodsCategoryService extends IService<GoodsCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 添加商品分类
     * @param shopId
     * @param categoryId
     * @param categoryName
     * @param shortName
     * @param pid
     * @param isVisible
     * @param keywords
     * @param description
     * @param sort
     * @param categoryPic
     * @param attrId
     * @param attrName
     * @return
     */
	Integer addOrEditGoodsCategory(Integer shopId,int categoryId, String categoryName, String shortName, Integer pid, Integer isVisible,
			String keywords, String description, Integer sort, String categoryPic, Integer attrId, String attrName,int icon);

	/**
	 * 获取商品分类树
	 * @param i
	 * @return
	 */
	List<GoodsCategoryEntity> getGoodsCategoryTree(Integer pid);

	/**
	 * 删除商品分类
	 * @param categoryId
	 * @return
	 */
	Integer deleteGoodsCategory(Integer categoryId);
}

