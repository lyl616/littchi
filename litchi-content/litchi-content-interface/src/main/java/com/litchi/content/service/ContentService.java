package com.litchi.content.service;

import java.util.List;

import com.litchi.pojo.Content;
import com.litchi.pojo.EzUIDataGridResult;
import com.litchi.utils.LitchiMsgUtils;

public interface ContentService {

	EzUIDataGridResult listContent(Integer page, Integer rows, Long categoryId);

	LitchiMsgUtils addContent(Content content);

	List<Content> getContentListByCid(long cid);

}
