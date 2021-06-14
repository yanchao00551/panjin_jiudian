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

import com.jiudian.modules.weixin.entity.SysWeixinMediaEntity;
import com.jiudian.modules.weixin.service.SysWeixinMediaService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
@RestController
@RequestMapping("weixin/sysweixinmedia")
public class SysWeixinMediaController {
    @Autowired
    private SysWeixinMediaService sysWeixinMediaService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("weixin:sysweixinmedia:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysWeixinMediaService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{mediaId}")
    @RequiresPermissions("weixin:sysweixinmedia:info")
    public R info(@PathVariable("mediaId") Integer mediaId){
			SysWeixinMediaEntity sysWeixinMedia = sysWeixinMediaService.selectById(mediaId);

        return R.ok().put("sysWeixinMedia", sysWeixinMedia);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("weixin:sysweixinmedia:save")
    public R save(@RequestBody SysWeixinMediaEntity sysWeixinMedia){
			sysWeixinMediaService.insert(sysWeixinMedia);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("weixin:sysweixinmedia:update")
    public R update(@RequestBody SysWeixinMediaEntity sysWeixinMedia){
			sysWeixinMediaService.updateById(sysWeixinMedia);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("weixin:sysweixinmedia:delete")
    public R delete(@RequestBody Integer[] mediaIds){
			sysWeixinMediaService.deleteBatchIds(Arrays.asList(mediaIds));

        return R.ok();
    }

}
