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

import com.jiudian.modules.star.entity.StarCommentEntity;
import com.jiudian.modules.star.service.StarCommentService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 服务星评论表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-20 08:29:38
 */
@RestController
@RequestMapping("star/starcomment")
public class StarCommentController {
    @Autowired
    private StarCommentService starCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("star:starcomment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = starCommentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("star:starcomment:info")
    public R info(@PathVariable("id") Integer id){
			StarCommentEntity starComment = starCommentService.selectById(id);

        return R.ok().put("starComment", starComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("star:starcomment:save")
    public R save(@RequestBody StarCommentEntity starComment){
			starCommentService.insert(starComment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("star:starcomment:update")
    public R update(@RequestBody StarCommentEntity starComment){
			starCommentService.updateById(starComment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("star:starcomment:delete")
    public R delete(@RequestBody Integer[] ids){
			starCommentService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
