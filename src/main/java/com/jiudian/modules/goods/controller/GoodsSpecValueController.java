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

import com.jiudian.modules.goods.entity.GoodsSpecValueEntity;
import com.jiudian.modules.goods.service.GoodsSpecValueService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 商品规格值模版表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:53
 */
@RestController
@RequestMapping("goods/goodsspecvalue")
public class GoodsSpecValueController {
    @Autowired
    private GoodsSpecValueService goodsSpecValueService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:goodsspecvalue:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsSpecValueService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{specValueId}")
    @RequiresPermissions("goods:goodsspecvalue:info")
    public R info(@PathVariable("specValueId") Integer specValueId){
			GoodsSpecValueEntity goodsSpecValue = goodsSpecValueService.selectById(specValueId);

        return R.ok().put("goodsSpecValue", goodsSpecValue);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:goodsspecvalue:save")
    public R save(@RequestBody GoodsSpecValueEntity goodsSpecValue){
			goodsSpecValueService.insert(goodsSpecValue);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:goodsspecvalue:update")
    public R update(@RequestBody GoodsSpecValueEntity goodsSpecValue){
			goodsSpecValueService.updateById(goodsSpecValue);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:goodsspecvalue:delete")
    public R delete(@RequestBody Integer[] specValueIds){
			goodsSpecValueService.deleteBatchIds(Arrays.asList(specValueIds));

        return R.ok();
    }

}
