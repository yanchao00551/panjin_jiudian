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

import com.jiudian.modules.weixin.entity.SysWeixinKeyReplayEntity;
import com.jiudian.modules.weixin.service.SysWeixinKeyReplayService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 关键词回复
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
@RestController
@RequestMapping("weixin/sysweixinkeyreplay")
public class SysWeixinKeyReplayController {
    @Autowired
    private SysWeixinKeyReplayService sysWeixinKeyReplayService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("weixin:sysweixinkeyreplay:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysWeixinKeyReplayService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("weixin:sysweixinkeyreplay:info")
    public R info(@PathVariable("id") Integer id){
			SysWeixinKeyReplayEntity sysWeixinKeyReplay = sysWeixinKeyReplayService.selectById(id);

        return R.ok().put("sysWeixinKeyReplay", sysWeixinKeyReplay);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("weixin:sysweixinkeyreplay:save")
    public R save(@RequestBody SysWeixinKeyReplayEntity sysWeixinKeyReplay){
			sysWeixinKeyReplayService.insert(sysWeixinKeyReplay);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("weixin:sysweixinkeyreplay:update")
    public R update(@RequestBody SysWeixinKeyReplayEntity sysWeixinKeyReplay){
			sysWeixinKeyReplayService.updateById(sysWeixinKeyReplay);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("weixin:sysweixinkeyreplay:delete")
    public R delete(@RequestBody Integer[] ids){
			sysWeixinKeyReplayService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
