package com.jiudian.modules.app.calculate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jiudian.modules.member.entity.MemberEntity;
import com.jiudian.modules.member.entity.MemberPartnerEntity;
import com.jiudian.modules.member.service.MemberPartnerService;
import com.jiudian.modules.member.service.MemberService;

@Service("RewardCalcuUtil")
public class RewardCalcuUtil {

	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberPartnerService memberPartnerService;


	/**
	 * 获取新注册用户的等级 1合伙人（正常情况注册时不会出现） 2高级会员（合伙人直接邀请） 3受邀会员（高级会员邀请）
	 * 4为大于等于4，即不在返润系统管理范围内
	 * 
	 * @param pid 用户的邀请人（上级ID）
	 * @return
	 */
	public int getCurrentLevel(int uid, String pid) {
		if (isPartner(uid)) {
			return 1;
		}
		if (pid == null || "".equals(pid)) {
			return 4;
		}
		MemberEntity parentEntity = memberService.selectOne(new EntityWrapper<MemberEntity>().eq("uid", pid));
		if (parentEntity == null) {
			return 4;
		}
		if (isPartner(parentEntity.getUid())) {
			return 2;
		}
		if (parentEntity.getPid() <= 0l) {
			return 4;
		}
		MemberEntity grandEntity = memberService
				.selectOne(new EntityWrapper<MemberEntity>().eq("uid", parentEntity.getPid()));
		if (grandEntity == null) {
			return 4;
		}
		if (isPartner(grandEntity.getUid())) {
			return 3;
		}
		return 4;
	}

	private boolean isPartner(long userId) {
		MemberPartnerEntity memberPartnerEntity = memberPartnerService
				.selectOne(new EntityWrapper<MemberPartnerEntity>().eq("uid", userId).ne("status", 2));
		if (memberPartnerEntity == null) {
			return false;
		}
		return memberPartnerEntity.getStatus() == 1 ? true : false;
	}

	public void setMemberPartnerService(MemberPartnerService memberPartnerService) {
		this.memberPartnerService = memberPartnerService;
	}
	
	public String getRichText(String info) {
		StringBuffer sb = new StringBuffer();
		sb.append("<!DOCTYPE html>" + "<html lang=\"zh-CN\">" + "<head>"
				+ "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">"
				+ "    <style>" + "        html,body{" + "            height:100%;" + "            width:100%;"
				+ "            padding:0;" + "            margin:0;" + "        }" + "        #content{"
				+ "            width:100%;" + "            height:100%;" + "            padding:0;"
				+ "            margin:10px auto;" + "        }" + "    </style>" + "</head>" + "<body>");
		sb.append("<div id=\"content\" style=\"width:90%;margin:0 auto;\">");
		sb.append(info);
		sb.append("</div></body>" + "    <script>" + "        var imgs = document.getElementsByTagName('img');"
				+ "        for(var i in imgs)" + "        {   " + "            var img = imgs[i];"
				+ " img.style.width='100%';" + "            img.style.height='auto';" + "        }"
				+ "    </script>" + "</html>");
		return sb.toString();
	}
}
