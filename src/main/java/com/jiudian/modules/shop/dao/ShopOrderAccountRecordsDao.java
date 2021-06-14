package com.jiudian.modules.shop.dao;

import com.jiudian.modules.shop.entity.ShopOrderAccountRecordsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 店铺针对订单的金额分配
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 13:58:03
 */
@Mapper
public interface ShopOrderAccountRecordsDao extends BaseMapper<ShopOrderAccountRecordsEntity> {
	
}
