package com.jiudian.modules.aboutUs.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.modules.aboutUs.entity.AboutUsEntity;
import com.jiudian.modules.aboutUs.service.AboutUsService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 
 *
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-12-07 09:49:30
 */
@RestController
@RequestMapping("aboutUs/aboutus")
public class AboutUsController {
    @Autowired
    private AboutUsService aboutUsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("aboutUs:aboutus:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = aboutUsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("aboutUs:aboutus:info")
    public R info(@PathVariable("id") Integer id){
			AboutUsEntity aboutUs = aboutUsService.selectById(id);

        return R.ok().put("aboutUs", aboutUs);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("aboutUs:aboutus:save")
    public R save(@RequestBody AboutUsEntity aboutUs){
			aboutUsService.insert(aboutUs);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("aboutUs:aboutus:update")
    public R update(@RequestBody AboutUsEntity aboutUs){
			aboutUsService.updateById(aboutUs);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("aboutUs:aboutus:delete")
    public R delete(@RequestBody Integer[] ids){
			aboutUsService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
