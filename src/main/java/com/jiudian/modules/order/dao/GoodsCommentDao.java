package com.jiudian.modules.order.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jiudian.modules.order.entity.GoodsCommentEntity;

/**
 * 商品评论送积分记录表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-09-27 11:50:49
 */
@Mapper
public interface GoodsCommentDao extends BaseMapper<GoodsCommentEntity> {

	public String queryPointAvg(Map<String, String> params);
	
	public List<GoodsCommentEntity> queryForSearch(Page<GoodsCommentEntity> page, Map<String, String> params);
}
