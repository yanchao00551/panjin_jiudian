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

import com.jiudian.modules.weixin.entity.SysWeixinMediaItemEntity;
import com.jiudian.modules.weixin.service.SysWeixinMediaItemService;
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
@RequestMapping("weixin/sysweixinmediaitem")
public class SysWeixinMediaItemController {
    @Autowired
    private SysWeixinMediaItemService sysWeixinMediaItemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("weixin:sysweixinmediaitem:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysWeixinMediaItemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("weixin:sysweixinmediaitem:info")
    public R info(@PathVariable("id") Integer id){
			SysWeixinMediaItemEntity sysWeixinMediaItem = sysWeixinMediaItemService.selectById(id);

        return R.ok().put("sysWeixinMediaItem", sysWeixinMediaItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("weixin:sysweixinmediaitem:save")
    public R save(@RequestBody SysWeixinMediaItemEntity sysWeixinMediaItem){
			sysWeixinMediaItemService.insert(sysWeixinMediaItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("weixin:sysweixinmediaitem:update")
    public R update(@RequestBody SysWeixinMediaItemEntity sysWeixinMediaItem){
			sysWeixinMediaItemService.updateById(sysWeixinMediaItem);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("weixin:sysweixinmediaitem:delete")
    public R delete(@RequestBody Integer[] ids){
			sysWeixinMediaItemService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
