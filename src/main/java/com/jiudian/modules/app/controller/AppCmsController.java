package com.jiudian.modules.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;
import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.album.service.AlbumPictureService;
import com.jiudian.modules.app.calculate.RewardCalcuUtil;
import com.jiudian.modules.cms.entity.CmsArticleSimpleEntity;
import com.jiudian.modules.cms.service.CmsArticleSimpleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 内容控制器
 * @author KF-180419
 *
 */

@RestController
@RequestMapping("/app")
@Api("新闻控制器")
public class AppCmsController {
	@Autowired
	private CmsArticleSimpleService cmsArticleSimpleService;
	@Autowired
	private AlbumPictureService albumPictureService;
	@Autowired
	private RewardCalcuUtil rewardCalcuUtil;
	 
	 /**
     * 列表
     */
    @SuppressWarnings("unchecked")
	@GetMapping("newlist")
    @ApiOperation("获取新闻列表")
    public R newlist(@RequestParam Map<String, Object> params){
        PageUtils page = cmsArticleSimpleService.queryPage(params);
        List<CmsArticleSimpleEntity> list = (List<CmsArticleSimpleEntity>) page.getList();
        for(int i=0;i<list.size();i++) {
        	AlbumPictureEntity albumPicture = albumPictureService.selectById(list.get(i).getBanner());
        	list.get(i).setAlbumPicture(albumPicture);
        }
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("newinfo")
    @ApiOperation("获取新闻单篇信息")
    public R newinfo(@RequestParam Map<String,Integer> params){
    	CmsArticleSimpleEntity ncCmsArticle = cmsArticleSimpleService.selectById(params.get("articleId"));
    	AlbumPictureEntity albumPicture = albumPictureService.selectById(ncCmsArticle.getBanner());
    	ncCmsArticle.setAlbumPicture(albumPicture);
    	ncCmsArticle.setContent(rewardCalcuUtil.getRichText(ncCmsArticle.getContent()));
        return R.ok().put("ncCmsArticle", ncCmsArticle);
    }
}
