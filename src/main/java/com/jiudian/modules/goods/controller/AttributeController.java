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

import com.jiudian.modules.goods.entity.AttributeEntity;
import com.jiudian.modules.goods.service.AttributeService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 商品相关属性
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 15:31:36
 */
@RestController
@RequestMapping("goods/attribute")
public class AttributeController {
    @Autowired
    private AttributeService attributeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:attribute:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attributeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    @RequiresPermissions("goods:attribute:info")
    public R info(@PathVariable("attrId") Integer attrId){
			AttributeEntity attribute = attributeService.selectById(attrId);

        return R.ok().put("attribute", attribute);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:attribute:save")
    public R save(@RequestBody AttributeEntity attribute){
			attributeService.insert(attribute);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:attribute:update")
    public R update(@RequestBody AttributeEntity attribute){
			attributeService.updateById(attribute);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:attribute:delete")
    public R delete(@RequestBody Integer[] attrIds){
			attributeService.deleteBatchIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
