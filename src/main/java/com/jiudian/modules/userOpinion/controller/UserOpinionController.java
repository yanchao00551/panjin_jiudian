package com.jiudian.modules.userOpinion.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.modules.userOpinion.entity.UserOpinionEntity;
import com.jiudian.modules.userOpinion.service.UserOpinionService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 
 *
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-10-27 14:44:06
 */
@RestController
@RequestMapping("userOpinion/useropinion")
public class UserOpinionController {
    @Autowired
    private UserOpinionService userOpinionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("userOpinion:useropinion:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userOpinionService.queryPage(params);

        return R.ok().put("page", page);
    }
    
    @RequestMapping("/queryContainsUserInfo")
//  @RequiresPermissions("userOpinion:useropinion:list")
  public R queryContainsUserInfo(@RequestParam Map<String, String> params){
      PageUtils page = userOpinionService.queryContainsUserInfo(params);

      return R.ok().put("page", page);
  }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("userOpinion:useropinion:info")
    public R info(@PathVariable("id") Integer id){
		UserOpinionEntity userOpinion = userOpinionService.selectById(id);

        return R.ok().put("userOpinion", userOpinion);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("userOpinion:useropinion:save")
    public R save(@RequestBody UserOpinionEntity userOpinion){
			userOpinionService.insert(userOpinion);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("userOpinion:useropinion:update")
    public R update(@RequestBody UserOpinionEntity userOpinion){
			userOpinionService.updateById(userOpinion);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("userOpinion:useropinion:delete")
    public R delete(@RequestBody Integer[] ids){
			userOpinionService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
