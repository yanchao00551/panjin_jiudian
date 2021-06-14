package com.jiudian.modules.supplier.controller;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.modules.supplier.entity.SupplierEntity;
import com.jiudian.modules.supplier.service.SupplierService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 供货商表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-30 10:23:09
 */
@RestController
@RequestMapping("supplier/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("supplier:supplier:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = supplierService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{supplierId}")
    @RequiresPermissions("supplier:supplier:update")
    public R info(@PathVariable("supplierId") Integer supplierId){
			SupplierEntity supplier = supplierService.selectById(supplierId);

        return R.ok().put("supplier", supplier);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("supplier:supplier:save")
    public R save(@RequestBody SupplierEntity supplier){
			supplierService.insert(supplier);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("supplier:supplier:update")
    public R update(@RequestBody SupplierEntity supplier){
			supplierService.updateById(supplier);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("supplier:supplier:delete")
    public R delete(@RequestBody SupplierEntity supplier){
			supplierService.deleteById(supplier.getSupplierId());

        return R.ok();
    }

}
