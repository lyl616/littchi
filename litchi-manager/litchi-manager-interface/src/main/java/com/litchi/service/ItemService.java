package com.litchi.service;

import com.litchi.pojo.EzUIDataGridResult;
import com.litchi.pojo.Item;
import com.litchi.utils.LitchiMsgUtils;

public interface ItemService {
	
	Item getItemById(Long itemId);

	EzUIDataGridResult getItemList(int pageNum, int rows);

	LitchiMsgUtils saveItem(Item item, String desc);
}
