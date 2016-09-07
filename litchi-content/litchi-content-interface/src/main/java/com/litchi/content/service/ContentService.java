package com.litchi.content.service;

import java.util.List;

import com.litchi.pojo.Content;
import com.litchi.pojo.EzUIDataGridResult;
import com.litchi.utils.LitchiMsgUtils;

public interface ContentService {
	
	List<EzUIDataGridResult> getContentList(Long categoryId);

	LitchiMsgUtils addContent(Content content);
}
