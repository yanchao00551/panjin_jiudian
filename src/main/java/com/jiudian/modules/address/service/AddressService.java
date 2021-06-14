package com.jiudian.modules.address.service;


import com.jiudian.modules.address.entity.CityEntity;
import com.jiudian.modules.address.entity.DistrictEntity;
import com.jiudian.modules.address.entity.ProvinceEntity;

import java.util.List;

/**
 * 
 *  区域地址
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-02 11:00:07
 */
public interface AddressService  {
	/**
	 * 获取地址 返回（例如： 山西省 太原市 小店区）
	 * @param provenceId
	 * @param cityId
	 * @param districtId
	 * @return
	 */
	String getAddress(Integer provenceId,Integer cityId,Integer districtId);

	/**
	 * 获取省列表
	 * @param areaId
	 * @return
	 */
	List<ProvinceEntity> getProvinceList(int areaId);

	/**
	 * 获取城市列表
	 * @param provinceId
	 * @return
	 */
	List<CityEntity> getCityList(Integer provinceId);

	/**
	 * 获取区域列表
	 * @param i
	 * @return
	 */
	List<DistrictEntity> getDistrictList(int cityId);

	
	
}

