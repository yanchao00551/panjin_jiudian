package com.jiudian.modules.goods.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jiudian.common.utils.ErrorMsg;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;
import com.jiudian.common.validator.ValidatorUtils;
import com.jiudian.modules.address.entity.CityEntity;
import com.jiudian.modules.address.entity.ProvinceEntity;
import com.jiudian.modules.address.service.AddressService;
import com.jiudian.modules.album.entity.AlbumClassEntity;
import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.album.service.AlbumClassService;
import com.jiudian.modules.album.service.AlbumPictureService;
import com.jiudian.modules.goods.entity.AttributeEntity;
import com.jiudian.modules.goods.entity.FormDynamic;
import com.jiudian.modules.goods.entity.GoodsAttributeEntity;
import com.jiudian.modules.goods.entity.GoodsBrandEntity;
import com.jiudian.modules.goods.entity.GoodsCategoryEntity;
import com.jiudian.modules.goods.entity.GoodsCreateOrUpdateForm;
import com.jiudian.modules.goods.entity.GoodsEntity;
import com.jiudian.modules.goods.entity.GoodsEvaluateEntity;
import com.jiudian.modules.goods.entity.GoodsGroupEntity;
import com.jiudian.modules.goods.entity.GoodsSkuPictureEntity;
import com.jiudian.modules.goods.entity.GoodsSpecEntity;
import com.jiudian.modules.goods.entity.GoodsSpecValueEntity;
import com.jiudian.modules.goods.form.AddAttributeServiceForm;
import com.jiudian.modules.goods.form.AddGoodsCategoryForm;
import com.jiudian.modules.goods.form.AddGoodsGroupForm;
import com.jiudian.modules.goods.form.AddGoodsSpecForm;
import com.jiudian.modules.goods.form.DeleteAttrForm;
import com.jiudian.modules.goods.form.DeleteGoodsSpecForm;
import com.jiudian.modules.goods.form.ModifyAttrValueServiceForm;
import com.jiudian.modules.goods.form.ReplyEvaluateAjaxForm;
import com.jiudian.modules.goods.service.AttributeService;
import com.jiudian.modules.goods.service.AttributeValueService;
import com.jiudian.modules.goods.service.GoodsAttributeService;
import com.jiudian.modules.goods.service.GoodsBrandService;
import com.jiudian.modules.goods.service.GoodsCategoryService;
import com.jiudian.modules.goods.service.GoodsEvaluateService;
import com.jiudian.modules.goods.service.GoodsGroupService;
import com.jiudian.modules.goods.service.GoodsService;
import com.jiudian.modules.goods.service.GoodsSpecService;
import com.jiudian.modules.supplier.entity.SupplierEntity;
import com.jiudian.modules.supplier.service.SupplierService;
import com.jiudian.modules.sys.controller.AbstractController;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;



/**
 * 商品表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:40
 */
@RestController
@RequestMapping("goods/goods")
public class GoodsController extends AbstractController{
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsSpecService goodsSpecService;
    @Autowired
    private GoodsBrandService goodsBrandService;
    @Autowired
    private AttributeService attributeService;
    @Autowired
    private AttributeValueService attributeValueService;
    @Autowired
    private GoodsAttributeService goodsAttributeService;
    @Autowired
    private GoodsCategoryService goodsCategoryService;
    @Autowired
    private GoodsGroupService goodsGroupService;
    @Autowired
    private GoodsEvaluateService goodsEvaluateService;
    @Autowired
    private AlbumClassService albumClassService;
    @Autowired
    private AlbumPictureService albumPictureService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private AddressService addressService;
    
    private Integer instance_id;
    
    public GoodsController() {
    	this.instance_id = 0;
    }
    
    /**
     * 商品列表
     */
    @RequestMapping("/goodsList")
    @RequiresPermissions("goods:goods:goodsList")
    public R goodsList(@RequestParam Map<String,String> params) {
    	Integer stateType = Integer.parseInt(params.get("state"));
    	String selectGoodsLableId = params.get("selectGoodsLableId");
    	String sortRule = params.get("sortRule");
    	String goodsType = params.get("goodsType");
    	
    	if(!goodsType.equals("all")) {
    		params.put("goodsType", goodsType);
    	}
    	
    	if(stateType > 0) {   //商品状态
    		params.put("state", "0");
    	}else {
    		params.put("state", "1");
    	}
    	
    	
    	if(selectGoodsLableId != null) {   //标签 可多选
    		String [] selectGoodsLabelIdArray = selectGoodsLableId.split(",");
    		String str = selectGoodsLabelIdArray[0];
    		if(selectGoodsLabelIdArray.length > 1) {
    			str = str + ",";
    		}
    		for(int i=1;i<selectGoodsLabelIdArray.length;i++) {
    			str += selectGoodsLabelIdArray[i];
    			if(i!= selectGoodsLabelIdArray.length - 1) {
    				str += ",";
    			}
    		}
    		params.put("selectGoodsLableId", str);
    	}
    	
    	
    	if(!sortRule.equals("") && sortRule != null) {   //排序规则
    		String [] sortRuleArr = sortRule.split(",");
    		String sortField = sortRuleArr[0];
    		String sortValue = sortRuleArr[1];
    		if(sortValue.equals("a")) {
    			sortValue = "0";
    		}else if(sortValue.equals("d")) {
    			sortValue = "1";
    		}else {
    			sortValue = null;
    		}
    		if(sortValue != null) {
    			switch(sortField) {
    			case "price":
    				params.put("orderPrice", sortValue);
    				break;
    			case "stock":
    				params.put("orderStock", sortValue);
    				break;
    			case "sales":
    				params.put("orderSales", sortValue);
    				break;
    			case "sort":
    				params.put("orderSort", sortValue);
    				break;
    			}
    		}
    	}else {
    		// 默认时间排序
			params.put("orderCreateTime","desc");
		}
    	params.put("shopId", this.instance_id.toString());
    	PageUtils result = goodsService.getGoodsList(params);
    	return R.ok().put("page", result);
    }
    
