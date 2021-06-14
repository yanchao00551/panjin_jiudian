package com.jiudian.modules.app.form;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.jiudian.modules.app.entity.GenerateOrderGoodsEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 订单表单
 * 
 * @author 20180802
 *
 */
@ApiModel(value = "订单表单")
public class OrderForm {
	
	/**
	 * key:goodsId value:0skuid 1count
	 */
	@ApiModelProperty(value = "订单商品列表")
    @NotNull(message="订单商品列表不能为空")
	private List<GenerateOrderGoodsEntity> generateOrderGoodsEntities;
	
	@ApiModelProperty(value = "订单类型")
    @NotNull(message="订单类型不能为空")
	private int orderType;
	
	@ApiModelProperty(value = "订单收货地址ID")
    @NotNull(message="订单收货地址ID不能为空")
	private String recieverAddressId;
	
	@ApiModelProperty(value = "买家留言")
	private String buyerMsg;
	
	@ApiModelProperty(value = "入住时间")
	private String liveIn;
	
	@ApiModelProperty(value = "离店时间")
	private String leaveOut;
	
	@ApiModelProperty(value = "买家发票ID")
	private String buyerInvoice;
	
	@ApiModelProperty(value = "住客姓名")
	private String receiverName;
	
	@ApiModelProperty(value = "住客联系方式")
	private String receiverMobile;
	
	@ApiModelProperty(value = "金钥匙ID")
	private int keyId;

	public List<GenerateOrderGoodsEntity> getGenerateOrderGoodsEntities() {
		return generateOrderGoodsEntities;
	}

	public void setGenerateOrderGoodsEntities(List<GenerateOrderGoodsEntity> generateOrderGoodsEntities) {
		this.generateOrderGoodsEntities = generateOrderGoodsEntities;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public String getRecieverAddressId() {
		return recieverAddressId;
	}

	public void setRecieverAddressId(String recieverAddressId) {
		this.recieverAddressId = recieverAddressId;
	}

	public String getBuyerMsg() {
		return buyerMsg;
	}

	public void setBuyerMsg(String buyerMsg) {
		this.buyerMsg = buyerMsg;
	}

	public String getLiveIn() {
		return liveIn;
	}

	public void setLiveIn(String liveIn) {
		this.liveIn = liveIn;
	}

	public String getLeaveOut() {
		return leaveOut;
	}

	public void setLeaveOut(String leaveOut) {
		this.leaveOut = leaveOut;
	}

	public String getBuyerInvoice() {
		return buyerInvoice;
	}

	public void setBuyerInvoice(String buyerInvoice) {
		this.buyerInvoice = buyerInvoice;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public int getKeyId() {
		return keyId;
	}

	public void setKeyId(int keyId) {
		this.keyId = keyId;
	}

}
