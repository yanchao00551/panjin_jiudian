package com.jiudian.modules.invoice.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.modules.invoice.entity.UserInvoiceEntity;
import com.jiudian.modules.invoice.service.UserInvoiceService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 
 *
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-09-29 15:29:06
 */
@RestController
@RequestMapping("invoice/userinvoice")
public class UserInvoiceController {
    @Autowired
    private UserInvoiceService userInvoiceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("invoice:userinvoice:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userInvoiceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{invoiceId}")
//    @RequiresPermissions("invoice:userinvoice:info")
    public R info(@PathVariable("invoiceId") Integer invoiceId){
			UserInvoiceEntity userInvoice = userInvoiceService.selectById(invoiceId);

        return R.ok().put("userInvoice", userInvoice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("invoice:userinvoice:save")
    public R save(@RequestBody UserInvoiceEntity userInvoice){
			userInvoiceService.insert(userInvoice);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("invoice:userinvoice:update")
    public R update(@RequestBody UserInvoiceEntity userInvoice){
			userInvoiceService.updateById(userInvoice);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("invoice:userinvoice:delete")
    public R delete(@RequestBody Integer[] invoiceIds){
			userInvoiceService.deleteBatchIds(Arrays.asList(invoiceIds));

        return R.ok();
    }

}
