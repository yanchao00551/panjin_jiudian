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

import com.jiudian.modules.goods.entity.GoodsLadderPreferentialEntity;
import com.jiudian.modules.goods.service.GoodsLadderPreferentialService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 商品阶梯优惠
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
@RestController
@RequestMapping("goods/goodsladderpreferential")
public class GoodsLadderPreferentialController {
    @Autowired
    private GoodsLadderPreferentialService goodsLadderPreferentialService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:goodsladderpreferential:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsLadderPreferentialService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("goods:goodsladderpreferential:info")
    public R info(@PathVariable("id") Integer id){
			GoodsLadderPreferentialEntity goodsLadderPreferential = goodsLadderPreferentialService.selectById(id);

        return R.ok().put("goodsLadderPreferential", goodsLadderPreferential);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:goodsladderpreferential:save")
    public R save(@RequestBody GoodsLadderPreferentialEntity goodsLadderPreferential){
			goodsLadderPreferentialService.insert(goodsLadderPreferential);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:goodsladderpreferential:update")
    public R update(@RequestBody GoodsLadderPreferentialEntity goodsLadderPreferential){
			goodsLadderPreferentialService.updateById(goodsLadderPreferential);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:goodsladderpreferential:delete")
    public R delete(@RequestBody Integer[] ids){
			goodsLadderPreferentialService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
