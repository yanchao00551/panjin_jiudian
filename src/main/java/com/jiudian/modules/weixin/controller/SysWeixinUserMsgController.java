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

import com.jiudian.modules.weixin.entity.SysWeixinUserMsgEntity;
import com.jiudian.modules.weixin.service.SysWeixinUserMsgService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 微信用户消息表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
@RestController
@RequestMapping("weixin/sysweixinusermsg")
public class SysWeixinUserMsgController {
    @Autowired
    private SysWeixinUserMsgService sysWeixinUserMsgService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("weixin:sysweixinusermsg:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysWeixinUserMsgService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{msgId}")
    @RequiresPermissions("weixin:sysweixinusermsg:info")
    public R info(@PathVariable("msgId") Integer msgId){
			SysWeixinUserMsgEntity sysWeixinUserMsg = sysWeixinUserMsgService.selectById(msgId);

        return R.ok().put("sysWeixinUserMsg", sysWeixinUserMsg);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("weixin:sysweixinusermsg:save")
    public R save(@RequestBody SysWeixinUserMsgEntity sysWeixinUserMsg){
			sysWeixinUserMsgService.insert(sysWeixinUserMsg);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("weixin:sysweixinusermsg:update")
    public R update(@RequestBody SysWeixinUserMsgEntity sysWeixinUserMsg){
			sysWeixinUserMsgService.updateById(sysWeixinUserMsg);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("weixin:sysweixinusermsg:delete")
    public R delete(@RequestBody Integer[] msgIds){
			sysWeixinUserMsgService.deleteBatchIds(Arrays.asList(msgIds));

        return R.ok();
    }

}
