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

import com.jiudian.modules.order.entity.OrderGoodsPromotionDetailsEntity;
import com.jiudian.modules.order.service.OrderGoodsPromotionDetailsService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 订单商品优惠详情
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-02 15:13:28
 */
@RestController
@RequestMapping("order/ordergoodspromotiondetails")
public class OrderGoodsPromotionDetailsController {
    @Autowired
    private OrderGoodsPromotionDetailsService orderGoodsPromotionDetailsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("order:ordergoodspromotiondetails:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderGoodsPromotionDetailsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("order:ordergoodspromotiondetails:info")
    public R info(@PathVariable("id") Integer id){
			OrderGoodsPromotionDetailsEntity orderGoodsPromotionDetails = orderGoodsPromotionDetailsService.selectById(id);

        return R.ok().put("orderGoodsPromotionDetails", orderGoodsPromotionDetails);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:ordergoodspromotiondetails:save")
    public R save(@RequestBody OrderGoodsPromotionDetailsEntity orderGoodsPromotionDetails){
			orderGoodsPromotionDetailsService.insert(orderGoodsPromotionDetails);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("order:ordergoodspromotiondetails:update")
    public R update(@RequestBody OrderGoodsPromotionDetailsEntity orderGoodsPromotionDetails){
			orderGoodsPromotionDetailsService.updateById(orderGoodsPromotionDetails);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:ordergoodspromotiondetails:delete")
    public R delete(@RequestBody Integer[] ids){
			orderGoodsPromotionDetailsService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
