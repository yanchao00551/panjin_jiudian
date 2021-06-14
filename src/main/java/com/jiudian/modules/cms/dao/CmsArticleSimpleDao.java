package com.jiudian.modules.cms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jiudian.modules.cms.entity.CmsArticleSimpleEntity;

/**
 * 
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:19:57
 */
@Mapper
public interface CmsArticleSimpleDao extends BaseMapper<CmsArticleSimpleEntity> {
	
	List<CmsArticleSimpleEntity> queryWithSort(Page<CmsArticleSimpleEntity> page, Map<String, String> params);
}
