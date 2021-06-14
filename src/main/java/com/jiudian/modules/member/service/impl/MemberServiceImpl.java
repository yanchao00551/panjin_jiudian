package com.jiudian.modules.member.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.exception.RRException;
import com.jiudian.common.utils.ErrorMsg;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;
import com.jiudian.modules.address.service.AddressService;
import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.album.service.AlbumPictureService;
import com.jiudian.modules.app.calculate.RewardCalcuUtil;
import com.jiudian.modules.app.entity.UserEntity;
import com.jiudian.modules.app.service.UserService;
import com.jiudian.modules.member.dao.MemberDao;
import com.jiudian.modules.member.entity.MemberAccountEntity;
import com.jiudian.modules.member.entity.MemberAccountRecordsEntity;
import com.jiudian.modules.member.entity.MemberBalanceWithdrawEntity;
import com.jiudian.modules.member.entity.MemberBankAccountEntity;
import com.jiudian.modules.member.entity.MemberEntity;
import com.jiudian.modules.member.entity.MemberExpressAddressEntity;
import com.jiudian.modules.member.service.MemberAccountRecordsService;
import com.jiudian.modules.member.service.MemberAccountService;
import com.jiudian.modules.member.service.MemberBalanceWithdrawService;
import com.jiudian.modules.member.service.MemberBankAccountService;
import com.jiudian.modules.member.service.MemberExpressAddressService;
import com.jiudian.modules.member.service.MemberLevelService;
import com.jiudian.modules.member.service.MemberService;
import com.jiudian.modules.order.entity.OrderEntity;
import com.jiudian.modules.order.service.OrderService;
import com.jiudian.modules.rewardRecord.entity.RewardRecordEntity;
import com.jiudian.modules.rewardRecord.service.RewardRecordService;

@Service("memberService")
public class MemberServiceImpl extends ServiceImpl<MemberDao, MemberEntity> implements MemberService {

	@Autowired
	UserService userService;

	@Autowired
	MemberAccountService memberAccountService;

	@Autowired
	MemberExpressAddressService memberExpressAddressService;

	@Autowired
	AddressService addressService;

	@Autowired
	MemberAccountRecordsService memberAccountRecordsService;

	@Autowired
	MemberService memberService;

	@Autowired
	OrderService orderService;

	@Autowired
	MemberLevelService memberLeverServcie;

	@Autowired
	MemberBalanceWithdrawService memberBalanceWithdrawService;

	@Autowired
	private RewardCalcuUtil rewardCalcuUtil;

	@Autowired
	private RewardRecordService rewardRecordService;

	@Autowired
	private AlbumPictureService albumPictureService;
	
