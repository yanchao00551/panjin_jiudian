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

import com.jiudian.modules.goods.entity.AttributeValueEntity;
import com.jiudian.modules.goods.service.AttributeValueService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 商品属性值
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 15:31:36
 */
@RestController
@RequestMapping("goods/attributevalue")
public class AttributeValueController {
    @Autowired
    private AttributeValueService attributeValueService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:attributevalue:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attributeValueService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrValueId}")
    @RequiresPermissions("goods:attributevalue:info")
    public R info(@PathVariable("attrValueId") Integer attrValueId){
			AttributeValueEntity attributeValue = attributeValueService.selectById(attrValueId);

        return R.ok().put("attributeValue", attributeValue);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:attributevalue:save")
    public R save(@RequestBody AttributeValueEntity attributeValue){
			attributeValueService.insert(attributeValue);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:attributevalue:update")
    public R update(@RequestBody AttributeValueEntity attributeValue){
			attributeValueService.updateById(attributeValue);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:attributevalue:delete")
    public R delete(@RequestBody Integer[] attrValueIds){
			attributeValueService.deleteBatchIds(Arrays.asList(attrValueIds));

        return R.ok();
    }

}
