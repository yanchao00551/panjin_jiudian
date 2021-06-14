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

import com.jiudian.modules.goods.entity.GoodsSkuDeletedEntity;
import com.jiudian.modules.goods.service.GoodsSkuDeletedService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 商品skui规格价格库存信息回收站表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:53
 */
@RestController
@RequestMapping("goods/goodsskudeleted")
public class GoodsSkuDeletedController {
    @Autowired
    private GoodsSkuDeletedService goodsSkuDeletedService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:goodsskudeleted:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsSkuDeletedService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{skuId}")
    @RequiresPermissions("goods:goodsskudeleted:info")
    public R info(@PathVariable("skuId") Integer skuId){
			GoodsSkuDeletedEntity goodsSkuDeleted = goodsSkuDeletedService.selectById(skuId);

        return R.ok().put("goodsSkuDeleted", goodsSkuDeleted);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:goodsskudeleted:save")
    public R save(@RequestBody GoodsSkuDeletedEntity goodsSkuDeleted){
			goodsSkuDeletedService.insert(goodsSkuDeleted);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:goodsskudeleted:update")
    public R update(@RequestBody GoodsSkuDeletedEntity goodsSkuDeleted){
			goodsSkuDeletedService.updateById(goodsSkuDeleted);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:goodsskudeleted:delete")
    public R delete(@RequestBody Integer[] skuIds){
			goodsSkuDeletedService.deleteBatchIds(Arrays.asList(skuIds));

        return R.ok();
    }

}
