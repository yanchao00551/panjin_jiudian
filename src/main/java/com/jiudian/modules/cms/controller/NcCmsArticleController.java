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

import com.jiudian.modules.cms.entity.NcCmsArticleEntity;
import com.jiudian.modules.cms.service.NcCmsArticleService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * CMS文章表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:19:57
 */
@RestController
@RequestMapping("cms/nccmsarticle")
public class NcCmsArticleController {
    @Autowired
    private NcCmsArticleService ncCmsArticleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("cms:nccmsarticle:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ncCmsArticleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{articleId}")
    @RequiresPermissions("cms:nccmsarticle:info")
    public R info(@PathVariable("articleId") Integer articleId){
			NcCmsArticleEntity ncCmsArticle = ncCmsArticleService.selectById(articleId);

        return R.ok().put("ncCmsArticle", ncCmsArticle);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("cms:nccmsarticle:save")
    public R save(@RequestBody NcCmsArticleEntity ncCmsArticle){
			ncCmsArticleService.insert(ncCmsArticle);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("cms:nccmsarticle:update")
    public R update(@RequestBody NcCmsArticleEntity ncCmsArticle){
			ncCmsArticleService.updateById(ncCmsArticle);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("cms:nccmsarticle:delete")
    public R delete(@RequestBody Integer[] articleIds){
			ncCmsArticleService.deleteBatchIds(Arrays.asList(articleIds));

        return R.ok();
    }

}
