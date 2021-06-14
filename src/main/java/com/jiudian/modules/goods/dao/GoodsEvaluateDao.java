package com.jiudian.modules.goods.dao;

import com.jiudian.modules.goods.entity.GoodsEvaluateEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
@Mapper
public interface GoodsEvaluateDao extends BaseMapper<GoodsEvaluateEntity> {

	List<GoodsEvaluateEntity> getGoodsEvaluateList(Page<GoodsEvaluateEntity> page, Map<String, Object> params);
	
}
