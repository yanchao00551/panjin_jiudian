package com.jiudian.modules.ueditor.upload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.jiudian.modules.ueditor.PathFormat;
import com.jiudian.modules.ueditor.define.BaseState;
import com.jiudian.modules.ueditor.define.State;


public class BinaryUploader {

	public static final State save(HttpServletRequest request,
			Map<String, Object> conf) {
		boolean isAjaxUpload = request.getHeader("X_Requested_With") != null;  
        if (!ServletFileUpload.isMultipartContent(request)) {  
            return new BaseState(false, 5);  
        }  
        ServletFileUpload upload = new ServletFileUpload(  
                new DiskFileItemFactory());  
        if (isAjaxUpload) {  
            upload.setHeaderEncoding("UTF-8");  
        }  
        try {  
            String savePath = "/root/application/imgroot/static/ueditor/jsp/upload/image/";  
//            String saveUrl  = request.getContextPath() + "/ueditor/";
            String saveUrl  = request.getContextPath() + "/ueditor/";  
              
            //上传附件目录  
            Path path = Paths.get(savePath);  
            if(!Files.isDirectory(path)){  
                try {  
                    Files.createDirectories(path);  
                } catch (IOException e) {  
//                    logger.error("百度上传附件创建上传文件夹错误： {}", e.getMessage());  
                }  
            }  
            //重新命名文件名字  
            String newFileName = "", fileExt = "", fileName = "";  
            CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());  
            //检查form中是否有enctype="multipart/form-data"  
            if(multipartResolver.isMultipart(request)) {  
                //将request变成多部分request  
                MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;  
                //获取multiRequest 中所有的文件名  
                Iterator<String>it=multiRequest.getFileNames();  
                //遍历文件  
                while(it.hasNext()) {  
                    MultipartFile file=multiRequest.getFile(it.next().toString());  
                    if(file != null){  
                        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");  
                        fileName = file.getOriginalFilename();  
                        fileExt = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();  
                        //新文件名称  
                        newFileName = savePath + df.format(new Date()) + fileExt;  
                        saveUrl = saveUrl + df.format(new Date())  + fileExt;  
                        if (!validType(fileExt, (String[])conf.get("allowFiles"))) {  
                            return new BaseState(false, 8);  
                          }  
                        try {  
                            //上传文件  
                            file.transferTo(new File(newFileName));  
                        } catch (IllegalStateException | IOException e) {  
//                            logger.error("百度上传附件保存文件错误： {}", e.getMessage());  
                        }  
                    }  
                }  
            }  
            State storageState = new BaseState(Boolean.TRUE);  
            if (storageState.isSuccess()) {  
                storageState.putInfo("url", PathFormat.format(saveUrl));  
                storageState.putInfo("type", fileExt);  
                storageState.putInfo("original", fileName);  
            }  
            return storageState;  
        } catch (Exception e) {  
        	e.printStackTrace();
//            logger.error("百度上传附件文件错误： {}", e.getMessage());  
        }  
        return new BaseState(false, 4);  
	}

	private static boolean validType(String type, String[] allowTypes) {
		List<String> list = Arrays.asList(allowTypes);

		return list.contains(type);
	}
}
