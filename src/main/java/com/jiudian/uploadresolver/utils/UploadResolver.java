package com.jiudian.uploadresolver.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.jiudian.uploadresolver.config.HandleImageWays;
import com.jiudian.uploadresolver.config.UploadResolverProperties;
import com.jiudian.uploadresolver.entity.HandleImageDataModel;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * @author longping jie
 * @name UploadResolver
 * @description the class is 上传图片的工具类,封装有图片缩放和剪裁
 * @date 2017/9/22
 */

public class UploadResolver {
	@Autowired
	UploadResolverProperties uploadResolverProperties;

	/**
	 * 原圖保持位置
	 */
	private String imageName;
	/**
	 * 處理后圖片保持位置
	 */
	private String thumbName;
	
	
	String dateName;
	
	
	public String getDateName() {
		return dateName;
	}


	public void setDateName(String dateName) {
		this.dateName = dateName;
	}


	//获取目录路径
	public String getImageDirName() {
		String path = this.imageName.substring(0, this.imageName.lastIndexOf("/"));
		return path;
	}


	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getThumbName() {
		return thumbName;
	}

	public void setThumbName(String thumbName) {
		this.thumbName = thumbName;
	}

	public UploadResolver() {
		LocalDate dt = LocalDate.now();
		int year = dt.getYear();
		int month = dt.getMonthValue();
		int date = dt.getDayOfMonth();

		String monthStr = month + "";
		String dateStr = date + "";

		if (month < 10) {
			monthStr = "0" + monthStr;
		}
		if (date < 10) {
			dateStr = "0" + date;
		}
		dateName = String.format("%s-%s-%s", year, monthStr, dateStr);
	}

	/**
	 *  图片上传的类
	 * @param image 需要上传的图片文件对象
	 * @param fileName 指定一个名字
	 * @param handleImageWays 处理图片的方式，如缩放，裁剪等
	 * @param dataModel 处理图片的数据模型
	 * @param x 循環調用情況下 是否指生產一張原圖
	 * @throws IOException
	 */
	public String saveImage(MultipartFile image, String fileName, String handleImageWays, HandleImageDataModel dataModel,int x)
			throws IOException {
		String imageName = null;	
		String thumbName = null;
		if(x == 0) {
			imageName = String.format("%s/%s.jpg", uploadResolverProperties.getUploadPath(), fileName);
		}else {
			imageName = this.imageName;
		}
		if(this.thumbName == null) {
			thumbName = String.format("%s/%s/%s.jpg", uploadResolverProperties.getUploadPath(),
					uploadResolverProperties.getThumbDir(), fileName);
		}else {
			thumbName = this.thumbName;
		}
		
		File imageFile = new File(imageName);
		File thumbFile = new File(thumbName);

		if (!imageFile.getParentFile().exists()) {
			imageFile.getParentFile().mkdirs();
		}
		if(!thumbFile.getParentFile().exists()) {
			thumbFile.getParentFile().mkdirs();
		}
		
		if(x == 0) {
			image.transferTo(new File(imageFile.getAbsolutePath()));
		}
		if (dataModel != null) {
			String defaultWaterImgPath = dataModel.getDefautlWaterPath() != null ? dataModel.getDefautlWaterPath()
					: uploadResolverProperties.getDefautlWaterPath();
			if (defaultWaterImgPath != null) {
				dataModel.setDefautlWaterPath(defaultWaterImgPath);
			}
		}
		if(handleImageWays != null) {
			switch (handleImageWays) {
			case HandleImageWays.SCALING_IMAGE:
				changeSize_Scaling(imageFile, thumbFile, dataModel);
				break;
			case HandleImageWays.SCALING_IMAGE_WH:
				changeSize_WH(imageFile, thumbFile, dataModel);
				break;
			case HandleImageWays.TRIMIMAGE_POINT:
				trimImage(imageFile, thumbFile, dataModel);
				break;
			case HandleImageWays.WATER_IMAGE_WH:
				waterImageWh(imageFile, thumbFile, dataModel);
				break;
			case HandleImageWays.WATER_IMAGE_SCALING:
				waterImageScaling(imageFile, thumbFile, dataModel);
				break;
			}
		}
		return imageName;
	}
	

	

