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

import com.jiudian.modules.express.entity.ExpressShippingEntity;
import com.jiudian.modules.express.service.ExpressShippingService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 运单模板
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-14 09:27:46
 */
@RestController
@RequestMapping("express/expressshipping")
public class ExpressShippingController {
    @Autowired
    private ExpressShippingService expressShippingService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("express:expressshipping:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = expressShippingService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{sid}")
    @RequiresPermissions("express:expressshipping:info")
    public R info(@PathVariable("sid") Integer sid){
			ExpressShippingEntity expressShipping = expressShippingService.selectById(sid);

        return R.ok().put("expressShipping", expressShipping);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("express:expressshipping:save")
    public R save(@RequestBody ExpressShippingEntity expressShipping){
			expressShippingService.insert(expressShipping);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("express:expressshipping:update")
    public R update(@RequestBody ExpressShippingEntity expressShipping){
			expressShippingService.updateById(expressShipping);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("express:expressshipping:delete")
    public R delete(@RequestBody Integer[] sids){
			expressShippingService.deleteBatchIds(Arrays.asList(sids));

        return R.ok();
    }

}
