package com.jiudian.modules.goods.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.cart.entity.CartEntity;
import com.jiudian.modules.goods.entity.GoodsCategoryEntity;
import com.jiudian.modules.goods.entity.GoodsEntity;
import com.jiudian.modules.goods.entity.GoodsSkuPictureEntity;
import com.jiudian.modules.goods.entity.GoodsSpecEntity;

/**
 * 商品表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:40
 */
public interface GoodsService extends IService<GoodsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 商品类型列表
     * @param params
     * @return
     */
	PageUtils getAttributeServiceList(Map<String, Object> params);

	/**
	 * 添加商品类型
	 * @param attrName
	 * @param isVisible
	 * @param selectBox
	 * @param sort
	 * @param dataObjStr
	 * @param selectBrank
	 * @return
	 */
	Integer addAttributeService(String attrName, Integer isVisible, String selectBox, Integer sort, String dataObjStr,
			String selectBrank);

	/**
	 * 修改商品类型
	 * @param integer 
	 * @param attrName
	 * @param isVisible
	 * @param selectBox
	 * @param sort
	 * @param dataObjStr
	 * @param selectBrank
	 * @return
	 */
	Integer updateAttributeService(Integer integer, String attrName, Integer isVisible, String selectBox, Integer sort,
			String dataObjStr, String selectBrank);

	/**
	 * 删除商品类型
	 * @param attrId
	 * @return
	 */
	Boolean deleteAttributeService(Integer attrId);

	/**
	 * 商品规格列表
	 * @param params
	 * @return
	 */
	PageUtils getGoodsSpecList(Map<String, Object> params);

	/**
	 * 添加规格
	 * @param instance_id
	 * @param speName
	 * @param showType
	 * @param isVisible
	 * @param sort
	 * @param specValueStr
	 * @param attrId
	 * @param isScreen
	 * @param specDes
	 * @return
	 */
	Integer addGoodsSpecService(Integer instance_id, String speName, Integer showType, Integer isVisible, Integer sort,
			String specValueStr, Integer attrId, Integer isScreen, String specDes);

	/**
	 * 修改规格
	 * @param specId
	 * @param instance_id
	 * @param speName
	 * @param showType
	 * @param isVisible
	 * @param sort
	 * @param specValueStr
	 * @param attrId
	 * @param isScreen
	 * @param specDes
	 * @return
	 */
	Integer updateGoodsSpecService(Integer specId, Integer instance_id, String speName, Integer showType,
			Integer isVisible, Integer sort, String specValueStr, Integer attrId, Integer isScreen, String specDes);

	/**
	 * 删除商品规格
	 * @param specId
	 * @return
	 */
	Boolean deleteGoodsSpec(Integer specId);
	
	/**
	 * 获取分类树-管理后台
	 * @return
	 */
	List<GoodsCategoryEntity> getCategoryTreeUseInAdmin();

	/**
	 * 获取商品规则值
	 * @param specId
	 * @return
	 */
	GoodsSpecEntity getGoodsSpecDetail(long specId);

	
	/**
	 * 获取商品详情
	 * @param goodsId
	 * @return
	 */
	GoodsEntity getGoodsDetail(Integer goodsId,Long uid,HttpServletRequest request);

	/**
	 * 删除1条商品类型属性
	 * @param attrId
	 * @param attrValueId
	 * @return
	 */
	Integer deleteAttributeValueService(Integer attrId, Integer attrValueId);

	/**
	 * 获取商品列表
	 * @param params
	 * @return
	 */
	PageUtils getGoodsList(Map<String, String> params, Map<String,List<GoodsEntity>> recommendMap);
	
	PageUtils getGoodsList(Map<String, String> params);
	
	public PageUtils queryGoodsListCanSort(Map<String, String> params,
			Map<String,List<GoodsEntity>> recommendMap, String categoryId, String goodsAttributeId);

	/**
	 * 功能说明：添加或更新商品时 ajax调用的函数
	 * @param goodsId
	 * @param title
	 * @param shopId
	 * @param categoryId
	 * @param i
	 * @param j
	 * @param k
	 * @param supplierId
	 * @param brandId
	 * @param groupArray
	 * @param goodsType
	 * @param marketPrice
	 * @param price
	 * @param costPrice
	 * @param pointExchangeType
	 * @param integrationAvailableUse
	 * @param integrationAvailableGive
	 * @param l
	 * @param shippingFee
	 * @param shippingFeeId
	 * @param stock
	 * @param maxBuy
	 * @param minBuy
	 * @param minstock
	 * @param baseGood
	 * @param baseSales
	 * @param m
	 * @param n
	 * @param o
	 * @param baseShare
	 * @param provinceId
	 * @param cityId
	 * @param picture
	 * @param keyWords
	 * @param introduction
	 * @param description
	 * @param qrcode
	 * @param code
	 * @param displayStock
	 * @param p
	 * @param q
	 * @param r
	 * @param sort
	 * @param imageArray
	 * @param skuArray
	 * @param isSale
	 * @param string
	 * @param goodsAttributeId
	 * @param goodsAttribute
	 * @param goodsSpecFormat
	 * @param goodsWeight
	 * @param goodsVolume
	 * @param shippingFeeType
	 * @param string2
	 * @param skuPictureVlaues
	 * @param virtualGoodsTypeData
	 * @param productionDate
	 * @param shelfLife
	 * @param ladderPreference
	 * @param goodsVideoAddress
	 * @param maxUsePoint
	 * @param isOpenPresell
	 * @param presellDeliveryType
	 * @param presellPrice
	 * @param presellTime
	 * @param presellDay
	 * @param goodsUnit
	 * @param calendarPrice
	 * @return
	 */
	Integer addOrEditGoods(Integer goodsId, String title, Integer shopId, Integer categoryId, int i, int j, int k,
			Integer supplierId, Integer brandId, String groupArray, Integer goodsType, BigDecimal marketPrice,
			BigDecimal price, BigDecimal costPrice, Integer pointExchangeType, Integer integrationAvailableUse,
			Integer integrationAvailableGive, int l, BigDecimal shippingFee, Integer shippingFeeId, Integer stock,
			String location, Integer maxBuy, Integer minBuy, Integer minstock, Integer baseGood, Integer baseSales,
			int m, int n, int o, Integer baseShare, Integer provinceId, Integer cityId, Integer picture,
			String keyWords, String introduction, String description, String qrcode, String code, Integer displayStock,
			int p, int q, int r, Integer sort, String imageArray, String skuArray, Integer isSale, String string,
			Integer goodsAttributeId, String goodsAttribute, String goodsSpecFormat, BigDecimal goodsWeight,
			BigDecimal goodsVolume, Integer shippingFeeType, String string2, String skuPictureVlaues,
			String virtualGoodsTypeData, Integer productionDate, String shelfLife, String ladderPreference,
			String goodsVideoAddress, Integer maxUsePoint, Integer isOpenPresell, Integer presellDeliveryType,
			BigDecimal presellPrice, Integer presellTime, Integer presellDay, String goodsUnit, String calendarPrice,
			Integer isRecommend, Integer goodsSort, int isEdit);

	/**
	 * 查询sku多图数据
	 * @param goodsId
	 * @return
	 */
	List<GoodsSkuPictureEntity> getGoodsSkuPicture(Integer goodsId);

	/**
	 * 删除商品
	 * @param goodsIds
	 */
	void deleteGoods(String goodsIds);

	/**
	 * 商品上架下架
	 * @param goodsIds
	 */
	void ModifyGoodsOffline(String goodsIds,int state);

	/**
	 * 添加购物车
	 * @param userId
	 * @param instance_id
	 * @param goodsId
	 * @param goodsName
	 * @param skuId
	 * @param skuName
	 * @param price
	 * @param count
	 * @param pictureId
	 * @param i
	 * @param type 
	 * @param  
	 * @param intoStore 入店日期
	 * @param leaveStore 离店日期
	 * @return
	 */
	boolean addCart(Integer userId, Integer instance_id, Integer goodsId, String goodsName, Integer goodsAttributeId,
			BigDecimal price, Integer count, Integer pictureId, int i, Integer type, Integer intoStore, Integer leaveStore,
			int maxUsePoint);

	/**
	 * 获取购物车
	 * @param userId
	 * @param type 
	 * @return
	 */
	List<CartEntity> getCart(Integer userId, Integer type);

	/**
	 * 更新购物车中商品数量
	 * @param cartId
	 * @param num
	 * @param userId 
	 */
	void cartAdjustNum(Integer cartId, Integer num, Integer userId);


	public PageUtils queryRoomList(Map<String, String> params);
	
	public GoodsEntity queryRoomUse(Map<String, String> params);

}

