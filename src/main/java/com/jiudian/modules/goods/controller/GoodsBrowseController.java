package com.jiudian.modules.goods.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.modules.goods.entity.GoodsBrowseEntity;
import com.jiudian.modules.goods.service.GoodsBrowseService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 商品足迹表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
@RestController
@RequestMapping("goods/goodsbrowse")
public class GoodsBrowseController {
    @Autowired
    private GoodsBrowseService goodsBrowseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:goodsbrowse:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsBrowseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{browseId}")
    @RequiresPermissions("goods:goodsbrowse:info")
    public R info(@PathVariable("browseId") Integer browseId){
			GoodsBrowseEntity goodsBrowse = goodsBrowseService.selectById(browseId);

        return R.ok().put("goodsBrowse", goodsBrowse);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:goodsbrowse:save")
    public R save(@RequestBody GoodsBrowseEntity goodsBrowse){
			goodsBrowseService.insert(goodsBrowse);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:goodsbrowse:update")
    public R update(@RequestBody GoodsBrowseEntity goodsBrowse){
			goodsBrowseService.updateById(goodsBrowse);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:goodsbrowse:delete")
    public R delete(@RequestBody Integer[] browseIds){
			goodsBrowseService.deleteBatchIds(Arrays.asList(browseIds));

        return R.ok();
    }

}
