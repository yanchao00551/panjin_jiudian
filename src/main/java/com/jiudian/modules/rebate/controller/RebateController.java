package com.jiudian.modules.rebate.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;
import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.album.service.AlbumPictureService;
import com.jiudian.modules.rebate.entity.RebateEntity;
import com.jiudian.modules.rebate.entity.RebateListEntity;
import com.jiudian.modules.rebate.service.RebateService;



/**
 * 
 *
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-10-08 09:46:47
 */
@RestController
@RequestMapping("rebate/rebate")
public class RebateController {
	
	private final static String[] KEYLIST = {"LEVEL2TOLEVEL1","LEVEL3TOLEVEL1","LEVEL3TOLEVEL2"};
	
	private final static String[] SOURCELIST = {"高级会员","受邀会员","受邀会员"};
	
	private final static String[] DESTLIST = {"合伙人","合伙人","高级会员"};
	
    @Autowired
    private RebateService rebateService;
    
    @Autowired
    private AlbumPictureService albumPictureService;

	@RequestMapping("/getRebateList")
	public R getRebateList(@RequestParam Map<String, Object> params) {
		List<RebateListEntity> rebateListEntities = new ArrayList<RebateListEntity>();
		for (int i = 0; i < 3; i++) {
			RebateListEntity rebateListEntity = new RebateListEntity();
			String points = rebateService.selectOne(new EntityWrapper<RebateEntity>().eq("rkey", KEYLIST[i])).getRvalue();
			rebateListEntity.setSource(SOURCELIST[i]);
			rebateListEntity.setDest(DESTLIST[i]);
			rebateListEntity.setRkey(KEYLIST[i]);
			rebateListEntity.setPoints(points);
			rebateListEntities.add(rebateListEntity);
		}
		return R.ok().put("data", rebateListEntities);
	}
	
	@RequestMapping("/updatePoints")
	public R updatePoints(@RequestParam Map<String, String> params) {
		for (int i = 0; i < 3; i++) {
			RebateEntity rebateEntity = new RebateEntity();
			rebateEntity.setRvalue(params.get(KEYLIST[i]));
			boolean res = rebateService.update(rebateEntity, new EntityWrapper<RebateEntity>().eq("rkey", KEYLIST[i]));
			if(!res) {
				return R.error("数据更新失败");
			}
		}
		return R.ok();
	}
	
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("rebate:rebate:list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rebateService.queryPage(params);

		return R.ok().put("page", page);
	}


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("rebate:rebate:info")
    public R info(@PathVariable("id") Integer id){
		RebateEntity rebate = rebateService.selectById(id);
		if(id == 4) {
			String imgs = rebate.getRvalue();
			if(!StringUtils.isEmpty(imgs)) {
				String[] turns = imgs.split(",");
//				StringBuffer buffer = new StringBuffer();
				List<AlbumPictureEntity> albumPictureEntities = new ArrayList<AlbumPictureEntity>();
//				int i = 0;
				for (String imgId : turns) {
					AlbumPictureEntity pictureEntity = albumPictureService.selectById(imgId);
					albumPictureEntities.add(pictureEntity);
//					if(i != 0) {
//						buffer.append(",");
//					}
//					buffer.append(pictureEntity.getPicCover());
				}
//				rebate.setRvalue(buffer.toString());
				rebate.setImgTempArray(albumPictureEntities);
			}
		}

        return R.ok().put("rebate", rebate);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("rebate:rebate:save")
    public R save(@RequestBody RebateEntity rebate){
			rebateService.insert(rebate);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("rebate:rebate:update")
    public R update(@RequestBody RebateEntity rebate){
			rebateService.updateById(rebate);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("rebate:rebate:delete")
    public R delete(@RequestBody Integer[] ids){
			rebateService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
