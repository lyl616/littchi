package com.litchi.service;

import java.util.List;

import com.litchi.pojo.EzUITreNode;

public interface ItemCatService {
	List<EzUITreNode> getItemCatList(Long parentId);
}
