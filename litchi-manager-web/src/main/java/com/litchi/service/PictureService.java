package com.litchi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.litchi.utils.FastDFSClient;


@Service
public class PictureService  {

	@Value("${IMAGE_SERVER_URL}")
	private String ImageServerURL;

	public  Map<String, Object> uploadFile(MultipartFile uploadFile) {
		Map<String, Object> map = new HashMap<>();
		try {
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
			String originalFilename = uploadFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			String uploadFile2 = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
			map.put("error", 0);
			map.put("url", ImageServerURL + uploadFile2);
		} catch (Exception e) {
			map.put("error", 1);
			map.put("url", "");
			map.put("message", "上传失败");
			e.printStackTrace();
		}
		return map;
	}
}