	/**
	 * 判断一个文件是否是图片类型
	 * @param type 文件类型
	 * @return 是否是图片类型
	 */
	public boolean checkImageFileType(String type) {
		String[] types = { ".PNG", ".JPG", ".JPEG", ".BMP", ".GIF" };
		boolean res = false;
		for (String t : types) {
			if (t.equals(type.toUpperCase())) {
				res = true;
				break;
			}
		}
		return res;
	}
	
	@Override
	public String toString() {
		return "UploadResolver{" + "uploadResolverProperties=" + uploadResolverProperties + ", dateName='" + dateName
				+ '\'' + '}';
	}

	/**
	 * 指定宽度高度缩放图片
	 * @param file 原图片文件
	 * @param newFile 目标图片文件
	 */
	private void changeSize_WH(File file, File newFile, HandleImageDataModel dataModel) throws IOException {
		// 变为400*300,遵循原图比例缩或放到400*某个高度
		Thumbnails.of(file).size(dataModel.getScaling_w(), dataModel.getScaling_h()).toFile(newFile);
	}

	/**
	 * 指定比例缩放图片
	 * @param file
	 * @param newFile
	 * @throws IOException
	 */
	private void changeSize_Scaling(File file, File newFile, HandleImageDataModel dataModel) throws IOException {
		Thumbnails.of(file).scale(dataModel.getScaling()).toFile(newFile);// 按比例缩小
	}


	/**
	 * 用uuid重命名文件
	 * @param fileName 文件原名
	 * @return 文件新的名字
	 */
	public String createFileName(String fileName) {
		return UUID.randomUUID().toString().replaceAll("-", "") + "."
				+ fileName.substring(fileName.lastIndexOf(".") + 1);
	}

	/**
	 * 裁剪图片
	 * @param file 原图片文件
	 * @param newFile 新图片文件
	 * @param dataModel 裁剪需要的数据模型
	 */
	private void trimImage(File file, File newFile, HandleImageDataModel dataModel) throws IOException {
		BufferedImage buf = Thumbnails.of(file).width(dataModel.getPresentWidth()).height(dataModel.getPresentHeight())
				.asBufferedImage();
		Thumbnails.of(buf).sourceRegion(dataModel.getX(), dataModel.getY(), dataModel.getW(), dataModel.getH())
				.size(dataModel.getNeed_w(), dataModel.getNeed_h()).toFile(newFile);
	}
	
	/**
	 * 指定宽高,给图片添加水印
	 * @param imageFile
	 * @param thumbFile
	 * @param dataModel
	 * @throws IOException 
	 */
	private void waterImageWh(File imageFile, File newFile, HandleImageDataModel dataModel) throws IOException {
		// TODO Auto-generated method stub
		Thumbnails.of(imageFile).size(dataModel.getScaling_w(), dataModel.getScaling_h()).watermark(getPositionsType(dataModel.getPositions()),ImageIO.read(new File(dataModel.getDefautlWaterPath())),dataModel.getTransparency()).toFile(newFile);
	}
	
	/**
	 * 等比 给图片添加水印
	 * @param imageFile
	 * @param thumbFile
	 * @param dataModel
	 * @throws IOException 
	 */
	private void waterImageScaling(File imageFile, File newFile, HandleImageDataModel dataModel) throws IOException {
		// TODO Auto-generated method stub
		Thumbnails.of(imageFile).scale(dataModel.getScaling()).watermark(getPositionsType(dataModel.getPositions()),ImageIO.read(new File(dataModel.getDefautlWaterPath())),dataModel.getTransparency()).toFile(newFile);
	}

	/**
	 * 获取水印位置
	 * @param positions
	 * @return
	 */
	private static Positions getPositionsType(String positions) {
		Positions position = null;
		switch(positions) {
		case "TOP_LEFT":
			position = Positions.TOP_LEFT;
			break;
		case "TOP_CENTER":
			position = Positions.TOP_CENTER;
			break;
		case "TOP_RIGHT":
			position = Positions.TOP_RIGHT;
			break;
		case "CENTER_LEFT":
			position = Positions.CENTER_LEFT;
			break;
		case "CENTER":
			position = Positions.CENTER;
			break;
		case "CENTER_RIGHT":
			position = Positions.CENTER_RIGHT;
			break;
		case "BOTTOM_LEFT":
			position = Positions.BOTTOM_LEFT;
			break;
		case "BOTTOM_CENTER":
			position = Positions.BOTTOM_CENTER;
			break;
		case "":
			position = Positions.BOTTOM_RIGHT;
			break;
		}
		return position;
	}
}
