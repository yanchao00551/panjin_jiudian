package com.jiudian.modules.cms.controller;

import java.util.Calendar;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.album.service.AlbumPictureService;
import com.jiudian.modules.cms.entity.CmsArticleSimpleEntity;
import com.jiudian.modules.cms.service.CmsArticleSimpleService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:19:57
 */
@RestController
@RequestMapping("cms/cmsarticlesimple")
public class CmsArticleSimpleController {
    @Autowired
    private CmsArticleSimpleService cmsArticleSimpleService;
    
    @Autowired
    private AlbumPictureService albumPictureService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("cms:cmsarticlesimple:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cmsArticleSimpleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{articleId}")
    @RequiresPermissions("cms:cmsarticlesimple:info")
    public R info(@PathVariable("articleId") Integer articleId){
		CmsArticleSimpleEntity cmsArticleSimple = cmsArticleSimpleService.selectById(articleId);
		AlbumPictureEntity albumPictureEntity = albumPictureService.selectOne
				(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", cmsArticleSimple.getBanner()));
		cmsArticleSimple.setAlbumPicture(albumPictureEntity);
        return R.ok().put("cmsArticleSimple", cmsArticleSimple);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("cms:cmsarticlesimple:save")
    public R save(@RequestBody CmsArticleSimpleEntity cmsArticleSimple){
    	cmsArticleSimple.setCreateTime(Calendar.getInstance().getTime());
		cmsArticleSimpleService.insert(cmsArticleSimple);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("cms:cmsarticlesimple:update")
    public R update(@RequestBody CmsArticleSimpleEntity cmsArticleSimple){
    	cmsArticleSimple.setCreateTime(Calendar.getInstance().getTime());
		cmsArticleSimpleService.updateById(cmsArticleSimple);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("cms:cmsarticlesimple:delete")
    public R delete(@RequestBody CmsArticleSimpleEntity form){
    	cmsArticleSimpleService.deleteById(form.getArticleId());
        return R.ok();
    }

}
