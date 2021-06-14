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

import com.jiudian.modules.goods.entity.GoodsEvaluateEntity;
import com.jiudian.modules.goods.service.GoodsEvaluateService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 商品评价表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
@RestController
@RequestMapping("goods/goodsevaluate")
public class GoodsEvaluateController {
    @Autowired
    private GoodsEvaluateService goodsEvaluateService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:goodsevaluate:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsEvaluateService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("goods:goodsevaluate:info")
    public R info(@PathVariable("id") Integer id){
			GoodsEvaluateEntity goodsEvaluate = goodsEvaluateService.selectById(id);

        return R.ok().put("goodsEvaluate", goodsEvaluate);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:goodsevaluate:save")
    public R save(@RequestBody GoodsEvaluateEntity goodsEvaluate){
			goodsEvaluateService.insert(goodsEvaluate);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:goodsevaluate:update")
    public R update(@RequestBody GoodsEvaluateEntity goodsEvaluate){
			goodsEvaluateService.updateById(goodsEvaluate);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:goodsevaluate:delete")
    public R delete(@RequestBody Integer[] ids){
			goodsEvaluateService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
