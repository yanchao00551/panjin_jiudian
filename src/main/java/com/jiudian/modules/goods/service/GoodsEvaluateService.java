package com.jiudian.modules.goods.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.goods.entity.GoodsEvaluateEntity;

import java.util.Map;

/**
 * 商品评价表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
public interface GoodsEvaluateService extends IService<GoodsEvaluateEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取商品评价列表
     * @param params
     * @return
     */
	PageUtils getGoodsEvaluateList(Map<String, Object> params);

	/**
	 * 添加商品评价回复
	 * @param evaluateId
	 * @param evaluateReply
	 * @param replyType
	 * @return
	 */
	Integer addGoodsEvaluateReply(Integer evaluateId, String evaluateReply, Integer replyType);

	/**
	 * 设置评价的显示状态
	 * @param evaluateId
	 */
	void setEvaluateShowStatu(Integer evaluateId);

	
}

