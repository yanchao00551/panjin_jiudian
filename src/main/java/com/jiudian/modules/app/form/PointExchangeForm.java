package com.jiudian.modules.app.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 积分兑换
 * @author Mr.Yan
 *
 */
@ApiModel(value = "积分兑换表单")

public class PointExchangeForm {
    @ApiModelProperty(value = "兑换额度")
    @NotNull(message="积分兑换额度不能为空")
    private String pointNum;

	public String getPointNum() {
		return pointNum;
	}

	public void setPointNum(String pointNum) {
		this.pointNum = pointNum;
	}

    
    
    
}
