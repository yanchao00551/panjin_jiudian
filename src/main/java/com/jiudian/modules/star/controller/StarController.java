package com.jiudian.modules.star.controller;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;
import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.album.service.AlbumPictureService;
import com.jiudian.modules.star.entity.StarEntity;
import com.jiudian.modules.star.service.StarService;



/**
 * 服务星表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-20 08:29:38
 */
@RestController
@RequestMapping("star/star")
public class StarController {
    @Autowired
    private StarService starService;
    
    @Autowired
    private AlbumPictureService albumPictureService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("star:star:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = starService.queryStarPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{starId}")
    @RequiresPermissions("star:star:info")
    public R info(@PathVariable("starId") Integer starId){
		StarEntity star = starService.selectById(starId);
		AlbumPictureEntity albumPictureEntity = albumPictureService.selectOne
				(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", star.getBanner()));
		star.setAlbumPicture(albumPictureEntity);
        return R.ok().put("star", star);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("star:star:save")
    public R save(@RequestBody StarEntity star){
			starService.insert(star);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("star:star:update")
    public R update(@RequestBody StarEntity star){
			starService.updateById(star);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("star:star:delete")
    public R delete(@RequestBody StarEntity form){
    	starService.deleteById(form.getStarId());
        return R.ok();
    }

}
