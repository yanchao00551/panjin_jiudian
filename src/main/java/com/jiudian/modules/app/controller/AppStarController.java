package com.jiudian.modules.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;
import com.jiudian.common.validator.ValidatorUtils;
import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.album.service.AlbumPictureService;
import com.jiudian.modules.app.annotation.Login;
import com.jiudian.modules.app.calculate.RewardCalcuUtil;
import com.jiudian.modules.app.form.CommentStarForm;
import com.jiudian.modules.member.entity.MemberEntity;
import com.jiudian.modules.member.service.MemberService;
import com.jiudian.modules.order.entity.OrderEntity;
import com.jiudian.modules.order.service.OrderService;
import com.jiudian.modules.star.entity.StarClassEntity;
import com.jiudian.modules.star.entity.StarCommentEntity;
import com.jiudian.modules.star.entity.StarEntity;
import com.jiudian.modules.star.service.StarClassService;
import com.jiudian.modules.star.service.StarCommentService;
import com.jiudian.modules.star.service.StarService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 服务星 金钥匙  控制器
 * @author Mr.Yan
 *
 */

@RestController
@RequestMapping("/app")
@Api("服务星和金钥匙控制器")
public class AppStarController {
	@Autowired
	StarService starService;
	@Autowired
	StarClassService starClassService;
	@Autowired
	StarCommentService starCommentService;
	@Autowired
	private AlbumPictureService albumPictureService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private RewardCalcuUtil rewardCalcuUtil;
	
	/**
	 * 获取服务星或金钥匙列表
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("getStarList")
	@ApiOperation("获取服务星和金钥匙列表")
	public R getStarList(@RequestParam Map<String, String> params) {
//		Integer cid = new Integer(params.get("classId").toString());
//		Integer type = new Integer(params.get("type").toString()); // 1.服务星 2.金钥匙
		PageUtils page = starService.queryStarAndAvg(params);
		List<StarEntity> list = (List<StarEntity>) page.getList();

		for (int i = 0; i < list.size(); i++) {
			AlbumPictureEntity albumPicture = albumPictureService.selectById(list.get(i).getBanner());
			list.get(i).setAlbumPicture(albumPicture);
		}

		return R.ok().put("page", page);
	}
	
	
	/**
	 *判断是否有权限评价该金钥匙
	 */
	@Login
	@GetMapping("hasKeyCommentPermission")
	@ApiOperation("获取可评价的金钥匙服务订单号列表")
	public R hasKeyCommentPermission(@RequestAttribute("userId") Integer userId, @RequestParam Map<String, String> params) {
//		String keyId = params.get("starId");
//		String orderId = params.get("orderId");
//		int count = starCommentService.selectCount(new EntityWrapper<StarCommentEntity>().eq("order_id", orderId));
//		if(count > 0) {
//			return R.error("此订单已进行过评价，请勿重复评价");
//		}
//		MemberEntity memberEntity = memberService.selectOne
//				(new EntityWrapper<MemberEntity>().eq("uid", userId).eq("key_id", keyId));
//		if(memberEntity == null) {
//			return R.error("该金钥匙不是本用户的绑定金钥匙，无法评价");
//		}
//		return R.ok();
		String keyId = params.get("starId");
		List<OrderEntity> orderEntities = orderService.selectList
				(new EntityWrapper<OrderEntity>().eq("key_id", keyId).eq("key_comment_flag", 0)
						.eq("buyer_id", userId).eq("order_status", 4));
		return R.ok().put("list", orderEntities);
	}
    
    /**
     * 获取服务星或金钥匙 详情 含评论
     */
    @GetMapping("getStarInfo")
    @ApiOperation("获取服务星或金钥匙详情含评论")
    public R getStarInfo(@RequestParam Map<String,String> params) {
    	params.put("page", "1");
    	params.put("limit", "5");
    	PageUtils page = starService.queryStarAndAvg(params);
    	if(page == null || page.getList() == null || page.getList().size() == 0) {
    		return R.error("未能获取到数据");
    	}
    	StarEntity info = (StarEntity) page.getList().get(0);
    	Map<String, Object> tmpMap = new HashMap<String, Object>();
    	tmpMap.put("starId", params.get("starId"));
    	List<StarCommentEntity> commentList = starCommentService.queryStarComment(tmpMap);
    	AlbumPictureEntity albumPicture = albumPictureService.selectById(info.getBanner());
    	info.setAlbumPicture(albumPicture);
    	if(!commentList.isEmpty()) {
        	info.setCommentList(commentList);
    	}
    	info.setContent(rewardCalcuUtil.getRichText(info.getContent()));
    	return R.ok().put("info", info);
    }
    
    
    /**
     * 评论服务星或金钥匙
     */
    @Login
    @PostMapping("commentStar")
    @ApiOperation("评论服务星或金钥匙")
    public R commentStar(@RequestAttribute("userId") Integer userId,@RequestBody CommentStarForm form) {
//    	if(Constant.getWordCount(form.getContent()) > 400) {
//    		return R.error("评论内容超过长度限制");
//    	}
        ValidatorUtils.validateEntity(form);
        StarCommentEntity info = new StarCommentEntity();
        info.setStarId(form.getStarId());
        info.setUserId(userId);
        info.setContent(form.getContent());
        info.setType(form.getType());
        info.setCreateDate((int)(System.currentTimeMillis() / 1000));
        info.setPoint(form.getPoint());
        starCommentService.insert(info);
        if(form.getType() == 2) {
	        OrderEntity orderEntity = orderService.selectOne(new EntityWrapper<OrderEntity>().eq("order_id", form.getOrderId()));
	        orderEntity.setKeyCommentFlag(1);
	        orderService.insertOrUpdate(orderEntity);
        }
    	return R.ok();
    }
    
    @Login
    @PostMapping("chooseKey")
    @ApiOperation("选择/绑定金钥匙")
    public R chooseKey(@RequestAttribute("userId") Integer userId,@RequestParam Map<String,String> params) {
    	String keyId = params.get("starId");
    	MemberEntity memberEntity = memberService.selectOne(new EntityWrapper<MemberEntity>().eq("uid", userId));
    	memberEntity.setKeyId(Integer.parseInt(keyId));
    	boolean res = memberService.insertOrUpdate(memberEntity);
    	if(res) {
    		//短信通知
    	}
    	return res ? R.ok() : R.error("金钥匙绑定失败");
    }
    
    /**
     * 获取服务星分类
     */
    @GetMapping("getStarClassName")
    @ApiOperation("获取服务星分类")
    public R getStarClassName() {
    	List<StarClassEntity> classEntities = starClassService.selectList(new EntityWrapper<StarClassEntity>());
    	classEntities.forEach(t -> {
    		AlbumPictureEntity albumPictureEntity = albumPictureService.selectOne
    				(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", t.getClassPic()));
    		t.setPicDetail(albumPictureEntity);
    	});
        return R.ok().put("data", classEntities);
    }
    
}
