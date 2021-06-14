package com.jiudian.modules.star.dao;

import com.jiudian.modules.star.entity.StarCommentEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 服务星评论表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-20 08:29:38
 */
@Mapper
public interface StarCommentDao extends BaseMapper<StarCommentEntity> {

	List<StarCommentEntity> queryStarComment(Map<String, Object> params);
	
}
