package com.jiudian.modules.order.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 订单商品退货退款操作表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:37
 */
@TableName("ns_order_refund")
public class OrderRefundEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 订单商品表id
	 */
	private Integer orderGoodsId;
	/**
	 * 操作状态
	 * 流程状态(refund_status)	状态名称(refund_status_name)	操作时间
	 * 1	买家申请	发起了退款申请,等待卖家处理
	 * 2	等待买家退货	卖家已同意退款申请,等待买家退货
	 * 3	等待卖家确认收货	买家已退货,等待卖家确认收货
	 * 4	等待卖家确认退款	卖家同意退款
	 * 0	退款已成功	卖家退款给买家，本次维权结束
	 * -1	退款已拒绝	卖家拒绝本次退款，本次维权结束
	 * -2	退款已关闭	主动撤销退款，退款关闭
	 * -3	退款申请不通过	拒绝了本次退款申请,等待买家修改
	 */
	private String refundStatus;
	/**
	 * 退款操作内容描述
	 */
	private String action;
	/**
	 * 操作方 1 买家 2 卖家
	 */
	private Integer actionWay;
	/**
	 * 操作人id
	 */
	private String actionUserid;
	/**
	 * 操作人姓名
	 */
	private String actionUsername;
	/**
	 * 操作时间
	 */
	private Integer actionTime;

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：订单商品表id
	 */
	public void setOrderGoodsId(Integer orderGoodsId) {
		this.orderGoodsId = orderGoodsId;
	}
	/**
	 * 获取：订单商品表id
	 */
	public Integer getOrderGoodsId() {
		return orderGoodsId;
	}
	/**
	 * 设置：操作状态
	 * 流程状态(refund_status)	状态名称(refund_status_name)	操作时间
	 * 1	买家申请	发起了退款申请,等待卖家处理
	 * 2	等待买家退货	卖家已同意退款申请,等待买家退货
	 * 3	等待卖家确认收货	买家已退货,等待卖家确认收货
	 * 4	等待卖家确认退款	卖家同意退款
	 * 0	退款已成功	卖家退款给买家，本次维权结束
	 * -1	退款已拒绝	卖家拒绝本次退款，本次维权结束
	 * -2	退款已关闭	主动撤销退款，退款关闭
	 * -3	退款申请不通过	拒绝了本次退款申请,等待买家修改
	 */
	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}
	/**
	 * 获取：操作状态
	 * 流程状态(refund_status)	状态名称(refund_status_name)	操作时间
	 * 1	买家申请	发起了退款申请,等待卖家处理
	 * 2	等待买家退货	卖家已同意退款申请,等待买家退货
	 * 3	等待卖家确认收货	买家已退货,等待卖家确认收货
	 * 4	等待卖家确认退款	卖家同意退款
	 * 0	退款已成功	卖家退款给买家，本次维权结束
	 * -1	退款已拒绝	卖家拒绝本次退款，本次维权结束
	 * -2	退款已关闭	主动撤销退款，退款关闭
	 * -3	退款申请不通过	拒绝了本次退款申请,等待买家修改
	 */
	public String getRefundStatus() {
		return refundStatus;
	}
	/**
	 * 设置：退款操作内容描述
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * 获取：退款操作内容描述
	 */
	public String getAction() {
		return action;
	}
	/**
	 * 设置：操作方 1 买家 2 卖家
	 */
	public void setActionWay(Integer actionWay) {
		this.actionWay = actionWay;
	}
	/**
	 * 获取：操作方 1 买家 2 卖家
	 */
	public Integer getActionWay() {
		return actionWay;
	}
	/**
	 * 设置：操作人id
	 */
	public void setActionUserid(String actionUserid) {
		this.actionUserid = actionUserid;
	}
	/**
	 * 获取：操作人id
	 */
	public String getActionUserid() {
		return actionUserid;
	}
	/**
	 * 设置：操作人姓名
	 */
	public void setActionUsername(String actionUsername) {
		this.actionUsername = actionUsername;
	}
	/**
	 * 获取：操作人姓名
	 */
	public String getActionUsername() {
		return actionUsername;
	}
	/**
	 * 设置：操作时间
	 */
	public void setActionTime(Integer actionTime) {
		this.actionTime = actionTime;
	}
	/**
	 * 获取：操作时间
	 */
	public Integer getActionTime() {
		return actionTime;
	}
}
