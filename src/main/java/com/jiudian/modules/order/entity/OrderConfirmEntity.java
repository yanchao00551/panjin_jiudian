package com.jiudian.modules.order.entity;

import java.util.List;

import com.jiudian.modules.goods.entity.GoodsEntity;
import com.jiudian.modules.member.entity.MemberEntity;
import com.jiudian.modules.member.entity.MemberExpressAddressEntity;

public class OrderConfirmEntity {

	/**
	 * 会员信息
	 */
	private MemberEntity memberEntity;
	
	/**
	 * 会员默认收货地址
	 */
	private MemberExpressAddressEntity expressAddressEntity;
	
	/**
	 * 商品信息列表
	 */
	private List<GoodsEntity> goodsEntities;

	public MemberEntity getMemberEntity() {
		return memberEntity;
	}

	public void setMemberEntity(MemberEntity memberEntity) {
		this.memberEntity = memberEntity;
	}

	public MemberExpressAddressEntity getExpressAddressEntity() {
		return expressAddressEntity;
	}

	public void setExpressAddressEntity(MemberExpressAddressEntity expressAddressEntity) {
		this.expressAddressEntity = expressAddressEntity;
	}

	public List<GoodsEntity> getGoodsEntities() {
		return goodsEntities;
	}

	public void setGoodsEntities(List<GoodsEntity> goodsEntities) {
		this.goodsEntities = goodsEntities;
	}
	
}
