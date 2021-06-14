package com.jiudian.modules.star.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.modules.star.entity.StarClassEntity;
import com.jiudian.modules.star.service.StarClassService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 服务星分类表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-20 08:29:38
 */
@RestController
@RequestMapping("star/starclass")
public class StarClassController {
    @Autowired
    private StarClassService starClassService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("star:starclass:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = starClassService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{classId}")
    @RequiresPermissions("star:starclass:info")
    public R info(@PathVariable("classId") Integer classId){
			StarClassEntity starClass = starClassService.selectById(classId);

        return R.ok().put("starClass", starClass);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("star:starclass:save")
    public R save(@RequestBody StarClassEntity starClass){
			starClassService.insert(starClass);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("star:starclass:update")
    public R update(@RequestBody StarClassEntity starClass){
			starClassService.updateById(starClass);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("star:starclass:delete")
    public R delete(@RequestBody Integer[] classIds){
			starClassService.deleteBatchIds(Arrays.asList(classIds));

        return R.ok();
    }

}
