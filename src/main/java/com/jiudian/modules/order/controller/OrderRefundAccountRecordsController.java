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

import com.jiudian.modules.order.entity.OrderRefundAccountRecordsEntity;
import com.jiudian.modules.order.service.OrderRefundAccountRecordsService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 订单退款账户记录
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:37
 */
@RestController
@RequestMapping("order/orderrefundaccountrecords")
public class OrderRefundAccountRecordsController {
    @Autowired
    private OrderRefundAccountRecordsService orderRefundAccountRecordsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("order:orderrefundaccountrecords:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderRefundAccountRecordsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("order:orderrefundaccountrecords:info")
    public R info(@PathVariable("id") Integer id){
			OrderRefundAccountRecordsEntity orderRefundAccountRecords = orderRefundAccountRecordsService.selectById(id);

        return R.ok().put("orderRefundAccountRecords", orderRefundAccountRecords);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:orderrefundaccountrecords:save")
    public R save(@RequestBody OrderRefundAccountRecordsEntity orderRefundAccountRecords){
			orderRefundAccountRecordsService.insert(orderRefundAccountRecords);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("order:orderrefundaccountrecords:update")
    public R update(@RequestBody OrderRefundAccountRecordsEntity orderRefundAccountRecords){
			orderRefundAccountRecordsService.updateById(orderRefundAccountRecords);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:orderrefundaccountrecords:delete")
    public R delete(@RequestBody Integer[] ids){
			orderRefundAccountRecordsService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
