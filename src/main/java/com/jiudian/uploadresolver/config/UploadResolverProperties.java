package com.jiudian.uploadresolver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author longping jie
 * @name UploadResolverProperties
 * @description the class is 上传文件基本配置项目,从配置文件中读取数据
 * @date 2017/9/22
 */

@Component
@ConfigurationProperties(prefix = "upload")
public class UploadResolverProperties {
	private String uploadPath;
    private String thumbDir;
    private Integer imageHeight;
    private String imageFormat;
    private String defautlWaterPath;
    private String iosQrcodeUrl;
    private String androidQrcodeUrl;

	public String getDefautlWaterPath() {
		return defautlWaterPath;
	}
	public void setDefautlWaterPath(String defautlWaterPath) {
		this.defautlWaterPath = defautlWaterPath;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getThumbDir() {
		return thumbDir;
	}
	public void setThumbDir(String thumbDir) {
		this.thumbDir = thumbDir;
	}
	public Integer getImageHeight() {
		return imageHeight;
	}
	public void setImageHeight(Integer imageHeight) {
		this.imageHeight = imageHeight;
	}
	public String getImageFormat() {
		return imageFormat;
	}
	public void setImageFormat(String imageFormat) {
		this.imageFormat = imageFormat;
	}
	public String getIosQrcodeUrl() {
		return iosQrcodeUrl;
	}
	public void setIosQrcodeUrl(String iosQrcodeUrl) {
		this.iosQrcodeUrl = iosQrcodeUrl;
	}
	public String getAndroidQrcodeUrl() {
		return androidQrcodeUrl;
	}
	public void setAndroidQrcodeUrl(String androidQrcodeUrl) {
		this.androidQrcodeUrl = androidQrcodeUrl;
	}
	
}
