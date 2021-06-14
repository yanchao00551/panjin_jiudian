package com.jiudian.modules.sms.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.modules.sms.entity.SysNoticeTemplateEntity;
import com.jiudian.modules.sms.service.SysNoticeTemplateService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 通知模版设置
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-22 10:30:13
 */
@RestController
@RequestMapping("sms/sysnoticetemplate")
public class SysNoticeTemplateController {
    @Autowired
    private SysNoticeTemplateService sysNoticeTemplateService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sms:sysnoticetemplate:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysNoticeTemplateService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{templateId}")
    @RequiresPermissions("sms:sysnoticetemplate:info")
    public R info(@PathVariable("templateId") Integer templateId){
			SysNoticeTemplateEntity sysNoticeTemplate = sysNoticeTemplateService.selectById(templateId);

        return R.ok().put("sysNoticeTemplate", sysNoticeTemplate);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sms:sysnoticetemplate:save")
    public R save(@RequestBody SysNoticeTemplateEntity sysNoticeTemplate){
			sysNoticeTemplateService.insert(sysNoticeTemplate);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sms:sysnoticetemplate:update")
    public R update(@RequestBody SysNoticeTemplateEntity sysNoticeTemplate){
			sysNoticeTemplateService.updateById(sysNoticeTemplate);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sms:sysnoticetemplate:delete")
    public R delete(@RequestBody Integer[] templateIds){
			sysNoticeTemplateService.deleteBatchIds(Arrays.asList(templateIds));

        return R.ok();
    }

}
