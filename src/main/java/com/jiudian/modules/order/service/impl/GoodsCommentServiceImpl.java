package com.jiudian.modules.order.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;
import com.jiudian.modules.order.dao.GoodsCommentDao;
import com.jiudian.modules.order.entity.GoodsCommentEntity;
import com.jiudian.modules.order.service.GoodsCommentService;


@Service("goodsCommentService")
public class GoodsCommentServiceImpl extends ServiceImpl<GoodsCommentDao, GoodsCommentEntity> implements GoodsCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params, String status) {
    	Wrapper<GoodsCommentEntity> wrapper =  new EntityWrapper<GoodsCommentEntity>();
    	wrapper.eq("goods_id", params.get("goodsId")).orderBy("create_time", false);
    	if(status != null) {
    		wrapper.eq("review_status", status); 
    	}
        Page<GoodsCommentEntity> page = this.selectPage(
                new Query<GoodsCommentEntity>(params).getPage(),wrapper
        );

        return new PageUtils(page);
    }

	@Override
	public String selectPointAvg(Map<String, String> params) {
		String d = baseMapper.queryPointAvg(params);
		return d;
	}

	@Override
	public PageUtils queryList(Map<String, Object> params) {
		Page<GoodsCommentEntity> page = this.selectPage(
                new Query<GoodsCommentEntity>(params).getPage(),
                new EntityWrapper<GoodsCommentEntity>().eq("goods_id", params.get("goodsId"))
        );

        return new PageUtils(page);
	}

	@Override
	public PageUtils queryForSearch(Map<String, String> params) {
		int limit = Integer.parseInt(params.get("limit"));
		int current = (Integer.parseInt(params.get("page")));
		Page<GoodsCommentEntity> page = new Page<GoodsCommentEntity>(current, limit);
		List<GoodsCommentEntity> pageList = baseMapper.queryForSearch(page, params);
		page.setRecords(pageList);
		return new PageUtils(page);
	}

}
