package com.jiudian.modules.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.member.dao.MemberLevelDao;
import com.jiudian.modules.member.entity.MemberEntity;
import com.jiudian.modules.member.entity.MemberLevelEntity;
import com.jiudian.modules.member.service.MemberLevelService;
import com.jiudian.modules.member.service.MemberService;


@Service("memberLevelService")
public class MemberLevelServiceImpl extends ServiceImpl<MemberLevelDao, MemberLevelEntity> implements MemberLevelService {
	@Autowired
	MemberService memberService;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MemberLevelEntity> page = this.selectPage(
                new Query<MemberLevelEntity>(params).getPage(),
                new EntityWrapper<MemberLevelEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public Integer addMemberLevel(Integer shopId, String levelName, Integer minIntegral, Integer quota, Integer upgrade,
			BigDecimal goodsDiscount, String desc, Integer relation) {
		// TODO Auto-generated method stub
		MemberLevelEntity memberLevel = new MemberLevelEntity();
		memberLevel.setShopId(shopId);
		memberLevel.setLevelName(levelName);
		memberLevel.setMinIntegral(minIntegral);
		memberLevel.setQuota(quota);
		memberLevel.setUpgrade(upgrade);
		memberLevel.setGoodsDiscount(goodsDiscount);
		memberLevel.setDesc(desc);
		memberLevel.setRelation(relation);
		return baseMapper.insert(memberLevel);
	}

	@Override
	public BigDecimal getMemberLevelDiscount(Long uid) {
		// TODO Auto-generated method stub
		MemberEntity memberInfo = new MemberEntity();
		memberInfo = memberService.selectById(uid);
		if(memberInfo != null) {
			MemberLevelEntity levelInfo = new MemberLevelEntity();
			levelInfo = baseMapper.selectById(memberInfo.getLevelId());
			if(levelInfo != null) {
				return levelInfo.getGoodsDiscount();
			}else {
				return new BigDecimal("1");
			}
		}else {
			return new BigDecimal("1");
		}
	}

}
