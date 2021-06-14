package com.jiudian.modules.shop.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 店铺数据表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 13:58:03
 */
@TableName("ns_shop")
public class ShopEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 店铺索引id
	 */
	@TableId
	private Integer shopId;
	/**
	 * 店铺名称
	 */
	private String shopName;
	/**
	 * 店铺类型等级
	 */
	private Integer shopType;
	/**
	 * 会员id
	 */
	private Integer uid;
	/**
	 * 店铺分类
	 */
	private Integer shopGroupId;
	/**
	 * 店铺公司名称
	 */
	private String shopCompanyName;
	/**
	 * 店铺所在省份ID
	 */
	private Integer provinceId;
	/**
	 * 店铺所在市ID
	 */
	private Integer cityId;
	/**
	 * 详细地区
	 */
	private String shopAddress;
	/**
	 * 邮政编码
	 */
	private String shopZip;
	/**
	 * 店铺状态，0关闭，1开启，2审核中
	 */
	private Integer shopState;
	/**
	 * 店铺关闭原因
	 */
	private String shopCloseInfo;
	/**
	 * 店铺排序
	 */
	private Integer shopSort;
	/**
	 * 店铺logo
	 */
	private String shopLogo;
	/**
	 * 店铺横幅
	 */
	private String shopBanner;
	/**
	 * 店铺头像
	 */
	private String shopAvatar;
	/**
	 * 店铺seo关键字
	 */
	private String shopKeywords;
	/**
	 * 店铺seo描述
	 */
	private String shopDescription;
	/**
	 * QQ
	 */
	private String shopQq;
	/**
	 * 阿里旺旺
	 */
	private String shopWw;
	/**
	 * 商家电话
	 */
	private String shopPhone;
	/**
	 * 店铺二级域名
	 */
	private String shopDomain;
	/**
	 * 二级域名修改次数
	 */
	private Integer shopDomainTimes;
	/**
	 * 推荐，0为否，1为是，默认为0
	 */
	private Integer shopRecommend;
	/**
	 * 店铺信用
	 */
	private Integer shopCredit;
	/**
	 * 描述相符度分数
	 */
	private Float shopDesccredit;
	/**
	 * 服务态度分数
	 */
	private Float shopServicecredit;
	/**
	 * 发货速度分数
	 */
	private Float shopDeliverycredit;
	/**
	 * 店铺收藏数量
	 */
	private Integer shopCollect;
	/**
	 * 店铺印章
	 */
	private String shopStamp;
	/**
	 * 打印订单页面下方说明文字
	 */
	private String shopPrintdesc;
	/**
	 * 店铺销售额（不计算退款）
	 */
	private BigDecimal shopSales;
	/**
	 * 店铺账户余额
	 */
	private BigDecimal shopAccount;
	/**
	 * 店铺可提现金额
	 */
	private BigDecimal shopCash;
	/**
	 * 工作时间
	 */
	private String shopWorkingtime;
	/**
	 * 商铺名称
	 */
	private String liveStoreName;
	/**
	 * 商家地址
	 */
	private String liveStoreAddress;
	/**
	 * 商铺电话
	 */
	private String liveStoreTel;
	/**
	 * 公交线路
	 */
	private String liveStoreBus;
	/**
	 * 商家兑换码前缀
	 */
	private String shopVrcodePrefix;
	/**
	 * 7天退换
	 */
	private Integer storeQtian;
	/**
	 * 正品保障
	 */
	private Integer shopZhping;
	/**
	 * 两小时发货
	 */
	private Integer shopErxiaoshi;
	/**
	 * 退货承诺
	 */
	private Integer shopTuihuo;
	/**
	 * 试用中心
	 */
	private Integer shopShiyong;
	/**
	 * 实体验证
	 */
	private Integer shopShiti;
	/**
	 * 消协保证
	 */
	private Integer shopXiaoxie;
	/**
	 * 货到付款
	 */
	private Integer shopHuodaofk;
	/**
	 * 商家配送时间
	 */
	private String shopFreeTime;
	/**
	 * 店铺默认配送区域
	 */
	private String shopRegion;
	/**
	 * 推荐招商员用户id
	 */
	private Integer recommendUid;
	/**
	 * 店铺公众号
	 */
	private String shopQrcode;
	/**
	 * 店铺时间
	 */
	private Integer shopCreateTime;
	/**
	 * 店铺关闭时间
	 */
	private Integer shopEndTime;

	/**
	 * 设置：店铺索引id
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	/**
	 * 获取：店铺索引id
	 */
	public Integer getShopId() {
		return shopId;
	}
	/**
	 * 设置：店铺名称
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	/**
	 * 获取：店铺名称
	 */
	public String getShopName() {
		return shopName;
	}
	/**
	 * 设置：店铺类型等级
	 */
	public void setShopType(Integer shopType) {
		this.shopType = shopType;
	}
	/**
	 * 获取：店铺类型等级
	 */
	public Integer getShopType() {
		return shopType;
	}
	/**
	 * 设置：会员id
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：会员id
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：店铺分类
	 */
	public void setShopGroupId(Integer shopGroupId) {
		this.shopGroupId = shopGroupId;
	}
	/**
	 * 获取：店铺分类
	 */
	public Integer getShopGroupId() {
		return shopGroupId;
	}
	/**
	 * 设置：店铺公司名称
	 */
	public void setShopCompanyName(String shopCompanyName) {
		this.shopCompanyName = shopCompanyName;
	}
	/**
	 * 获取：店铺公司名称
	 */
	public String getShopCompanyName() {
		return shopCompanyName;
	}
	/**
	 * 设置：店铺所在省份ID
	 */
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	/**
	 * 获取：店铺所在省份ID
	 */
	public Integer getProvinceId() {
		return provinceId;
	}
	/**
	 * 设置：店铺所在市ID
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	/**
	 * 获取：店铺所在市ID
	 */
	public Integer getCityId() {
		return cityId;
	}
	/**
	 * 设置：详细地区
	 */
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	/**
	 * 获取：详细地区
	 */
	public String getShopAddress() {
		return shopAddress;
	}
	/**
	 * 设置：邮政编码
	 */
	public void setShopZip(String shopZip) {
		this.shopZip = shopZip;
	}
	/**
	 * 获取：邮政编码
	 */
	public String getShopZip() {
		return shopZip;
	}
	/**
	 * 设置：店铺状态，0关闭，1开启，2审核中
	 */
	public void setShopState(Integer shopState) {
		this.shopState = shopState;
	}
	/**
	 * 获取：店铺状态，0关闭，1开启，2审核中
	 */
	public Integer getShopState() {
		return shopState;
	}
	/**
	 * 设置：店铺关闭原因
	 */
	public void setShopCloseInfo(String shopCloseInfo) {
		this.shopCloseInfo = shopCloseInfo;
	}
	/**
	 * 获取：店铺关闭原因
	 */
	public String getShopCloseInfo() {
		return shopCloseInfo;
	}
	/**
	 * 设置：店铺排序
	 */
	public void setShopSort(Integer shopSort) {
		this.shopSort = shopSort;
	}
	/**
	 * 获取：店铺排序
	 */
	public Integer getShopSort() {
		return shopSort;
	}
	/**
	 * 设置：店铺logo
	 */
	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}
	/**
	 * 获取：店铺logo
	 */
	public String getShopLogo() {
		return shopLogo;
	}
	/**
	 * 设置：店铺横幅
	 */
	public void setShopBanner(String shopBanner) {
		this.shopBanner = shopBanner;
	}
	/**
	 * 获取：店铺横幅
	 */
	public String getShopBanner() {
		return shopBanner;
	}
	/**
	 * 设置：店铺头像
	 */
	public void setShopAvatar(String shopAvatar) {
		this.shopAvatar = shopAvatar;
	}
	/**
	 * 获取：店铺头像
	 */
	public String getShopAvatar() {
		return shopAvatar;
	}
	/**
	 * 设置：店铺seo关键字
	 */
	public void setShopKeywords(String shopKeywords) {
		this.shopKeywords = shopKeywords;
	}
	/**
	 * 获取：店铺seo关键字
	 */
	public String getShopKeywords() {
		return shopKeywords;
	}
	/**
	 * 设置：店铺seo描述
	 */
	public void setShopDescription(String shopDescription) {
		this.shopDescription = shopDescription;
	}
	/**
	 * 获取：店铺seo描述
	 */
	public String getShopDescription() {
		return shopDescription;
	}
	/**
	 * 设置：QQ
	 */
	public void setShopQq(String shopQq) {
		this.shopQq = shopQq;
	}
	/**
	 * 获取：QQ
	 */
	public String getShopQq() {
		return shopQq;
	}
	/**
	 * 设置：阿里旺旺
	 */
	public void setShopWw(String shopWw) {
		this.shopWw = shopWw;
	}
	/**
	 * 获取：阿里旺旺
	 */
	public String getShopWw() {
		return shopWw;
	}
	/**
	 * 设置：商家电话
	 */
	public void setShopPhone(String shopPhone) {
		this.shopPhone = shopPhone;
	}
	/**
	 * 获取：商家电话
	 */
	public String getShopPhone() {
		return shopPhone;
	}
	/**
	 * 设置：店铺二级域名
	 */
	public void setShopDomain(String shopDomain) {
		this.shopDomain = shopDomain;
	}
	/**
	 * 获取：店铺二级域名
	 */
	public String getShopDomain() {
		return shopDomain;
	}
	/**
	 * 设置：二级域名修改次数
	 */
	public void setShopDomainTimes(Integer shopDomainTimes) {
		this.shopDomainTimes = shopDomainTimes;
	}
	/**
	 * 获取：二级域名修改次数
	 */
	public Integer getShopDomainTimes() {
		return shopDomainTimes;
	}
	/**
	 * 设置：推荐，0为否，1为是，默认为0
	 */
	public void setShopRecommend(Integer shopRecommend) {
		this.shopRecommend = shopRecommend;
	}
	/**
	 * 获取：推荐，0为否，1为是，默认为0
	 */
	public Integer getShopRecommend() {
		return shopRecommend;
	}
	/**
	 * 设置：店铺信用
	 */
	public void setShopCredit(Integer shopCredit) {
		this.shopCredit = shopCredit;
	}
	/**
	 * 获取：店铺信用
	 */
	public Integer getShopCredit() {
		return shopCredit;
	}
	/**
	 * 设置：描述相符度分数
	 */
	public void setShopDesccredit(Float shopDesccredit) {
		this.shopDesccredit = shopDesccredit;
	}
	/**
	 * 获取：描述相符度分数
	 */
	public Float getShopDesccredit() {
		return shopDesccredit;
	}
	/**
	 * 设置：服务态度分数
	 */
	public void setShopServicecredit(Float shopServicecredit) {
		this.shopServicecredit = shopServicecredit;
	}
	/**
	 * 获取：服务态度分数
	 */
	public Float getShopServicecredit() {
		return shopServicecredit;
	}
	/**
	 * 设置：发货速度分数
	 */
	public void setShopDeliverycredit(Float shopDeliverycredit) {
		this.shopDeliverycredit = shopDeliverycredit;
	}
	/**
	 * 获取：发货速度分数
	 */
	public Float getShopDeliverycredit() {
		return shopDeliverycredit;
	}
	/**
	 * 设置：店铺收藏数量
	 */
	public void setShopCollect(Integer shopCollect) {
		this.shopCollect = shopCollect;
	}
	/**
	 * 获取：店铺收藏数量
	 */
	public Integer getShopCollect() {
		return shopCollect;
	}
	/**
	 * 设置：店铺印章
	 */
	public void setShopStamp(String shopStamp) {
		this.shopStamp = shopStamp;
	}
	/**
	 * 获取：店铺印章
	 */
	public String getShopStamp() {
		return shopStamp;
	}
	/**
	 * 设置：打印订单页面下方说明文字
	 */
	public void setShopPrintdesc(String shopPrintdesc) {
		this.shopPrintdesc = shopPrintdesc;
	}
	/**
	 * 获取：打印订单页面下方说明文字
	 */
	public String getShopPrintdesc() {
		return shopPrintdesc;
	}
	/**
	 * 设置：店铺销售额（不计算退款）
	 */
	public void setShopSales(BigDecimal shopSales) {
		this.shopSales = shopSales;
	}
	/**
	 * 获取：店铺销售额（不计算退款）
	 */
	public BigDecimal getShopSales() {
		return shopSales;
	}
	/**
	 * 设置：店铺账户余额
	 */
	public void setShopAccount(BigDecimal shopAccount) {
		this.shopAccount = shopAccount;
	}
	/**
	 * 获取：店铺账户余额
	 */
	public BigDecimal getShopAccount() {
		return shopAccount;
	}
	/**
	 * 设置：店铺可提现金额
	 */
	public void setShopCash(BigDecimal shopCash) {
		this.shopCash = shopCash;
	}
	/**
	 * 获取：店铺可提现金额
	 */
	public BigDecimal getShopCash() {
		return shopCash;
	}
	/**
	 * 设置：工作时间
	 */
	public void setShopWorkingtime(String shopWorkingtime) {
		this.shopWorkingtime = shopWorkingtime;
	}
	/**
	 * 获取：工作时间
	 */
	public String getShopWorkingtime() {
		return shopWorkingtime;
	}
	/**
	 * 设置：商铺名称
	 */
	public void setLiveStoreName(String liveStoreName) {
		this.liveStoreName = liveStoreName;
	}
	/**
	 * 获取：商铺名称
	 */
	public String getLiveStoreName() {
		return liveStoreName;
	}
	/**
	 * 设置：商家地址
	 */
	public void setLiveStoreAddress(String liveStoreAddress) {
		this.liveStoreAddress = liveStoreAddress;
	}
	/**
	 * 获取：商家地址
	 */
	public String getLiveStoreAddress() {
		return liveStoreAddress;
	}
	/**
	 * 设置：商铺电话
	 */
	public void setLiveStoreTel(String liveStoreTel) {
		this.liveStoreTel = liveStoreTel;
	}
	/**
	 * 获取：商铺电话
	 */
	public String getLiveStoreTel() {
		return liveStoreTel;
	}
	/**
	 * 设置：公交线路
	 */
	public void setLiveStoreBus(String liveStoreBus) {
		this.liveStoreBus = liveStoreBus;
	}
	/**
	 * 获取：公交线路
	 */
	public String getLiveStoreBus() {
		return liveStoreBus;
	}
	/**
	 * 设置：商家兑换码前缀
	 */
	public void setShopVrcodePrefix(String shopVrcodePrefix) {
		this.shopVrcodePrefix = shopVrcodePrefix;
	}
	/**
	 * 获取：商家兑换码前缀
	 */
	public String getShopVrcodePrefix() {
		return shopVrcodePrefix;
	}
	/**
	 * 设置：7天退换
	 */
	public void setStoreQtian(Integer storeQtian) {
		this.storeQtian = storeQtian;
	}
	/**
	 * 获取：7天退换
	 */
	public Integer getStoreQtian() {
		return storeQtian;
	}
	/**
	 * 设置：正品保障
	 */
	public void setShopZhping(Integer shopZhping) {
		this.shopZhping = shopZhping;
	}
	/**
	 * 获取：正品保障
	 */
	public Integer getShopZhping() {
		return shopZhping;
	}
	/**
	 * 设置：两小时发货
	 */
	public void setShopErxiaoshi(Integer shopErxiaoshi) {
		this.shopErxiaoshi = shopErxiaoshi;
	}
	/**
	 * 获取：两小时发货
	 */
	public Integer getShopErxiaoshi() {
		return shopErxiaoshi;
	}
	/**
	 * 设置：退货承诺
	 */
	public void setShopTuihuo(Integer shopTuihuo) {
		this.shopTuihuo = shopTuihuo;
	}
	/**
	 * 获取：退货承诺
	 */
	public Integer getShopTuihuo() {
		return shopTuihuo;
	}
	/**
	 * 设置：试用中心
	 */
	public void setShopShiyong(Integer shopShiyong) {
		this.shopShiyong = shopShiyong;
	}
	/**
	 * 获取：试用中心
	 */
	public Integer getShopShiyong() {
		return shopShiyong;
	}
	/**
	 * 设置：实体验证
	 */
	public void setShopShiti(Integer shopShiti) {
		this.shopShiti = shopShiti;
	}
	/**
	 * 获取：实体验证
	 */
	public Integer getShopShiti() {
		return shopShiti;
	}
	/**
	 * 设置：消协保证
	 */
	public void setShopXiaoxie(Integer shopXiaoxie) {
		this.shopXiaoxie = shopXiaoxie;
	}
	/**
	 * 获取：消协保证
	 */
	public Integer getShopXiaoxie() {
		return shopXiaoxie;
	}
	/**
	 * 设置：货到付款
	 */
	public void setShopHuodaofk(Integer shopHuodaofk) {
		this.shopHuodaofk = shopHuodaofk;
	}
	/**
	 * 获取：货到付款
	 */
	public Integer getShopHuodaofk() {
		return shopHuodaofk;
	}
	/**
	 * 设置：商家配送时间
	 */
	public void setShopFreeTime(String shopFreeTime) {
		this.shopFreeTime = shopFreeTime;
	}
	/**
	 * 获取：商家配送时间
	 */
	public String getShopFreeTime() {
		return shopFreeTime;
	}
	/**
	 * 设置：店铺默认配送区域
	 */
	public void setShopRegion(String shopRegion) {
		this.shopRegion = shopRegion;
	}
	/**
	 * 获取：店铺默认配送区域
	 */
	public String getShopRegion() {
		return shopRegion;
	}
	/**
	 * 设置：推荐招商员用户id
	 */
	public void setRecommendUid(Integer recommendUid) {
		this.recommendUid = recommendUid;
	}
	/**
	 * 获取：推荐招商员用户id
	 */
	public Integer getRecommendUid() {
		return recommendUid;
	}
	/**
	 * 设置：店铺公众号
	 */
	public void setShopQrcode(String shopQrcode) {
		this.shopQrcode = shopQrcode;
	}
	/**
	 * 获取：店铺公众号
	 */
	public String getShopQrcode() {
		return shopQrcode;
	}
	/**
	 * 设置：店铺时间
	 */
	public void setShopCreateTime(Integer shopCreateTime) {
		this.shopCreateTime = shopCreateTime;
	}
	/**
	 * 获取：店铺时间
	 */
	public Integer getShopCreateTime() {
		return shopCreateTime;
	}
	/**
	 * 设置：店铺关闭时间
	 */
	public void setShopEndTime(Integer shopEndTime) {
		this.shopEndTime = shopEndTime;
	}
	/**
	 * 获取：店铺关闭时间
	 */
	public Integer getShopEndTime() {
		return shopEndTime;
	}
}
