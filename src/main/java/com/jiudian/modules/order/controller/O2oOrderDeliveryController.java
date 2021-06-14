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

import com.jiudian.modules.order.entity.O2oOrderDeliveryEntity;
import com.jiudian.modules.order.service.O2oOrderDeliveryService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * o2o订单配送
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:47
 */
@RestController
@RequestMapping("order/o2oorderdelivery")
public class O2oOrderDeliveryController {
    @Autowired
    private O2oOrderDeliveryService o2oOrderDeliveryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("order:o2oorderdelivery:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = o2oOrderDeliveryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("order:o2oorderdelivery:info")
    public R info(@PathVariable("id") Integer id){
			O2oOrderDeliveryEntity o2oOrderDelivery = o2oOrderDeliveryService.selectById(id);

        return R.ok().put("o2oOrderDelivery", o2oOrderDelivery);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:o2oorderdelivery:save")
    public R save(@RequestBody O2oOrderDeliveryEntity o2oOrderDelivery){
			o2oOrderDeliveryService.insert(o2oOrderDelivery);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("order:o2oorderdelivery:update")
    public R update(@RequestBody O2oOrderDeliveryEntity o2oOrderDelivery){
			o2oOrderDeliveryService.updateById(o2oOrderDelivery);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:o2oorderdelivery:delete")
    public R delete(@RequestBody Integer[] ids){
			o2oOrderDeliveryService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
