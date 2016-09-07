package com.litchi.content.service;

import java.util.List;

import com.litchi.pojo.EasyUITreeNode;

public interface ContentCategoryService {
	List<EasyUITreeNode> getContentCatList(Long parentId);
}
