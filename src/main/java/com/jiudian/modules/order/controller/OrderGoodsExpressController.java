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

import com.jiudian.modules.order.entity.OrderGoodsExpressEntity;
import com.jiudian.modules.order.service.OrderGoodsExpressService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 商品订单物流信息表（多次发货）
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-02 15:13:19
 */
@RestController
@RequestMapping("order/ordergoodsexpress")
public class OrderGoodsExpressController {
    @Autowired
    private OrderGoodsExpressService orderGoodsExpressService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("order:ordergoodsexpress:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderGoodsExpressService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("order:ordergoodsexpress:info")
    public R info(@PathVariable("id") Integer id){
			OrderGoodsExpressEntity orderGoodsExpress = orderGoodsExpressService.selectById(id);

        return R.ok().put("orderGoodsExpress", orderGoodsExpress);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:ordergoodsexpress:save")
    public R save(@RequestBody OrderGoodsExpressEntity orderGoodsExpress){
			orderGoodsExpressService.insert(orderGoodsExpress);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("order:ordergoodsexpress:update")
    public R update(@RequestBody OrderGoodsExpressEntity orderGoodsExpress){
			orderGoodsExpressService.updateById(orderGoodsExpress);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:ordergoodsexpress:delete")
    public R delete(@RequestBody Integer[] ids){
			orderGoodsExpressService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
