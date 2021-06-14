package com.jiudian.uploadresolver.config;

/**
 * @author longping jie
 * @name HandleImageWays
 * @description the class is 处理图片的方法类型常量的类
 * @date 2017/9/22
 */
public class HandleImageWays {
	//按比例缩放一张图片
    public static final String SCALING_IMAGE="SCALING_IMAGE";
    //按宽高缩放一张图片
    public static final String SCALING_IMAGE_WH="SCALING_IMAGE_WH";
    //指定坐标裁剪一张图片
    public static final String TRIMIMAGE_POINT="TRIMIMAGE_POINT";
    //按比例缩放一张图片,并给图片加水印
    public static final String WATER_IMAGE_SCALING = "WATER_IMAGE_SCALING";
    //按宽高缩放一张图片,并给图片加水印
    public static final String WATER_IMAGE_WH = "WATER_IMAGE_WH";

    
}
