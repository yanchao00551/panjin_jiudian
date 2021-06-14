package com.jiudian.modules.star.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jiudian.modules.star.entity.StarEntity;

/**
 * 服务星表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-20 08:29:38
 */
@Mapper
public interface StarDao extends BaseMapper<StarEntity> {

	public List<StarEntity> queryStarAndAvg(Page<StarEntity> page, Map<String, String> params);
}
