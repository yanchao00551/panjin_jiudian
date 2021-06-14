package com.jiudian.modules.goods.dao;

import com.jiudian.modules.goods.entity.GoodsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 商品表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:40
 */
@Mapper
public interface GoodsDao extends BaseMapper<GoodsEntity> {

	List<GoodsEntity> queryByGoodsList(Page<GoodsEntity> page, Map<String, String> params);
	
	public List<GoodsEntity> queryGoodsListCanSort(Page<GoodsEntity> page, Map<String, String> params);
	
	public List<GoodsEntity> queryGoodsSoldCount(Map<String, String> params);
	
	public List<GoodsEntity> queryRoomList(Page<GoodsEntity> page,Map<String, String> params);
	
	public GoodsEntity queryRoomUse(Map<String, String> params);
	
}
