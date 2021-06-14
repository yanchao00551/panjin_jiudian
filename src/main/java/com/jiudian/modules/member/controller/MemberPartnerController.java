package com.jiudian.modules.member.controller;

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

import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.album.service.AlbumPictureService;
import com.jiudian.modules.member.entity.MemberEntity;
import com.jiudian.modules.member.entity.MemberPartnerEntity;
import com.jiudian.modules.member.service.MemberPartnerService;
import com.jiudian.modules.member.service.MemberService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 会员合伙人申请表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-21 15:55:35
 */
@RestController
@RequestMapping("member/memberpartner")
public class MemberPartnerController {
    @Autowired
    private MemberPartnerService memberPartnerService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private AlbumPictureService albumPictureService;

    /**
     * 列表
     */
    @SuppressWarnings("unchecked")
	@RequestMapping("/list")
    @RequiresPermissions("member:memberpartner:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberPartnerService.queryByPartnerList(params);
        List<MemberPartnerEntity> memberPartnerEntities = (List<MemberPartnerEntity>) page.getList();
        memberPartnerEntities.forEach(mpe ->{
        	String picId = mpe.getUserHeadimg();
        	AlbumPictureEntity albumPictureEntity = albumPictureService.selectById(picId);
        	mpe.setHeadPic(albumPictureEntity);
        });
        return R.ok().put("page", page);
    }

    /**
     * 合伙人申请审核通过
     */
    @RequestMapping("/auditor")
    @RequiresPermissions("member:memberpartner:auditor")
    public R auditor(@RequestBody MemberPartnerEntity form) {
    	if(form.getPartnerId() == null || form.getPartnerId() == 0) {
    		return R.error("缺少parntnerId参数！");
    	}
    	MemberPartnerEntity entity = new MemberPartnerEntity();
    	entity.setStatus(form.getStatus());
    	memberPartnerService.update(entity, new EntityWrapper<MemberPartnerEntity>().eq("partner_id", form.getPartnerId()));
//    	MemberEntity info = new MemberEntity();
////    	info.setMemberLevel(2);
//    	info.setUid(form.getUid());
//    	memberService.update(info, new EntityWrapper<MemberEntity>().eq("uid", form.getUid()));
    	return R.ok();
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{partnerId}")
    @RequiresPermissions("member:memberpartner:info")
    public R info(@PathVariable("partnerId") Integer partnerId){
			MemberPartnerEntity memberPartner = memberPartnerService.selectById(partnerId);

        return R.ok().put("memberPartner", memberPartner);
    }
    
	/**
	 * 信息
	 */
	@RequestMapping("/getCardInfo")
	public R getCardInfo(@RequestParam Map<String, String> params) {
		int partnerId = Integer.parseInt(params.get("id"));
		MemberPartnerEntity memberPartner = memberPartnerService.selectById(partnerId);
		MemberEntity memberEntity = memberService.selectOne(new EntityWrapper<MemberEntity>().eq("uid", memberPartner.getUid()));
		int cardFront = memberEntity.getCardFront();
		int cardBack = memberEntity.getCardReverse();
		AlbumPictureEntity frontImg = albumPictureService.selectOne
				(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", cardFront));
		AlbumPictureEntity backImg = albumPictureService.selectOne
				(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", cardBack));
		memberPartner.setCardFront(frontImg);
		memberPartner.setCardBack(backImg);
		return R.ok().put("memberPartner", memberPartner);
	}

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("member:memberpartner:save")
    public R save(@RequestBody MemberPartnerEntity memberPartner){
			memberPartnerService.insert(memberPartner);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("member:memberpartner:update")
    public R update(@RequestBody MemberPartnerEntity memberPartner){
			memberPartnerService.updateById(memberPartner);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("member:memberpartner:delete")
    public R delete(@RequestBody Integer[] partnerIds){
			memberPartnerService.deleteBatchIds(Arrays.asList(partnerIds));

        return R.ok();
    }

}
