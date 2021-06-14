package com.jiudian.modules.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.modules.ueditor.ActionEnter;

@RestController
@RequestMapping("/ueditor")
public class AppUeditorController {

	@RequestMapping("/ueditorUpload")
	public void ueditorUpload(HttpServletRequest request, HttpServletResponse response, String action)
			throws IOException {
		response.setContentType("application/json");
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		String exec = new ActionEnter(request, rootPath).exec();
		PrintWriter writer = response.getWriter();
		writer.write(exec);
		writer.flush();
		writer.close();
	}
}
