package com.jiudian.modules.star.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.star.entity.StarEntity;

/**
 * 服务星表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-20 08:29:38
 */
public interface StarService extends IService<StarEntity> {

    PageUtils queryPage(Map<String, Object> params,Integer cid, Integer type);

	PageUtils queryStarPage(Map<String, Object> params);
	
	public PageUtils queryStarAndAvg(Map<String, String> params);
}

