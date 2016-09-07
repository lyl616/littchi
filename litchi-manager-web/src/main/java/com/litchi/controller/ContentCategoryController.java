package com.litchi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.litchi.content.service.ContentCategoryService;
import com.litchi.pojo.EasyUITreeNode;

@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

	@Autowired
	private ContentCategoryService contentCategoryService;
	
	@RequestMapping("/list")
	@ResponseBody
	List<EasyUITreeNode> getContentCatList(@RequestParam(value="id",defaultValue="0")Long parentId){
		return this.contentCategoryService.getContentCatList(parentId);
	};
}
