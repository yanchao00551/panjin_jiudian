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

import com.jiudian.modules.goods.entity.GoodsSkuEntity;
import com.jiudian.modules.goods.service.GoodsSkuService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 商品skui规格价格库存信息表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:53
 */
@RestController
@RequestMapping("goods/goodssku")
public class GoodsSkuController {
    @Autowired
    private GoodsSkuService goodsSkuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:goodssku:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsSkuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{skuId}")
    @RequiresPermissions("goods:goodssku:info")
    public R info(@PathVariable("skuId") Integer skuId){
			GoodsSkuEntity goodsSku = goodsSkuService.selectById(skuId);

        return R.ok().put("goodsSku", goodsSku);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:goodssku:save")
    public R save(@RequestBody GoodsSkuEntity goodsSku){
			goodsSkuService.insert(goodsSku);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:goodssku:update")
    public R update(@RequestBody GoodsSkuEntity goodsSku){
			goodsSkuService.updateById(goodsSku);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:goodssku:delete")
    public R delete(@RequestBody Integer[] skuIds){
			goodsSkuService.deleteBatchIds(Arrays.asList(skuIds));

        return R.ok();
    }

}
