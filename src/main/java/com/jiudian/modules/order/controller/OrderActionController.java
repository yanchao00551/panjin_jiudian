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

import com.jiudian.modules.order.entity.OrderActionEntity;
import com.jiudian.modules.order.service.OrderActionService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 订单操作表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:35
 */
@RestController
@RequestMapping("order/orderaction")
public class OrderActionController {
    @Autowired
    private OrderActionService orderActionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("order:orderaction:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderActionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{actionId}")
    @RequiresPermissions("order:orderaction:info")
    public R info(@PathVariable("actionId") Integer actionId){
			OrderActionEntity orderAction = orderActionService.selectById(actionId);

        return R.ok().put("orderAction", orderAction);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:orderaction:save")
    public R save(@RequestBody OrderActionEntity orderAction){
			orderActionService.insert(orderAction);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("order:orderaction:update")
    public R update(@RequestBody OrderActionEntity orderAction){
			orderActionService.updateById(orderAction);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:orderaction:delete")
    public R delete(@RequestBody Integer[] actionIds){
			orderActionService.deleteBatchIds(Arrays.asList(actionIds));

        return R.ok();
    }

}
