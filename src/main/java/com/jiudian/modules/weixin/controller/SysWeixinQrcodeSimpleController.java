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

import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.album.service.AlbumPictureService;
import com.jiudian.modules.weixin.entity.SysWeixinQrcodeSimpleEntity;
import com.jiudian.modules.weixin.service.SysWeixinQrcodeSimpleService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 推广码简洁表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
@RestController
@RequestMapping("weixin/sysweixinqrcodesimple")
public class SysWeixinQrcodeSimpleController {
    @Autowired
    private SysWeixinQrcodeSimpleService sysWeixinQrcodeSimpleService;
    @Autowired
    private AlbumPictureService albumPictureService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("weixin:sysweixinqrcodesimple:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysWeixinQrcodeSimpleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("weixin:sysweixinqrcodesimple:info")
    public R info(@PathVariable("id") Integer id){
			SysWeixinQrcodeSimpleEntity sysWeixinQrcodeSimple = sysWeixinQrcodeSimpleService.selectById(id);
			AlbumPictureEntity info = new AlbumPictureEntity();
			info = albumPictureService.selectById(sysWeixinQrcodeSimple.getQrcodeImg());
			if(info != null) {
				sysWeixinQrcodeSimple.setPicture(info);
			}
        return R.ok().put("sysWeixinQrcodeSimple", sysWeixinQrcodeSimple);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("weixin:sysweixinqrcodesimple:save")
    public R save(@RequestBody SysWeixinQrcodeSimpleEntity sysWeixinQrcodeSimple){
			sysWeixinQrcodeSimpleService.insert(sysWeixinQrcodeSimple);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("weixin:sysweixinqrcodesimple:update")
    public R update(@RequestBody SysWeixinQrcodeSimpleEntity sysWeixinQrcodeSimple){
			sysWeixinQrcodeSimpleService.updateById(sysWeixinQrcodeSimple);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("weixin:sysweixinqrcodesimple:delete")
    public R delete(@RequestBody Integer[] ids){
			sysWeixinQrcodeSimpleService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
