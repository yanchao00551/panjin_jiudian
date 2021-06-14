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

import com.jiudian.modules.weixin.entity.SysWeixinQrcodeTemplateEntity;
import com.jiudian.modules.weixin.service.SysWeixinQrcodeTemplateService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 微信推广二维码模板管理
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
@RestController
@RequestMapping("weixin/sysweixinqrcodetemplate")
public class SysWeixinQrcodeTemplateController {
    @Autowired
    private SysWeixinQrcodeTemplateService sysWeixinQrcodeTemplateService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("weixin:sysweixinqrcodetemplate:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysWeixinQrcodeTemplateService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("weixin:sysweixinqrcodetemplate:info")
    public R info(@PathVariable("id") Integer id){
			SysWeixinQrcodeTemplateEntity sysWeixinQrcodeTemplate = sysWeixinQrcodeTemplateService.selectById(id);

        return R.ok().put("sysWeixinQrcodeTemplate", sysWeixinQrcodeTemplate);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("weixin:sysweixinqrcodetemplate:save")
    public R save(@RequestBody SysWeixinQrcodeTemplateEntity sysWeixinQrcodeTemplate){
			sysWeixinQrcodeTemplateService.insert(sysWeixinQrcodeTemplate);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("weixin:sysweixinqrcodetemplate:update")
    public R update(@RequestBody SysWeixinQrcodeTemplateEntity sysWeixinQrcodeTemplate){
			sysWeixinQrcodeTemplateService.updateById(sysWeixinQrcodeTemplate);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("weixin:sysweixinqrcodetemplate:delete")
    public R delete(@RequestBody Integer[] ids){
			sysWeixinQrcodeTemplateService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
