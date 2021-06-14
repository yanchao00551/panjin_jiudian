package com.jiudian.modules.app.form;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 评论服务星或金钥匙
 * @author Mr.Yan
 *
 */
@ApiModel(value = "评论服务星或金钥匙表单")

public class CommentStarForm {
    @ApiModelProperty(value = "评论类型")
    @NotNull(message="评论类型不能为空")
    private Integer type;
    
    @ApiModelProperty(value = "评论服务星或金钥匙ID")
    @NotNull(message="评论对象ID不能为空")
    private Integer starId;
    
    
    @ApiModelProperty(value = "评论内容")
    @NotNull(message="评论内容不能为空")
    private String content;
    
    @ApiModelProperty(value = "评论评分")
    @NotNull(message="评论评分不能为空")
    private double point;
    
    @ApiModelProperty(value = "面向该金钥匙评论对应的订单ID(评论类型为金钥匙时必填)")
    @NotNull(message="订单ID不能为空")
    private int orderId;


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	public Integer getStarId() {
		return starId;
	}


	public void setStarId(Integer starId) {
		this.starId = starId;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public double getPoint() {
		return point;
	}


	public void setPoint(double point) {
		this.point = point;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
    
}
