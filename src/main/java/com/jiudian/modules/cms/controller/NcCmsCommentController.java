package com.jiudian.modules.cms.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.modules.cms.entity.NcCmsCommentEntity;
import com.jiudian.modules.cms.service.NcCmsCommentService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * CMS评论表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:19:57
 */
@RestController
@RequestMapping("cms/nccmscomment")
public class NcCmsCommentController {
    @Autowired
    private NcCmsCommentService ncCmsCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("cms:nccmscomment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ncCmsCommentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{commentId}")
    @RequiresPermissions("cms:nccmscomment:info")
    public R info(@PathVariable("commentId") Integer commentId){
			NcCmsCommentEntity ncCmsComment = ncCmsCommentService.selectById(commentId);

        return R.ok().put("ncCmsComment", ncCmsComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("cms:nccmscomment:save")
    public R save(@RequestBody NcCmsCommentEntity ncCmsComment){
			ncCmsCommentService.insert(ncCmsComment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("cms:nccmscomment:update")
    public R update(@RequestBody NcCmsCommentEntity ncCmsComment){
			ncCmsCommentService.updateById(ncCmsComment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("cms:nccmscomment:delete")
    public R delete(@RequestBody Integer[] commentIds){
			ncCmsCommentService.deleteBatchIds(Arrays.asList(commentIds));

        return R.ok();
    }

}
