package com.litchi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.litchi.pojo.EzUIDataGridResult;
import com.litchi.pojo.Item;
import com.litchi.service.ItemService;
import com.litchi.utils.LitchiMsgUtils;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public Item getItemById(@PathVariable Long itemId) {
		return this.itemService.getItemById(itemId);
	}

	@RequestMapping("/item/list")
	@ResponseBody
	public EzUIDataGridResult getItemList(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "30") Integer rows) {
		return this.itemService.getItemList(page, rows);
	}
	
	@RequestMapping("/item/save")
	@ResponseBody
	public LitchiMsgUtils saveItem(Item item,String desc) {
		return this.itemService.saveItem(item, desc);
	}
}
