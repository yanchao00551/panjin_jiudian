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

import com.jiudian.modules.goods.entity.GoodsAttributeValueEntity;
import com.jiudian.modules.goods.service.GoodsAttributeValueService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 商品规格值模版表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
@RestController
@RequestMapping("goods/goodsattributevalue")
public class GoodsAttributeValueController {
    @Autowired
    private GoodsAttributeValueService goodsAttributeValueService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:goodsattributevalue:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsAttributeValueService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrValueId}")
    @RequiresPermissions("goods:goodsattributevalue:info")
    public R info(@PathVariable("attrValueId") Integer attrValueId){
			GoodsAttributeValueEntity goodsAttributeValue = goodsAttributeValueService.selectById(attrValueId);

        return R.ok().put("goodsAttributeValue", goodsAttributeValue);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:goodsattributevalue:save")
    public R save(@RequestBody GoodsAttributeValueEntity goodsAttributeValue){
			goodsAttributeValueService.insert(goodsAttributeValue);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:goodsattributevalue:update")
    public R update(@RequestBody GoodsAttributeValueEntity goodsAttributeValue){
			goodsAttributeValueService.updateById(goodsAttributeValue);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:goodsattributevalue:delete")
    public R delete(@RequestBody Integer[] attrValueIds){
			goodsAttributeValueService.deleteBatchIds(Arrays.asList(attrValueIds));

        return R.ok();
    }

}
