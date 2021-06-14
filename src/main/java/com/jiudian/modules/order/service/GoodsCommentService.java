package com.jiudian.modules.order.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.order.entity.GoodsCommentEntity;

/**
 * 商品评论送积分记录表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-09-27 11:50:49
 */
public interface GoodsCommentService extends IService<GoodsCommentEntity> {

    PageUtils queryPage(Map<String, Object> params, String status);
    
    PageUtils queryList(Map<String, Object> params);
    
    public String selectPointAvg(Map<String, String> params);
    
    public PageUtils queryForSearch(Map<String, String> params);
}

