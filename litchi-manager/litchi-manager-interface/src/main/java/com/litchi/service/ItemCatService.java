package com.litchi.service;

import java.util.List;

import com.litchi.pojo.EasyUITreeNode;

public interface ItemCatService {
	List<EasyUITreeNode> getItemCatList(Long parentId);
}
