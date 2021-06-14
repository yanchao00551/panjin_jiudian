package com.jiudian.modules.app.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jiudian.common.utils.ErrorMsg;
import com.jiudian.common.utils.Md5Utils;
import com.jiudian.common.utils.R;
import com.jiudian.config.UploadResolverConfig;
import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.album.service.AlbumPictureService;
import com.jiudian.uploadresolver.config.HandleImageWays;
import com.jiudian.uploadresolver.entity.HandleImageDataModel;

import io.swagger.annotations.Api;

/**
 * 图片上传控制器
 * 
 * @author KF-180419
 *
 */
@RestController
@RequestMapping("/app")
@Api("图片上传处理接口")
public class AppUploadController {
	@Autowired
	private AlbumPictureService albumPictureService;

	@Autowired
	UploadResolverConfig uploadResolverConfig;

	private String fileName; // 文件原名
	private long fileSize; // 文件大小
	private String fileType; // 文件类型
	private String filePath; // 文件路径
	private String message; // 验证文件失败提示
	private String relateveSourcePath;  //原图相对路径
	private Integer uploadType;   //上传方式  1.本地 2.七牛
	private Integer albumId;
	private Integer instance_id;
    
    public AppUploadController() {
    	this.instance_id = 0;
    	this.uploadType = 1;
    	this.albumId = 0;
    }

	@RequestMapping("/testUploadFile")
	public void testUploadFile(@RequestParam("image") MultipartFile file) throws IOException {
		String fileName = file.getOriginalFilename();
		String uuidFileName = uploadResolverConfig.getUploadResolver().createFileName(fileName);
		uuidFileName = uuidFileName.substring(0, uuidFileName.lastIndexOf("."));
		uploadResolverConfig.getUploadResolver().saveImage(file, uuidFileName, null, null,0);
	}

	/**
	 * 功能说明：文件(图片)上传(存入相册)
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/uploadFile/{filepath}",method=RequestMethod.POST,headers = "content-type=multipart/form-data")
	public R uploadFile(@RequestParam("image") MultipartFile file, @PathVariable("filepath") String filepath,
			@RequestParam(value = "picName", required = false) String picName,
			@RequestParam(value = "albumId", required = false) Integer albumId,
			@RequestParam(value = "picTag", required = false) String picTag,
			@RequestParam(value = "picId", required = false) Integer picId) throws IOException {
		if (filepath == null) {
			return R.error(ErrorMsg.UPLOAD_FILEPATH_NULL.getCode(), ErrorMsg.UPLOAD_FILEPATH_NULL.getName());
		}
		this.filePath = filepath;
		if (file != null) { // 判断上传的文件是否为空
			String filetype = null; // 文件类型
			String fileName = file.getOriginalFilename(); // 文件原名称
			this.fileName = fileName;
			// 判断文件类型
			filetype = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf("."), fileName.length())
					: null;
	        
	        
			if (filetype != null) {// 判断文件类型是否为空
				if (!uploadResolverConfig.getUploadResolver().checkImageFileType(filetype)) {
					System.out.println("文件不是图片类型");
					return R.error(ErrorMsg.UPLOAD_FILE_TYPE_FAIL.getCode(), ErrorMsg.UPLOAD_FILE_TYPE_FAIL.getName());
				}
				this.fileType = filetype;
				this.fileSize = file.getSize();

				if (file.getSize() > 10000000) { // 10M
					return R.error(ErrorMsg.UPLOAD_FILE_MAX_FAIL.getCode(), ErrorMsg.UPLOAD_FILE_MAX_FAIL.getName());
				}
				if (file.getSize() == 0) {
					return R.error(ErrorMsg.UPLOAD_FILE_SIZE_0.getCode(), ErrorMsg.UPLOAD_FILE_SIZE_0.getName());
				}
				// 验证文件
				if (!this.validationFile()) {
					return R.error(this.message);
				}
				

				String uuidFileName = uploadResolverConfig.getUploadResolver().createFileName(fileName);
				uuidFileName = uuidFileName.substring(0, uuidFileName.lastIndexOf("."));
				BufferedImage sourceImg = ImageIO.read(file.getInputStream());
				
				//图片类全部相册管理
				Integer id = 0;
				if (!this.filePath.equals("upload_video") && !this.filePath.equals("goods_video_path")
						&& !this.filePath.equals("upload_file")) {
					int height = sourceImg.getHeight();
					int width = sourceImg.getWidth();
					if (this.filePath.equals("goods") || this.filePath.equals("uppload_common") || this.filePath.equals("upload_comment") || this.filePath.equals("upload_avator")) {
						// 商品图
						if (picName == null) {
							picName = fileName;
						}
						if (picTag == null) {
							picTag = fileName;
						}
						// 上传到相册管理，生成四张大小不一的图
						if(albumId != null) {
							this.albumId = albumId;  //相册ID
						}
						id = this.photoCreate(file,
								this.fileType,picName, this.albumId, width, height, picTag, picId);
						
					}
				} else {
					//非图片类全部原文件上传
					uploadResolverConfig.getUploadResolver().saveImage(file, uuidFileName, null, null,0);
				}
				
				if(id == 0) {
					this.message = "上传图片失败!";
				}else {
					this.message = null;
				}
				// HandleImageDataModel dataModel = new HandleImageDataModel();
				/*
				 * 水印 dataModel.setScaling(2f); //等比 或 指定宽高 dataModel.setPositions("CENTER");
				 * //水印位置 dataModel.setTransparency(0.5f); //透明度
				 */

