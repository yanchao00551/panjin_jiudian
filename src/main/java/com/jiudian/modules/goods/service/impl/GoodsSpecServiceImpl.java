package com.jiudian.modules.goods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.goods.dao.GoodsSpecDao;
import com.jiudian.modules.goods.entity.AttributeEntity;
import com.jiudian.modules.goods.entity.GoodsSpecEntity;
import com.jiudian.modules.goods.entity.GoodsSpecValueEntity;
import com.jiudian.modules.goods.service.AttributeService;
import com.jiudian.modules.goods.service.GoodsSpecService;
import com.jiudian.modules.goods.service.GoodsSpecValueService;


@Service("goodsSpecService")
public class GoodsSpecServiceImpl extends ServiceImpl<GoodsSpecDao, GoodsSpecEntity> implements GoodsSpecService {
	@Autowired
	GoodsSpecValueService goodsSpecValueService;
	@Autowired
	AttributeService attributeService;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsSpecEntity> page = this.selectPage(
                new Query<GoodsSpecEntity>(params).getPage(),
                new EntityWrapper<GoodsSpecEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public List<GoodsSpecEntity> getGoodsSpecList() {
		// TODO Auto-generated method stub
		List<GoodsSpecEntity> goodsSpec = new ArrayList<GoodsSpecEntity>();
		List<GoodsSpecValueEntity> goodsSpecValue = new ArrayList<GoodsSpecValueEntity>();
		
		goodsSpec = baseMapper.selectList(new EntityWrapper<GoodsSpecEntity>());
		if(!goodsSpec.isEmpty()) {
			for(int i=0;i<goodsSpec.size();i++) {
				String goodsSpecValueName = "";
				goodsSpecValue = goodsSpecValueService.selectList(new EntityWrapper<GoodsSpecValueEntity>().eq("spec_id", goodsSpec.get(i).getSpecId()));
				for(int j=0;j<goodsSpecValue.size();j++) {
					goodsSpecValueName = goodsSpecValueName + "," + goodsSpecValue.get(j).getSpecValueName();
				}
				goodsSpec.get(i).setSpecValueList(goodsSpecValue);
				goodsSpecValueName = (goodsSpecValueName == "" || goodsSpecValueName == null) ? "" : goodsSpecValueName.substring(1);
				goodsSpec.get(i).setGoodsSpecValueName(goodsSpecValueName);
			}
		}
		return goodsSpec;
	}

	
	@Override
	public List<GoodsSpecEntity> getGoodsSpecInfoQuery(Integer attrId) {
		// TODO Auto-generated method stub
		Map<String,Object> conditionSpec= new HashMap<String,Object>();
		if(attrId > 0) {
			AttributeEntity info = this.getAttributeInfo(attrId);
			if(info != null) {
				conditionSpec.put("specId", info.getSpecIdArray());
			}
		}
		conditionSpec.put("isVisible", 1);
		conditionSpec.put("goodsId", 0);    //与商品关联的规格不进行查询
		List<GoodsSpecEntity> specList = this.getGoodsSpecQuery(conditionSpec); //商品规格
		return specList;
	}
	
	
	private List<GoodsSpecEntity> getGoodsSpecQuery(Map<String, Object> conditionSpec) {
		// TODO Auto-generated method stub
		EntityWrapper<GoodsSpecEntity> ew = new EntityWrapper<GoodsSpecEntity>();
		if(conditionSpec.get("specId") != null) {
			ew.in("spec_id", conditionSpec.get("specId").toString());
		}
		ew.eq("is_visible", conditionSpec.get("isVisible"));
		ew.eq("goods_id", conditionSpec.get("goodsId"));
		ew.orderBy("sort", false);
		List<GoodsSpecEntity> goodsSpecQuery = baseMapper.selectList(ew);
		for(int i=0;i<goodsSpecQuery.size();i++) {
			List<GoodsSpecValueEntity> goodsSpecValueList = goodsSpecValueService.selectList(new EntityWrapper<GoodsSpecValueEntity>().eq("spec_id", goodsSpecQuery.get(i).getSpecId()).eq("goods_id", 0));
			goodsSpecQuery.get(i).setSpecValueList(goodsSpecValueList);
		}
		return goodsSpecQuery;
	}

	
	private AttributeEntity getAttributeInfo(Integer attrId) {
		// TODO Auto-generated method stub
		return attributeService.selectById(attrId);
	}

}
