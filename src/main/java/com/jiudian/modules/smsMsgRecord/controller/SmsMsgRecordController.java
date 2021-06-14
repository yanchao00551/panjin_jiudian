package com.jiudian.modules.smsMsgRecord.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.modules.smsMsgRecord.entity.SmsMsgRecordEntity;
import com.jiudian.modules.smsMsgRecord.service.SmsMsgRecordService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 
 *
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-11-07 15:17:02
 */
@RestController
@RequestMapping("smsMsgRecord/smsmsgrecord")
public class SmsMsgRecordController {
    @Autowired
    private SmsMsgRecordService smsMsgRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("smsMsgRecord:smsmsgrecord:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsMsgRecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("smsMsgRecord:smsmsgrecord:info")
    public R info(@PathVariable("id") Integer id){
			SmsMsgRecordEntity smsMsgRecord = smsMsgRecordService.selectById(id);

        return R.ok().put("smsMsgRecord", smsMsgRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("smsMsgRecord:smsmsgrecord:save")
    public R save(@RequestBody SmsMsgRecordEntity smsMsgRecord){
			smsMsgRecordService.insert(smsMsgRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("smsMsgRecord:smsmsgrecord:update")
    public R update(@RequestBody SmsMsgRecordEntity smsMsgRecord){
			smsMsgRecordService.updateById(smsMsgRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("smsMsgRecord:smsmsgrecord:delete")
    public R delete(@RequestBody Integer[] ids){
			smsMsgRecordService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
