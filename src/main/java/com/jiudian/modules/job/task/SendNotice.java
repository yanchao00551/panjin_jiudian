package com.jiudian.modules.job.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.jiudian.modules.sms.service.SysNoticeRecordsService;
import com.jiudian.modules.sms.entity.SysNoticeRecordsEntity;

/**
 * 通知任务 含短信发送
 * 
 * @author yanchao
 */
@Component("sendNotice")
public class SendNotice {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private SysNoticeRecordsService sysNoticeRecordsService;

	/**
	 * 发送通知任务
	 */
	public void sendSms() {
		logger.info("Sms Send Start ...");
		Map<String, Object> map = new HashMap<>();
		map.put("is_send", '0');
		List<SysNoticeRecordsEntity> list = sysNoticeRecordsService.selectByMap(map);
		logger.info("list:" + list.get(0).getId());
		for (int i = 0; i <= list.size(); i++) {
			if (list.get(i).getSendType() == 1) { // 1.短信发送 2.邮件发送
				boolean rst = this.noticeSmsSend(list.get(i).getId(), list.get(i).getSendAccount(),
						list.get(i).getSendConfig(), list.get(i).getNoticeContext(), list.get(i).getNoticeTitle());
				if (!rst) {
					logger.debug("---短信发送失败---");
					logger.debug("发送参数:" + (list.get(i).getId() + "||" + list.get(i).getSendAccount() + "||"
							+ list.get(i).getSendConfig() + "||" + list.get(i).getNoticeContext() + "||"
							+ list.get(i).getNoticeTitle()));
				}
			}
		}
		logger.info("Sms Send end...");
	}

	/**
	 * 发送短信
	 * 
	 * @param id
	 * @param sendAccount
	 * @param sendConfig
	 * @param noticeContext
	 * @return
	 */
	private boolean noticeSmsSend(Integer id, String sendAccount, String sendConfig, String noticeContext,
			String templateCode) {
		return sysNoticeRecordsService.noticeSmsSend(id, sendAccount, sendConfig, noticeContext, templateCode);
	}

}
