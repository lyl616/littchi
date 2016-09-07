package com.litchi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.litchi.content.service.ContentService;
import com.litchi.pojo.Content;
import com.litchi.utils.LitchiMsgUtils;

@Controller
@RequestMapping("/content")
public class CategoryController {

	@Autowired
	private ContentService contentService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public LitchiMsgUtils addContent(Content content) {
		return this.contentService.addContent(content);
	}

}
