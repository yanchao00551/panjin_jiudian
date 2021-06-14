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

import com.jiudian.modules.order.entity.OrderPickupEntity;
import com.jiudian.modules.order.service.OrderPickupService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 订单自提点管理
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:54:29
 */
@RestController
@RequestMapping("order/orderpickup")
public class OrderPickupController {
    @Autowired
    private OrderPickupService orderPickupService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("order:orderpickup:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderPickupService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("order:orderpickup:info")
    public R info(@PathVariable("id") Integer id){
			OrderPickupEntity orderPickup = orderPickupService.selectById(id);

        return R.ok().put("orderPickup", orderPickup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:orderpickup:save")
    public R save(@RequestBody OrderPickupEntity orderPickup){
			orderPickupService.insert(orderPickup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("order:orderpickup:update")
    public R update(@RequestBody OrderPickupEntity orderPickup){
			orderPickupService.updateById(orderPickup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:orderpickup:delete")
    public R delete(@RequestBody Integer[] ids){
			orderPickupService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
