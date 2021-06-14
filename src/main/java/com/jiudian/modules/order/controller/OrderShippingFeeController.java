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

import com.jiudian.modules.order.entity.OrderShippingFeeEntity;
import com.jiudian.modules.order.service.OrderShippingFeeService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 运费模板
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:36
 */
@RestController
@RequestMapping("order/ordershippingfee")
public class OrderShippingFeeController {
    @Autowired
    private OrderShippingFeeService orderShippingFeeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("order:ordershippingfee:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderShippingFeeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{shippingFeeId}")
    @RequiresPermissions("order:ordershippingfee:info")
    public R info(@PathVariable("shippingFeeId") Integer shippingFeeId){
			OrderShippingFeeEntity orderShippingFee = orderShippingFeeService.selectById(shippingFeeId);

        return R.ok().put("orderShippingFee", orderShippingFee);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:ordershippingfee:save")
    public R save(@RequestBody OrderShippingFeeEntity orderShippingFee){
			orderShippingFeeService.insert(orderShippingFee);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("order:ordershippingfee:update")
    public R update(@RequestBody OrderShippingFeeEntity orderShippingFee){
			orderShippingFeeService.updateById(orderShippingFee);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:ordershippingfee:delete")
    public R delete(@RequestBody Integer[] shippingFeeIds){
			orderShippingFeeService.deleteBatchIds(Arrays.asList(shippingFeeIds));

        return R.ok();
    }

}
