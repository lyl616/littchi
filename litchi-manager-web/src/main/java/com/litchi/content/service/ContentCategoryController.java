package com.litchi.content.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.litchi.pojo.EasyUITreeNode;

@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

	@Autowired
	private ContentCategoryService contentCategoryService;

	@RequestMapping
	@ResponseBody
	public List<EasyUITreeNode> getContentCategotyList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
		return this.contentCategoryService.getContentCategoryList(parentId);
	}

}
