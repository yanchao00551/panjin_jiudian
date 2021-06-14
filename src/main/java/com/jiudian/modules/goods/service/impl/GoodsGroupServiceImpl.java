package com.jiudian.modules.goods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.ErrorMsg;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;
import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.album.service.AlbumPictureService;
import com.jiudian.modules.goods.dao.GoodsGroupDao;
import com.jiudian.modules.goods.entity.GoodsGroupEntity;
import com.jiudian.modules.goods.service.GoodsGroupService;


@Service("goodsGroupService")
public class GoodsGroupServiceImpl extends ServiceImpl<GoodsGroupDao, GoodsGroupEntity> implements GoodsGroupService {

	@Autowired
	AlbumPictureService albumPictureService;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsGroupEntity> page = this.selectPage(
                new Query<GoodsGroupEntity>(params).getPage(),
                new EntityWrapper<GoodsGroupEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public PageUtils getGoodsGroupList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		Page<GoodsGroupEntity> page = this.selectPage(
				new Query<GoodsGroupEntity>(params).getPage(),
	            new EntityWrapper<GoodsGroupEntity>()
	            );
		List<GoodsGroupEntity> records = page.getRecords();
		int index = 0;  
		for(GoodsGroupEntity list:records) {
			AlbumPictureEntity picInfo = new AlbumPictureEntity();
			if(!list.getGroupPic().isEmpty()) {
				picInfo = albumPictureService.selectById(list.getGroupPic());
			}
			records.get(index).setPicture(picInfo);
			index++;
		}
		page.setRecords(records);
		return new PageUtils(page);
	}

	@Override
	public Integer addOrEditGoodsGroup(int groupId, Integer shopId, String groupName, Integer pid,
			Integer isVisible, Integer sort, String groupPic, String groupDec) {
		// TODO Auto-generated method stub
		int level = 1;  //目前仅为一级
		Integer res = ErrorMsg.ADD_FAIL.getCode();
		GoodsGroupEntity entity = new GoodsGroupEntity();
		entity.setShopId(shopId);
		entity.setGroupName(groupName);
		entity.setPid(pid);
		entity.setLevel(level);
		entity.setIsVisible(isVisible);
		entity.setSort(sort);
		entity.setGroupPic(groupPic);
		entity.setGroupDec(groupDec);
		if(groupId == 0) {
			baseMapper.insert(entity);
			res = entity.getGroupId();
		}else {
			entity.setGroupId(groupId);
			baseMapper.updateById(entity);
			res = 0;
		}
		return res;
	}

	@Override
	public Integer deleteGoodsGroup(Integer goodsGroupIdArray, Integer shopId) {
		// TODO Auto-generated method stub
		Integer res = 0;
		List<GoodsGroupEntity> subList = this.getGoodsGroupListByParentId(goodsGroupIdArray,shopId);
		if(!subList.isEmpty()) {
			res = ErrorMsg.SYSTEM_DELETE_FAIL.getCode();
		}else {
			baseMapper.delete(new EntityWrapper<GoodsGroupEntity>().eq("shop_id", shopId).eq("group_id", goodsGroupIdArray));
		}
		return res;
	}

	private List<GoodsGroupEntity> getGoodsGroupListByParentId(Integer pid, Integer shopId) {
		// TODO Auto-generated method stub
		List<GoodsGroupEntity> list = baseMapper.selectList(new EntityWrapper<GoodsGroupEntity>().eq("shop_id", shopId).eq("pid", pid));
		int index = 0;
		for(GoodsGroupEntity value:list) {
			AlbumPictureEntity picInfo = new AlbumPictureEntity();
			if(!value.getGroupPic().isEmpty()) {
				picInfo = albumPictureService.selectById(value.getGroupPic());
			}
			list.get(index).setPicture(picInfo);
			index++;
		}
		return list;
	}

}
