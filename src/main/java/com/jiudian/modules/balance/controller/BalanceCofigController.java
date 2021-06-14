package com.jiudian.modules.balance.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.modules.balance.entity.BalanceCofigEntity;
import com.jiudian.modules.balance.service.BalanceCofigService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 余额设置表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-22 08:46:17
 */
@RestController
@RequestMapping("balance/balancecofig")
public class BalanceCofigController {
    @Autowired
    private BalanceCofigService balanceCofigService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("balance:balancecofig:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = balanceCofigService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("balance:balancecofig:info")
    public R info(@PathVariable("id") Integer id){
			BalanceCofigEntity balanceCofig = balanceCofigService.selectById(id);

        return R.ok().put("balanceCofig", balanceCofig);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("balance:balancecofig:save")
    public R save(@RequestBody BalanceCofigEntity balanceCofig){
			balanceCofigService.insert(balanceCofig);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("balance:balancecofig:update")
    public R update(@RequestBody BalanceCofigEntity balanceCofig){
			balanceCofigService.updateById(balanceCofig);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("balance:balancecofig:delete")
    public R delete(@RequestBody Integer[] ids){
			balanceCofigService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
