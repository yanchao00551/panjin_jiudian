package com.jiudian.modules.rewardRecord.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.modules.rewardRecord.entity.RewardRecordEntity;
import com.jiudian.modules.rewardRecord.service.RewardRecordService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 
 *
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-10-20 15:45:58
 */
@RestController
@RequestMapping("rewardRecord/rewardrecord")
public class RewardRecordController {
    @Autowired
    private RewardRecordService rewardRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("rewardRecord:rewardrecord:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rewardRecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{rewardId}")
    @RequiresPermissions("rewardRecord:rewardrecord:info")
    public R info(@PathVariable("rewardId") Integer rewardId){
			RewardRecordEntity rewardRecord = rewardRecordService.selectById(rewardId);

        return R.ok().put("rewardRecord", rewardRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("rewardRecord:rewardrecord:save")
    public R save(@RequestBody RewardRecordEntity rewardRecord){
			rewardRecordService.insert(rewardRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("rewardRecord:rewardrecord:update")
    public R update(@RequestBody RewardRecordEntity rewardRecord){
			rewardRecordService.updateById(rewardRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("rewardRecord:rewardrecord:delete")
    public R delete(@RequestBody Integer[] rewardIds){
			rewardRecordService.deleteBatchIds(Arrays.asList(rewardIds));

        return R.ok();
    }

}
