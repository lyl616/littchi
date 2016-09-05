package com.litchi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.litchi.service.PictureService;
import com.litchi.utils.JsonUtils;

@Controller
public class PictureController  {

	@Autowired
	private PictureService pictureService;

	@RequestMapping("/pic/upload")
	@ResponseBody
	public String uploadFile(MultipartFile uploadFile) {
		Map<String, Object> uploadFile2 = pictureService.uploadFile(uploadFile);
		return JsonUtils.objectToJson(uploadFile2);
	}
}
