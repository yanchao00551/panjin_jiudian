package com.jiudian.modules.goods.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;
import com.jiudian.modules.goods.dao.AttributeValueDao;
import com.jiudian.modules.goods.entity.AttrModel;
import com.jiudian.modules.goods.entity.AttributeValueEntity;
import com.jiudian.modules.goods.entity.FormDynamic;
import com.jiudian.modules.goods.service.AttributeValueService;

@Service("attributeValueService")
public class AttributeValueServiceImpl extends ServiceImpl<AttributeValueDao, AttributeValueEntity> implements AttributeValueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AttributeValueEntity> page = this.selectPage(
                new Query<AttributeValueEntity>(params).getPage(),
                new EntityWrapper<AttributeValueEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public Integer modifyAttributeValueService(Integer attrValueId, String fieldName, String fieldValue) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		AttributeValueEntity entity = new AttributeValueEntity();
		entity.setAttrValueId(attrValueId);
		Field field = entity.getClass().getDeclaredField(fieldName);   //知识点:反射 动态设置属性值
		field.setAccessible(true);
		if(fieldName.equals("attrValueName")||fieldName.equals("value")) {
			field.set(entity, fieldValue);
		}else {
			field.set(entity, Integer.parseInt(fieldValue));
		}
		return baseMapper.updateById(entity);
	}

	@Override
	public List<FormDynamic> getGoodsAttrSpecQuery(Integer attrId) {
		// TODO Auto-generated method stub
		List<AttributeValueEntity> attributeList= baseMapper.selectList(new EntityWrapper<AttributeValueEntity>().eq("attr_id", attrId));
		if(!attributeList.isEmpty()) {
			for(int i=0;i<attributeList.size();i++) {
				String [] valueItems = attributeList.get(i).getValue().split(",");
				attributeList.get(i).setValueItems(valueItems);
			}
		}
		List<FormDynamic> formDynamic = new ArrayList<FormDynamic>();
		for(AttributeValueEntity v:attributeList) {
			if(v.getType() == 1) {
				FormDynamic info = new FormDynamic();
				info.setType("input");
				info.setLabel(v.getAttrValueName());
				info.setPlaceholder("请输入"+v.getAttrValueName());
				info.setAttrValueId(v.getAttrValueId());
				formDynamic.add(info);
			}else if(v.getType() == 2) {
				FormDynamic info = new FormDynamic();
				info.setType("select");
				info.setLabel(v.getAttrValueName());
				info.setOptions(v.getValueItems());
				info.setAttrValueId(v.getAttrValueId());
				formDynamic.add(info);
			}else if(v.getType() == 3) {
				FormDynamic info = new FormDynamic();
				info.setType("checkbox");
				info.setLabel(v.getAttrValueName());
				info.setOptions(v.getValueItems());
				List<AttrModel> attrModels = new ArrayList<AttrModel>();
				for (String values : v.getValueItems()) {
					AttrModel attrModel = new AttrModel();
					attrModel.setLabel(values);
					attrModels.add(attrModel);
				}
				info.setModels(attrModels);
				info.setAttrValueId(v.getAttrValueId());
				String [] arrNull;
				arrNull= new String[0];
				info.setArrValue(arrNull);
				formDynamic.add(info);
			}
		}
		
		return formDynamic;
	}


}
