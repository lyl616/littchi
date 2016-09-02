package com.litchi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.litchi.pojo.ItemCat;
import com.litchi.service.ItemCatService;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;

	@RequestMapping("/list")
	@ResponseBody
	public List<Map<String, Object>> categoryList(@RequestParam(value = "id", defaultValue = "0") Long parentId) throws Exception {
		List<ItemCat> itemCatList = this.itemCatService.getItemCatList(parentId);
		List<Map<String, Object>> catList = new ArrayList<Map<String, Object>>();
		for (ItemCat itemCat : itemCatList) {
			Map<String, Object> node = new HashMap<String, Object>();
			node.put("id", itemCat.getId());
			node.put("text", itemCat.getName());
			// 如果是父节点的话就设置成关闭状态，如果是叶子节点就是open状态
			node.put("state", itemCat.getIsParent() ? "closed" : "open");
			catList.add(node);
		}
		return catList;
	}

}
