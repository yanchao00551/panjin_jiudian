package com.jiudian.modules.cms.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.modules.cms.entity.NcCmsTopicEntity;
import com.jiudian.modules.cms.service.NcCmsTopicService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 专题
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:19:57
 */
@RestController
@RequestMapping("cms/nccmstopic")
public class NcCmsTopicController {
    @Autowired
    private NcCmsTopicService ncCmsTopicService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("cms:nccmstopic:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ncCmsTopicService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{topicId}")
    @RequiresPermissions("cms:nccmstopic:info")
    public R info(@PathVariable("topicId") Integer topicId){
			NcCmsTopicEntity ncCmsTopic = ncCmsTopicService.selectById(topicId);

        return R.ok().put("ncCmsTopic", ncCmsTopic);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("cms:nccmstopic:save")
    public R save(@RequestBody NcCmsTopicEntity ncCmsTopic){
			ncCmsTopicService.insert(ncCmsTopic);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("cms:nccmstopic:update")
    public R update(@RequestBody NcCmsTopicEntity ncCmsTopic){
			ncCmsTopicService.updateById(ncCmsTopic);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("cms:nccmstopic:delete")
    public R delete(@RequestBody Integer[] topicIds){
			ncCmsTopicService.deleteBatchIds(Arrays.asList(topicIds));

        return R.ok();
    }

}
