package com.jiudian.modules.app.form;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "支付表单")
public class PayForm {

	@ApiModelProperty(value = "订单ID")
	@NotNull(message = "订单ID不能为空")
	private long orderId;

	@ApiModelProperty(value = "支付密码")
	@NotNull(message = "支付密码不能为空")
	private String payPwd;
	
	private String usePoint;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getPayPwd() {
		return payPwd;
	}

	public void setPayPwd(String payPwd) {
		this.payPwd = payPwd;
	}

	public String getUsePoint() {
		return usePoint;
	}

	public void setUsePoint(String usePoint) {
		this.usePoint = usePoint;
	}

}
