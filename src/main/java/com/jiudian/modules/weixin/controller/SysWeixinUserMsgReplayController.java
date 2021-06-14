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

import com.jiudian.modules.weixin.entity.SysWeixinUserMsgReplayEntity;
import com.jiudian.modules.weixin.service.SysWeixinUserMsgReplayService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 微信用户消息回复表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
@RestController
@RequestMapping("weixin/sysweixinusermsgreplay")
public class SysWeixinUserMsgReplayController {
    @Autowired
    private SysWeixinUserMsgReplayService sysWeixinUserMsgReplayService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("weixin:sysweixinusermsgreplay:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysWeixinUserMsgReplayService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{replayId}")
    @RequiresPermissions("weixin:sysweixinusermsgreplay:info")
    public R info(@PathVariable("replayId") Integer replayId){
			SysWeixinUserMsgReplayEntity sysWeixinUserMsgReplay = sysWeixinUserMsgReplayService.selectById(replayId);

        return R.ok().put("sysWeixinUserMsgReplay", sysWeixinUserMsgReplay);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("weixin:sysweixinusermsgreplay:save")
    public R save(@RequestBody SysWeixinUserMsgReplayEntity sysWeixinUserMsgReplay){
			sysWeixinUserMsgReplayService.insert(sysWeixinUserMsgReplay);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("weixin:sysweixinusermsgreplay:update")
    public R update(@RequestBody SysWeixinUserMsgReplayEntity sysWeixinUserMsgReplay){
			sysWeixinUserMsgReplayService.updateById(sysWeixinUserMsgReplay);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("weixin:sysweixinusermsgreplay:delete")
    public R delete(@RequestBody Integer[] replayIds){
			sysWeixinUserMsgReplayService.deleteBatchIds(Arrays.asList(replayIds));

        return R.ok();
    }

}
