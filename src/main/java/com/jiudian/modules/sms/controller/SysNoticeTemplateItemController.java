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

import com.jiudian.modules.sms.entity.SysNoticeTemplateItemEntity;
import com.jiudian.modules.sms.service.SysNoticeTemplateItemService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;

import java.util.List;

/**
 * 通知模板项
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-22 11:24:27
 */
@RestController
@RequestMapping("sms/sysnoticetemplateitem")
public class SysNoticeTemplateItemController {
    @Autowired
    private SysNoticeTemplateItemService sysNoticeTemplateItemService;

    /**
     * 根据template_code查询模板可用变量
     */
    @RequestMapping("/getTemplateItem/{templateCode}")
    @RequiresPermissions("sms:sysnoticetemplateitem:getTemplateItem")
    public R getTemplateItem(@PathVariable("templateCode") String templateCode){
    	List<SysNoticeTemplateItemEntity> list = sysNoticeTemplateItemService.queryByTemplateCodeInfo(templateCode);
        return R.ok().put("availableVariables", list);
    }
    
    
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sms:sysnoticetemplateitem:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysNoticeTemplateItemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sms:sysnoticetemplateitem:info")
    public R info(@PathVariable("id") Integer id){
			SysNoticeTemplateItemEntity sysNoticeTemplateItem = sysNoticeTemplateItemService.selectById(id);

        return R.ok().put("sysNoticeTemplateItem", sysNoticeTemplateItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sms:sysnoticetemplateitem:save")
    public R save(@RequestBody SysNoticeTemplateItemEntity sysNoticeTemplateItem){
			sysNoticeTemplateItemService.insert(sysNoticeTemplateItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sms:sysnoticetemplateitem:update")
    public R update(@RequestBody SysNoticeTemplateItemEntity sysNoticeTemplateItem){
			sysNoticeTemplateItemService.updateById(sysNoticeTemplateItem);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sms:sysnoticetemplateitem:delete")
    public R delete(@RequestBody Integer[] ids){
			sysNoticeTemplateItemService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
