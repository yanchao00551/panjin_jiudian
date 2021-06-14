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

import com.jiudian.modules.order.entity.OrderRefundEntity;
import com.jiudian.modules.order.service.OrderRefundService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 订单商品退货退款操作表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:37
 */
@RestController
@RequestMapping("order/orderrefund")
public class OrderRefundController {
    @Autowired
    private OrderRefundService orderRefundService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("order:orderrefund:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderRefundService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("order:orderrefund:info")
    public R info(@PathVariable("id") Integer id){
			OrderRefundEntity orderRefund = orderRefundService.selectById(id);

        return R.ok().put("orderRefund", orderRefund);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:orderrefund:save")
    public R save(@RequestBody OrderRefundEntity orderRefund){
			orderRefundService.insert(orderRefund);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("order:orderrefund:update")
    public R update(@RequestBody OrderRefundEntity orderRefund){
			orderRefundService.updateById(orderRefund);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:orderrefund:delete")
    public R delete(@RequestBody Integer[] ids){
			orderRefundService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
