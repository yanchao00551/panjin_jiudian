package com.jiudian.modules.app.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.album.service.AlbumPictureService;
import com.jiudian.modules.app.entity.StartPageEntity;
import com.jiudian.modules.app.service.StartPageService;
import com.jiudian.modules.cms.entity.CmsArticleSimpleEntity;
import com.jiudian.modules.cms.service.CmsArticleSimpleService;
import com.jiudian.modules.goods.entity.GoodsAttributeEntity;
import com.jiudian.modules.goods.entity.GoodsCategoryEntity;
import com.jiudian.modules.goods.entity.GoodsEntity;
import com.jiudian.modules.goods.entity.GoodsGroupEntity;
import com.jiudian.modules.goods.service.GoodsAttributeService;
import com.jiudian.modules.goods.service.GoodsCategoryService;
import com.jiudian.modules.goods.service.GoodsGroupService;
import com.jiudian.modules.goods.service.GoodsService;
import com.jiudian.modules.order.entity.GoodsCommentEntity;
import com.jiudian.modules.order.service.GoodsCommentService;
import com.jiudian.modules.rebate.entity.RebateEntity;
import com.jiudian.modules.rebate.service.RebateService;

@Service("startPageService")
public class StartPageServiceImpl implements StartPageService {
	
	@Autowired
	private GoodsGroupService goodsGroupService;
	
	@Autowired
	private GoodsCategoryService categoryService;
	
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private CmsArticleSimpleService cmsArticleSimpleService;
	
	@Autowired
	private AlbumPictureService albumPictureService;
	
	@Autowired
	private GoodsCommentService goodsCommentService;
	
	@Autowired
	private GoodsAttributeService goodsAttributeService;
	
	@Autowired
	private RebateService rebateService;
	
//	private final static String[] TURN_IMGS = {"343","344","345"};
	
