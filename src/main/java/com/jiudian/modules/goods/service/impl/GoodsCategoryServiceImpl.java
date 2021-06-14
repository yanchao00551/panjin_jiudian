package com.jiudian.modules.goods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.ErrorMsg;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.goods.dao.GoodsCategoryDao;
import com.jiudian.modules.goods.entity.GoodsCategoryBlockEntity;
import com.jiudian.modules.goods.entity.GoodsCategoryEntity;
import com.jiudian.modules.goods.service.GoodsCategoryBlockService;
import com.jiudian.modules.goods.service.GoodsCategoryService;


@Service("goodsCategoryService")
public class GoodsCategoryServiceImpl extends ServiceImpl<GoodsCategoryDao, GoodsCategoryEntity> implements GoodsCategoryService {

	@Autowired
	GoodsCategoryBlockService goodsCategoryBlockService;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsCategoryEntity> page = this.selectPage(
                new Query<GoodsCategoryEntity>(params).getPage(),
                new EntityWrapper<GoodsCategoryEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public Integer addOrEditGoodsCategory(Integer shopId,int categoryId, String categoryName, String shortName, Integer pid, Integer isVisible,
			String keywords, String description, Integer sort, String categoryPic, Integer attrId, String attrName,int icon) {
		// TODO Auto-generated method stub
		Integer level;
		if(pid == 0) {
			level = 1;
		}else {
			level = this.getGoodsCategoryDetail(pid).getLevel() + 1;
		}
		GoodsCategoryEntity entity = new GoodsCategoryEntity();
		entity.setCategoryName(categoryName);
		entity.setShortName(shortName);
		entity.setPid(pid);
		entity.setIsVisible(isVisible);
		entity.setLevel(level);
		entity.setKeywords(keywords);
		entity.setDescription(description);
		entity.setSort(sort);
		entity.setCategoryPic(categoryPic);
		entity.setIcon(String.valueOf(icon));
		entity.setAttrId(attrId);
		entity.setAttrName(attrName);
		if(categoryId == 0) {
			Integer result = baseMapper.insert(entity);
			if(result > 0) {
				// 创建商品分类楼层
				this.addGoodsCategoryBlock(entity.getCategoryId(),shopId);
			}else {
				return ErrorMsg.ADD_FAIL.getCode();
			}
			return 1;
		}else {
			entity.setCategoryId(categoryId);
			Integer ret = baseMapper.updateById(entity);
			return ret;
		}
	}

	private void addGoodsCategoryBlock(Integer categoryId,Integer shopId) {
		// TODO Auto-generated method stub
		GoodsCategoryEntity goodsCategoryInfo = new GoodsCategoryEntity();
		goodsCategoryInfo = baseMapper.selectById(categoryId);
		if(goodsCategoryInfo != null) {
			GoodsCategoryBlockEntity goodsCategoryBlock = new GoodsCategoryBlockEntity();
			goodsCategoryBlock = goodsCategoryBlockService.selectById(categoryId);
			if(goodsCategoryBlock == null && goodsCategoryInfo.getPid() == 0) {
				goodsCategoryBlock = new GoodsCategoryBlockEntity();
				goodsCategoryBlock.setShopId(shopId);
				goodsCategoryBlock.setCategoryId(categoryId);
				goodsCategoryBlock.setCategoryName(goodsCategoryInfo.getCategoryName());
				goodsCategoryBlock.setCategoryAlias(goodsCategoryInfo.getCategoryName());
				goodsCategoryBlock.setCreateTime((int)(System.currentTimeMillis() / 1000));
				goodsCategoryBlock.setShortName(substring(goodsCategoryInfo.getCategoryName(), 4,"UTF8"));
				goodsCategoryBlockService.insert(goodsCategoryBlock);
			}else {
				if(goodsCategoryInfo.getPid() > 0) {
					this.deleteGoodsCategoryBlock(categoryId);
				}else {
					goodsCategoryBlock.setCategoryName(goodsCategoryInfo.getCategoryName());
					goodsCategoryBlock.setCategoryAlias(goodsCategoryInfo.getCategoryName());
					goodsCategoryBlock.setModifyTime((int)(System.currentTimeMillis() / 1000));
					goodsCategoryBlock.setShortName(substring(goodsCategoryInfo.getCategoryName(),4,"UTF8"));
					goodsCategoryBlockService.update(goodsCategoryBlock, new EntityWrapper<GoodsCategoryBlockEntity>().eq("category_id", categoryId));
				}
			}
		}
	}

	private void deleteGoodsCategoryBlock(Integer categoryId) {
		// TODO Auto-generated method stub
		goodsCategoryBlockService.delete(new EntityWrapper<GoodsCategoryBlockEntity>().eq("category_id", categoryId));
	}

	private GoodsCategoryEntity getGoodsCategoryDetail(Integer cateogryId) {
		// TODO Auto-generated method stub
		return baseMapper.selectById(cateogryId);
	}
	
	 /**
	  * @param text 目标字符串
	  * @param length 截取长度
	  * @return
	  */
	public static String substring(String text, int length,String encode) {
		if (text == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		int currentLength = 0;
		for (char c : text.toCharArray()) {
			try {
				currentLength += String.valueOf(c).getBytes(encode).length;
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (currentLength <= length) {
				sb.append(c);
			} else {
				break;
			}
		}
		return sb.toString();
	}

	@Override
	public List<GoodsCategoryEntity> getGoodsCategoryTree(Integer pid) {
		// TODO Auto-generated method stub
		// 暂时 获取 两级
		List<GoodsCategoryEntity> goodsCategoryList = new ArrayList<GoodsCategoryEntity>();
		List<GoodsCategoryEntity> oneList = new ArrayList<GoodsCategoryEntity>();
		List<GoodsCategoryEntity> twoList = new ArrayList<GoodsCategoryEntity>();
		oneList = this.getGoodsCategoryListByParentId(pid);
		for(int i=0;i<oneList.size();i++) {
			twoList = this.getGoodsCategoryListByParentId(oneList.get(i).getPid());
			oneList.get(i).setChildList(twoList);
		}
		goodsCategoryList = oneList;
		return goodsCategoryList;
	}

	
	private List<GoodsCategoryEntity> getGoodsCategoryListByParentId(Integer pid) {
		// TODO Auto-generated method stub
		List<GoodsCategoryEntity> goodsCategoryList = new ArrayList<GoodsCategoryEntity>();
		List<GoodsCategoryEntity> childList = new ArrayList<GoodsCategoryEntity>();
		goodsCategoryList = baseMapper.selectList(new EntityWrapper<GoodsCategoryEntity>().eq("pid", pid));
		if(!goodsCategoryList.isEmpty()) {
			for(int i=0;i<goodsCategoryList.size();i++) {
				Integer parentId = goodsCategoryList.get(i).getCategoryId();
				childList = baseMapper.selectList(new EntityWrapper<GoodsCategoryEntity>().eq("pid", parentId));
				if(!childList.isEmpty() && childList.size() > 0) {
					goodsCategoryList.get(i).setIsParent(1);
				}else {
					goodsCategoryList.get(i).setIsParent(0);
				}
			}
		}
		return goodsCategoryList;
	}

	@Override
	public Integer deleteGoodsCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		List<GoodsCategoryEntity> subList = this.getGoodsCategoryListByParentId(categoryId);
		if(!subList.isEmpty()) {
			return ErrorMsg.SYSTEM_DELETE_FAIL.getCode();
		}else {
			baseMapper.deleteById(categoryId);
			this.deleteGoodsCategoryBlock(categoryId);
		}
		return 0;
	}

}
