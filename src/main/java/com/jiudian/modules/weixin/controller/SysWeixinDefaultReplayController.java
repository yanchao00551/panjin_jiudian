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

import com.jiudian.modules.weixin.entity.SysWeixinDefaultReplayEntity;
import com.jiudian.modules.weixin.service.SysWeixinDefaultReplayService;
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
@RequestMapping("weixin/sysweixindefaultreplay")
public class SysWeixinDefaultReplayController {
    @Autowired
    private SysWeixinDefaultReplayService sysWeixinDefaultReplayService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("weixin:sysweixindefaultreplay:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysWeixinDefaultReplayService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("weixin:sysweixindefaultreplay:info")
    public R info(@PathVariable("id") Integer id){
			SysWeixinDefaultReplayEntity sysWeixinDefaultReplay = sysWeixinDefaultReplayService.selectById(id);

        return R.ok().put("sysWeixinDefaultReplay", sysWeixinDefaultReplay);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("weixin:sysweixindefaultreplay:save")
    public R save(@RequestBody SysWeixinDefaultReplayEntity sysWeixinDefaultReplay){
			sysWeixinDefaultReplayService.insert(sysWeixinDefaultReplay);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("weixin:sysweixindefaultreplay:update")
    public R update(@RequestBody SysWeixinDefaultReplayEntity sysWeixinDefaultReplay){
			sysWeixinDefaultReplayService.updateById(sysWeixinDefaultReplay);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("weixin:sysweixindefaultreplay:delete")
    public R delete(@RequestBody Integer[] ids){
			sysWeixinDefaultReplayService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
