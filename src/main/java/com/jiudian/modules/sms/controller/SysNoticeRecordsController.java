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

import com.jiudian.modules.sms.entity.SysNoticeRecordsEntity;
import com.jiudian.modules.sms.service.SysNoticeRecordsService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 通知记录
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-21 09:08:19
 */
@RestController
@RequestMapping("sms/sysnoticerecords")
public class SysNoticeRecordsController {
    @Autowired
    private SysNoticeRecordsService sysNoticeRecordsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sms:sysnoticerecords:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysNoticeRecordsService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sms:sysnoticerecords:info")
    public R info(@PathVariable("id") Integer id){
			SysNoticeRecordsEntity sysNoticeRecords = sysNoticeRecordsService.selectById(id);

        return R.ok().put("sysNoticeRecords", sysNoticeRecords);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sms:sysnoticerecords:save")
    public R save(@RequestBody SysNoticeRecordsEntity sysNoticeRecords){
			sysNoticeRecordsService.insert(sysNoticeRecords);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sms:sysnoticerecords:update")
    public R update(@RequestBody SysNoticeRecordsEntity sysNoticeRecords){
			sysNoticeRecordsService.updateById(sysNoticeRecords);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sms:sysnoticerecords:delete")
    public R delete(@RequestBody Integer[] ids){
			sysNoticeRecordsService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