	@Autowired
	private MemberBankAccountService memberBankAccountService;

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<MemberEntity> page = this.selectPage(new Query<MemberEntity>(params).getPage(),
				new EntityWrapper<MemberEntity>());
		return new PageUtils(page);
	}

	@Override
	public PageUtils queryByUserList(Map<String, Object> params) {
		int limit = Integer.parseInt((String) params.get("limit"));
		int current = (Integer.parseInt((String) params.get("page")));
		Page<MemberEntity> page = new Page<MemberEntity>(current, limit);
		params.put("page", current);
		params.put("limit", limit);
		List<MemberEntity> pageList = baseMapper.queryByUserList(page, params);
		pageList.forEach(me -> {
			AlbumPictureEntity albumPictureEntity = albumPictureService.selectOne
					(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", me.getUserHeadimg()));
			me.setUserHeadImgDetail(albumPictureEntity);
		});
		page.setRecords(pageList);
		return new PageUtils(page);
	}

	@Override
	public Boolean judgeUserNameIsExistence(String username) {
		// TODO Auto-generated method stub
		int count = userService.selectCount(new EntityWrapper<UserEntity>().eq("username", username));
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean updateUserPaymentPassword(Integer uid, String oldPaymentPassword, String newPaymentPassword) {
		// TODO Auto-generated method stub
		UserEntity user = userService.selectOne(new EntityWrapper<UserEntity>().eq("user_id", uid));
		// 检测原密码是否正确
		if (!user.getPaymentPassword().equals(DigestUtils.sha256Hex(oldPaymentPassword))) {
			throw new RRException("原密码错误");
		}
		if (uid != null) {
			user.setPaymentPassword(DigestUtils.sha256Hex(newPaymentPassword));
			return userService.update(user, new EntityWrapper<UserEntity>().eq("user_id", uid));
		} else {
			return false;
		}

	}

	@Override
	public Boolean setUserPaymentPassword(Integer uid, String paymentPassword,String salt) {
		// TODO Auto-generated method stub
		UserEntity user = userService.selectOne(new EntityWrapper<UserEntity>().eq("user_id", uid));

		user.setIsSetPaymentPassword(1);
		user.setPaymentPassword(DigestUtils.md5Hex(paymentPassword + salt));
		user.setPaySalt(salt);
		return userService.update(user, new EntityWrapper<UserEntity>().eq("user_id", uid));

	}

	@Override
	public Map<String, Object> getMemberAccount(Integer uid, Integer shopId) {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberAccountEntity accountMember = new MemberAccountEntity();
		accountMember = memberAccountService
				.selectOne(new EntityWrapper<MemberAccountEntity>().eq("uid", uid).eq("shopId", shopId));
		if (accountMember == null) {
			map.put("point", 0);
		}
		map.put("balance", memberAccountService.getMemberBalance(uid));
		map.put("coin", memberAccountService.getMemberCoin(uid));
		return map;
	}

	@Override
	public Boolean updateAddressDefault(Integer id, Integer uid) {
		// TODO Auto-generated method stub
		MemberExpressAddressEntity expressAddress = new MemberExpressAddressEntity();
		expressAddress.setIsDefault(0);
		memberExpressAddressService.update(expressAddress,
				new EntityWrapper<MemberExpressAddressEntity>().eq("uid", uid));
		expressAddress.setIsDefault(1);
		return memberExpressAddressService.update(expressAddress,
				new EntityWrapper<MemberExpressAddressEntity>().eq("id", id));
	}

	@Override
	public Integer memberAddressDelete(Integer id, Integer uid) {
		// TODO Auto-generated method stub
		MemberExpressAddressEntity expressAddress = new MemberExpressAddressEntity();
		Integer count = memberExpressAddressService
				.selectCount(new EntityWrapper<MemberExpressAddressEntity>().eq("uid", uid));
		if (count == 1) {
			return -2007; // 默认地址不能删除
		} else {
			expressAddress = memberExpressAddressService
					.selectOne(new EntityWrapper<MemberExpressAddressEntity>().eq("uid", uid).eq("id", id));
			memberExpressAddressService.deleteById(id);
			if (expressAddress.getIsDefault() == 1) {
				MemberExpressAddressEntity expressAddressInfo = new MemberExpressAddressEntity();
				expressAddressInfo = memberExpressAddressService
						.selectOne(new EntityWrapper<MemberExpressAddressEntity>().eq("uid", uid).orderBy("id desc"));
				this.updateAddressDefault(expressAddressInfo.getId(), uid);
			}
		}
		return 0;
	}

	@Override
	public MemberExpressAddressEntity getMemberExpressAddressDetail(Integer id, Integer uid) {
		// TODO Auto-generated method stub
		MemberExpressAddressEntity expressAddressInfo = new MemberExpressAddressEntity();
		expressAddressInfo = memberExpressAddressService.selectById(id);
		if (expressAddressInfo != null) {
			String addressInfo = addressService.getAddress(expressAddressInfo.getProvince(),
					expressAddressInfo.getCity(), expressAddressInfo.getDistrict());
			if (StringUtils.isEmpty(addressInfo)) {
				return null;
			}
			expressAddressInfo.setAddressInfo(addressInfo);
		}
		if (expressAddressInfo.getUid() == uid) {
			return expressAddressInfo;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageUtils getMemberExpressAddressList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		PageUtils page = memberExpressAddressService.queryPage(params);
		// 处理地址信息
		if (!page.getList().isEmpty()) {
			List<MemberExpressAddressEntity> list = new ArrayList<MemberExpressAddressEntity>();
			list = (List<MemberExpressAddressEntity>) page.getList();
			for (int i = 0; i < list.size(); i++) {
				String addressInfo = addressService.getAddress(list.get(i).getProvince(), list.get(i).getCity(),
						list.get(i).getDistrict());
				list.get(i).setAddressInfo(addressInfo);
			}
			page.setList(list);
		}
		return page;
	}

	@Override
	public Boolean updateMemberExpressAddress(Integer id, Integer uid, String consigner, String mobile, String phone,
			Integer province, Integer city, Integer district, String address, String zipCode, String alias,
			int isDefault, int recvTimeRange) {
		// TODO Auto-generated method stub
		MemberExpressAddressEntity expressAddressInfo = new MemberExpressAddressEntity();
		expressAddressInfo.setUid(uid);
		expressAddressInfo.setConsigner(consigner);
		expressAddressInfo.setMobile(mobile);
		expressAddressInfo.setPhone(phone);
		expressAddressInfo.setProvince(province);
		expressAddressInfo.setCity(city);
		expressAddressInfo.setDistrict(district);
		expressAddressInfo.setAddress(address);
		expressAddressInfo.setZipCode(zipCode);
		expressAddressInfo.setAlias(alias);
		expressAddressInfo.setId(id);
		expressAddressInfo.setIsDefault(isDefault);
		expressAddressInfo.setRecvTimeRange(recvTimeRange);
//		this.updateAddressDefault(id, uid);
		return memberExpressAddressService.updateById(expressAddressInfo);
	}

	@Override
	public MemberExpressAddressEntity getDefaultExpressAddress(Integer uid) {
		MemberExpressAddressEntity expressAddressInfo = new MemberExpressAddressEntity();
		expressAddressInfo = memberExpressAddressService
				.selectOne(new EntityWrapper<MemberExpressAddressEntity>().eq("uid", uid).eq("is_default", 1));
		if (expressAddressInfo != null) {
			String addressInfo = addressService.getAddress(expressAddressInfo.getProvince(),
					expressAddressInfo.getCity(), expressAddressInfo.getDistrict());
			if (StringUtils.isEmpty(addressInfo)) {
				return null;
			}
			expressAddressInfo.setAddressInfo(addressInfo);
		}
		return expressAddressInfo;
	}

	@Override
	public Boolean addMemberExpressAddress(Integer uid, String consigner, String mobile, String phone, Integer province,
			Integer city, Integer district, String address, String zipCode, String alias, int isDefault,
			int recvTimeRange) {
		MemberExpressAddressEntity expressAddressInfo = new MemberExpressAddressEntity();
//		memberExpressAddressService.update(expressAddressInfo, new EntityWrapper<MemberExpressAddressEntity>().eq("uid", uid));
		expressAddressInfo.setConsigner(consigner);
		expressAddressInfo.setMobile(mobile);
		expressAddressInfo.setPhone(phone);
		expressAddressInfo.setProvince(province);
		expressAddressInfo.setCity(city);
		expressAddressInfo.setDistrict(district);
		expressAddressInfo.setAddress(address);
		expressAddressInfo.setZipCode(zipCode);
		expressAddressInfo.setAlias(alias);
		expressAddressInfo.setUid(uid);
		expressAddressInfo.setIsDefault(isDefault);
		expressAddressInfo.setRecvTimeRange(recvTimeRange);
		return memberExpressAddressService.insert(expressAddressInfo);
	}

	@Override
	public Boolean updateMemberInformation(Integer uid, String username, String userQq, String realName, Integer sex,
			Integer birthday, String location, String userHeadimg) {
		// TODO Auto-generated method stub
		UserEntity user = new UserEntity();
		user.setNickName(username);
		user.setUserQq(userQq);
		user.setRealName(realName);
		user.setSex(sex);
		user.setBirthday(birthday);
		user.setLocation(location);
		if (userHeadimg != null) {
			user.setUserHeadimg(userHeadimg);
		}
		return userService.update(user, new EntityWrapper<UserEntity>().eq("uid", uid));
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageUtils getAccountList(Map<String, Object> params) {
		PageUtils page = memberAccountRecordsService.queryDetailByUserList(params);
		if (!page.getList().isEmpty()) {
			List<MemberAccountRecordsEntity> list = new ArrayList<MemberAccountRecordsEntity>();
			for (int i = 0; i < page.getList().size(); i++) {
				list = (List<MemberAccountRecordsEntity>) page.getList();
				list.get(i)
						.setFromTypeName(memberAccountService.getMemberAccountRecordsName(list.get(i).getFromType()));
				list.get(i).setAccountTypeName(
						memberAccountService.getMemberAccountRecordsTypeName(list.get(i).getAccountType()));
				if (list.get(i).getAccountType() == 2
						&& (list.get(i).getFromType() == 1 || list.get(i).getFromType() == 2)) {
					OrderEntity orderInfo = orderService
							.selectOne(new EntityWrapper<OrderEntity>().eq("order_id", list.get(i).getDataId()));
					list.get(i).setDataContent(orderInfo);
				}
				//获取佣金产生者信息
				if(list.get(i).getFromUid() != null && list.get(i).getFromUid() > 0) {
					MemberEntity memberEntity = memberService.selectOne
							(new EntityWrapper<MemberEntity>().eq("uid", list.get(i).getFromUid()));
					UserEntity userEntity = userService.selectOne
							(new EntityWrapper<UserEntity>().eq("user_id", list.get(i).getFromUid()));
					memberEntity.setNickName(userEntity.getNickName());
					if(userEntity != null && userEntity.getUserHeadimg() != null) {
						AlbumPictureEntity albumPictureEntity = albumPictureService.selectOne
								(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", userEntity.getUserHeadimg()));
						memberEntity.setUserHeadImgDetail(albumPictureEntity);
					}
					list.get(i).setFromer(memberEntity);
				}
			}
			page.setList(list);
		}
		return page;
	}

	@Override
	public Boolean deleteMember(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateNickNameByUid(Integer uid, String nickName) {
		// TODO Auto-generated method stub
		if (uid == null) {
			return false;
		}
		UserEntity objUser = new UserEntity();
		EntityWrapper<UserEntity> ew = new EntityWrapper<UserEntity>();
		objUser.setNickName(nickName);
		objUser.setCurrentLoginTime(new Date());
		ew.eq("uid", uid);
		return userService.update(objUser, ew);
	}

	@Override
	public Integer addMemberAccount(Integer shopId, Integer type, Integer uid, BigDecimal number, String text) {
		// TODO Auto-generated method stub
		return memberAccountService.addMemberAccountData(shopId, type, uid, 1, number, 10, 0, text);
	}

	@Override
	public Boolean userLock(Integer uid) {
		// TODO Auto-generated method stub
		UserEntity user = new UserEntity();
		user.setUserStatus(0);
		return userService.update(user, new EntityWrapper<UserEntity>().eq("user_id", uid));
	}

	@Override
	public Boolean userUnlock(Integer uid) {
		// TODO Auto-generated method stub
		UserEntity user = new UserEntity();
		user.setUserStatus(1);
		return userService.update(user, new EntityWrapper<UserEntity>().eq("user_id", uid));
	}

	@Override
	public Boolean updateUserInfoByUserid(Integer uid, String password) {
		// TODO Auto-generated method stub
		UserEntity user = new UserEntity();
		user.setPassword(DigestUtils.sha256Hex(password));
		return userService.update(user, new EntityWrapper<UserEntity>().eq("user_id", uid));
	}

	@Override
	public Boolean updateUserLevel(Integer uid, Integer levelName) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("uid", uid);
		params.put("levelName", levelName);
		return baseMapper.updateByUserLevel(params);
	}

	@Override
	public Integer updateMemberByAdmin(Integer id, String username, String email, Integer sex, Integer status,
			String mobile, String nickname) {
		// TODO Auto-generated method stub
		UserEntity user = new UserEntity();
		user = userService.selectOne(new EntityWrapper<UserEntity>().eq("user_id", id));
		if (username != null) {
			if (!user.getUsername().equals(username)) {
				int count = userService.selectCount(new EntityWrapper<UserEntity>().eq("username", username));
				if (count > 0) {
					return ErrorMsg.USER_REPEAT.getCode();
				}
			}
		}
		if (mobile != null) {
			if (!user.getUserTel().equals(mobile) || !user.getMobile().equals(mobile)) {
				int count = userService.selectCount(new EntityWrapper<UserEntity>().eq("mobile", mobile));
				if (count > 0) {
					return ErrorMsg.USER_MOBILE_REPEAT.getCode();
				}
			}
		}
		if (email != null) {
			if (!user.getUserEmail().equals(email)) {
				int count = userService.selectCount(new EntityWrapper<UserEntity>().eq("user_email", email));
				if (count > 0) {
					return ErrorMsg.USER_EMAIL_REPEAT.getCode();
				}
			}
		}
		if (nickname == null) {
			nickname = username;
		}
		user.setUsername(username);
		user.setUserTel(mobile);
		user.setMobile(mobile);
		user.setUserEmail(email);
		user.setSex(sex);
		user.setUserStatus(status);
		user.setNickName(nickname);
		Boolean rst = userService.update(user, new EntityWrapper<UserEntity>().eq("user_id", id));
		if (rst) {
			return 0;
		}
		return ErrorMsg.UPDATA_FAIL.getCode();
	}

	@Override
	public PageUtils getMemberLevelList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return memberLeverServcie.queryPage(params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageUtils getMemberBalanceWithdraw(Map<String, Object> params) {
		// TODO Auto-generated method stub
		PageUtils page = memberBalanceWithdrawService.getMemberBalanceWithdraw(params);
		List<MemberBalanceWithdrawEntity> list = (List<MemberBalanceWithdrawEntity>) page.getList();
		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				MemberBankAccountEntity memberBankAccountEntity = memberBankAccountService.selectOne
						(new EntityWrapper<MemberBankAccountEntity>().eq("uid", list.get(i).getUid()));
				list.get(i).setAccountType(memberBankAccountEntity.getAccountType());
				UserEntity user = new UserEntity();
				user = userService.selectOne(new EntityWrapper<UserEntity>().eq("user_id", list.get(i).getUid()));
				list.get(i).setRealname(user.getNickName());
			}
			page.setList(list);
		}
		return page;
	}

	@Override
	public MemberEntity queryByUserDetail(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return baseMapper.queryByUserDetail(map);
	}

	@Override
	public void updateCommissionDistributionIssue(Integer orderId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<Integer, List<MemberEntity>> queryTeamList(int userId) {
		MemberEntity selfEntity = memberService.selectOne(new EntityWrapper<MemberEntity>().eq("uid", userId));
		selfEntity.setSelf(true);
		List<MemberEntity> selfEntities = new ArrayList<MemberEntity>();
		selfEntities.add(selfEntity);
		Map<Integer, List<MemberEntity>> teamMap = new HashMap<Integer, List<MemberEntity>>();
		int level = rewardCalcuUtil.getCurrentLevel(userId, String.valueOf(selfEntity.getPid()));
		switch (level) {
		case 1:
//			teamMap.put(1, selfEntities);
			List<MemberEntity> child1Entities = memberService
					.selectList(new EntityWrapper<MemberEntity>().eq("pid", selfEntity.getUid()));
			teamMap.put(2, child1Entities);
			List<MemberEntity> child1EntitiesAll = new ArrayList<MemberEntity>();
			if (child1Entities != null && child1Entities.size() > 0) {
				child1Entities.forEach(cEntity -> {
					Map<String, String> params = new HashMap<String, String>();
					params.put("toUid", String.valueOf(selfEntity.getUid()));
					params.put("fromUid", String.valueOf(cEntity.getUid()));
					RewardRecordEntity rewardRecordEntities = rewardRecordService.querySumGroupByFromUid(params);
					// 设置佣金
					cEntity.setRewardList(rewardRecordEntities);
					AlbumPictureEntity info = new AlbumPictureEntity();
					UserEntity userEntity = userService
							.selectOne(new EntityWrapper<UserEntity>().eq("user_id", cEntity.getUid()));
					info = albumPictureService.selectById(userEntity.getUserHeadimg());
					// 设置头像
					cEntity.setNickName(userEntity.getNickName());
					cEntity.setUserHeadImgDetail(info);
					cEntity.setMobile(userEntity.getMobile());
					List<MemberEntity> grandChild1Entities = memberService
							.selectList(new EntityWrapper<MemberEntity>().eq("pid", cEntity.getUid()));
					grandChild1Entities.forEach(gEntity -> {
						Map<String, String> gParams = new HashMap<String, String>();
						gParams.put("toUid", String.valueOf(selfEntity.getUid()));
						gParams.put("fromUid", String.valueOf(gEntity.getUid()));
						RewardRecordEntity gRewardRecordEntities = rewardRecordService
								.querySumGroupByFromUid(params);
						// 设置佣金
						gEntity.setRewardList(gRewardRecordEntities);
						AlbumPictureEntity gInfo = new AlbumPictureEntity();
						UserEntity gUserEntity = userService
								.selectOne(new EntityWrapper<UserEntity>().eq("user_id", gEntity.getUid()));
						gInfo = albumPictureService.selectById(gUserEntity.getUserHeadimg());
						// 设置头像
						gEntity.setNickName(gUserEntity.getNickName());
						gEntity.setMobile(gUserEntity.getMobile());
						gEntity.setUserHeadImgDetail(gInfo);
					});
					child1EntitiesAll.addAll(grandChild1Entities);
				});
			}
			teamMap.put(3, child1EntitiesAll);
			break;
		case 2:
			List<MemberEntity> parent2Entities = memberService
					.selectList(new EntityWrapper<MemberEntity>().eq("uid", selfEntity.getPid()));
			if (parent2Entities != null && parent2Entities.size() > 0) {
//				teamMap.put(1, parent2Entities);
			}
//			teamMap.put(2, selfEntities);
			List<MemberEntity> child2Entities = memberService
					.selectList(new EntityWrapper<MemberEntity>().eq("pid", selfEntity.getUid()));
			child2Entities.forEach(cEntity -> {
				Map<String, String> params = new HashMap<String, String>();
				params.put("toUid", String.valueOf(selfEntity.getUid()));
				params.put("fromUid", String.valueOf(cEntity.getUid()));
				RewardRecordEntity rewardRecordEntities = rewardRecordService.querySumGroupByFromUid(params);
				// 设置佣金
				cEntity.setRewardList(rewardRecordEntities);
				AlbumPictureEntity info = new AlbumPictureEntity();
				UserEntity userEntity = userService
						.selectOne(new EntityWrapper<UserEntity>().eq("user_id", cEntity.getUid()));
				info = albumPictureService.selectById(userEntity.getUserHeadimg());
				// 设置头像
				cEntity.setNickName(userEntity.getNickName());
				cEntity.setMobile(userEntity.getMobile());
				cEntity.setUserHeadImgDetail(info);
			});
			teamMap.put(3, child2Entities);
			break;
		case 3:
//			List<MemberEntity> parent3Entities = memberService
//					.selectList(new EntityWrapper<MemberEntity>().eq("uid", selfEntity.getPid()));
//			if (parent3Entities != null && parent3Entities.size() > 0) {
//				if (parent3Entities.get(0).getPid() > 0) {
//					List<MemberEntity> grandParent3Entities = memberService
//							.selectList(new EntityWrapper<MemberEntity>().eq("uid", parent3Entities.get(0).getPid()));
//					teamMap.put(1, grandParent3Entities);
//				}
//				teamMap.put(2, parent3Entities);
//			}
//			teamMap.put(3, selfEntities);
			break;
		case 4:
//			teamMap.put(4, selfEntities);
			break;
		default:
			return null;
		}
		return teamMap;
	}

	@Override
	public Map<String, Object> queryTeamNumAmong(Integer userId, String username) {
		Map<String, Object> rspMap = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("uid", userId);
		params.put("username", username);
		MemberEntity info = baseMapper.queryTeamNumAmong(params);
		rspMap.put("teamNumber", info.getTeamNumber());
		rspMap.put("amongMe", info.getAmong()); // 自己购买的订房业绩的排名

		/*
		 * List<MemberEntity> memberTeamList = baseMapper.queryAllTeamList(params);
		 * if(memberTeamList.size() == 1) { rspMap.put("among", 0); //如果没有下级 则团队总业绩排名为0
		 * }else { for(int i=0; i< memberTeamList.size(); i++) { Map<String,Object> map
		 * = new HashMap<String,Object>(); map.put("uid",
		 * memberTeamList.get(i).getUid()); map.put("username",
		 * memberTeamList.get(i).getMemberName()); MemberEntity objData =
		 * baseMapper.queryByUserCombine(map);
		 * 
		 * } }
		 */
		return rspMap;
	}

	@Override
	@Transactional
	public Integer memberEmbody(Integer userId, BigDecimal cash, String branchBankName, String realname,
			String accountNumber, String mobile) {
		// TODO Auto-generated method stub
		try {
			MemberBalanceWithdrawEntity objData = new MemberBalanceWithdrawEntity();
			objData.setShopId(0);
			objData.setUid(userId);
			objData.setBankName(branchBankName);
			objData.setAccountNumber(accountNumber);
			objData.setRealname(realname);
			objData.setMobile(mobile);
			objData.setCash(cash);
			objData.setStatus(0); // 已申请 等待处理
			objData.setAskForDate((int) (System.currentTimeMillis() / 1000));
			objData.setTransferType(1); // 线下转账
			objData.setTransferName(branchBankName);
			objData.setTransferMoney(cash);
			objData.setTransferStatus(new Integer(0)); // 未转账
			objData.setTransferAccountNo(accountNumber); // 转账银行账号
			objData.setWithdrawNo(getOrderIdByTime()); // 提现流水号
			Integer flowId = memberAccountService.addMemberAccountData(0, 2, userId, 1,
					cash.multiply(new BigDecimal(-1)), 8, 0, "申请提现扣除余额:" + cash + ",冻结:" + cash);
			if (flowId <= 0) {
				return flowId;
			}
			objData.setFlowId(flowId); // 提现申请记录 同时记录提现流水扣款ID 如果提现不成功 可以退还到余额
			boolean rst = memberBalanceWithdrawService.insert(objData);
			if (rst) {
				return 1;
			}
		} catch (RRException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new RRException("会员提现失败!");
		}
		return null;
	}

	/**
	 * 生成随机字符串
	 * 
	 * @return
	 */
	private static String getOrderIdByTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String newDate = sdf.format(new Date());
		String result = "";
		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			result += random.nextInt(10);
		}
		return newDate + result;
	}

	@Override
	public PageUtils queryPartnerList(Map<String, String> params) {
		int current = Integer.parseInt(params.get("page"));
		int limit = Integer.parseInt(params.get("limit"));
		Page<MemberEntity> page = new Page<MemberEntity>(current, limit);
		
		List<MemberEntity> pageList = baseMapper.queryPartnerList(page, params);
		page.setRecords(pageList);
		return new PageUtils(page);
	}

}
