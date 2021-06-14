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

import com.jiudian.modules.weixin.entity.SysWeixinFansEntity;
import com.jiudian.modules.weixin.service.SysWeixinFansService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 微信公众号获取粉丝列表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:23:07
 */
@RestController
@RequestMapping("weixin/sysweixinfans")
public class SysWeixinFansController {
    @Autowired
    private SysWeixinFansService sysWeixinFansService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("weixin:sysweixinfans:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysWeixinFansService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{fansId}")
    @RequiresPermissions("weixin:sysweixinfans:info")
    public R info(@PathVariable("fansId") Integer fansId){
			SysWeixinFansEntity sysWeixinFans = sysWeixinFansService.selectById(fansId);

        return R.ok().put("sysWeixinFans", sysWeixinFans);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("weixin:sysweixinfans:save")
    public R save(@RequestBody SysWeixinFansEntity sysWeixinFans){
			sysWeixinFansService.insert(sysWeixinFans);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("weixin:sysweixinfans:update")
    public R update(@RequestBody SysWeixinFansEntity sysWeixinFans){
			sysWeixinFansService.updateById(sysWeixinFans);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("weixin:sysweixinfans:delete")
    public R delete(@RequestBody Integer[] fansIds){
			sysWeixinFansService.deleteBatchIds(Arrays.asList(fansIds));

        return R.ok();
    }

}
