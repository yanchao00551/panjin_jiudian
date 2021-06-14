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

import com.jiudian.modules.order.entity.OrderPaymentEntity;
import com.jiudian.modules.order.service.OrderPaymentService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 订单支付表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-02 15:13:28
 */
@RestController
@RequestMapping("order/orderpayment")
public class OrderPaymentController {
    @Autowired
    private OrderPaymentService orderPaymentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("order:orderpayment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderPaymentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{outTradeNo}")
    @RequiresPermissions("order:orderpayment:info")
    public R info(@PathVariable("outTradeNo") String outTradeNo){
			OrderPaymentEntity orderPayment = orderPaymentService.selectById(outTradeNo);

        return R.ok().put("orderPayment", orderPayment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:orderpayment:save")
    public R save(@RequestBody OrderPaymentEntity orderPayment){
			orderPaymentService.insert(orderPayment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("order:orderpayment:update")
    public R update(@RequestBody OrderPaymentEntity orderPayment){
			orderPaymentService.updateById(orderPayment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:orderpayment:delete")
    public R delete(@RequestBody String[] outTradeNos){
			orderPaymentService.deleteBatchIds(Arrays.asList(outTradeNos));

        return R.ok();
    }

}
