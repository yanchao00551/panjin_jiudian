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

import com.jiudian.modules.goods.entity.GoodsBrandEntity;
import com.jiudian.modules.goods.service.GoodsBrandService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 品牌表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
@RestController
@RequestMapping("goods/goodsbrand")
public class GoodsBrandController {
    @Autowired
    private GoodsBrandService goodsBrandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:goodsbrand:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsBrandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    @RequiresPermissions("goods:goodsbrand:info")
    public R info(@PathVariable("brandId") Long brandId){
			GoodsBrandEntity goodsBrand = goodsBrandService.selectById(brandId);

        return R.ok().put("goodsBrand", goodsBrand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:goodsbrand:save")
    public R save(@RequestBody GoodsBrandEntity goodsBrand){
			goodsBrandService.insert(goodsBrand);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:goodsbrand:update")
    public R update(@RequestBody GoodsBrandEntity goodsBrand){
			goodsBrandService.updateById(goodsBrand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:goodsbrand:delete")
    public R delete(@RequestBody Long[] brandIds){
			goodsBrandService.deleteBatchIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
