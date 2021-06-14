package com.jiudian.modules.sms.dao;

import com.jiudian.modules.sms.entity.SysNoticeTemplateItemEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * 通知模板项
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-22 11:24:27
 */
@Mapper
public interface SysNoticeTemplateItemDao extends BaseMapper<SysNoticeTemplateItemEntity> {
	List<SysNoticeTemplateItemEntity> queryByTemplateCodeInfo(String templateCode);
}
