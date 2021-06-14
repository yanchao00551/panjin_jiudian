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

import com.jiudian.modules.weixin.entity.SysWeixinInstanceMsgEntity;
import com.jiudian.modules.weixin.service.SysWeixinInstanceMsgService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 微信实例消息
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
@RestController
@RequestMapping("weixin/sysweixininstancemsg")
public class SysWeixinInstanceMsgController {
    @Autowired
    private SysWeixinInstanceMsgService sysWeixinInstanceMsgService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("weixin:sysweixininstancemsg:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysWeixinInstanceMsgService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("weixin:sysweixininstancemsg:info")
    public R info(@PathVariable("id") Integer id){
			SysWeixinInstanceMsgEntity sysWeixinInstanceMsg = sysWeixinInstanceMsgService.selectById(id);

        return R.ok().put("sysWeixinInstanceMsg", sysWeixinInstanceMsg);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("weixin:sysweixininstancemsg:save")
    public R save(@RequestBody SysWeixinInstanceMsgEntity sysWeixinInstanceMsg){
			sysWeixinInstanceMsgService.insert(sysWeixinInstanceMsg);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("weixin:sysweixininstancemsg:update")
    public R update(@RequestBody SysWeixinInstanceMsgEntity sysWeixinInstanceMsg){
			sysWeixinInstanceMsgService.updateById(sysWeixinInstanceMsg);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("weixin:sysweixininstancemsg:delete")
    public R delete(@RequestBody Integer[] ids){
			sysWeixinInstanceMsgService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
