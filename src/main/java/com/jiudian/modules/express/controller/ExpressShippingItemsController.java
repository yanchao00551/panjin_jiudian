package com.jiudian.modules.express.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.modules.express.entity.ExpressShippingItemsEntity;
import com.jiudian.modules.express.service.ExpressShippingItemsService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 物流模板打印项
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-14 09:27:46
 */
@RestController
@RequestMapping("express/expressshippingitems")
public class ExpressShippingItemsController {
    @Autowired
    private ExpressShippingItemsService expressShippingItemsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("express:expressshippingitems:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = expressShippingItemsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{sid}")
    @RequiresPermissions("express:expressshippingitems:info")
    public R info(@PathVariable("sid") Integer sid){
			ExpressShippingItemsEntity expressShippingItems = expressShippingItemsService.selectById(sid);

        return R.ok().put("expressShippingItems", expressShippingItems);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("express:expressshippingitems:save")
    public R save(@RequestBody ExpressShippingItemsEntity expressShippingItems){
			expressShippingItemsService.insert(expressShippingItems);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("express:expressshippingitems:update")
    public R update(@RequestBody ExpressShippingItemsEntity expressShippingItems){
			expressShippingItemsService.updateById(expressShippingItems);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("express:expressshippingitems:delete")
    public R delete(@RequestBody Integer[] sids){
			expressShippingItemsService.deleteBatchIds(Arrays.asList(sids));

        return R.ok();
    }

}
