package com.jiudian.modules.member.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.member.entity.MemberGiftEntity;

import java.util.Map;

/**
 * 会员赠品表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
public interface MemberGiftService extends IService<MemberGiftEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

