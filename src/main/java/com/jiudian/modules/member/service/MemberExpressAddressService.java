package com.jiudian.modules.member.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.member.entity.MemberExpressAddressEntity;

import java.util.Map;

/**
 * 会员收货地址管理
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
public interface MemberExpressAddressService extends IService<MemberExpressAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    public void updateIsDefault(Map<String, String> params);
}

