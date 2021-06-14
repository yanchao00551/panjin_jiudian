package com.jiudian.modules.address.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jiudian.modules.address.entity.CityEntity;
import com.jiudian.modules.address.entity.DistrictEntity;
import com.jiudian.modules.address.entity.ProvinceEntity;
import com.jiudian.modules.address.service.AddressService;
import com.jiudian.modules.address.service.CityService;
import com.jiudian.modules.address.service.DistrictService;
import com.jiudian.modules.address.service.ProvinceService;

@Service("addressService")
public class AddressServceImpl implements AddressService {
	@Autowired
	ProvinceService provinceService;
	@Autowired
	DistrictService districtService;
	@Autowired
	CityService cityService;

	@Override
	public String getAddress(Integer provenceId, Integer cityId, Integer districtId) {
		// TODO Auto-generated method stub
		CityEntity city = new CityEntity();
		DistrictEntity district = new DistrictEntity();
		ProvinceEntity province = new ProvinceEntity();

		province = provinceService.selectOne(new EntityWrapper<ProvinceEntity>().eq("province_id", provenceId));
		city = cityService.selectOne(new EntityWrapper<CityEntity>().eq("city_id", cityId));
		district = districtService.selectOne(new EntityWrapper<DistrictEntity>().eq("district_id", districtId));
		if(province == null || city == null || district == null) {
			return null;
		}
		String address = province.getProvinceName() + "|" + city.getCityName() + "|" + district.getDistrictName();
		return address;
	}

	@Override
	public List<ProvinceEntity> getProvinceList(int areaId) {
		// TODO Auto-generated method stub
		List<ProvinceEntity> list = new ArrayList<ProvinceEntity>();
		if (areaId == -1) {
			list = null;
		} else if (areaId == 0) {
			list = provinceService.selectList(new EntityWrapper<ProvinceEntity>());
		} else {
			list = provinceService
					.selectList(new EntityWrapper<ProvinceEntity>().eq("area_id", areaId).orderBy("sort asc"));
		}
		return list;
	}

	@Override
	public List<CityEntity> getCityList(Integer provinceId) {
		// TODO Auto-generated method stub
		List<CityEntity> list = new ArrayList<CityEntity>();
		if (provinceId == 0) {
			list = cityService.selectList(new EntityWrapper<CityEntity>());
		} else {
			list = cityService.selectList(new EntityWrapper<CityEntity>().eq("province_id", provinceId).orderBy("sort asc"));
		}
		return list;
	}

	@Override
	public List<DistrictEntity> getDistrictList(int cityId) {
		// TODO Auto-generated method stub
		List<DistrictEntity> list = new ArrayList<DistrictEntity>();
		if (cityId == 0) {
			list = districtService.selectList(new EntityWrapper<DistrictEntity>());
		} else {
			list = districtService.selectList(new EntityWrapper<DistrictEntity>().eq("city_id", cityId).orderBy("sort asc"));
		}
		return list;
	}

}
