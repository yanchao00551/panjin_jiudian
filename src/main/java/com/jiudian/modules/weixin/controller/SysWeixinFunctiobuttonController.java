package com.jiudian.modules.weixin.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.modules.weixin.entity.SysWeixinFunctiobuttonEntity;
import com.jiudian.modules.weixin.service.SysWeixinFunctiobuttonService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 微信功能按钮
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:23:07
 */
@RestController
@RequestMapping("weixin/sysweixinfunctiobutton")
public class SysWeixinFunctiobuttonController {
    @Autowired
    private SysWeixinFunctiobuttonService sysWeixinFunctiobuttonService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("weixin:sysweixinfunctiobutton:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysWeixinFunctiobuttonService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{buttonId}")
    @RequiresPermissions("weixin:sysweixinfunctiobutton:info")
    public R info(@PathVariable("buttonId") Integer buttonId){
			SysWeixinFunctiobuttonEntity sysWeixinFunctiobutton = sysWeixinFunctiobuttonService.selectById(buttonId);

        return R.ok().put("sysWeixinFunctiobutton", sysWeixinFunctiobutton);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("weixin:sysweixinfunctiobutton:save")
    public R save(@RequestBody SysWeixinFunctiobuttonEntity sysWeixinFunctiobutton){
			sysWeixinFunctiobuttonService.insert(sysWeixinFunctiobutton);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("weixin:sysweixinfunctiobutton:update")
    public R update(@RequestBody SysWeixinFunctiobuttonEntity sysWeixinFunctiobutton){
			sysWeixinFunctiobuttonService.updateById(sysWeixinFunctiobutton);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("weixin:sysweixinfunctiobutton:delete")
    public R delete(@RequestBody Integer[] buttonIds){
			sysWeixinFunctiobuttonService.deleteBatchIds(Arrays.asList(buttonIds));

        return R.ok();
    }

}
