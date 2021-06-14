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

import com.jiudian.modules.order.entity.OrderPromotionDetailsEntity;
import com.jiudian.modules.order.service.OrderPromotionDetailsService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 订单优惠详情
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:37
 */
@RestController
@RequestMapping("order/orderpromotiondetails")
public class OrderPromotionDetailsController {
    @Autowired
    private OrderPromotionDetailsService orderPromotionDetailsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("order:orderpromotiondetails:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderPromotionDetailsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("order:orderpromotiondetails:info")
    public R info(@PathVariable("id") Integer id){
			OrderPromotionDetailsEntity orderPromotionDetails = orderPromotionDetailsService.selectById(id);

        return R.ok().put("orderPromotionDetails", orderPromotionDetails);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:orderpromotiondetails:save")
    public R save(@RequestBody OrderPromotionDetailsEntity orderPromotionDetails){
			orderPromotionDetailsService.insert(orderPromotionDetails);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("order:orderpromotiondetails:update")
    public R update(@RequestBody OrderPromotionDetailsEntity orderPromotionDetails){
			orderPromotionDetailsService.updateById(orderPromotionDetails);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:orderpromotiondetails:delete")
    public R delete(@RequestBody Integer[] ids){
			orderPromotionDetailsService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
