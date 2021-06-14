package com.jiudian;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jiudian.common.utils.Constant;
import com.jiudian.common.utils.QRCodeUtils;
import com.jiudian.config.UploadResolverConfig;
import com.jiudian.modules.app.calculate.RewardCalcuTask;
import com.jiudian.modules.app.calculate.RewardExcutor;
import com.jiudian.modules.app.calculate.RewardQueue;
import com.jiudian.modules.member.entity.MemberEntity;
import com.jiudian.modules.member.service.MemberService;
import com.jiudian.modules.sysMsg.entity.SysMsgEntity;
import com.jiudian.modules.sysMsg.service.SysMsgService;
import com.jiudian.modules.userMsg.entity.UserMsgEntity;
import com.jiudian.modules.userMsg.service.UserMsgService;

@Component
public class StartUpRunner implements ApplicationRunner {

	@Autowired
	private UploadResolverConfig uploadResolverConfig;
	
	@Autowired
	private SysMsgService sysMsgService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private UserMsgService userMsgService;

	private final static int corePoolSize = 5;

	private final static int maximumPoolSize = 5;

	private final static int keepAliveTime = 100;

	private final static TimeUnit unit = TimeUnit.SECONDS;
	
	public static RewardExcutor executor = null;

	@Override
	public void run(ApplicationArguments arg) throws Exception {
		//生日推送
		new BirthNotify().start();
		//积分处理线程池
		BufferedImage bufferedImageIOS = QRCodeUtils.toBufferedImage(uploadResolverConfig.getIOSQrcodeUrl(), 300, 300);
		BufferedImage bufferedImageAndroid = QRCodeUtils.toBufferedImage(uploadResolverConfig.getAndroidQrcodeUrl(),
				300, 300);
		File iosFile = new File(Constant.IOS_QRCODE_PATH);
		iosFile.mkdirs();
		File androidFile = new File(Constant.ANDROID_QRCODE_PATH);
		androidFile.mkdirs();
		ImageIO.write(bufferedImageIOS, "png", iosFile);
		ImageIO.write(bufferedImageAndroid, "png", androidFile);

		Comparator<? super Runnable> comparator = (Runnable r1, Runnable r2) -> {
			RewardCalcuTask s1 = ((RewardCalcuTask) r1);
			RewardCalcuTask s2 = ((RewardCalcuTask) r2);
			if (s1.getDelay() > 0 || s2.getDelay() > 0) {
				if (s1.getDelay() > s2.getDelay()) {
					if ((s1.getLastIndex() + 1l) < s2.getIndex()) {
						return -1;
					}
				} else {
					if ((s2.getLastIndex() + 1l) < s1.getIndex()) {
						return -1;
					}
				}
			}
			return s1.getIndex() > s2.getIndex() ? 1 : -1;
		};
		BlockingQueue<Runnable> taskQueue = new RewardQueue<Runnable>(200, comparator);
		executor = new RewardExcutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, taskQueue, 
				new ThreadPoolExecutor.CallerRunsPolicy());
		while (true) {
			RewardCalcuTask r = (RewardCalcuTask) taskQueue.take();
			executor.execute(r);
		}
	}
	
	public RewardExcutor getExecutor() {
		return executor;
	}
	
	class BirthNotify extends Thread{
		
		@Override
		public void run() {
			super.run();
			Calendar today = Calendar.getInstance();
			today.add(Calendar.DATE, 1);
			today = turnDate(today);
//			today.set(Calendar.HOUR_OF_DAY, 16);
//			today.set(Calendar.MINUTE, 48);
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					List<SysMsgEntity> sysMsgEntities = sysMsgService.selectList
							(new EntityWrapper<SysMsgEntity>().eq("msg_type", 2));
					List<MemberEntity> memberEntities = memberService.selectList(new EntityWrapper<MemberEntity>());
					Calendar current = Calendar.getInstance();
					current = turnDate(current);
					for (MemberEntity me : memberEntities) {
						Calendar birth = Calendar.getInstance();
						if(me.getBirthDate() == null) {
							continue;
						}
						birth.setTime(me.getBirthDate());
						birth = turnDate(birth);
						if(current.get(Calendar.DAY_OF_MONTH) == birth.get(Calendar.DAY_OF_MONTH) && 
								current.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
							for (SysMsgEntity sme : sysMsgEntities) {
								UserMsgEntity userMsgEntity = new UserMsgEntity();
								userMsgEntity.setIsRead(0);
								userMsgEntity.setMsgId(sme.getId());
								userMsgEntity.setRecieveDate(Calendar.getInstance().getTime());
								userMsgEntity.setUid(((Long)me.getUid()).intValue());
								userMsgService.insert(userMsgEntity);
								sme.setSendTimes(sme.getSendTimes() + 1);
								sysMsgService.insertOrUpdate(sme);
							}
						}
					}
				}
			}, today.getTime(), 1000 * 60 * 60 * 24 * 1);//每天
		}
		
		private Calendar turnDate(Calendar day) {
			day.set(Calendar.HOUR_OF_DAY, 0);
			day.set(Calendar.MINUTE, 0);
			day.set(Calendar.SECOND, 0);
			day.set(Calendar.MILLISECOND, 0);
			return day;
			
		}
	}
}
