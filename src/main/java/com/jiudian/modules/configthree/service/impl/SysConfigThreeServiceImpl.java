package com.jiudian.modules.configthree.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;
import com.jiudian.modules.configthree.dao.SysConfigThreeDao;
import com.jiudian.modules.configthree.entity.SysConfigThreeEntity;
import com.jiudian.modules.configthree.service.SysConfigThreeService;

import net.sf.json.JSONArray;




@Service("sysConfigThreeService")
public class SysConfigThreeServiceImpl extends ServiceImpl<SysConfigThreeDao, SysConfigThreeEntity> implements SysConfigThreeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysConfigThreeEntity> page = this.selectPage(
                new Query<SysConfigThreeEntity>(params).getPage(),
                new EntityWrapper<SysConfigThreeEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
    public SysConfigThreeEntity queryByKeyInfo(String key) {
    	if(StringUtils.isNotBlank(key)) {
    		return baseMapper.queryByKeyInfo(key);
    	}
    	return null;
    }

	/* (non-Javadoc)
	 * @see com.jiudian.modules.configthree.service.SysConfigThreeService#setBalanceWithdrawConfig(java.lang.Integer, java.lang.String, java.util.List, java.lang.Integer)
	 */
	@Override
	public boolean setBalanceWithdrawConfig(Integer shopId, String key, List<Map<String, Object>> withdrawAccountMap,
			Integer isUse) {
		// TODO Auto-generated method stub
		SysConfigThreeEntity config = new SysConfigThreeEntity();
		config.setInstanceId(shopId);
		config.setKey(key);
		String jsonStr = JSONArray.fromObject(withdrawAccountMap).toString();
		config.setValue(jsonStr);
		config.setDesc("会员余额提现设置");
		config.setIsUse(isUse);
		List<SysConfigThreeEntity> list = new ArrayList<SysConfigThreeEntity>();
		list.add(config);
		boolean res = this.setConfig(list);
		return res;
	}

	/**
	 * 设置第三方配置或更新
	 * @param list
	 * @return
	 */
	public boolean setConfig(List<SysConfigThreeEntity> list) {
		// TODO Auto-generated method stub
		Boolean res = false;
		for(int i=0;i<list.size();i++) {
			if(this.checkConfigKeyIsset(list.get(i).getInstanceId(),list.get(i).getKey())) {
				list.get(i).setModifyTime((int) (System.currentTimeMillis() / 1000));
				Integer rst = baseMapper.update(list.get(i), new EntityWrapper<SysConfigThreeEntity>().eq("instance_id", list.get(i).getInstanceId()).eq("`key`", list.get(i).getKey()));
				if(rst > 0) {
					res = true;
				}
			}else {
				list.get(i).setCreateTime((int) (System.currentTimeMillis() / 1000));
				Integer rst = baseMapper.insert(list.get(i));
				if(rst > 0) {
					res = true;
				}
			}
		}
		return res;
	}

	/**
	 * 判断当前设置是否存在
     * 存在返回 true 不存在返回 false
	 * @param instanceId
	 * @param key
	 * @return
	 */
	public boolean checkConfigKeyIsset(Integer instanceId, String key) {
		// TODO Auto-generated method stub
		int num = baseMapper.selectCount(new EntityWrapper<SysConfigThreeEntity>().eq("instance_id", instanceId).eq("`key`", key));
		return num > 0 ? true : false;
	}
	
	
    


}
