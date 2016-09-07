package com.litchi.content.service;

import java.util.List;

import com.litchi.pojo.EzUITreNode;
import com.litchi.utils.LitchiMsgUtils;

public interface ContentCategoryService {

	List<EzUITreNode> getContentCatList(Long parentId);

	LitchiMsgUtils addCategoryNode(long parentId, String name);
}
