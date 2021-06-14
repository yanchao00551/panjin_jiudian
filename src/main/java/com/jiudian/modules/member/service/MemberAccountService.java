package com.jiudian.modules.member.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.member.entity.MemberAccountEntity;
import com.jiudian.modules.member.form.MemberAccountRecordsTypeNameList;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 会员账户统计表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
public interface MemberAccountService extends IService<MemberAccountEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    /**
     * 获取会员记录购买金额类型
     * @return
     */
    List<MemberAccountRecordsTypeNameList> getMemberAccountRecordsTypeNameList();
    
    /**
     * 获取会员记录产生方式类型名称
     * @return
     */
    List<MemberAccountRecordsTypeNameList> getMemberAccountRecordsNameList();
    
    /**
     * 获取会员账户产生方式名称
     * @param fromType
     * @return
     */
    String getMemberAccountRecordsName(Integer fromType);
    
    /**
     * 获取会员账户记录类型名称
     * @param accountType
     * @return
     */
    String getMemberAccountRecordsTypeName(Integer accountType);
    
    /**
     * 获取会员积分
     * @param uid
     * @return
     */
    Integer getMemberPoint(long uid);
    
    /**
     * 获取用户购物币
     * @param uid
     * @return
     */
    BigDecimal getMemberCoin(long uid);
    
    /**
     * 获取用户余额数
     * @param uid
     * @return
     */
    BigDecimal getMemberBalance(long uid);
    
    /**
     * 添加会员消费
     * @param shopid
     * @param uid
     * @param consum
     */
    void addMmemberConsum(Integer shopid,Integer uid,BigDecimal consum);
    
    /**
     * 添加账户流水
     * @param shopid
     * @param accountType
     * @param uid
     * @param sign
     * @param number
     * @param fromType
     * @param dateId
     * @param text
     * @return
     */
    Integer addMemberAccountData(Integer shopid,Integer accountType,Integer uid,Integer sign,BigDecimal number,Integer fromType,Integer dataId,String text);
    
    public Integer addMemberAccountData(Integer shopid,Integer accountType,Integer uid,Integer sign,
    		BigDecimal number,Integer fromType,Integer dataId,String text,List<String> rollbackInfo);
}

