package com.jiudian.modules.member.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.member.entity.MemberEntity;
import com.jiudian.modules.member.entity.MemberExpressAddressEntity;
/**
 * 前台用户表
 *
 * @author yanchao
 * @param <T>
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    /**
     * 分页获取所有会员记录
     * @param params
     * @return
     */
    PageUtils queryByUserList(Map<String,Object> params);
    
    /**
     * 分页获取会员等级列表
     * @param params
     * @return
     */
    PageUtils getMemberLevelList(Map<String,Object> params);
    
    /**
     * 判断用户是否存在
     * @param username
     * @return
     */
    Boolean judgeUserNameIsExistence(String username);
    
    /**
     * 修改用户支付密码
     * @param uid
     * @param oldPaymentPassword
     * @param newPaymentPassword
     * @return
     */
    Boolean updateUserPaymentPassword(Integer uid,String oldPaymentPassword,String newPaymentPassword);
    
    /**
     * 设置用户支付密码
     * @param uid
     * @param paymentPassword
     * @return
     */
    Boolean setUserPaymentPassword(Integer uid,String paymentPassword,String salt);
    
    /**
     * 获取用户余额
     * @param uid
     * @param shopId
     * @return
     */
    Map<String,Object> getMemberAccount(Integer uid,Integer shopId);
    
    /**
     * 修改会员默认收货地址
     * @param id
     * @return
     */
    Boolean updateAddressDefault(Integer id,Integer uid);
    
    /**
     * 删除会员收货地址
     * @param id
     * @return
     */
    Integer memberAddressDelete(Integer id,Integer uid);
    
    /**
     * 获取会员收货地址详情
     * @param id
     * @return
     */
    MemberExpressAddressEntity getMemberExpressAddressDetail(Integer id,Integer uid);
    
    /**
     * 获取会员地址分页列表
     * @param params
     * @return
     */
    PageUtils getMemberExpressAddressList(Map<String,Object> params);
    
    /**
     * 修改会员收货地址
     * @param id
     * @param consigner
     * @param mobile
     * @param phone
     * @param province
     * @param city
     * @param district
     * @param address
     * @param zipCode
     * @param alias
     * @return
     */
    Boolean updateMemberExpressAddress(Integer id,Integer uid,String consigner,String mobile,String phone,Integer province,
    		Integer city,Integer district,String address,String zipCode,String alias,int isDefault,int recvTimeRange);

    /**
     * 获取会员默认收货地址
     * @param uid
     * @return
     */
    MemberExpressAddressEntity getDefaultExpressAddress(Integer uid);
    
    /**
     * 新增会员收货地址
     * @param consigner
     * @param mobile
     * @param phone
     * @param province
     * @param city
     * @param district
     * @param address
     * @param zipCode
     * @param alias
     * @return
     */
    Boolean addMemberExpressAddress(Integer uid,String consigner,String mobile,String phone,Integer province,Integer city,
    		Integer district,String address,String zipCode,String alias,int isDefault,int recvTimeRange);

    /**
     * 修改会员个人资料
     * @param username
     * @param userQq
     * @param realName
     * @param sex
     * @param birthday
     * @param location
     * @param userHeadimg
     * @return
     */
    Boolean updateMemberInformation(Integer uid,String username,String userQq,String realName,Integer sex,Integer birthday,String location,String userHeadimg);

    /**
     * 分页获取会员账户流水明细
     * @param params
     * @return
     */
    PageUtils getAccountList(Map<String,Object> params); 
    
    
    /**
     * 会员提现列表
     * @param params
     * @return
     */
    PageUtils getMemberBalanceWithdraw(Map<String,Object> params);
    
    
    /**
     * 删除会员
     * @param uid
     * @return
     */
    Boolean deleteMember(Integer uid);
    
    /**
     * 更新会员昵称
     * @param uid
     * @return
     */
    Boolean updateNickNameByUid(Integer uid,String nickName);
    
    /**
     * 会员积分调整
     * @param shopId
     * @param type
     * @param uid
     * @param number
     * @param text
     * @return
     */
    Integer addMemberAccount(Integer shopId,Integer type,Integer uid,BigDecimal number,String text);

    /**
     * 锁定用户
     * @param uid
     * @return
     */
    Boolean userLock(Integer uid);
    /**
     * 解锁用户
     * @param uid
     * @return
     */
    Boolean userUnlock(Integer uid);
    
    /**
     * 根据用户id修改用户登录密码
     * @param uid
     * @param password
     * @return
     */
    Boolean updateUserInfoByUserid(Integer uid,String password);

    
    /**
     * 更新会员等级
     * @param levelName
     * @return
     */
	Boolean updateUserLevel(Integer uid,Integer levelName);

	/**
	 * 根据ID修改会员资料
	 * @param id
	 * @param username
	 * @param email
	 * @param sex
	 * @param status
	 * @param mobile
	 * @param nickname
	 * @return
	 */
	Integer updateMemberByAdmin(Integer id, String username, String email, Integer sex, Integer status, String mobile,
			String nickname);

	/**
	 * 单个会员详情记录
	 * @param map
	 * @return
	 */
	MemberEntity queryByUserDetail(Map<String, Object> map);

	/**
	 * 发放订单的三级分销佣金
	 * @param orderId
	 */
	void updateCommissionDistributionIssue(Integer orderId);

	/**
	 * 查询我的团队 （三级）列表
	 * @param params
	 * @return
	 */
	public Map<Integer,List<MemberEntity>> queryTeamList(int userId);

	/**
	 * 获取我的团队人数
	 * @param userId
	 * @param username 
	 * @return
	 */
	Map<String, Object> queryTeamNumAmong(Integer userId, String username);

	/**
	 * 会员体现申请
	 * @param userId
	 * @param cash
	 * @param branchBankName
	 * @param realname
	 * @param accountNumber
	 * @param mobile
	 * @return
	 */
	Integer memberEmbody(Integer userId, BigDecimal cash, String branchBankName, String realname, String accountNumber,
			String mobile);


	public PageUtils queryPartnerList(Map<String, String> params);
    
}

