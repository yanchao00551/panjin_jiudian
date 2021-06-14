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

import com.jiudian.modules.cms.entity.NcCmsArticleClassEntity;
import com.jiudian.modules.cms.service.NcCmsArticleClassService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * cms文章分类表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:19:57
 */
@RestController
@RequestMapping("cms/nccmsarticleclass")
public class NcCmsArticleClassController {
    @Autowired
    private NcCmsArticleClassService ncCmsArticleClassService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("cms:nccmsarticleclass:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ncCmsArticleClassService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{classId}")
    @RequiresPermissions("cms:nccmsarticleclass:info")
    public R info(@PathVariable("classId") Integer classId){
			NcCmsArticleClassEntity ncCmsArticleClass = ncCmsArticleClassService.selectById(classId);

        return R.ok().put("ncCmsArticleClass", ncCmsArticleClass);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("cms:nccmsarticleclass:save")
    public R save(@RequestBody NcCmsArticleClassEntity ncCmsArticleClass){
			ncCmsArticleClassService.insert(ncCmsArticleClass);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("cms:nccmsarticleclass:update")
    public R update(@RequestBody NcCmsArticleClassEntity ncCmsArticleClass){
			ncCmsArticleClassService.updateById(ncCmsArticleClass);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("cms:nccmsarticleclass:delete")
    public R delete(@RequestBody Integer[] classIds){
			ncCmsArticleClassService.deleteBatchIds(Arrays.asList(classIds));

        return R.ok();
    }

}
