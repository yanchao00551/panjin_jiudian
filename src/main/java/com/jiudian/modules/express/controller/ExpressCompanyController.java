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

import com.jiudian.modules.express.entity.ExpressCompanyEntity;
import com.jiudian.modules.express.service.ExpressCompanyService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 物流公司
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-14 09:27:46
 */
@RestController
@RequestMapping("express/expresscompany")
public class ExpressCompanyController {
    @Autowired
    private ExpressCompanyService expressCompanyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("express:expresscompany:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = expressCompanyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{coId}")
    @RequiresPermissions("express:expresscompany:info")
    public R info(@PathVariable("coId") Integer coId){
			ExpressCompanyEntity expressCompany = expressCompanyService.selectById(coId);

        return R.ok().put("expressCompany", expressCompany);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("express:expresscompany:save")
    public R save(@RequestBody ExpressCompanyEntity expressCompany){
			expressCompanyService.insert(expressCompany);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("express:expresscompany:update")
    public R update(@RequestBody ExpressCompanyEntity expressCompany){
			expressCompanyService.updateById(expressCompany);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("express:expresscompany:delete")
    public R delete(@RequestBody Integer[] coIds){
			expressCompanyService.deleteBatchIds(Arrays.asList(coIds));

        return R.ok();
    }

}