	private final static String PRIZE_IMG = "196";

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public StartPageEntity getStartPage(Map<String,String> tParams) {
		StartPageEntity startPageEntity = new StartPageEntity();
		EntityWrapper<GoodsGroupEntity> goodsGroupEntity = new EntityWrapper<GoodsGroupEntity>();
		goodsGroupEntity.eq("is_visible", 1);
		List<GoodsGroupEntity> goodsGroupEntities = goodsGroupService.selectList(goodsGroupEntity);
		for(int i = 0; i < goodsGroupEntities.size(); i++) {
			String picid = goodsGroupEntities.get(i).getGroupPic();
			goodsGroupEntities.get(i).setPicture(albumPictureService.selectById(picid));
		}
		startPageEntity.setGroupEntities(goodsGroupEntities);
		Map<String,String> params = new HashMap<String,String>();
		params.put("limit",tParams.get("roomLimit"));
		params.put("page",tParams.get("roomPage"));
		params.put("goodsAttributeId","1");
		params.put("state","1");
		params.put("isRecommend", "1");
		PageUtils roomPage = goodsService.getGoodsList(params);
		List<GoodsEntity> roomEntities = (List<GoodsEntity>) roomPage.getList();
		Iterator<GoodsEntity> iterator = roomEntities.iterator();
		while (iterator.hasNext()) {
			GoodsEntity t = iterator.next();
			int count = goodsCommentService.selectCount(new EntityWrapper<GoodsCommentEntity>()
					.eq("goods_id", t.getGoodsId()).eq("review_status", 2));
			t.setCommentCount(count);
			Map<String, String> tMap = new HashMap<String, String>();
			tMap.put("goodsId", String.valueOf(t.getGoodsId()));
			t.setCommentPointAvg(goodsCommentService.selectPointAvg(tMap));
			AlbumPictureEntity albumPictureEntity = albumPictureService.selectOne
					(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", t.getPicture()));
			t.setPictureDetail(albumPictureEntity);
			try {
				Calendar currentCalendar = Calendar.getInstance();
				int currentDay = currentCalendar.getTime().getDate();
				int currentYear = 1900 + currentCalendar.getTime().getYear();
				int currentMonth = currentCalendar.getTime().getMonth() + 1;
				Calendar firstDayCalendar = Calendar.getInstance();
				firstDayCalendar.set(currentYear, currentMonth - 1, 1);
				if(!StringUtils.isEmpty(t.getExtends1())) {
					JSONArray jsonArray = JSON.parseArray(t.getExtends1());
					JSONObject currentMonthJson = null;
					int dayOfWeek = firstDayCalendar.getTime().getDay();
					for (int i = 0; i < jsonArray.size(); i++) {
						String tYear = jsonArray.getJSONObject(i).getString("year");
						String tMonth = jsonArray.getJSONObject(i).getString("month");
						if (!StringUtils.isEmpty(tYear) && tYear.equals(String.valueOf(currentYear))
								&& !StringUtils.isEmpty(tMonth) && tMonth.equals(String.valueOf(currentMonth))) {
							currentMonthJson = jsonArray.getJSONObject(i);
						}
					}
					if(currentMonthJson != null) {
						String priceNormals = currentMonthJson.getString("price0");
						String tmpPrice0 = priceNormals.replaceAll("\\[", "").replaceAll("\\]", "")
								.replaceAll("null", "").replaceAll("\"", "");
						for(int j = 0; j < dayOfWeek - 1; j++) {
							tmpPrice0 = tmpPrice0.replaceFirst(",", "");
						}
						String[] price0 = tmpPrice0.split(",");
						t.setPrice(new BigDecimal(price0[currentDay - 1]));
					}else {
						iterator.remove();
					}
				}else {
					iterator.remove();
				}
			}catch (Exception e) {
				if(t != null) {
					t.setPrice(new BigDecimal(0));
				}
			}
		}
//		roomEntities.forEach(new Consumer<GoodsEntity>() {
//			@SuppressWarnings("deprecation")
//			@Override
//			public void accept(GoodsEntity t) {
//				
//			}
//		});
		roomPage.setList(roomEntities);
		startPageEntity.setRoomEntities(roomPage);
		EntityWrapper<GoodsCategoryEntity> entityWrapper = new EntityWrapper<GoodsCategoryEntity>();
		startPageEntity.setCategoryEntities(categoryService.selectList(entityWrapper));
		params.clear();
		params.put("limit",tParams.get("goodLimit"));
		params.put("page",tParams.get("goodPage"));
		params.put("goodsAttributeIdAll","1");
		params.put("state","1");
		params.put("isRecommend", "1");
		params.put("categoryId", tParams.get("categoryId"));
		PageUtils goodsPage = goodsService.getGoodsList(params);
		List<GoodsEntity> goodsEntities = (List<GoodsEntity>) goodsPage.getList();
		goodsEntities.forEach(new Consumer<GoodsEntity>() {
			@Override
			public void accept(GoodsEntity t) {
				List<GoodsAttributeEntity> goodsAttributeEntities = goodsAttributeService.selectList
						(new EntityWrapper<GoodsAttributeEntity>().eq("goods_id", t.getGoodsId()));
				if(goodsAttributeEntities == null || goodsAttributeEntities.size() == 0) {
					return;
				}
				Collections.sort(goodsAttributeEntities,(GoodsAttributeEntity o1, GoodsAttributeEntity o2) -> {
					if(o1.getPrice() == null) {
						return -1;
					}
					if(o2.getPrice() == null) {
						return 1;
					}
					return o1.getPrice().compareTo(o2.getPrice());
				});
				t.setPrice(goodsAttributeEntities.get(0).getPrice());
				int count = goodsCommentService.selectCount(new EntityWrapper<GoodsCommentEntity>()
						.eq("goods_id", t.getGoodsId()));
				t.setCommentCount(count);
				Map<String, String> tMap = new HashMap<String, String>();
				tMap.put("goodsId", String.valueOf(t.getGoodsId()));
				t.setCommentPointAvg(goodsCommentService.selectPointAvg(tMap));
				AlbumPictureEntity albumPictureEntity = albumPictureService.selectOne
						(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", t.getPicture()));
				t.setPictureDetail(albumPictureEntity);
			}
		});
		goodsPage.setList(goodsEntities);
		startPageEntity.setGoodsEntities(goodsPage);
		Map<String,String> tmpMap = new HashMap<String,String>();
		tmpMap.put("page",tParams.get("cmsPage"));
		tmpMap.put("limit",tParams.get("cmsLimit"));
		PageUtils page = cmsArticleSimpleService.queryWithSort(tmpMap);
		List<CmsArticleSimpleEntity> list = (List<CmsArticleSimpleEntity>) page.getList();
		for(int i = 0; i < list.size(); i++) {
			AlbumPictureEntity albumPicture = albumPictureService.selectById(list.get(i).getBanner());
			list.get(i).setAlbumPicture(albumPicture);
		}
		startPageEntity.setArticleSimpleEntities(list);
		RebateEntity rebateEntity = rebateService.selectById(4);
		if(rebateEntity != null && rebateEntity.getRvalue() != null && rebateEntity.getRvalue().contains(",")) {
			List<AlbumPictureEntity> albumPictureEntities = new ArrayList<AlbumPictureEntity>();
			String[] imgs = rebateEntity.getRvalue().split(",");
			for (String imgId : imgs) {
				AlbumPictureEntity turnPic = albumPictureService.selectById(imgId);
				albumPictureEntities.add(turnPic);
			}
//			AlbumPictureEntity turnPic1 = albumPictureService.selectById(TURN_IMGS[0]);
//			AlbumPictureEntity turnPic2 = albumPictureService.selectById(TURN_IMGS[1]);
//			AlbumPictureEntity turnPic3 = albumPictureService.selectById(TURN_IMGS[2]);
//			albumPictureEntities.add(turnPic1);
//			albumPictureEntities.add(turnPic2);
//			albumPictureEntities.add(turnPic3);
			startPageEntity.setTurnImg(albumPictureEntities);
		}
		AlbumPictureEntity prizePic3 = albumPictureService.selectById(PRIZE_IMG);
		startPageEntity.setPrizeImg(prizePic3);
		return startPageEntity;
	}

	@Override
	public List<GoodsGroupEntity> getGroupList() {
		EntityWrapper<GoodsGroupEntity> goodsGroupEntity = new EntityWrapper<GoodsGroupEntity>();
		goodsGroupEntity.eq("is_visible", 1);
		return goodsGroupService.selectList(goodsGroupEntity);
	}

}
