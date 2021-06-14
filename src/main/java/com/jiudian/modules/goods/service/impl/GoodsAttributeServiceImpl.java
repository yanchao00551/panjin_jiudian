package com.jiudian.modules.goods.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.goods.dao.GoodsAttributeDao;
import com.jiudian.modules.goods.entity.GoodsAttributeEntity;
import com.jiudian.modules.goods.service.GoodsAttributeService;


@Service("goodsAttributeService")
public class GoodsAttributeServiceImpl extends ServiceImpl<GoodsAttributeDao, GoodsAttributeEntity> implements GoodsAttributeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsAttributeEntity> page = this.selectPage(
                new Query<GoodsAttributeEntity>(params).getPage(),
                new EntityWrapper<GoodsAttributeEntity>()
        );

        return new PageUtils(page);
    }
    
	@Override
	public Integer updateGoodsAttributeSort(Integer attrValueId, String sort, Integer instance_id) {
		// TODO Auto-generated method stub
		GoodsAttributeEntity entity = new GoodsAttributeEntity();
		entity.setSort(new Integer(sort));
		EntityWrapper<GoodsAttributeEntity> es = new EntityWrapper<GoodsAttributeEntity>();
		es.eq("attr_value_id", attrValueId);
		es.eq("shop_id", instance_id);
		return baseMapper.update(entity, es);
	}
}
