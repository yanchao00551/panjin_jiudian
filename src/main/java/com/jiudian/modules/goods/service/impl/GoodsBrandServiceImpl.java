package com.jiudian.modules.goods.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.goods.dao.GoodsBrandDao;
import com.jiudian.modules.goods.entity.GoodsBrandEntity;
import com.jiudian.modules.goods.service.GoodsBrandService;


@Service("goodsBrandService")
public class GoodsBrandServiceImpl extends ServiceImpl<GoodsBrandDao, GoodsBrandEntity> implements GoodsBrandService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsBrandEntity> page = this.selectPage(
                new Query<GoodsBrandEntity>(params).getPage(),
                new EntityWrapper<GoodsBrandEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public List<GoodsBrandEntity> getGoodsBrandList() {
		// TODO Auto-generated method stub
		return baseMapper.selectList(new EntityWrapper<GoodsBrandEntity>());
	}

	@Override
	public PageUtils getGoodsBrandList(Map<String, Object> params,Integer shopId) {
		// TODO Auto-generated method stub
		Page<GoodsBrandEntity> page = this.selectPage(
	                new Query<GoodsBrandEntity>(params).getPage(),
	                new EntityWrapper<GoodsBrandEntity>().eq("shop_id", shopId).like("brand_name", "%"+params.get("searchText")+"%").orderBy("sort asc"));
	    return new PageUtils(page);
	}

}