				/*
				 * 等比 dataModel.setScaling(0.5f);
				 */

				/*
				 * 指定宽高 dataModel.setScaling_w(400); dataModel.setScaling_h(4000);
				 */
				// uploadResolverConfig.getUploadResolver().saveImage(file, uuidFileName,
				// HandleImageWays.WATER_IMAGE_SCALING, dataModel);
				// System.out.println("文件上传成功");

				if (this.message == null) {
					return R.ok().put("pictureId", id);
				}
				return R.error(this.message);

			} else {
				System.out.println("文件类型为空");
			}
		} else {
			System.out.println("没有找到相对应的文件");
		}
		return R.ok();
	}

	/**
	 *  各类型图片生成 统一按指定宽高等比缩放
	 * @param file
	 * @param fileType
	 * @param picName
	 * @param albumId
	 * @param width
	 * @param height
	 * @param picTag
	 * @param picId
	 * @throws IOException
	 */
	private Integer photoCreate(MultipartFile file,String fileType,String picName, Integer albumId,
			int width, int height, String picTag, Integer picId) throws IOException {
		// TODO Auto-generated method stub
		photo bigPath = new photo();
		photo middlePath = new photo();
		photo smallPath = new photo();
		photo littlePath = new photo();
		bigPath.setWidth(700);
		bigPath.setHeight(700);
		middlePath.setWidth(360);
		middlePath.setHeight(360);
		smallPath.setWidth(240);
		smallPath.setHeight(240);
		littlePath.setWidth(60);
		littlePath.setHeight(60);
		bigPath.setNewFileName(Md5Utils.hash((String.valueOf(System.currentTimeMillis()) + picTag)) + "_700x700");
		middlePath.setNewFileName(Md5Utils.hash((String.valueOf(System.currentTimeMillis()) + picTag)) + "_360x360");
		smallPath.setNewFileName(Md5Utils.hash((String.valueOf(System.currentTimeMillis()) + picTag)) + "_240x240");
		littlePath.setNewFileName(Md5Utils.hash((String.valueOf(System.currentTimeMillis()) + picTag)) + "_60x60");
		bigPath.setPath("/"+uploadResolverConfig.getthumbDir()+"/"+bigPath.getNewFileName()+"."+uploadResolverConfig.getImageFormat());
		middlePath.setPath("/"+uploadResolverConfig.getthumbDir()+"/"+middlePath.getNewFileName()+"."+uploadResolverConfig.getImageFormat());
		smallPath.setPath("/"+uploadResolverConfig.getthumbDir()+"/"+smallPath.getNewFileName()+"."+uploadResolverConfig.getImageFormat());
		littlePath.setPath("/"+uploadResolverConfig.getthumbDir()+"/"+littlePath.getNewFileName()+"."+uploadResolverConfig.getImageFormat());
		this.relateveSourcePath = uploadResolverConfig.getUploadPath().substring(uploadResolverConfig.getUploadPath().lastIndexOf("/"), uploadResolverConfig.getUploadPath().length())+"/"+bigPath.getNewFileName()+"."+uploadResolverConfig.getImageFormat();
		List<photo> list = new ArrayList<photo>();
		list.add(bigPath);
		list.add(middlePath);
		list.add(littlePath);
		list.add(smallPath);

		// 循环生成4张大小不一的图
		int p = 0;
		String imageName2=null;
		for(int i=0;i<list.size();i++) {
			HandleImageDataModel dataModel = new HandleImageDataModel();
			dataModel.setScaling_w(list.get(i).getWidth());
			dataModel.setScaling_h(list.get(i).getHeight());
			imageName2 = uploadResolverConfig.getUploadResolver().saveImage(file, list.get(i).getNewFileName(),
					HandleImageWays.SCALING_IMAGE_WH, dataModel,p++);
			if(imageName2 != null && i==0) {
				uploadResolverConfig.getUploadResolver().setImageName(imageName2);
			}
		}
		
		//存數據庫
		AlbumPictureEntity entity = new AlbumPictureEntity();
		entity.setShopId(this.instance_id);
		entity.setAlbumId(albumId);
		entity.setIsWide(0);
		entity.setPicName(picName);
		entity.setPicTag(picTag);
		entity.setPicCover(this.relateveSourcePath);        //原图图片相对路径
		entity.setPicSize(this.fileSize+""); //原图大小
		entity.setPicSpec(width+","+height); //原图规格
		
		entity.setPicCoverBig(bigPath.getPath()); //大图路径
		entity.setPicSizeBig(bigPath.getWidth()+","+bigPath.getHeight()); //大图大小
		entity.setPicSpecBig(bigPath.getWidth()+","+bigPath.getHeight());    //大图规格
		
		entity.setPicCoverMid(middlePath.getPath());
		entity.setPicSizeMid(middlePath.getWidth()+","+middlePath.getHeight());
		entity.setPicSpecMid(middlePath.getWidth()+","+middlePath.getHeight());
		
		entity.setPicCoverSmall(smallPath.getPath());
		entity.setPicSizeSmall(smallPath.getWidth()+","+smallPath.getHeight());
		entity.setPicSpecSmall(smallPath.getWidth()+","+smallPath.getHeight());
		
		entity.setPicCoverMicro(littlePath.getPath());
		entity.setPicSizeMicro(littlePath.getWidth()+","+littlePath.getHeight());
		entity.setPicSpecMicro(littlePath.getWidth()+","+littlePath.getHeight());
		
		entity.setUploadTime((int)(System.currentTimeMillis() / 1000));
		
		entity.setUploadType(this.uploadType);
		entity.setFileSourceName(this.fileName);
		Integer retval = 0;
		if(picId == null) {
			albumPictureService.insert(entity);
			retval = entity.getPicId();
		}else {
			entity.setPicId(picId);
			retval = picId;
		}
		return retval;
	}

	/**
	 * 验证文件
	 * 
	 * @return
	 */
	private boolean validationFile() {
		// TODO Auto-generated method stub
		boolean flag = true;
		switch (this.filePath) {
		// 存放商品图片、主图、sku
		case "goods":
			if (!this.fileType.toUpperCase().equals(".GIF") && !this.fileType.toUpperCase().equals(".PNG")
					&& !this.fileType.toUpperCase().equals(".JPEG") && !this.fileType.toUpperCase().equals(".JPG")
					|| this.fileSize > 3000000) {
				this.message = "文件上传失败,请检查您上传的文件类型,文件大小不能超过3MB";
				flag = false;
			}
			break;
		case "goods_sku":
			// 商品SKU图片
			if (!this.fileType.toUpperCase().equals(".GIF") && !this.fileType.toUpperCase().equals(".PNG")
					&& !this.fileType.toUpperCase().equals(".JPEG") && !this.fileType.toUpperCase().equals(".JPG")
					|| this.fileSize > 1000000) {
				this.message = "文件上传失败,请检查您上传的文件类型,文件大小不能超过1MB";
				flag = false;
			}
			break;
		case "goods_brand":
			// 商品品牌
			if (!this.fileType.toUpperCase().equals(".GIF") && !this.fileType.toUpperCase().equals(".PNG")
					&& !this.fileType.toUpperCase().equals(".JPEG") && !this.fileType.toUpperCase().equals(".JPG")
					|| this.fileSize > 1000000) {
				this.message = "文件上传失败,请检查您上传的文件类型,文件大小不能超过1MB";
				flag = false;
			}
			break;
		case "goods_group":
			// 商品分组
			if (!this.fileType.toUpperCase().equals(".GIF") && !this.fileType.toUpperCase().equals(".PNG")
					&& !this.fileType.toUpperCase().equals(".JPEG") && !this.fileType.toUpperCase().equals(".JPG")
					|| this.fileSize > 1000000) {
				this.message = "文件上传失败,请检查您上传的文件类型,文件大小不能超过1MB";
				flag = false;
			}
			break;
		case "goods_category":
			// 商品分类
			if (!this.fileType.toUpperCase().equals(".GIF") && !this.fileType.toUpperCase().equals(".PNG")
					&& !this.fileType.toUpperCase().equals(".JPEG") && !this.fileType.toUpperCase().equals(".JPG")
					|| this.fileSize > 1000000) {
				this.message = "文件上传失败,请检查您上传的文件类型,文件大小不能超过1MB";
				flag = false;
			}
			break;
		case "uppload_common":
			// 公共
			if (!this.fileType.toUpperCase().equals(".GIF") && !this.fileType.toUpperCase().equals(".PNG")
					&& !this.fileType.toUpperCase().equals(".JPEG") && !this.fileType.toUpperCase().equals(".JPG")
					|| this.fileSize > 1000000) {
				this.message = "文件上传失败,请检查您上传的文件类型,文件大小不能超过1MB";
				flag = false;
			}
			break;
		case "upload_avator":
			// 用户头像
			if (!this.fileType.toUpperCase().equals(".GIF") && !this.fileType.toUpperCase().equals(".PNG")
					&& !this.fileType.toUpperCase().equals(".JPEG") && !this.fileType.toUpperCase().equals(".JPG")
					|| this.fileSize > 1000000) {
				this.message = "文件上传失败,请检查您上传的文件类型,文件大小不能超过1MB";
				flag = false;
			}
			break;
		case "upload_pay":
			// 支付
			if (!this.fileType.toUpperCase().equals(".GIF") && !this.fileType.toUpperCase().equals(".PNG")
					&& !this.fileType.toUpperCase().equals(".JPEG") && !this.fileType.toUpperCase().equals(".JPG")
					|| this.fileSize > 1000000) {
				this.message = "文件上传失败,请检查您上传的文件类型,文件大小不能超过1MB";
				flag = false;
			}
			break;
		case "upload_adv":
			// 广告位
			if (!this.fileType.toUpperCase().equals(".GIF") && !this.fileType.toUpperCase().equals(".PNG")
					&& !this.fileType.toUpperCase().equals(".JPEG") && !this.fileType.toUpperCase().equals(".JPG")
					|| this.fileSize > 1000000) {
				this.message = "文件上传失败,请检查您上传的文件类型,文件大小不能超过1MB";
				flag = false;
			}
			break;
		case "upload_express":
			// 物流
			if (!this.fileType.toUpperCase().equals(".GIF") && !this.fileType.toUpperCase().equals(".PNG")
					&& !this.fileType.toUpperCase().equals(".JPEG") && !this.fileType.toUpperCase().equals(".JPG")
					|| this.fileSize > 1000000) {
				this.message = "文件上传失败,请检查您上传的文件类型,文件大小不能超过1MB";
				flag = false;
			}
			break;
		case "upload_cms":
			// 文章
			if (!this.fileType.toUpperCase().equals(".GIF") && !this.fileType.toUpperCase().equals(".PNG")
					&& !this.fileType.toUpperCase().equals(".JPEG") && !this.fileType.toUpperCase().equals(".JPG")
					|| this.fileSize > 1000000) {
				this.message = "文件上传失败,请检查您上传的文件类型,文件大小不能超过1MB";
				flag = false;
			}
			break;
		case "upload_video":
			// 文章
			if (!this.fileType.toUpperCase().equals(".GIF") && !this.fileType.toUpperCase().equals(".PNG")
					&& !this.fileType.toUpperCase().equals(".JPEG") && !this.fileType.toUpperCase().equals(".JPG")
					|| this.fileSize > 500000000) {
				this.message = "文件上传失败,请检查您上传的文件类型,文件大小不能超过500MB";
				flag = false;
			}
			break;
		case "upload_comment":
			// 评论
			if (!this.fileType.toUpperCase().equals(".GIF") && !this.fileType.toUpperCase().equals(".PNG")
					&& !this.fileType.toUpperCase().equals(".JPEG") && !this.fileType.toUpperCase().equals(".JPG")) {
				this.message = "文件上传失败,请检查您上传的文件类型";
				flag = false;
			}
			break;
		case "goods_video_path":
			// 商品视频
			if (!this.fileType.toUpperCase().equals(".MP4") || this.fileSize > 500000000) {
				this.message = "文件上传失败,请检查您上传的文件类型,文件大小不能超过500MB";
				flag = false;
			}
			break;
		case "upload_file":
			// 存放文件
			if (this.fileSize > 500000000) {
				this.message = "文件上传失败,请检查您上传的文件类型,文件大小不能超过500MB";
				flag = false;
			}
			break;
		default:
			this.message = "不存在的文件类型";
			flag = false;
			break;
		}
		return flag;
	}
	

	
}

/**
 * 待处理图片类
 * @author Mr.Yan
 *
 */
class photo {
	private String path;     //处理后图片相对路径
	private int width;
	private int height;    
	private String newFileName;    //新文件名


	public String getNewFileName() {
		return newFileName;
	}

	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
