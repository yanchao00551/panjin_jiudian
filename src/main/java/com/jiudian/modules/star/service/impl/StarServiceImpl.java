package com.jiudian.modules.star.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;
import com.jiudian.modules.star.dao.StarDao;
import com.jiudian.modules.star.entity.StarEntity;
import com.jiudian.modules.star.service.StarService;


@Service("starService")
public class StarServiceImpl extends ServiceImpl<StarDao, StarEntity> implements StarService {

	@Override
	public PageUtils queryPage(Map<String, Object> params, Integer cid, Integer type) {
		Wrapper<StarEntity> wrapper = new EntityWrapper<StarEntity>().eq("type", type);
		if (type == 1) {
			wrapper.eq("star_class", cid);
		}
		Page<StarEntity> page = this.selectPage(new Query<StarEntity>(params).getPage(), wrapper);
		return new PageUtils(page);
	}

	@Override
	public PageUtils queryStarPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		Page<StarEntity> page = this.selectPage(
                new Query<StarEntity>(params).getPage(),
                new EntityWrapper<StarEntity>().eq("type", params.get("type"))
                .like("star_name", params.get("searchText").toString()).orderBy("star_id")
        );

        return new PageUtils(page);
	}

	@Override
	public PageUtils queryStarAndAvg(Map<String, String> params) {
		int limit = Integer.parseInt((String)params.get("limit"));
    	int current = (Integer.parseInt((String)params.get("page")));
    	Page<StarEntity> page = new Page<StarEntity>(current,limit);
    	List<StarEntity> pageList = baseMapper.queryStarAndAvg(page,params);
    	page.setRecords(pageList);
    	return new PageUtils(page);
	}

}
