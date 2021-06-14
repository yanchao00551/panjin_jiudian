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

import com.jiudian.modules.goods.entity.GoodsSkuPictureDeleteEntity;
import com.jiudian.modules.goods.service.GoodsSkuPictureDeleteService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 商品sku多图
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:53
 */
@RestController
@RequestMapping("goods/goodsskupicturedelete")
public class GoodsSkuPictureDeleteController {
    @Autowired
    private GoodsSkuPictureDeleteService goodsSkuPictureDeleteService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:goodsskupicturedelete:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsSkuPictureDeleteService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("goods:goodsskupicturedelete:info")
    public R info(@PathVariable("id") Integer id){
			GoodsSkuPictureDeleteEntity goodsSkuPictureDelete = goodsSkuPictureDeleteService.selectById(id);

        return R.ok().put("goodsSkuPictureDelete", goodsSkuPictureDelete);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:goodsskupicturedelete:save")
    public R save(@RequestBody GoodsSkuPictureDeleteEntity goodsSkuPictureDelete){
			goodsSkuPictureDeleteService.insert(goodsSkuPictureDelete);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:goodsskupicturedelete:update")
    public R update(@RequestBody GoodsSkuPictureDeleteEntity goodsSkuPictureDelete){
			goodsSkuPictureDeleteService.updateById(goodsSkuPictureDelete);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:goodsskupicturedelete:delete")
    public R delete(@RequestBody Integer[] ids){
			goodsSkuPictureDeleteService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
