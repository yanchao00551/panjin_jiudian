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

import com.jiudian.modules.goods.entity.GoodsCategoryBlockEntity;
import com.jiudian.modules.goods.service.GoodsCategoryBlockService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 商品分类楼层表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
@RestController
@RequestMapping("goods/goodscategoryblock")
public class GoodsCategoryBlockController {
    @Autowired
    private GoodsCategoryBlockService goodsCategoryBlockService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:goodscategoryblock:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsCategoryBlockService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("goods:goodscategoryblock:info")
    public R info(@PathVariable("id") Integer id){
			GoodsCategoryBlockEntity goodsCategoryBlock = goodsCategoryBlockService.selectById(id);

        return R.ok().put("goodsCategoryBlock", goodsCategoryBlock);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:goodscategoryblock:save")
    public R save(@RequestBody GoodsCategoryBlockEntity goodsCategoryBlock){
			goodsCategoryBlockService.insert(goodsCategoryBlock);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:goodscategoryblock:update")
    public R update(@RequestBody GoodsCategoryBlockEntity goodsCategoryBlock){
			goodsCategoryBlockService.updateById(goodsCategoryBlock);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:goodscategoryblock:delete")
    public R delete(@RequestBody Integer[] ids){
			goodsCategoryBlockService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
