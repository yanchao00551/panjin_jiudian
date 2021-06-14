package com.jiudian.modules.member.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.member.entity.MemberLevelEntity;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 会员等级
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
         *  新增会员等级
     * @param shopId
     * @param levelName
     * @param minIntegral
     * @param quota
     * @param upgrade
     * @param goodsDiscount
     * @param desc
     * @param relation
     * @return
     */
	Integer addMemberLevel(Integer shopId, String levelName, Integer minIntegral, Integer quota, Integer upgrade,
			BigDecimal goodsDiscount, String desc, Integer relation);

	/**
	  *  获取会员等级相对应折扣率
	 * @param uid
	 * @return
	 */
	BigDecimal getMemberLevelDiscount(Long uid);
}

