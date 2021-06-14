package com.jiudian.modules.star.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.star.entity.StarCommentEntity;

import java.util.List;
import java.util.Map;

/**
 * 服务星评论表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-20 08:29:38
 */
public interface StarCommentService extends IService<StarCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取评论列表
     * @param params
     * @return
     */
	List<StarCommentEntity> queryStarComment(Map<String, Object> params);
}

