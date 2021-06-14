package com.jiudian.modules.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.member.dao.MemberExpressAddressDao;
import com.jiudian.modules.member.entity.MemberExpressAddressEntity;
import com.jiudian.modules.member.service.MemberExpressAddressService;


@Service("memberExpressAddressService")
public class MemberExpressAddressServiceImpl extends ServiceImpl<MemberExpressAddressDao, MemberExpressAddressEntity> implements MemberExpressAddressService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MemberExpressAddressEntity> page = this.selectPage(
                new Query<MemberExpressAddressEntity>(params).getPage(),
                new EntityWrapper<MemberExpressAddressEntity>().eq("uid", (Integer)params.get("uid"))
        );

        return new PageUtils(page);
    }

	@Override
	public void updateIsDefault(Map<String, String> params) {
		baseMapper.updateIsDefault(params);
		
	}

}
