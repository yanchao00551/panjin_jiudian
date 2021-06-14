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

import com.jiudian.modules.weixin.entity.SysWeixinFollowReplayEntity;
import com.jiudian.modules.weixin.service.SysWeixinFollowReplayService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 关注时回复
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:23:07
 */
@RestController
@RequestMapping("weixin/sysweixinfollowreplay")
public class SysWeixinFollowReplayController {
    @Autowired
    private SysWeixinFollowReplayService sysWeixinFollowReplayService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("weixin:sysweixinfollowreplay:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysWeixinFollowReplayService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("weixin:sysweixinfollowreplay:info")
    public R info(@PathVariable("id") Integer id){
			SysWeixinFollowReplayEntity sysWeixinFollowReplay = sysWeixinFollowReplayService.selectById(id);

        return R.ok().put("sysWeixinFollowReplay", sysWeixinFollowReplay);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("weixin:sysweixinfollowreplay:save")
    public R save(@RequestBody SysWeixinFollowReplayEntity sysWeixinFollowReplay){
			sysWeixinFollowReplayService.insert(sysWeixinFollowReplay);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("weixin:sysweixinfollowreplay:update")
    public R update(@RequestBody SysWeixinFollowReplayEntity sysWeixinFollowReplay){
			sysWeixinFollowReplayService.updateById(sysWeixinFollowReplay);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("weixin:sysweixinfollowreplay:delete")
    public R delete(@RequestBody Integer[] ids){
			sysWeixinFollowReplayService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
