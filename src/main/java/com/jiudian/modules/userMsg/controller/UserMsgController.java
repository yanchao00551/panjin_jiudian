package com.jiudian.modules.userMsg.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.modules.userMsg.entity.UserMsgEntity;
import com.jiudian.modules.userMsg.service.UserMsgService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 
 *
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-10-27 16:20:26
 */
@RestController
@RequestMapping("userMsg/usermsg")
public class UserMsgController {
    @Autowired
    private UserMsgService userMsgService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("userMsg:usermsg:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userMsgService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("userMsg:usermsg:info")
    public R info(@PathVariable("id") Integer id){
			UserMsgEntity userMsg = userMsgService.selectById(id);

        return R.ok().put("userMsg", userMsg);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("userMsg:usermsg:save")
    public R save(@RequestBody UserMsgEntity userMsg){
			userMsgService.insert(userMsg);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("userMsg:usermsg:update")
    public R update(@RequestBody UserMsgEntity userMsg){
			userMsgService.updateById(userMsg);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("userMsg:usermsg:delete")
    public R delete(@RequestBody Integer[] ids){
			userMsgService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