    /**
     * 删除商品
     */
    @RequestMapping("/deleteGoods")
    @RequiresPermissions("goods:goods:deleteGoods")
    public R deleteGoods(@RequestBody GoodsEntity form) {
    	String goodsIds = form.getGoodsId().toString();
    	goodsService.deleteGoods(goodsIds);
    	return R.ok();
    }
    
    /**
     * 商品下架
     */
    @RequestMapping("/ModifyGoodsOffline")
    @RequiresPermissions("goods:goods:ModifyGoodsOffline")
    public R ModifyGoodsOffline(@RequestBody GoodsEntity form) {
    	String goodsIds = form.getGoodsId().toString();
    	int state = form.getState();
    	goodsService.ModifyGoodsOffline(goodsIds, state);
    	return R.ok();
    }
    
    /**
     * 商品保存添加或更新
     */
    @RequestMapping("/GoodsCreateOrUpdate")
    @RequiresPermissions("goods:goods:addGoods")
    public R GoodsCreateOrUpdate(@RequestBody GoodsCreateOrUpdateForm form) {
    	Integer res = 0;
    	if(form != null) {
    		Integer shopId = this.instance_id;
			res = goodsService.addOrEditGoods(
    				form.getGoodsId(),   // 商品Id
    				form.getTitle(),    // 商品标题
    				shopId,
    				form.getCategoryId(),  // 商品类目
    				0,
    				0,
    				0,
    				form.getSupplierId(),
    				form.getBrandId(),
    				form.getGroupArray(),   // 商品分组
    				form.getGoodsType(),    
    				form.getMarketPrice(),
    				form.getPrice(),        // 商品现价
    				form.getCostPrice(),
    				form.getPointExchangeType(),
    				form.getIntegrationAvailableUse(),
    				form.getIntegrationAvailableGive(),
    				0,
    				form.getShippingFee(),
    				form.getShippingFeeId(),
    				form.getStock(),
    				form.getLocation(),
    				form.getMaxBuy(),
    				form.getMinBuy(),
    				form.getMinstock(),
    				form.getBaseGood(),
    				form.getBaseSales(),
    				0,
    				0,
    				0,
    				form.getBaseShare(),
    				form.getProvinceId(),
    				form.getCityId(),
    				form.getPicture(),
    				form.getKeyWords(),
    				form.getIntroduction(),  // 商品简介，促销语
    				form.getDescription(),
    				form.getQrcode(),         // 商品二维码
    				form.getCode(),
    				form.getDisplayStock(),
    				0,
    				0,
    				0,
    				form.getSort(),
    			    form.getImageArray(),
    			    form.getSkuArray(),
    			    form.getIsSale(),
    			    "",
    			    form.getGoodsAttributeId(),
    			    form.getGoodsAttribute(),
    			    form.getGoodsSpecFormat(),
    			    form.getGoodsWeight(),
    			    form.getGoodsVolume(),
    			    form.getShippingFeeType(),
    			    "",
    			    form.getSkuPictureVlaues(),
    			    form.getVirtualGoodsTypeData(),
    			    form.getProductionDate(),
    			    form.getShelfLife(),
    			    form.getLadderPreference(),
    			    form.getGoodsVideoAddress(),
    			    form.getMaxUsePoint(),
    			    form.getIsOpenPresell(),
    			    form.getPresellDeliveryType(),
    			    form.getPresellPrice(),
    			    form.getPresellTime(),
    			    form.getPresellDay(),
    			    form.getGoodsUnit(),
    			    form.getCalendarPrice(),   // 特殊商品日历价格json
    			    form.getIsRecommend(),
    			    form.getSort(),
    			    form.getIsEdit()
    				);
    		if(res > 0) {
    			return R.ok();
    		}else {
    			return R.error("保存商品失败！");
    		}
    	}else {
    		return R.error("请求数据为空");
    	}
    }
    

    
    /**
     * 商品类型
     */
    @RequestMapping("/attributelist")
    @RequiresPermissions("goods:goods:attributelist")
    public R attributelist(@RequestParam Map<String, Object> params){
        PageUtils page = goodsService.getAttributeServiceList(params);
        return R.ok().put("page", page);
    }
    
    /**
     * 获取规格和品牌
     * @return
     */
    @RequestMapping("/getSpecAndBrankList/{attrId}")
    @RequiresPermissions("goods:goods:getSpecAndBrankList")
    public R getSpecAndBrankList(@PathVariable("attrId") Integer attrId) {
    	List<GoodsSpecEntity> goodsSpec = goodsSpecService.getGoodsSpecList();
    	List<GoodsBrandEntity> goodsBrand = goodsBrandService.getGoodsBrandList();
    	Map<String,Object> map = new HashMap<String,Object>();
    	if(attrId != null && attrId != 0) {
    		AttributeEntity attrValueObj = new AttributeEntity();
    		attrValueObj = attributeService.getAttributeServiceDetail(attrId);
    		map.put("info", attrValueObj);
    	}
    	map.put("goodsguige", goodsSpec);
    	map.put("brand_list", goodsBrand);
    	return R.ok(map);
    }
    
    /**
     * 添加商品类型
     * @return
     */
    @RequestMapping("/addAttributeService")
    @RequiresPermissions("goods:goods:addAttributeService")
    public R addAttributeService(@RequestBody AddAttributeServiceForm form) {
    	ValidatorUtils.validateEntity(form);
    	goodsService.addAttributeService(form.getAttrName(),form.getIsUse(),form.getSelectBox(),
    			form.getSort(),form.getDataObjStr(),form.getSelectBrank());
    	return R.ok();
    }
    
    
    /**
     * 修改商品类型
     * @return
     */
    @RequestMapping("/updateGoodsAttribute")
    @RequiresPermissions("goods:goods:updateGoodsAttribute")
    public R updateGoodsAttribute(@RequestBody AddAttributeServiceForm form) {
    	ValidatorUtils.validateEntity(form);
    	goodsService.updateAttributeService(form.getAttrId(),form.getAttrName(),form.getIsUse()
    			,form.getSelectBox(),form.getSort(),form.getDataObjStr(),form.getSelectBrank());
    	return R.ok();
    }
    
