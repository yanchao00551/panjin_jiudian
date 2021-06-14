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

import com.jiudian.modules.express.entity.ExpressShippingItemsLibraryEntity;
import com.jiudian.modules.express.service.ExpressShippingItemsLibraryService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 物流模版打印项库
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-14 09:27:46
 */
@RestController
@RequestMapping("express/expressshippingitemslibrary")
public class ExpressShippingItemsLibraryController {
    @Autowired
    private ExpressShippingItemsLibraryService expressShippingItemsLibraryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("express:expressshippingitemslibrary:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = expressShippingItemsLibraryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("express:expressshippingitemslibrary:info")
    public R info(@PathVariable("id") Integer id){
			ExpressShippingItemsLibraryEntity expressShippingItemsLibrary = expressShippingItemsLibraryService.selectById(id);

        return R.ok().put("expressShippingItemsLibrary", expressShippingItemsLibrary);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("express:expressshippingitemslibrary:save")
    public R save(@RequestBody ExpressShippingItemsLibraryEntity expressShippingItemsLibrary){
			expressShippingItemsLibraryService.insert(expressShippingItemsLibrary);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("express:expressshippingitemslibrary:update")
    public R update(@RequestBody ExpressShippingItemsLibraryEntity expressShippingItemsLibrary){
			expressShippingItemsLibraryService.updateById(expressShippingItemsLibrary);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("express:expressshippingitemslibrary:delete")
    public R delete(@RequestBody Integer[] ids){
			expressShippingItemsLibraryService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
