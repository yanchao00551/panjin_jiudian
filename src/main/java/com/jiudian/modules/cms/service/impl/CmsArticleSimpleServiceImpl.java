package com.jiudian.modules.cms.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;
import com.jiudian.modules.cms.dao.CmsArticleSimpleDao;
import com.jiudian.modules.cms.entity.CmsArticleSimpleEntity;
import com.jiudian.modules.cms.service.CmsArticleSimpleService;


@Service("cmsArticleSimpleService")
public class CmsArticleSimpleServiceImpl extends ServiceImpl<CmsArticleSimpleDao, CmsArticleSimpleEntity> implements CmsArticleSimpleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CmsArticleSimpleEntity> page = this.selectPage(
                new Query<CmsArticleSimpleEntity>(params).getPage(),
                new EntityWrapper<CmsArticleSimpleEntity>().orderBy("sort", true)
        );

        return new PageUtils(page);
    }

	@Override
	public PageUtils queryWithSort(Map<String, String> params) {
		int limit = Integer.parseInt((String)params.get("limit"));
    	int current = (Integer.parseInt((String)params.get("page")));
    	Page<CmsArticleSimpleEntity> page = new Page<CmsArticleSimpleEntity>(current,limit);
    	List<CmsArticleSimpleEntity> pageList = baseMapper.queryWithSort(page, params);
		page.setRecords(pageList);
		return new PageUtils(page);
	}

}
