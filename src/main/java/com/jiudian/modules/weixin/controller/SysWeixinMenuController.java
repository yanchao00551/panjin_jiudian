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

import com.jiudian.modules.weixin.entity.SysWeixinMenuEntity;
import com.jiudian.modules.weixin.service.SysWeixinMenuService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 微设置->微店菜单
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
@RestController
@RequestMapping("weixin/sysweixinmenu")
public class SysWeixinMenuController {
    @Autowired
    private SysWeixinMenuService sysWeixinMenuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("weixin:sysweixinmenu:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysWeixinMenuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{menuId}")
    @RequiresPermissions("weixin:sysweixinmenu:info")
    public R info(@PathVariable("menuId") Integer menuId){
			SysWeixinMenuEntity sysWeixinMenu = sysWeixinMenuService.selectById(menuId);

        return R.ok().put("sysWeixinMenu", sysWeixinMenu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("weixin:sysweixinmenu:save")
    public R save(@RequestBody SysWeixinMenuEntity sysWeixinMenu){
			sysWeixinMenuService.insert(sysWeixinMenu);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("weixin:sysweixinmenu:update")
    public R update(@RequestBody SysWeixinMenuEntity sysWeixinMenu){
			sysWeixinMenuService.updateById(sysWeixinMenu);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("weixin:sysweixinmenu:delete")
    public R delete(@RequestBody Integer[] menuIds){
			sysWeixinMenuService.deleteBatchIds(Arrays.asList(menuIds));

        return R.ok();
    }

}
