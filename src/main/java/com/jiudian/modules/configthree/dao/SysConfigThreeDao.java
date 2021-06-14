package com.jiudian.modules.configthree.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jiudian.modules.configthree.entity.SysConfigThreeEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 第三方配置表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-06-20 09:40:02
 */
@Mapper
public interface SysConfigThreeDao extends BaseMapper<SysConfigThreeEntity> {
	SysConfigThreeEntity queryByKeyInfo(String key);
}
