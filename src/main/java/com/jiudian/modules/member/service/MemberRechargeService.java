package com.jiudian.modules.member.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.member.entity.MemberRechargeEntity;

import java.util.Map;

/**
 * 会员充值余额记录
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
public interface MemberRechargeService extends IService<MemberRechargeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

