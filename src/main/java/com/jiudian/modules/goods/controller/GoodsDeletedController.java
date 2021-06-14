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

import com.jiudian.modules.goods.entity.GoodsDeletedEntity;
import com.jiudian.modules.goods.service.GoodsDeletedService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 商品回收站表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
@RestController
@RequestMapping("goods/goodsdeleted")
public class GoodsDeletedController {
    @Autowired
    private GoodsDeletedService goodsDeletedService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:goodsdeleted:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsDeletedService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{goodsId}")
    @RequiresPermissions("goods:goodsdeleted:info")
    public R info(@PathVariable("goodsId") Integer goodsId){
			GoodsDeletedEntity goodsDeleted = goodsDeletedService.selectById(goodsId);

        return R.ok().put("goodsDeleted", goodsDeleted);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:goodsdeleted:save")
    public R save(@RequestBody GoodsDeletedEntity goodsDeleted){
			goodsDeletedService.insert(goodsDeleted);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:goodsdeleted:update")
    public R update(@RequestBody GoodsDeletedEntity goodsDeleted){
			goodsDeletedService.updateById(goodsDeleted);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:goodsdeleted:delete")
    public R delete(@RequestBody Integer[] goodsIds){
			goodsDeletedService.deleteBatchIds(Arrays.asList(goodsIds));

        return R.ok();
    }

}
