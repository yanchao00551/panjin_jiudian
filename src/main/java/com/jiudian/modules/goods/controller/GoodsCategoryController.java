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

import com.jiudian.modules.goods.entity.GoodsCategoryEntity;
import com.jiudian.modules.goods.service.GoodsCategoryService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 商品分类表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
@RestController
@RequestMapping("goods/goodscategory")
public class GoodsCategoryController {
    @Autowired
    private GoodsCategoryService goodsCategoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:goodscategory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{categoryId}")
    @RequiresPermissions("goods:goodscategory:info")
    public R info(@PathVariable("categoryId") Integer categoryId){
			GoodsCategoryEntity goodsCategory = goodsCategoryService.selectById(categoryId);

        return R.ok().put("goodsCategory", goodsCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:goodscategory:save")
    public R save(@RequestBody GoodsCategoryEntity goodsCategory){
			goodsCategoryService.insert(goodsCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:goodscategory:update")
    public R update(@RequestBody GoodsCategoryEntity goodsCategory){
			goodsCategoryService.updateById(goodsCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:goodscategory:delete")
    public R delete(@RequestBody Integer[] categoryIds){
			goodsCategoryService.deleteBatchIds(Arrays.asList(categoryIds));

        return R.ok();
    }

}
