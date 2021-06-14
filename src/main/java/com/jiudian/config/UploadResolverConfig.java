package com.jiudian.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.jiudian.uploadresolver.config.UploadResolverProperties;
import com.jiudian.uploadresolver.utils.UploadResolver;

/**
 * @author longping jie
 * @name UploadResolverConfig
 * @description the class is 装载UploadResolver对象
 * @date 2017/9/22
 */

@Configuration
@EnableConfigurationProperties(UploadResolverProperties.class)
@Scope("prototype")
public class UploadResolverConfig {
	@Autowired
	UploadResolverProperties uploadResolverProperties;
	
	@Bean
	public UploadResolver getUploadResolver() {
		return new UploadResolver();
	}
	
	
	@Bean
	public String getUploadPath() {
		return uploadResolverProperties.getUploadPath();
	}


	@Bean
	public String getthumbDir() {
		return uploadResolverProperties.getThumbDir();
	}
    /**
     * 文件上传配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大
        factory.setMaxFileSize("10240KB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("102400KB");
        return factory.createMultipartConfig();
    }

    @Bean
	public String getImageFormat() {
		// TODO Auto-generated method stub
		return uploadResolverProperties.getImageFormat();
	}
    
	// 获取IOS推广二维码
	@Bean
	public String getIOSQrcodeUrl() {
		return uploadResolverProperties.getIosQrcodeUrl();
	}

	// 获取Android推广二维码
	@Bean
	public String getAndroidQrcodeUrl() {
		return uploadResolverProperties.getAndroidQrcodeUrl();
	}
    
    

}
