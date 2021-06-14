package com.jiudian.modules.goods.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;
import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.album.service.AlbumPictureService;
import com.jiudian.modules.goods.dao.AttributeDao;
import com.jiudian.modules.goods.entity.AttributeEntity;
import com.jiudian.modules.goods.entity.AttributeValueEntity;
import com.jiudian.modules.goods.entity.GoodsAttributeEntity;
import com.jiudian.modules.goods.service.AttributeService;
import com.jiudian.modules.goods.service.AttributeValueService;
import com.jiudian.modules.goods.service.GoodsAttributeService;


@Service("attributeService")
public class AttributeServiceImpl extends ServiceImpl<AttributeDao, AttributeEntity> implements AttributeService {

	@Autowired
	AttributeValueService attributeValueService;
	
	@Autowired
	private AlbumPictureService albumPictureService;
	
	@Autowired
	private GoodsAttributeService goodsAttributeService;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
		if(params.get("limit").equals(0)) {
			PageUtils page = new PageUtils(null, 0, 0, 0);
			page.setList(baseMapper.selectList(new EntityWrapper<AttributeEntity>()));
			return page;
		}
        Page<AttributeEntity> page = this.selectPage(
                new Query<AttributeEntity>(params).getPage(),
                new EntityWrapper<AttributeEntity>()
        );
        return new PageUtils(page);
    }

	@Override
	public AttributeEntity getAttributeServiceDetail(Integer attrId) {
		// TODO Auto-generated method stub
		AttributeEntity attr = new AttributeEntity();
		attr = baseMapper.selectById(attrId);
		if(attr.getAttrId() != null) {
			List<AttributeValueEntity> valueList = new ArrayList<AttributeValueEntity>();
			valueList = this.getAttributeValueServiceList(attrId);
			attr.setValueList(valueList);
		}
		return attr;
	}


	private List<AttributeValueEntity> getAttributeValueServiceList(Integer attrId) {
		// TODO Auto-generated method stub
		List<AttributeValueEntity> attributeValueEntities = attributeValueService.selectList(new EntityWrapper<AttributeValueEntity>().eq("attr_id", attrId));
		attributeValueEntities.forEach(ae -> {
			AlbumPictureEntity albumPictureEntity = albumPictureService.selectOne
					(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", ae.getIco()));
			ae.setIconDetail(albumPictureEntity);
			int attrValueId = ae.getAttrValueId();
			List<GoodsAttributeEntity> goodsAttributeEntities = goodsAttributeService.selectList
					(new EntityWrapper<GoodsAttributeEntity>().eq("attr_value_id", attrValueId).ne("attr_value_name", ""));
			StringBuffer goodsIDs = new StringBuffer();
			List<Integer> idList = new ArrayList<Integer>();
			if (goodsAttributeEntities != null && goodsAttributeEntities.size() > 0) {
				int i = 0;
				for (GoodsAttributeEntity gae : goodsAttributeEntities) {
					int gId = gae.getGoodsId();
					if(!idList.contains(gId)) {
						if (i > 0) {
							goodsIDs.append(",");
						}
						i++;
						idList.add(gId);
						goodsIDs.append(String.valueOf(gId));
					}
				}
			}
			if (goodsAttributeEntities != null && goodsAttributeEntities.size() > 0) {
				ae.setIsBind(1);
				ae.setBindIds(goodsIDs.toString());
			} else {
				ae.setIsBind(0);
			}
		});
		return attributeValueEntities;
	}
	
}
