package com.jiudian.modules.order.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;
import com.jiudian.modules.order.entity.GoodsCommentEntity;
import com.jiudian.modules.order.service.GoodsCommentService;



/**
 * 商品评论送积分记录表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-09-27 11:50:49
 */
@RestController
@RequestMapping("order/goodscomment")
public class GoodsCommentController {
    @Autowired
    private GoodsCommentService goodsCommentService;
//    @Autowired
//    private GoodsService goodsService;

    /**
     * 列表
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/list")
//    @RequiresPermissions("order:goodscomment:list")
	public R list(@RequestParam Map<String, String> params) {
		try {
			if (params.containsKey("startTime")) {
				String startDatetime = params.get("startTime").toString();
				SimpleDateFormat startDateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				long startDate = startDateformat.parse(startDatetime).getTime();
				params.put("startTime", String.valueOf(startDate / 1000));
			}
			if (params.containsKey("endTime")) {
				String endDatetime = params.get("endTime").toString();
				SimpleDateFormat endDateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				long endDate = endDateformat.parse(endDatetime).getTime();
				params.put("endTime", String.valueOf(endDate / 1000));
			}
		} catch (ParseException e) {
		}
        PageUtils page = goodsCommentService.queryForSearch(params);
        List<GoodsCommentEntity> commentEntities = (List<GoodsCommentEntity>) page.getList();
        commentEntities.forEach(ce ->{
        	try {
				String content = URLDecoder.decode(ce.getComments(), "UTF-8");
				ce.setComments(content);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
        page.setList(commentEntities);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("order:goodscomment:info")
    public R info(@PathVariable("id") Integer id){
		GoodsCommentEntity goodsComment = goodsCommentService.selectById(id);

        return R.ok().put("goodsComment", goodsComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:goodscomment:save")
    public R save(@RequestBody GoodsCommentEntity goodsComment){
			goodsCommentService.insert(goodsComment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("order:goodscomment:update")
    public R update(@RequestBody GoodsCommentEntity goodsComment){
			goodsCommentService.updateById(goodsComment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("order:goodscomment:delete")
    public R delete(@RequestBody Integer[] ids){
			goodsCommentService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
