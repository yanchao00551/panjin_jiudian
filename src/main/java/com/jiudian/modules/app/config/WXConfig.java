package com.jiudian.modules.app.config;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.jiudian.common.wxsdk.IWXPayDomain;
import com.jiudian.common.wxsdk.WXPayConfig;

public class WXConfig extends WXPayConfig {
	private byte[] certData;
	
	private static TempDomain tempDomain = new TempDomain();
	
	public final static String NOTIFY_URL = "http://www.xinyupoly.cn:8081/panjin_jiudian/app/wxpay/notify";

	public WXConfig() throws Exception {
    	String certPath = "classes/static/apiclient_cert.p12";
		File file = new File(certPath);
		if(!file.exists()) {
			return;
		}
		InputStream certStream = new FileInputStream(file);
		this.certData = new byte[(int) file.length()];
		certStream.read(this.certData);
		certStream.close();
	}
	
	//微信开放平台审核通过的应用APPID（请登录open.weixin.qq.com查看，注意与公众号的APPID不同）wx37dad15756e1c9ab
	public String getAppID() {
		return "wx37dad15756e1c9ab";
	}

	//微信支付分配的商户号1519053001
	public String getMchID() {
		return "1519053001";
	}

	//密钥 ddf15f401aa220b81cb6409111cad12e  30d45a99086e2bed16bc02ca0126ac10
	public String getKey() {
		return "30d45a99086e2bed16bc02ca0126ac10";
	}

	public InputStream getCertStream() {
		ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
		return certBis;
	}

	public int getHttpConnectTimeoutMs() {
		return 8000;
	}

	public int getHttpReadTimeoutMs() {
		return 10000;
	}

	@Override
	protected IWXPayDomain getWXPayDomain() {
		if(tempDomain == null) {
			tempDomain = new TempDomain();
		}
		return tempDomain;
	}
	
	static class TempDomain implements IWXPayDomain{
		
		@Override
		public void report(String domain, long elapsedTimeMillis, Exception ex) {
			
		}

		@Override
		public DomainInfo getDomain(WXPayConfig config) {
			return new DomainInfo("api.mch.weixin.qq.com", true);
		}
		
	}

}