    /**
     * 删除1条商品类型属性
     */
    @RequestMapping("/deleteattributevalue")
    public R deleteattributevalue(@RequestBody AddAttributeServiceForm form) {
    	Integer attrId = form.getAttrId();
    	Integer attrValueId = form.getAttrValueId();
    	List<GoodsAttributeEntity> goodsAttributeEntities = goodsAttributeService.selectList
    			(new EntityWrapper<GoodsAttributeEntity>().eq("attr_value_id", attrValueId).ne("attr_value_name", ""));
    	StringBuffer goodsIDs = new StringBuffer();
    	if(goodsAttributeEntities != null && goodsAttributeEntities.size() > 0) {
    		int i = 0;
			goodsAttributeEntities.forEach(gae -> {
				if(i > 0) {
					goodsIDs.append(",");
				}
				goodsIDs.append(String.valueOf(gae.getGoodsId()));
				
			});
    	}
    	if(goodsIDs.toString().trim().length() > 0) {
    		return R.ok().put("res", goodsIDs);
    	}
    	Integer ret = goodsService.deleteAttributeValueService(attrId,attrValueId);
    	goodsAttributeService.delete(new EntityWrapper<GoodsAttributeEntity>().eq("attr_value_id", attrValueId));
    	if(ret < 0) {
    		return R.error(ErrorMsg.DELETE_FAIL.getCode(), ErrorMsg.DELETE_FAIL.getName());
    	}
    	return R.ok();
    }
    
