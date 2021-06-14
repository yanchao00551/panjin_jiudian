package com.jiudian.modules.cart.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.modules.cart.entity.CartEntity;
import com.jiudian.modules.cart.service.CartService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 购物车表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-28 10:13:44
 */
@RestController
@RequestMapping("cart/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("cart:cart:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cartService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{cartId}")
    @RequiresPermissions("cart:cart:info")
    public R info(@PathVariable("cartId") Integer cartId){
			CartEntity cart = cartService.selectById(cartId);

        return R.ok().put("cart", cart);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("cart:cart:save")
    public R save(@RequestBody CartEntity cart){
			cartService.insert(cart);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("cart:cart:update")
    public R update(@RequestBody CartEntity cart){
			cartService.updateById(cart);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("cart:cart:delete")
    public R delete(@RequestBody Integer[] cartIds){
			cartService.deleteBatchIds(Arrays.asList(cartIds));

        return R.ok();
    }

}
