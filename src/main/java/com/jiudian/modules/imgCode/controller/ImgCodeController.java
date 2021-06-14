package com.jiudian.modules.imgCode.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.modules.imgCode.entity.ImgCodeEntity;
import com.jiudian.modules.imgCode.service.ImgCodeService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 
 *
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-11-07 10:16:48
 */
@RestController
@RequestMapping("imgCode/imgcode")
public class ImgCodeController {
    @Autowired
    private ImgCodeService imgCodeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("imgCode:imgcode:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = imgCodeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("imgCode:imgcode:info")
    public R info(@PathVariable("id") Integer id){
			ImgCodeEntity imgCode = imgCodeService.selectById(id);

        return R.ok().put("imgCode", imgCode);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("imgCode:imgcode:save")
    public R save(@RequestBody ImgCodeEntity imgCode){
			imgCodeService.insert(imgCode);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("imgCode:imgcode:update")
    public R update(@RequestBody ImgCodeEntity imgCode){
			imgCodeService.updateById(imgCode);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("imgCode:imgcode:delete")
    public R delete(@RequestBody Integer[] ids){
			imgCodeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
