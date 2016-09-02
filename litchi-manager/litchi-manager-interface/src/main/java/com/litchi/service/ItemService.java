package com.litchi.service;

import com.litchi.pojo.EzUIDataGridResult;
import com.litchi.pojo.Item;

public interface ItemService {
	public Item getItemByItemId(Long itemId);
	public EzUIDataGridResult  getItemList(int pageNum,int pageSize);
}
