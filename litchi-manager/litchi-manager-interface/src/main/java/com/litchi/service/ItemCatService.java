package com.litchi.service;

import java.util.List;

import com.litchi.pojo.ItemCat;

public interface ItemCatService {
	List<ItemCat> getItemCatList(Long parentId);
}
