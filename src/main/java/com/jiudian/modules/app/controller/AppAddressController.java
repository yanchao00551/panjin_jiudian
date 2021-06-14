package com.jiudian.modules.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.common.utils.R;
import com.jiudian.modules.address.entity.CityEntity;
import com.jiudian.modules.address.entity.DistrictEntity;
import com.jiudian.modules.address.entity.ProvinceEntity;
import com.jiudian.modules.address.service.AddressService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 省市区控制器
 * @author KF-180419
 *
 */

@RestController
@RequestMapping("/app")
@Api("省市区控制器")
public class AppAddressController {
	@Autowired
	private AddressService addressService;
	 

    @GetMapping("getAddress")
    @ApiOperation("获取地址 返回（例如： 山西省 太原市 小店区）")
    public R getAddress(@RequestParam Map<String, String> params){
    	Integer provenceId = Integer.parseInt(params.get("provenceId"));
    	Integer cityId = Integer.parseInt(params.get("cityId"));
    	Integer districtId = Integer.parseInt(params.get("districtId"));
    	String info = addressService.getAddress(provenceId, cityId, districtId);
    	if(StringUtils.isEmpty(info)) {
    		return R.error("地址信息有异常！");
    	}
    	return R.ok().put("info", info);
    }

    @GetMapping("getProvinceList")
    @ApiOperation("获取省列表")
    public R getProvinceList() {
    	List<ProvinceEntity> list = addressService.getProvinceList(0);
    	return R.ok().put("provinceList", list);
    }
    
    @GetMapping("getCityList")
    @ApiOperation("获取城市列表")
    public R getCityList(@RequestParam Map<String, String> params) {
    	String provinceId = params.get("provinceId");
    	List<CityEntity> list = addressService.getCityList(Integer.parseInt(provinceId));
    	return R.ok().put("cityList", list);
    }
    
    @GetMapping("getDistrictList")
    @ApiOperation("获取区域列表")
    public R getDistrictList(@RequestParam Map<String, String> params) {
    	String cityId = params.get("cityId");
    	List<DistrictEntity> list = addressService.getDistrictList(Integer.parseInt(cityId)); 
    	return R.ok().put("districtList", list);
    }
    
    @GetMapping("getAllAddress")
    @ApiOperation("获取所有地址 省/市/区 列表")
    public R getAllAddress(@RequestParam Map<String, Integer> params){
    	List<ProvinceEntity> plist = addressService.getProvinceList(0);
    	List<CityEntity> clist = addressService.getCityList(0);
    	List<DistrictEntity> dlist = addressService.getDistrictList(0); 
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("provinceList", plist);
    	map.put("cityList", clist);
    	map.put("districtList", dlist);
    	return R.ok(map);
    }
    
    

}
