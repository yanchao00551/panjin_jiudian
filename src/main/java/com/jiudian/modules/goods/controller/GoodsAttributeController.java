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

import com.jiudian.modules.goods.entity.GoodsAttributeEntity;
import com.jiudian.modules.goods.service.GoodsAttributeService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 商品属性表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:40
 */
@RestController
@RequestMapping("goods/goodsattribute")
public class GoodsAttributeController {
    @Autowired
    private GoodsAttributeService goodsAttributeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:goodsattribute:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsAttributeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    @RequiresPermissions("goods:goodsattribute:info")
    public R info(@PathVariable("attrId") Integer attrId){
			GoodsAttributeEntity goodsAttribute = goodsAttributeService.selectById(attrId);

        return R.ok().put("goodsAttribute", goodsAttribute);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:goodsattribute:save")
    public R save(@RequestBody GoodsAttributeEntity goodsAttribute){
			goodsAttributeService.insert(goodsAttribute);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:goodsattribute:update")
    public R update(@RequestBody GoodsAttributeEntity goodsAttribute){
			goodsAttributeService.updateById(goodsAttribute);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:goodsattribute:delete")
    public R delete(@RequestBody Integer[] attrIds){
			goodsAttributeService.deleteBatchIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