    /**
     * 实时更新属性值
     * @param form
     * @return
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     * @throws SecurityException 
     * @throws NoSuchFieldException 
     */
    @RequestMapping("/modifyAttributeValueService")
    public R modifyAttributeValueService(@RequestBody ModifyAttrValueServiceForm form) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    	ValidatorUtils.validateEntity(form);
    	Integer res = attributeValueService.modifyAttributeValueService(form.getAttrValueId(),form.getFieldName(),form.getFieldValue());
    	 // 修改成功后修改商品属性表属性排序
    	if(res>= 0) {
    		if(form.getFieldName().equals("sort")) {
    			goodsAttributeService.updateGoodsAttributeSort(form.getAttrValueId(),form.getFieldValue(),this.instance_id);
    		}
    	}
    	return R.ok();
    }
    
    /**
     * 删除商品类型
     * @return
     */
    @RequestMapping("/deleteAttr")
    @RequiresPermissions("goods:goods:deleteAttr")
    public R deleteAttr(@RequestBody DeleteAttrForm form) {
    	ValidatorUtils.validateEntity(form);
    	goodsService.deleteAttributeService(form.getAttrId());
    	return R.ok();
    }
    
    /**
     * 商品规格列表
     * @param params
     * @return
     */
    @RequestMapping("/goodsspeclist")
    @RequiresPermissions("goods:goods:goodsspeclist")
    public R goodsspeclist(@RequestParam Map<String, Object> params) {
    	PageUtils page = goodsService.getGoodsSpecList(params);
        return R.ok().put("page", page);
    }
    
    /**
     * 添加商品规格
     * @param form
     * @return
     */
    @RequestMapping("/addGoodsSpec")
    @RequiresPermissions("goods:goods:addGoodsSpec")
    public R addGoodsSpec(@RequestBody AddGoodsSpecForm form) {
    	ValidatorUtils.validateEntity(form);
    	goodsService.addGoodsSpecService(this.instance_id,form.getSpecName(),form.getShowType(),form.getIsVisible(),form.getSort(),form.getSpecValueStr(),form.getAttrId(),form.getIsScreen(),form.getSpecDes());
    	return R.ok();
    }
    
    
    /**
     * 修改商品规格
     * @param form
     * @return
     */
    @RequestMapping("/updateGoodsSpec")
    @RequiresPermissions("goods:goods:updateGoodsSpec")
    public R updateGoodsSpec(@RequestBody AddGoodsSpecForm form) {
    	ValidatorUtils.validateEntity(form);
    	goodsService.updateGoodsSpecService(form.getSpecId(),this.instance_id,form.getSpecName(),form.getShowType(),form.getIsVisible(),form.getSort(),form.getSpecValueStr(),form.getAttrId(),form.getIsScreen(),form.getSpecDes());
    	return R.ok();
    }
    
    
    /**
     * 获取商品规则值
     * @param specId
     * @return
     */
    @GetMapping("/getGoodsSpecDetail/{specId}")
	@RequiresPermissions("goods:goods:updateGoodsSpec")
    public R getGoodsSpecDetail(@PathVariable("specId") long specId) {
    	GoodsSpecEntity info = new GoodsSpecEntity();
    	info = goodsService.getGoodsSpecDetail(specId);
    	return R.ok().put("info", info);
    }
     
    
    /**
     * 删除商品规格
     * @return
     */
    @RequestMapping("/deleteGoodsSpec")
    @RequiresPermissions("goods:goods:deleteGoodsSpec")
    public R deleteGoodsSpec(@RequestBody DeleteGoodsSpecForm form) {
    	ValidatorUtils.validateEntity(form);
    	goodsService.deleteGoodsSpec(form.getSpecId());
    	return R.ok();
    }
    
    /**
     * 商品分类列表
     * @return
     */
    @RequestMapping("/goodscategorylist")
    @RequiresPermissions("goods:goods:goodscategorylist")
    public R goodscategorylist() {
    	List<GoodsCategoryEntity> goodsCategory = new ArrayList<GoodsCategoryEntity>();
    	goodsCategory = goodsService.getCategoryTreeUseInAdmin();
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("categoryList", goodsCategory);
    	return R.ok(map);
    }
    
    /**
     * 商品分类列表 为兼容vue组建
     * @return
     */
    @RequestMapping("/goodscategorylist2")
    @RequiresPermissions("goods:goods:goodscategorylist")
    public R goodscategorylist2() {
    	List<GoodsCategoryEntity> goodsCategory = new ArrayList<GoodsCategoryEntity>();
    	goodsCategory = goodsCategoryService.selectList(new EntityWrapper<GoodsCategoryEntity>());
    	for(GoodsCategoryEntity item:goodsCategory) {
    		item.setParentId(item.getPid());
    	}
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("categoryList", goodsCategory);
    	return R.ok(map);
    }
    
    /**
     * 商品分类列表 为兼容vue组建  select
     * @return
     */
    @RequestMapping("/goodscategorylistSelect")
    @RequiresPermissions("goods:goods:goodscategorylist")
    public R goodscategorylistSelect() {
    	List<GoodsCategoryEntity> goodsCategory = new ArrayList<GoodsCategoryEntity>();
    	goodsCategory = goodsCategoryService.selectList(new EntityWrapper<GoodsCategoryEntity>());
    	for(GoodsCategoryEntity item:goodsCategory) {
    		item.setParentId(item.getPid());
    	}
    	GoodsCategoryEntity one = new GoodsCategoryEntity();
    	one.setCategoryId(0);
    	one.setParentId(0);
    	one.setCategoryName("顶级菜单");
    	goodsCategory.add(one);
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("categoryList", goodsCategory);
    	return R.ok(map);
    }
    
    /**
     * 添加商品分类
     * @param form
     * @return
     */
    @RequestMapping("/addGoodsCategory")
    @RequiresPermissions("goods:goods:addGoodsCategory")
    public R addGoodsCategory(@RequestBody AddGoodsCategoryForm form) {
    	ValidatorUtils.validateEntity(form);
    	goodsCategoryService.addOrEditGoodsCategory(this.instance_id,0,form.getCategoryName(),
    			form.getShortName(),form.getPid(),form.getIsVisible(),form.getKeywords(),
    			form.getDescription(),form.getSort(),form.getCategoryPic(),form.getAttrId(),
    			form.getAttrName(),form.getIcon());
    	return R.ok();
    }
    
    /**
     * 添加商品分类获取上级分类/商品类型
     * @return
     */
    @RequestMapping("/addGoodsCategoryInfo")
    @RequiresPermissions("goods:goods:addGoodsCategory")
    public R addGoodsCategoryInfo() {
    	List<GoodsCategoryEntity> goodsCategoryList = new ArrayList<GoodsCategoryEntity>();
    	Map<String,Object> map = new HashMap<String,Object>();
    	goodsCategoryList = goodsCategoryService.getGoodsCategoryTree(0);
    	Map<String,Object> params = new HashMap<String,Object>();
    	params.put("page", 1);
    	params.put("limit",0);
    	PageUtils attributeList = goodsService.getAttributeServiceList(params);
    	map.put("categoryList",goodsCategoryList);
    	map.put("goodsAttributeList", attributeList);
    	return R.ok(map);
    }
    

    
   
    /**
     * 修改商品分类
     * @param form
     * @return
     */
    @RequestMapping("/updateGoodsCategory")
    @RequiresPermissions("goods:goods:updateGoodsCategory")
    public R updateGoodsCategory(@RequestBody AddGoodsCategoryForm form) {
    	ValidatorUtils.validateEntity(form);
    	goodsCategoryService.addOrEditGoodsCategory(this.instance_id,form.getCategoryId(),
    			form.getCategoryName(),form.getShortName(),form.getPid(),form.getIsVisible(),
    			form.getKeywords(),form.getDescription(),form.getSort(),form.getCategoryPic(),
    			form.getAttrId(),form.getAttrName(),form.getIcon());
    	return R.ok();
    }
    
    /**
     * 修改商品分类获取分类详情
     * @return
     */
    @RequestMapping("/updateGoodsCategoryInfo/{categoryId}")
    @RequiresPermissions("goods:goods:updateGoodsCategory")
    public R updateGoodsCategoryInfo(@PathVariable("categoryId") Integer categoryId) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	GoodsCategoryEntity goodsCategoryInfo = goodsCategoryService.selectById(categoryId);
    	map.put("data", goodsCategoryInfo);
    	AlbumPictureEntity catePictureEntity = albumPictureService.selectOne
    			(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", goodsCategoryInfo.getCategoryPic()));
    	goodsCategoryInfo.setCatePic(catePictureEntity);
    	AlbumPictureEntity iconPictureEntity = albumPictureService.selectOne
    			(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", goodsCategoryInfo.getIcon()));
    	goodsCategoryInfo.setIconPic(iconPictureEntity);
    	List<GoodsCategoryEntity> categoryList = new ArrayList<GoodsCategoryEntity>();
    	List<GoodsCategoryEntity> chileList = goodsCategoryService.getGoodsCategoryTree(categoryId);
    	List<GoodsCategoryEntity> tempList = new ArrayList<GoodsCategoryEntity>();

    	if(goodsCategoryInfo.getLevel() == 1) {
    		if(chileList.isEmpty()) {
    			categoryList = goodsCategoryService.getGoodsCategoryTree(0);
    		}else {
    			boolean isHave = false;
    			for(int i=0;i<chileList.size();i++) {
    				if(chileList.get(i).getLevel() == 3) {
    					isHave = true;
    				}
    			}
    			if(isHave) {
    				categoryList = null;
    			}else {
    				categoryList = goodsCategoryService.selectList(new EntityWrapper<GoodsCategoryEntity>().eq("pid", 0));
    			}
    		}
    	}else if(goodsCategoryInfo.getLevel() == 2) {
    		chileList = goodsCategoryService.getGoodsCategoryTree(categoryId);
    		if(chileList.isEmpty()) {
    			categoryList = goodsCategoryService.getGoodsCategoryTree(0);
    		}else {
    			categoryList = goodsCategoryService.selectList(new EntityWrapper<GoodsCategoryEntity>().eq("pid", 0));
    		}
    	}else if(goodsCategoryInfo.getLevel() == 3) {
    		categoryList = goodsCategoryService.getGoodsCategoryTree(0);
    	}
    	if(!categoryList.isEmpty()) {
    		for(int j=0;j<categoryList.size();j++) {
    			if(categoryList.get(j).getCategoryId() == categoryId && categoryId != 0) {
    				categoryList.remove(j);
    			}else {
    				List<GoodsCategoryEntity> childList = categoryList.get(j).getChildList();
    				if(childList != null) {
    					tempList = categoryList.get(j).getChildList();
    					for(int k=0;k<tempList.size();k++) {
    						if(tempList.get(k).getCategoryId() == categoryId && categoryId != 0) {
    							tempList.remove(k);
    						}
    					}
    					categoryList.get(j).setChildList(tempList);
    				}
    			}
    		}
    	}
    	map.put("categoryList", categoryList);
    	Map<String,Object> params = new HashMap<String,Object>();
    	params.put("page", 1);
    	params.put("limit",0);
    	PageUtils attributeList = goodsService.getAttributeServiceList(params);
    	map.put("goodsAttributeList", attributeList);
    	return R.ok(map);
    }
    
    /**
     * 删除商品分类
     * @param categoryId
     * @return
     */
    @RequestMapping("/deleteGoodsCategory")
    @RequiresPermissions("goods:goods:deleteGoodsCategory")
    public R deleteGoodsCategory(@RequestBody AddGoodsCategoryForm form) {
    	Integer res = goodsCategoryService.deleteGoodsCategory(form.getCategoryId());
    	if(res < 0) {
    		return R.error(res, ErrorMsg.queryCodeByName(res));
    	}
    	return R.ok();
    }
    
	/**
	 * 商品分组列表 标签分组
	 * @return
	 */
	@RequestMapping("/goodsgrouplist")
	@RequiresPermissions("goods:goods:goodsgrouplist")
	public R goodsgrouplist(@RequestParam Map<String, Object> params) {
		PageUtils page = goodsGroupService.getGoodsGroupList(params);
		return R.ok().put("page", page);
	}
	
	
	/**
	 * 添加商品分组
	 * @param form
	 * @return
	 */
	@RequestMapping("/addGoodsGroup")
	@RequiresPermissions("goods:goods:addGoodsGroup")
	public R addGoodsGroup(@RequestBody AddGoodsGroupForm form) {
    	ValidatorUtils.validateEntity(form);
    	Integer res = goodsGroupService.addOrEditGoodsGroup(0,this.instance_id,form.getGroupName(),form.getPid(),form.getIsVisible(),form.getSort(),form.getGroupPic(),form.getGroupDec());
    	if(res < 0) {
    		return R.error(res, ErrorMsg.queryCodeByName(res));
    	}
    	return R.ok();
	}
	
	
	/**
	 * 修改商品分组
	 * @param form
	 * @return
	 */
	@RequestMapping("/updateGoodsGroup")
	@RequiresPermissions("goods:goods:updateGoodsGroup")
	public R updateGoodsGroup(@RequestBody AddGoodsGroupForm form) {
    	ValidatorUtils.validateEntity(form);
    	Integer res = goodsGroupService.addOrEditGoodsGroup(form.getGroupId(),this.instance_id,form.getGroupName(),form.getPid(),form.getIsVisible(),form.getSort(),form.getGroupPic(),form.getGroupDec());
    	if(res < 0) {
    		return R.error(res, ErrorMsg.queryCodeByName(res));
    	}
    	return R.ok();
	}
    
	
	/**
     * 修改商品分组获取详情
     * @return
     */
    @RequestMapping("/updateGoodsGroupInfo/{groupId}")
    @RequiresPermissions("goods:goods:updateGoodsGroup")
    public R updateGoodsGroupInfo(@PathVariable("groupId") Integer groupId) {
    	GoodsGroupEntity goodsGroupInfo = new GoodsGroupEntity();
    	goodsGroupInfo = goodsGroupService.selectById(groupId);
    	AlbumPictureEntity pictureEntity = albumPictureService.selectOne
    			(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", goodsGroupInfo.getGroupPic()));
    	goodsGroupInfo.setPicture(pictureEntity);
    	return R.ok().put("goodsGroupInfo", goodsGroupInfo);
    }
	
	/**
     * 删除商品分组
     * @return
     */
    @RequestMapping("/deleteGoodsGroup")
    @RequiresPermissions("goods:goods:deleteGoodsGroup")
    public R deleteGoodsGroup(@RequestBody AddGoodsGroupForm form) {
    	Integer res = goodsGroupService.deleteGoodsGroup(form.getGroupId(),this.instance_id);
    	if(res < 0) {
    		return R.error(res, ErrorMsg.queryCodeByName(res));
    	}
    	return R.ok();
    }
    
	/**
	 * 商品评论列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/goodscomment")
//	@RequiresPermissions("goods:goods:goodscomment")
	public R goodscomment(@RequestParam Map<String, Object> params) {
		PageUtils page = goodsEvaluateService.getGoodsEvaluateList(params);
		return R.ok().put("page", page);
	}
    
	/**
	 * 添加商品评价回复
	 * @return
	 */
	@RequestMapping("/replyEvaluateAjax")
	@RequiresPermissions("goods:goods:replyEvaluateAjax")
    public R replyEvaluateAjax(@RequestBody ReplyEvaluateAjaxForm form) {
    	ValidatorUtils.validateEntity(form);
    	goodsEvaluateService.addGoodsEvaluateReply(form.getEvaluateId(),form.getEvaluateReply(),form.getReplyType());
    	return R.ok();
    }
	
	
	/**
	 * 设置评价的显示状态
	 * @return
	 */
	@RequestMapping("/setEvaluteShowStatuAjax")
	@RequiresPermissions("goods:goods:setEvaluteShowStatuAjax")
	public R setEvaluteShowStatuAjax(@RequestBody ReplyEvaluateAjaxForm form) {
    	ValidatorUtils.validateEntity(form);
    	goodsEvaluateService.setEvaluateShowStatu(form.getEvaluateId());
    	return R.ok();
    }
	
	/**
	 * 删除商品评价
	 * @return
	 */
	@RequestMapping("/deleteEvaluateAjax")
	@RequiresPermissions("goods:goods:deleteEvaluateAjax")
	public R deleteEvaluateAjax(@RequestBody ReplyEvaluateAjaxForm form) {
		goodsEvaluateService.deleteById(form.getEvaluateId());
		return R.ok();
	}
	
	/**
	 * 获取单条评价信息
	 * @return
	 */
	@RequestMapping("/getEvaluateAjaxInfo/{evaluateId}")
	@RequiresPermissions("goods:goods:replyEvaluateAjax")
	public R getEvaluateAjaxInfo(@PathVariable("evaluateId") Integer evaluateId) {
		GoodsEvaluateEntity goodsEvaluate = goodsEvaluateService.selectById(evaluateId);
		return R.ok().put("goodsEvaluate", goodsEvaluate);
	}
	
	/**
	 * 根据商品类型id查询，商品规格信息
	 * @param attrId
	 * @return
	 */
	@RequestMapping(value="/getGoodsSpecListByAttrId",method=RequestMethod.POST)
	@RequiresPermissions("goods:goods:addGoods")
	public R getGoodsSpecListByAttrId(@RequestBody AttributeEntity form) {
		List<FormDynamic> list = attributeValueService.getGoodsAttrSpecQuery(form.getAttrId());
		return R.ok().put("form_dynamic",list);
	}
	
	/**
	 * 单一获取规格数据
	 * @param form
	 * @return
	 */
	@RequestMapping(value="/getGoodsSpecInfoQuery",method=RequestMethod.POST)
	@RequiresPermissions("goods:goods:addGoods")
	public R getGoodsSpecInfoQuery(@RequestBody AttributeEntity form) {
		List<GoodsSpecEntity> list = goodsSpecService.getGoodsSpecInfoQuery(form.getAttrId());
		return R.ok().put("specList", list);
	}
	
	/**
	 * 获取省列表，商品添加时用户可以设置商品所在地
	 * @return
	 */
	@RequestMapping(value="/getProvince",method=RequestMethod.POST)
	@RequiresPermissions("goods:goods:addGoods")
	public R getProvince() {
		List<ProvinceEntity> provinceList = addressService.getProvinceList(0);
		return R.ok().put("provinceList", provinceList);
	}
	
	/**
	 * 获取城市列表
	 * @return
	 */
	@RequestMapping(value="/getCity",method=RequestMethod.POST)
	@RequiresPermissions("goods:goods:addGoods")
	public R getCity(HttpServletRequest request) {
		if(StringUtils.isEmpty(request.getParameter("provinceId"))) {
			return R.error();
		}
		Integer provinceId = Integer.parseInt(request.getParameter("provinceId"));
		List<CityEntity> cityList = addressService.getCityList(provinceId);
		return R.ok().put("cityList", cityList);
	}
	
	/**
	 * 商品品牌列表
	 * @return
	 */
	@RequestMapping("/goodsbrandlist")
	@RequiresPermissions("goods:goods:goodsbrandlist")
	public R goodsbrandlist(@RequestParam Map<String,Object> params) {
    	PageUtils page = goodsBrandService.getGoodsBrandList(params,this.instance_id);
        return R.ok().put("page", page);
	}
	
	/**
	 * 添加商品品牌
	 */
	@RequestMapping("/addGoodsBrand")
	@RequiresPermissions("goods:goods:addGoodsBrand")
	public R addGoodsBrand(@RequestBody GoodsBrandEntity form) {
		form.setShopId(this.instance_id);
		form.setSort(0);
		form.setBrandCategoryName("");
		form.setCategoryIdArray("1");
		form.setCategoryName("");
		form.setCategoryId1(0);
		form.setCategoryId2(0);
		form.setCategoryId3(0);
		goodsBrandService.insert(form);
        return R.ok();
	}
	
	/**
	 * 修改商品品牌
	 */
	@RequestMapping("/updateGoodsBrand")
	@RequiresPermissions("goods:goods:updateGoodsBrand")
	public R updateGoodsBrand(@RequestBody GoodsBrandEntity form) {
		form.setShopId(this.instance_id);
		form.setSort(0);
		form.setBrandCategoryName("");
		form.setCategoryIdArray("1");
		form.setCategoryName("");
		form.setCategoryId1(0);
		form.setCategoryId2(0);
		form.setCategoryId3(0);
		goodsBrandService.updateById(form);
        return R.ok();
	}
	
	/**
	 * 修改商品品牌 获取单个品牌
	 */
	@RequestMapping("/updateGoodsBrandInfo/{brandId}")
	@RequiresPermissions("goods:goods:updateGoodsBrand")
    public R updateGoodsBrandInfo(@PathVariable("brandId") Integer brandId) {
    	GoodsBrandEntity goodsBrandInfo = new GoodsBrandEntity();
    	goodsBrandInfo = goodsBrandService.selectById(brandId);
    	return R.ok().put("goodsBrandInfo", goodsBrandInfo);
    }
	
	 /**
	 * 删除商品品牌
	 * @return
	 */
	@RequestMapping("/deleteGoodsBrand")
	@RequiresPermissions("goods:goods:deleteGoodsBrand")
	public R deleteGoodsBrand(@RequestBody GoodsBrandEntity form) {
		goodsBrandService.deleteById(form.getBrandId());
		return R.ok();
	}
		
	/**
	 * 添加或修改商品 获取商品详情
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	public R addGoods2(HttpServletRequest request) {
		Map<String,Object> retvalMap = new HashMap<String,Object>();
		String goodsId = request.getParameter("goodsId");
		String goodsCategoryId = request.getParameter("goodsCategoryId");
		String goodsCategoryName = request.getParameter("goodsCategoryName");
		List<GoodsGroupEntity> goodsGroupList = new ArrayList<GoodsGroupEntity>();
	
		Integer goodsAttrId = 0; //商品类目关联ID
		if(goodsCategoryId != null) {
			retvalMap.put("goodsCategoryId", goodsCategoryId);
			retvalMap.put("goodsCategoryName", goodsCategoryName);
		}
		if(goodsAttrId != null) {
			retvalMap.put("goodsAttrId", goodsAttrId);
		}
		//商品分类
		List<GoodsCategoryEntity> goodsCategoryList = goodsCategoryService.selectList(new EntityWrapper<GoodsCategoryEntity>());
		List<GoodsCategoryEntity> goodsCatList = this.getTreeList(0,goodsCategoryList);
		retvalMap.put("goodsCategoryList", goodsCatList);
		
		//商品类型
		List<AttributeEntity> attributeList = attributeService.selectList(new EntityWrapper<AttributeEntity>().eq("is_use", 1));
		retvalMap.put("AttributeList", attributeList);
		
		//供货商
		List<SupplierEntity> supplierList = supplierService.selectList(new EntityWrapper<SupplierEntity>());
		retvalMap.put("supplierList", supplierList);
		
		//物流 虚拟商品分组  模板 略

		//分组group
		goodsGroupList = goodsGroupService.selectList(new EntityWrapper<GoodsGroupEntity>().eq("shop_id", this.instance_id));
		retvalMap.put("groupList",goodsGroupList);  //分组
		
		if(goodsGroupList.isEmpty()) {
			retvalMap.put("groupStr", "");
		}else {
			retvalMap.put("groupStr", JSONObject.toJSONString(goodsGroupList));
		}
		
		//品牌brand
		List<GoodsBrandEntity> goodsBrandList = goodsBrandService.selectList(new EntityWrapper<GoodsBrandEntity>().eq("shop_id", this.instance_id));
		retvalMap.put("brandList", goodsBrandList);
		if(goodsBrandList.isEmpty()) {
			retvalMap.put("brandStr", "");
		}else {
			retvalMap.put("brandStr", JSONObject.toJSONString(goodsBrandList));
		}
		
		
		retvalMap.put("shopType", 2);
		
		//相册列表
		AlbumClassEntity albumClassDetail = albumClassService.selectOne(new EntityWrapper<AlbumClassEntity>().eq("shop_id", this.instance_id).eq("is_default", 1));
		retvalMap.put("detailAlbumId",albumClassDetail.getAlbumId());    //默认相册ID
		
		long uid = 0;
		GoodsEntity goodsInfo = new GoodsEntity();
		if(goodsId != null) {
			retvalMap.put("goodsId", goodsId);
			goodsInfo = goodsService.getGoodsDetail(Integer.parseInt(goodsId),uid,null);
			if(Integer.parseInt(goodsId) > 0) {
				
				if(goodsInfo != null) {
					SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
					sdf.applyPattern("yyyy-MM-dd HH:mm:ss");      // a为am/pm的标记
					goodsInfo.setPreselltimeFormat(sdf.format(goodsInfo.getPresellTime() * 1000));
					
					//sku多图数据
					List<GoodsSkuPictureEntity> skuPictureList = goodsService.getGoodsSkuPicture(Integer.parseInt(goodsId));
					
					Map<String,Object> goodsAllPicture = new HashMap<String,Object>();
					for(GoodsSkuPictureEntity v:skuPictureList) {
						goodsAllPicture.put(v.getSpecValueId().toString(), v);
					}
					// 判断规格数组中图片路径是id还是路径
					if(goodsInfo.getGoodsSpecFormat() != null && !StringUtils.isEmpty(goodsInfo.getGoodsSpecFormat().trim())) {
						List<GoodsSpecEntity> specList = new ArrayList<GoodsSpecEntity>();
						JSONArray jsonArray = JSONArray.fromObject(goodsInfo.getGoodsSpecFormat()); 
						if(!jsonArray.isEmpty()) {
							for(int i=0;i<jsonArray.size();i++) {
								for(int j=0;j<jsonArray.getJSONObject(i).getJSONArray("specValueList").size();j++) {
									jsonArray.getJSONObject(i).getJSONArray("specValueList").getJSONObject(j).remove("specName");
									jsonArray.getJSONObject(i).getJSONArray("specValueList").getJSONObject(j).remove("specValueDataSrc");
									if(jsonArray.getJSONObject(i).getJSONArray("specValueList").getJSONObject(j).getString("specShowType").equals("null")) {
										jsonArray.getJSONObject(i).getJSONArray("specValueList").getJSONObject(j).put("specShowType", 1);
									}
									Integer picture = 0;
									GoodsSkuPictureEntity skuImgArray = (GoodsSkuPictureEntity)goodsAllPicture.get(jsonArray.getJSONObject(i).getJSONArray("specValueList").getJSONObject(j).getString("specValueId"));
									if(skuImgArray != null) {
										String [] arr = skuImgArray.getSkuImgArray().split(",");
										picture = Integer.parseInt(arr[0]);
									}
									// 查询SKU规格主图，没有返回0
									jsonArray.getJSONObject(i).getJSONArray("specValueList").getJSONObject(j).put("picture", picture);

								}
							}
						}
						specList = JSONArray.toList(jsonArray,new GoodsSpecEntity(),new JsonConfig());
						for(GoodsSpecEntity item:specList) {
							for(int i=0;i<jsonArray.size();i++) {
								List<GoodsSpecValueEntity> specValueList = JSONArray.toList(jsonArray.getJSONObject(i).getJSONArray("specValueList"),new GoodsSpecValueEntity(),new JsonConfig());
								item.setSpecValueList(specValueList);
							}
						}
						
						for(int i=0;i<specList.size();i++) {
							for(int j=0;j<specList.get(i).getSpecValueList().size();j++) {
								if(isInteger(specList.get(i).getSpecValueList().get(j).getSpecValueData()) && specList.get(i).getSpecValueList().get(j).getSpecShowType() == 3) {
									AlbumPictureEntity pictureDetail = albumPictureService.selectById(specList.get(i).getSpecValueList().get(j).getSpecValueData());
									if(pictureDetail != null) {
										specList.get(i).getSpecValueList().get(j).setSpecValueDataSrc(pictureDetail.getPicCoverMicro());
									}
								}else {
									if(!isInteger(specList.get(i).getSpecValueList().get(j).getSpecValueData()) && specList.get(i).getSpecValueList().get(j).getSpecShowType() == 3) {
										specList.get(i).getSpecValueList().get(j).setSpecValueDataSrc(specList.get(i).getSpecValueList().get(j).getSpecValueData());
									}
								}
							}
						}
						String goodsSpecFormat = JSONArray.fromObject(specList).toString();
						goodsInfo.setGoodsSpecFormat(goodsSpecFormat);
						goodsInfo.setDescription(goodsInfo.getDescription().replace("\n", ""));
					}
				}else {
					R.error(ErrorMsg.GOODS_NOT_FOUND.getCode(), ErrorMsg.GOODS_NOT_FOUND.getName());
				}
			}
			retvalMap.put("goodsInfo",goodsInfo);
		}
		
		return R.ok(retvalMap);
	}
	
	@RequestMapping(value="/addGoods",method=RequestMethod.GET)
	@RequiresPermissions("goods:goods:addGoods")
	public R addGoods(HttpServletRequest request) {
		Map<String,Object> resMap = new HashMap<String,Object>();
		String goodsId = request.getParameter("goodsId");
		String goodsCategoryId = request.getParameter("goodsCategoryId");
		String goodsCategoryName = request.getParameter("goodsCategoryName");
		GoodsEntity goodsEntity = goodsService.getGoodsDetail(Integer.parseInt(goodsId), 0l, request);
		if(goodsCategoryId != null) {
			resMap.put("goodsCategoryId", goodsCategoryId);
			resMap.put("goodsCategoryName", goodsCategoryName);
		}
//		if(goodsEntity.getGoodsAttributeId() != null) {
//			resMap.put("goodsAttrId", goodsEntity.getGoodsAttributeId());
//		}
		//商品分类
		List<GoodsCategoryEntity> goodsCategoryList = goodsCategoryService.selectList(new EntityWrapper<GoodsCategoryEntity>());
		List<GoodsCategoryEntity> goodsCatList = this.getTreeList(0,goodsCategoryList);
		resMap.put("goodsCategoryList", goodsCatList);
		List<GoodsGroupEntity> goodsGroupList = goodsGroupService.selectList(new EntityWrapper<GoodsGroupEntity>().eq("shop_id", this.instance_id));
		resMap.put("groupList",goodsGroupList);  //分组
		if(goodsGroupList.isEmpty()) {
			resMap.put("groupStr", "");
		}else {
			resMap.put("groupStr", JSONObject.toJSONString(goodsGroupList));
		}
		//商品类型
		List<AttributeEntity> attributeList = attributeService.selectList(new EntityWrapper<AttributeEntity>().eq("is_use", 1));
		resMap.put("AttributeList", attributeList);
		resMap.put("goodsInfo", goodsEntity);
		return R.ok(resMap);
	}
	
	
	
	
	private List<GoodsCategoryEntity> getTreeList(Integer topId, List<GoodsCategoryEntity> goodsCategoryList) {
		List<GoodsCategoryEntity> resultList=new ArrayList<>();  
        
        //获取顶层元素集合  
        Integer parentId;  
        for (GoodsCategoryEntity entity : goodsCategoryList) {  
            parentId=entity.getPid();  
            entity.setLabel(entity.getCategoryName());
            entity.setValue(entity.getCategoryId());
            if(parentId==null||topId.equals(parentId)){  
                resultList.add(entity);  
            }  
        }  
          
        //获取每个顶层元素的子数据集合  
        for (GoodsCategoryEntity entity : resultList) {  
            entity.setChildren(getSubList(entity.getCategoryId(),goodsCategoryList));  
        }  
          
        return resultList;  
        
	}
	
	/**
	 * 获取子数据集合
	 * @param id
	 * @param entityList
	 * @return
	 */
    private  static List<GoodsCategoryEntity> getSubList(Integer id, List<GoodsCategoryEntity> entityList) {  
        List<GoodsCategoryEntity> childList=new ArrayList<>();  
        Integer parentId;  
          
        //子集的直接子对象  
        for (GoodsCategoryEntity entity : entityList) {  
            parentId=entity.getPid();  
            entity.setLabel(entity.getCategoryName());
            entity.setValue(entity.getCategoryId());
            if(id.equals(parentId)){  
                childList.add(entity);  
            }  
        }  
          
        //子集的间接子对象  
        for (GoodsCategoryEntity entity : childList) {  
            entity.setChildren(getSubList(entity.getCategoryId(), entityList));  
        }  
          
        //递归退出条件  
        if(childList.size()==0){  
            return null;  
        }  
        return childList;  
    }

	/*
	 * 方法二：推荐，速度最快 判断是否为整数
	 * 
	 * @param str 传入的字符串
	 * 
	 * @return 是整数返回true,否则返回false
	 */
	private static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}
	
    
}
