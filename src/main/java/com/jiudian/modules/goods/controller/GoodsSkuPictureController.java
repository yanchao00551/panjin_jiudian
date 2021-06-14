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

import com.jiudian.modules.goods.entity.GoodsSkuPictureEntity;
import com.jiudian.modules.goods.service.GoodsSkuPictureService;
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
@RequestMapping("goods/goodsskupicture")
public class GoodsSkuPictureController {
    @Autowired
    private GoodsSkuPictureService goodsSkuPictureService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:goodsskupicture:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsSkuPictureService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("goods:goodsskupicture:info")
    public R info(@PathVariable("id") Integer id){
			GoodsSkuPictureEntity goodsSkuPicture = goodsSkuPictureService.selectById(id);

        return R.ok().put("goodsSkuPicture", goodsSkuPicture);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:goodsskupicture:save")
    public R save(@RequestBody GoodsSkuPictureEntity goodsSkuPicture){
			goodsSkuPictureService.insert(goodsSkuPicture);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:goodsskupicture:update")
    public R update(@RequestBody GoodsSkuPictureEntity goodsSkuPicture){
			goodsSkuPictureService.updateById(goodsSkuPicture);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:goodsskupicture:delete")
    public R delete(@RequestBody Integer[] ids){
			goodsSkuPictureService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
