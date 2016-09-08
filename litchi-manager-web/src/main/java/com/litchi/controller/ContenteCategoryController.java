package com.litchi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.litchi.content.service.ContentCategoryService;
import com.litchi.pojo.EzUITreNode;
import com.litchi.utils.LitchiMsgUtils;

/**
 * 
 * @author YuLong
 *
 */
@Controller
@RequestMapping("/content/category")
public class ContenteCategoryController {

	@Autowired
	private ContentCategoryService contentCategoryService;

	@RequestMapping("/list")
	@ResponseBody
	public List<EzUITreNode> getContentCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
		List<EzUITreNode> list = contentCategoryService.getContentCatList(parentId);
		return list;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public LitchiMsgUtils createNode(Long parentId, String name) {
		LitchiMsgUtils result = contentCategoryService.addCategoryNode(parentId, name);
		return result;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public LitchiMsgUtils deleteContentCategory(Long parentId, Long id) {
		LitchiMsgUtils result = contentCategoryService.delCategoryNode(parentId, id);
		return result;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public LitchiMsgUtils updateContentCategory(Long id, String name) {
		LitchiMsgUtils result = contentCategoryService.updateContentCategory(id, name);
		return result;
	}
	

}
