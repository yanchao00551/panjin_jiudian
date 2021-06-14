package com.jiudian.modules.app.config;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;

public class PayConfig {

	public final static String PREFIX = "新宇酒店-";
	
	public final static String RECHARGE_TEXT = "RECH";
	
	public final static String COMMON_GOODS_NAME = "酒店房间预订";
	
	public final static String RECHARGE_GOODS_NAME = "商城充值";
	
	public final static String ERROR_HEAD = "ERROR";

	// RSA加密用公钥
	public final static String RSA_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnffhOca16ngQVBleN4OY4e/uwKxrtuX/kvNFUKQheXR3Q2tY0/CTWxR4fn/9NSL54wzj5Cqq1pBTYAJYp4X8YoAMhYp7GVrjUqczVrndNvaLzNAoSaU5anugI3z0mFZqaYqe8q5vi8yNGHA791yXUPNr9fYuVD4GqPBDnpBQbk6fSXS/cYsMzw/FohWAhAsK9bWkG4w+ZA/w/AhC+m4uaNfs6qwi7wdfXD9A7sh/AU3L1RvKC8bUmlBqrXk6K93e03hYJeur0+CpDMVy3YRt18o0fpeEC1tUHbAPpw7Wnp9xsj7asdf6HawMksp2WkHUho6Z4DtedAZ78qz9P1jwcwIDAQAB";

	// RSA加密用私钥
	public final static String RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCd9+E5xrXqeBBUGV43g5jh7+7ArGu25f+S80VQpCF5dHdDa1jT8JNbFHh+f/01IvnjDOPkKqrWkFNgAlinhfxigAyFinsZWuNSpzNWud029ovM0ChJpTlqe6AjfPSYVmppip7yrm+LzI0YcDv3XJdQ82v19i5UPgao8EOekFBuTp9JdL9xiwzPD8WiFYCECwr1taQbjD5kD/D8CEL6bi5o1+zqrCLvB19cP0DuyH8BTcvVG8oLxtSaUGqteTor3d7TeFgl66vT4KkMxXLdhG3XyjR+l4QLW1QdsA+nDtaen3GyPtqx1/odrAySynZaQdSGjpngO150BnvyrP0/WPBzAgMBAAECggEAVlgdZaU13jlOQ4myNAncUPMCv5H/NnO1JK+QHan5GhgM8G8GmKIRCWHBEvQGhTre97od/qNLyggNapcdukPEVlrDfWLaMlu5kX4O08K4JcjRVVwaCVckcQ2t1HgCghoKBDJe+ytZkUJ3hPoj7OtRUlAbnM+5NxbIMSNS8qLTM9cqwCvZrpsman/RT5fRbVyAZSMuogMl3IEOxActUqLLBUvJWQp4CrVvCWbIVE6sznaLuNZCjz6lW46mHLIGsuRZSyOUxTLYIAum/0yobXINPpFOEEJaVh4EJERTVKXYsYMHGZA2St9COh4UcK4ijQ+neSz2RS/djq53ceaSlSA38QKBgQDuJ0S2uA4W7tSq0wdA5FkkkXoE1MPESu0ag9d8av/Qw4H0B/73lOXOJOIazU/WTTUIv3DpUEhzLqNELZUDlzKZjHbUELIT+Bv22Tg+zxhJdULjnDN9RXtcp9+yKjQJJ2+Zcp70r+dTNmIlcWoRhx2j01oPoonrjcGBoq8LyIJKPQKBgQCpzlda2Se9KgmnFV5eAIefkqUa+RMAQPa8MP9/lUatSQMj6lpgjlxxBc/LTlCz0LORKfpScz+wB7KR27GXlH1yPxh/47eXAkK818AzzF8dypsBzgyJEEf5Y0InXix6Fd5bSBOdYK0yKeCIGxVj5sdBB+bcshRHY1UDdRFOf7HAbwKBgH73uI6hugFH+2HHeEqEc3InjSIePPDd8WL9f1j5wsEOOq5bxPdCDvLEfzdC1pmuN+QeDJiXEMk3yBuFIbj0Vym91WxiKk6zLFWCoZX62zvupGas1FapQIe5iG14Sp3GxJzOmyhgz7dxewnzWVVW79pzx8QmJ9nJja0Lir+BetURAoGAVRNHmwG/sjvUmDzRieFUEfQD+q6eAXuK4yDdccuVnI4/H4hz/Xp2AD58LI0xS9YdkXZpr1OErio9Imzi3mIMM+g+2xx5SBRe4YRrDMixQxjWbqIQj79zgBRl+ZlqSUSZojxLb4cXX1Gx6B9BqUrfu8o8tYgXNukil9fYcu7xXMsCgYEAmUuk0I/05inzcHLOPSYGEB27kIv5O13ZX+2XR4o/aVRJ3/+LQ8n9vPYiX85nuWl8XIK6yH3CKASS71+hv9BBBW2JPX/ZKlN/HNtUvisEc6w7Acx1Y3Kx4gsgTfHk6LlnNBOxm3ywssbpSDXTh+EJxdd6B515tCRt+/IUjJx1ek0=";

	public static PublicKey getPublicKey() throws Exception {
		byte[] keyBytes;
		keyBytes = new Base64().decode(RSA_PUBLIC_KEY);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(keySpec);
		return publicKey;
	}

	public static PrivateKey getPrivateKey() throws Exception {
		byte[] keyBytes;
		keyBytes = new Base64().decode(RSA_PRIVATE_KEY);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
		return privateKey;
	}
}
