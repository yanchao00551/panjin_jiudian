package com.jiudian.uploadresolver.entity;

/**
 * @author longping jie
 * @name HandleImage
 * @description the class is 裁剪图片的数据模型类 图片缩放等配置数据项
 * @date 2017/9/21
 */
public class HandleImageDataModel {
	
	// 图片当前显示在画布上的的高度
	private int presentHeight;
	// 图片当前显示在画布上的的宽度
	private int presentWidth;

	// 裁剪的x坐标
	private int x;
	// 裁剪的y坐标
	private int y;
	// 裁剪的高度
	private int h;
	// 裁剪的宽度
	private int w;
	// 裁剪后需要的宽度
	private int need_w;
	// 裁剪后需要的高度
	private int need_h;

	// 需要缩放的比例
	private double scaling;

	// 需要缩放的宽度
	private int scaling_w;
	// 需要缩放的高度
	private int scaling_h;
	
	// 水印图片透明度
	private float transparency;
	
	//水印图片位置
	private int waterPosition;
	
	//水印图片
	private String defautlWaterPath;
	
	//水印对其方式
	private String positions;
	
	

	public String getPositions() {
		return positions;
	}

	public void setPositions(String positions) {
		this.positions = positions;
	}

	public String getDefautlWaterPath() {
		return defautlWaterPath;
	}

	public void setDefautlWaterPath(String defautlWaterPath) {
		this.defautlWaterPath = defautlWaterPath;
	}

	public float getTransparency() {
		return transparency;
	}

	public void setTransparency(float transparency) {
		this.transparency = transparency;
	}

	public int getWaterPosition() {
		return waterPosition;
	}

	public void setWaterPosition(int waterPosition) {
		this.waterPosition = waterPosition;
	}



	public int getPresentHeight() {
		return presentHeight;
	}

	public void setPresentHeight(int presentHeight) {
		this.presentHeight = presentHeight;
	}

	public int getPresentWidth() {
		return presentWidth;
	}

	public void setPresentWidth(int presentWidth) {
		this.presentWidth = presentWidth;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getNeed_w() {
		return need_w;
	}

	public void setNeed_w(int need_w) {
		this.need_w = need_w;
	}

	public int getNeed_h() {
		return need_h;
	}

	public void setNeed_h(int need_h) {
		this.need_h = need_h;
	}

	public double getScaling() {
		return scaling;
	}

	public void setScaling(double scaling) {
		this.scaling = scaling;
	}

	public int getScaling_w() {
		return scaling_w;
	}

	public void setScaling_w(int scaling_w) {
		this.scaling_w = scaling_w;
	}

	public int getScaling_h() {
		return scaling_h;
	}

	public void setScaling_h(int scaling_h) {
		this.scaling_h = scaling_h;
	}
}
