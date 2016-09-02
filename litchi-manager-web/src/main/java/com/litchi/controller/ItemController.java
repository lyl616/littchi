package com.litchi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.litchi.pojo.EzUIDataGridResult;
import com.litchi.pojo.Item;
import com.litchi.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public Item query(@PathVariable Long itemId) {
		return this.itemService.getItemByItemId(itemId);
	}

	@RequestMapping("/item/list")
	@ResponseBody
	public EzUIDataGridResult getItemList(Integer page, Integer rows) {
		EzUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
}
