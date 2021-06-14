package com.jiudian.modules.app.config;

public class AlipayConfig {
	// 商户appid
	public static String APPID = "2018110762015886";// 2016091800539551
	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCkqbvxOXfEuakiMIdPRersudLYu7HZ+zWaJCxyXqxvKWUgdkVJluJef3R1imzRsQgbxm/r6nAiTHzvz1l8MVS92LIMwjteRRMpGK20LyVFf7y8bnYmEz0jSiV6fReL2T8iblEUlAd1sSRhBvUMc/DnYv/1icbMz4VELyDslO4AW/NM4+iuRSO8zBrI5hzJfPk7xI/rfiB7vBVcuiboJUSF1l1AZS9uGLBi/PwAQ0HdIp6JSSnTvUmRGJdpbOSpkr/a+u2w7m6469OAxMLngkQ27JMjOnYddJ0qbPSnk0dLUOxdNGwI4a41bDgfuwITTacTiaONzqUCYJaDf3gY9Gl9AgMBAAECggEAJI9HGlUPIY+zXNL3iANXGL5dcR+jammbSiET+UTJ9lhzipSX57HniuGzotFcPeaXjUsu2GuSABuJddlM3gU58njld228rr6ZdXt0Pdhl5xtodVH1S5jj7yzsS1jw3G0c1nE18WK4kUoGcMCRsfUgHM/fUs4HZLwCs9Pe9IhQm6VyuxRGPp11AuJBur098VZwj4/4CdxIfDbKuWAwayKxYdCcEhFPAc8uK46Dtt6qQ5DiSOuiGN4VaR5jaO52lbWgPSbgidKQp7DPy2ZmfxD2nyuoAoo3vv8WAsWBPoERnAJB/zITzLoxT+XBJx74xJPlwo+FWsvBgHv9+SBZ23PY5QKBgQDsNFAG2Xc6OUmkNIGMeji85WPf/wocWh4QtQ/f7z67e0eISwtwQ3Cw6uomVrlPDUo/8LtiBsgcZ3r5qhDXiG7LTROv/gCMUnovKGO2wCGIy/9RSjYsL8oIY6mRfZ1c3Pd9iIvKWMNps2GBZmgAiUGQm7cbGOtrJ/QQx24Bqt+6jwKBgQCydoaX8P556dhXxhyqX2kT7PMJBOJ184AX1CR73p07iKqzn/Iw+b5b/y2SV/O8DriUwGLwxD7wsNvem7xCiiau44cd4MIIkrfQJhgSg66I/jICNZax9ClFNFfAVnvVeeATBVsLld6CQkPWmuu8P0gXsQflHWlsIXB5DDwyb3VRMwKBgQCnGFLMpaa8n65C5YoH8KaWqsg+u9NRP0cplo0GY99DDfEKr9wFrQ/ZeDXwrUUmcUZneUt2C0ohHetXF0IW10NZussEo3GL0wTwu2fe7ohKl9WkkhVEqQIJcUeRzwU1nnPOcHxDxwtmiSmfOuy0BGVHgYDFQJm6EmeMPyjJMTJYbQKBgHavjsmD06m+lEujjLLd6yL+RY9s+TLacwjl5DGhFk5ekLAPImHh5fCG34bhCU67N5Rt8h8PVJB7/m2oguZ5vEo5NUXwkPpkoOxEOWQuwSeIbje77fGBYOUOb4GRwp9xg00DFc65qBZW/Yi+1SIHr+lZqdd83Py1rHhEY9BjAdGzAoGBAL3JxXhpIwPAZt/934HXSmBwLg0u2UYr+t3xU8o+oIexYINjsmlPrO3ZgJqh6lAyAmnOcNJrcqK5zuAVgKpYkjzX3Qk5vFFB6olP2kuzOwVJiXDz/dGfDrp92teKMYXx72c86H3m2SgdY1qQCSAY9AN3iE3HOcqILnNref64dUGB";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://www.xinyupoly.cn:8081/panjin_jiudian/app/alipay/notify";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	// 商户可以自定义同步跳转地址
	public static String return_url = "http://www.xinyupoly.cn:8081/app/alipay/return";
	// 请求网关地址
	public static String URL = "https://openapi.alipay.com/gateway.do";
	// 沙箱地址
	public static String SANDBOX_URL = "http://openapi.alipaydev.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkUROWELYkst5l+K6OHM9MyTcQUWKL52dmS1IUssueyR+CVBFfHx6R4YjX4SOErNBg47z03VBXQJ10WmcQDWkoRzHz71O18Cb5rsOllyZ5cI2VH0Whz2+NUmSEOYn+Hth4I6cb4tVsdjcV5EX6svLONypLVTjAds/qygp0qQuLNWk7r1RZuqjMAGKaQCRU4dKu37R4mD5zhhSKUUSjgVcYj/DVGjdgbqY8aRGm9ajbN9NwcW45G4O5RT0NsLL9BCvmFN+FUa0/nBUqwp5eqC69txEJYfXMWs+MVQWfw38KcZNnoKhhetHr52dpchaacu8Haw7TVqxb5141lCQbqpxgQIDAQAB";
	// 日志记录目录
	public static String log_path = "/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";
	
	public final static String PRODUCT_CODE = "QUICK_MSECURITY_PAY";
	
	public final static String TIMEOUT_EXPRESS = "15m";
}
