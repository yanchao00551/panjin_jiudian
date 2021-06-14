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

import com.jiudian.modules.weixin.entity.SysWeixinAuthEntity;
import com.jiudian.modules.weixin.service.SysWeixinAuthService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 店铺(实例)微信公众账号授权
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:23:07
 */
@RestController
@RequestMapping("weixin/sysweixinauth")
public class SysWeixinAuthController {
    @Autowired
    private SysWeixinAuthService sysWeixinAuthService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("weixin:sysweixinauth:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysWeixinAuthService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("weixin:sysweixinauth:info")
    public R info(@PathVariable("id") Integer id){
			SysWeixinAuthEntity sysWeixinAuth = sysWeixinAuthService.selectById(id);

        return R.ok().put("sysWeixinAuth", sysWeixinAuth);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("weixin:sysweixinauth:save")
    public R save(@RequestBody SysWeixinAuthEntity sysWeixinAuth){
			sysWeixinAuthService.insert(sysWeixinAuth);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("weixin:sysweixinauth:update")
    public R update(@RequestBody SysWeixinAuthEntity sysWeixinAuth){
			sysWeixinAuthService.updateById(sysWeixinAuth);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("weixin:sysweixinauth:delete")
    public R delete(@RequestBody Integer[] ids){
			sysWeixinAuthService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
