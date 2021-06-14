package com.jiudian.modules.member.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.member.entity.MemberPartnerEntity;

import java.util.Map;

/**
 * 会员合伙人申请表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-21 15:55:35
 */
public interface MemberPartnerService extends IService<MemberPartnerEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 合伙人列表
     * @param params
     * @return
     */
	PageUtils queryByPartnerList(Map<String, Object> params);
}

