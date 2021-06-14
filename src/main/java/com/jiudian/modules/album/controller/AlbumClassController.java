package com.jiudian.modules.album.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.modules.album.entity.AlbumClassEntity;
import com.jiudian.modules.album.service.AlbumClassService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 相册表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-11 17:15:11
 */
@RestController
@RequestMapping("album/albumclass")
public class AlbumClassController {
    @Autowired
    private AlbumClassService albumClassService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("album:albumclass:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = albumClassService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{albumId}")
    @RequiresPermissions("album:albumclass:info")
    public R info(@PathVariable("albumId") Integer albumId){
			AlbumClassEntity albumClass = albumClassService.selectById(albumId);

        return R.ok().put("albumClass", albumClass);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("album:albumclass:save")
    public R save(@RequestBody AlbumClassEntity albumClass){
			albumClassService.insert(albumClass);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("album:albumclass:update")
    public R update(@RequestBody AlbumClassEntity albumClass){
			albumClassService.updateById(albumClass);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("album:albumclass:delete")
    public R delete(@RequestBody Integer[] albumIds){
			albumClassService.deleteBatchIds(Arrays.asList(albumIds));

        return R.ok();
    }

}
