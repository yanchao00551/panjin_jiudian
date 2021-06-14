package com.jiudian.modules.goods.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.goods.dao.GoodsEvaluateDao;
import com.jiudian.modules.goods.entity.GoodsEvaluateEntity;
import com.jiudian.modules.goods.service.GoodsEvaluateService;


@Service("goodsEvaluateService")
public class GoodsEvaluateServiceImpl extends ServiceImpl<GoodsEvaluateDao, GoodsEvaluateEntity> implements GoodsEvaluateService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsEvaluateEntity> page = this.selectPage(
                new Query<GoodsEvaluateEntity>(params).getPage(),
                new EntityWrapper<GoodsEvaluateEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public PageUtils getGoodsEvaluateList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int limit = Integer.parseInt((String) params.get("limit"));
		int current = (Integer.parseInt((String) params.get("page")));
		Page<GoodsEvaluateEntity> page = new Page<GoodsEvaluateEntity>(current, limit);
		List<GoodsEvaluateEntity> pageList = baseMapper.getGoodsEvaluateList(page, params);
		page.setRecords(pageList);
		return new PageUtils(page);
	}

	@Override
	public Integer addGoodsEvaluateReply(Integer id, String replyContent, Integer replyType) {
		// TODO Auto-generated method stub
		Integer res = 0;
		GoodsEvaluateEntity entity = new GoodsEvaluateEntity();
		if(replyType == 1) {
			entity.setExplainFirst(replyContent);
		}else if(replyType == 2) {
			entity.setAgainExplain(replyContent);
		}
		entity.setId(id);
		baseMapper.updateById(entity);
		return res;
	}

	@Override
	public void setEvaluateShowStatu(Integer evaluateId) {
		// TODO Auto-generated method stub
		GoodsEvaluateEntity goodsEvaluateInfo = new GoodsEvaluateEntity();
		goodsEvaluateInfo = baseMapper.selectById(evaluateId);
		if(goodsEvaluateInfo.getIsShow() == 1) {
			goodsEvaluateInfo.setIsShow(0);
			goodsEvaluateInfo.setId(evaluateId);
			baseMapper.updateById(goodsEvaluateInfo);
		}else if(goodsEvaluateInfo.getIsShow() == 0){
			goodsEvaluateInfo.setIsShow(1);
			goodsEvaluateInfo.setId(evaluateId);
			baseMapper.updateById(goodsEvaluateInfo);
		}
	}



}
