package com.jiudian.modules.sysMsg.controller;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.album.service.AlbumPictureService;
import com.jiudian.modules.app.entity.UserEntity;
import com.jiudian.modules.app.service.UserService;
import com.jiudian.modules.sysMsg.entity.SysMsgEntity;
import com.jiudian.modules.sysMsg.service.SysMsgService;
import com.jiudian.modules.userMsg.entity.UserMsgEntity;
import com.jiudian.modules.userMsg.service.UserMsgService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;



/**
 * 
 *
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-10-27 16:23:13
 */
@RestController
@RequestMapping("sysMsg/sysmsg")
public class SysMsgController {
    @Autowired
    private SysMsgService sysMsgService;
    @Autowired
    private AlbumPictureService albumPictureService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserMsgService userMsgService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("sysMsg:sysmsg:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysMsgService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("sysMsg:sysmsg:info")
    public R info(@PathVariable("id") Integer id){
		SysMsgEntity sysMsg = sysMsgService.selectById(id);
		AlbumPictureEntity albumPictureEntity = albumPictureService.selectOne
				(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", sysMsg.getImg()));
		sysMsg.setImgDetail(albumPictureEntity);

        return R.ok().put("sysMsg", sysMsg);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("sysMsg:sysmsg:save")
    public R save(@RequestBody SysMsgEntity sysMsg){
		sysMsg.setCreateDate(Calendar.getInstance().getTime());
		sysMsgService.insert(sysMsg);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("sysMsg:sysmsg:update")
    public R update(@RequestBody SysMsgEntity sysMsg){
			sysMsgService.updateById(sysMsg);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sysMsg:sysmsg:delete")
    public R delete(@RequestBody Integer[] ids){
			sysMsgService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
    
	/**
	 * 发送消息通知
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping("/sendMsg")
	public R sendMsg(@RequestParam Map<String, String> params) {
		String msgId = params.get("id");
		Date date = Calendar.getInstance().getTime();
		List<UserEntity> userEntities = userService.selectList(new EntityWrapper<UserEntity>().eq("user_status", 1));
		userEntities.forEach(ue -> {
			UserMsgEntity userMsgEntity = new UserMsgEntity();
			userMsgEntity.setIsRead(0);
			userMsgEntity.setMsgId(Integer.parseInt(msgId));
			userMsgEntity.setRecieveDate(date);
			userMsgEntity.setUid(ue.getUserId().intValue());
			userMsgService.insert(userMsgEntity);
		});
		SysMsgEntity sysMsgEntity = sysMsgService.selectById(msgId);
		int sendTimes = sysMsgEntity.getSendTimes();
		sysMsgEntity.setSendTimes(sendTimes + 1);
		sysMsgEntity.setLastSendDate(date);
		sysMsgService.insertOrUpdate(sysMsgEntity);
		return R.ok();
	}

}
