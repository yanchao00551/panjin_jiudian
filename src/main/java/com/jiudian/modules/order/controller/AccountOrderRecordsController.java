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

import com.jiudian.modules.order.entity.AccountOrderRecordsEntity;
import com.jiudian.modules.order.service.AccountOrderRecordsService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 金额账户记录
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:47
 */
@RestController
@RequestMapping("order/accountorderrecords")
public class AccountOrderRecordsController {
    @Autowired
    private AccountOrderRecordsService accountOrderRecordsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("order:accountorderrecords:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = accountOrderRecordsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("order:accountorderrecords:info")
    public R info(@PathVariable("id") Integer id){
			AccountOrderRecordsEntity accountOrderRecords = accountOrderRecordsService.selectById(id);

        return R.ok().put("accountOrderRecords", accountOrderRecords);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:accountorderrecords:save")
    public R save(@RequestBody AccountOrderRecordsEntity accountOrderRecords){
			accountOrderRecordsService.insert(accountOrderRecords);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("order:accountorderrecords:update")
    public R update(@RequestBody AccountOrderRecordsEntity accountOrderRecords){
			accountOrderRecordsService.updateById(accountOrderRecords);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:accountorderrecords:delete")
    public R delete(@RequestBody Integer[] ids){
			accountOrderRecordsService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
