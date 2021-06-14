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

import com.jiudian.modules.goods.entity.GoodsGroupEntity;
import com.jiudian.modules.goods.service.GoodsGroupService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 商品本店分类
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
@RestController
@RequestMapping("goods/goodsgroup")
public class GoodsGroupController {
    @Autowired
    private GoodsGroupService goodsGroupService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:goodsgroup:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsGroupService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{groupId}")
    @RequiresPermissions("goods:goodsgroup:info")
    public R info(@PathVariable("groupId") Integer groupId){
			GoodsGroupEntity goodsGroup = goodsGroupService.selectById(groupId);

        return R.ok().put("goodsGroup", goodsGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:goodsgroup:save")
    public R save(@RequestBody GoodsGroupEntity goodsGroup){
			goodsGroupService.insert(goodsGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:goodsgroup:update")
    public R update(@RequestBody GoodsGroupEntity goodsGroup){
			goodsGroupService.updateById(goodsGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:goodsgroup:delete")
    public R delete(@RequestBody Integer[] groupIds){
			goodsGroupService.deleteBatchIds(Arrays.asList(groupIds));

        return R.ok();
    }

}
