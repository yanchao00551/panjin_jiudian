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

import com.jiudian.modules.goods.entity.GoodsAttributeDeletedEntity;
import com.jiudian.modules.goods.service.GoodsAttributeDeletedService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 商品属性回收站表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:40
 */
@RestController
@RequestMapping("goods/goodsattributedeleted")
public class GoodsAttributeDeletedController {
    @Autowired
    private GoodsAttributeDeletedService goodsAttributeDeletedService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:goodsattributedeleted:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsAttributeDeletedService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    @RequiresPermissions("goods:goodsattributedeleted:info")
    public R info(@PathVariable("attrId") Integer attrId){
			GoodsAttributeDeletedEntity goodsAttributeDeleted = goodsAttributeDeletedService.selectById(attrId);

        return R.ok().put("goodsAttributeDeleted", goodsAttributeDeleted);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:goodsattributedeleted:save")
    public R save(@RequestBody GoodsAttributeDeletedEntity goodsAttributeDeleted){
			goodsAttributeDeletedService.insert(goodsAttributeDeleted);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:goodsattributedeleted:update")
    public R update(@RequestBody GoodsAttributeDeletedEntity goodsAttributeDeleted){
			goodsAttributeDeletedService.updateById(goodsAttributeDeleted);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:goodsattributedeleted:delete")
    public R delete(@RequestBody Integer[] attrIds){
			goodsAttributeDeletedService.deleteBatchIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
