package com.jiudian.modules.order.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;
import com.jiudian.modules.order.entity.OrderGoodsEntity;
import com.jiudian.modules.order.service.OrderGoodsService;



/**
 * 订单商品表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:36
 */
@RestController
@RequestMapping("order/ordergoods")
public class OrderGoodsController {
    @Autowired
    private OrderGoodsService orderGoodsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("order:ordergoods:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderGoodsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{orderGoodsId}")
    @RequiresPermissions("order:ordergoods:info")
    public R info(@PathVariable("orderGoodsId") Integer orderGoodsId){
			OrderGoodsEntity orderGoods = orderGoodsService.selectById(orderGoodsId);

        return R.ok().put("orderGoods", orderGoods);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:ordergoods:save")
    public R save(@RequestBody OrderGoodsEntity orderGoods){
			orderGoodsService.insert(orderGoods);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("order:ordergoods:update")
    public R update(@RequestBody OrderGoodsEntity orderGoods){
			orderGoodsService.updateById(orderGoods);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:ordergoods:delete")
    public R delete(@RequestBody Integer[] orderGoodsIds){
			orderGoodsService.deleteBatchIds(Arrays.asList(orderGoodsIds));

        return R.ok();
    }

}
