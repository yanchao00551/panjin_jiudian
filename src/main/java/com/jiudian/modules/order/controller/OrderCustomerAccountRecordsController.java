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

import com.jiudian.modules.order.entity.OrderCustomerAccountRecordsEntity;
import com.jiudian.modules.order.service.OrderCustomerAccountRecordsService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 订单售后账户记录
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:36
 */
@RestController
@RequestMapping("order/ordercustomeraccountrecords")
public class OrderCustomerAccountRecordsController {
    @Autowired
    private OrderCustomerAccountRecordsService orderCustomerAccountRecordsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("order:ordercustomeraccountrecords:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderCustomerAccountRecordsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("order:ordercustomeraccountrecords:info")
    public R info(@PathVariable("id") Integer id){
			OrderCustomerAccountRecordsEntity orderCustomerAccountRecords = orderCustomerAccountRecordsService.selectById(id);

        return R.ok().put("orderCustomerAccountRecords", orderCustomerAccountRecords);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:ordercustomeraccountrecords:save")
    public R save(@RequestBody OrderCustomerAccountRecordsEntity orderCustomerAccountRecords){
			orderCustomerAccountRecordsService.insert(orderCustomerAccountRecords);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("order:ordercustomeraccountrecords:update")
    public R update(@RequestBody OrderCustomerAccountRecordsEntity orderCustomerAccountRecords){
			orderCustomerAccountRecordsService.updateById(orderCustomerAccountRecords);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:ordercustomeraccountrecords:delete")
    public R delete(@RequestBody Integer[] ids){
			orderCustomerAccountRecordsService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
