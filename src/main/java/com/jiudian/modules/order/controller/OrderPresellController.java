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

import com.jiudian.modules.order.entity.OrderPresellEntity;
import com.jiudian.modules.order.service.OrderPresellService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 预售订单表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:37
 */
@RestController
@RequestMapping("order/orderpresell")
public class OrderPresellController {
    @Autowired
    private OrderPresellService orderPresellService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("order:orderpresell:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderPresellService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{presellOrderId}")
    @RequiresPermissions("order:orderpresell:info")
    public R info(@PathVariable("presellOrderId") Integer presellOrderId){
			OrderPresellEntity orderPresell = orderPresellService.selectById(presellOrderId);

        return R.ok().put("orderPresell", orderPresell);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:orderpresell:save")
    public R save(@RequestBody OrderPresellEntity orderPresell){
			orderPresellService.insert(orderPresell);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("order:orderpresell:update")
    public R update(@RequestBody OrderPresellEntity orderPresell){
			orderPresellService.updateById(orderPresell);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:orderpresell:delete")
    public R delete(@RequestBody Integer[] presellOrderIds){
			orderPresellService.deleteBatchIds(Arrays.asList(presellOrderIds));

        return R.ok();
    }

}
