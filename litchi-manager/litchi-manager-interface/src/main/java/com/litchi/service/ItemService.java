package com.litchi.service;

import com.litchi.pojo.EasyUIResult;
import com.litchi.pojo.Item;
import com.litchi.utils.LitchiResult;

public interface ItemService {
	Item getItemById(Long itemId);
	EasyUIResult getItemList(int pageNum,int rows);
	LitchiResult saveItem(Item item, String desc);
}
