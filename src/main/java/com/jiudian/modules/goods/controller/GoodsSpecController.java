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

import com.jiudian.modules.goods.entity.GoodsSpecEntity;
import com.jiudian.modules.goods.service.GoodsSpecService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 商品属性（规格）表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:53
 */
@RestController
@RequestMapping("goods/goodsspec")
public class GoodsSpecController {
    @Autowired
    private GoodsSpecService goodsSpecService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:goodsspec:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsSpecService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{specId}")
    @RequiresPermissions("goods:goodsspec:info")
    public R info(@PathVariable("specId") Integer specId){
			GoodsSpecEntity goodsSpec = goodsSpecService.selectById(specId);

        return R.ok().put("goodsSpec", goodsSpec);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:goodsspec:save")
    public R save(@RequestBody GoodsSpecEntity goodsSpec){
			goodsSpecService.insert(goodsSpec);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:goodsspec:update")
    public R update(@RequestBody GoodsSpecEntity goodsSpec){
			goodsSpecService.updateById(goodsSpec);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:goodsspec:delete")
    public R delete(@RequestBody Integer[] specIds){
			goodsSpecService.deleteBatchIds(Arrays.asList(specIds));

        return R.ok();
    }

}
