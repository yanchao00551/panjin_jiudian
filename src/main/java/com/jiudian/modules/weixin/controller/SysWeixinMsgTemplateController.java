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

import com.jiudian.modules.weixin.entity.SysWeixinMsgTemplateEntity;
import com.jiudian.modules.weixin.service.SysWeixinMsgTemplateService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 微信消息模版
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
@RestController
@RequestMapping("weixin/sysweixinmsgtemplate")
public class SysWeixinMsgTemplateController {
    @Autowired
    private SysWeixinMsgTemplateService sysWeixinMsgTemplateService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("weixin:sysweixinmsgtemplate:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysWeixinMsgTemplateService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("weixin:sysweixinmsgtemplate:info")
    public R info(@PathVariable("id") Integer id){
			SysWeixinMsgTemplateEntity sysWeixinMsgTemplate = sysWeixinMsgTemplateService.selectById(id);

        return R.ok().put("sysWeixinMsgTemplate", sysWeixinMsgTemplate);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("weixin:sysweixinmsgtemplate:save")
    public R save(@RequestBody SysWeixinMsgTemplateEntity sysWeixinMsgTemplate){
			sysWeixinMsgTemplateService.insert(sysWeixinMsgTemplate);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("weixin:sysweixinmsgtemplate:update")
    public R update(@RequestBody SysWeixinMsgTemplateEntity sysWeixinMsgTemplate){
			sysWeixinMsgTemplateService.updateById(sysWeixinMsgTemplate);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("weixin:sysweixinmsgtemplate:delete")
    public R delete(@RequestBody Integer[] ids){
			sysWeixinMsgTemplateService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
