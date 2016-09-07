package com.litchi.content.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litchi.content.service.ContentService;
import com.litchi.mapper.ContentMapper;
import com.litchi.pojo.Content;
import com.litchi.pojo.ContentExample;
import com.litchi.pojo.ContentExample.Criteria;
import com.litchi.pojo.EzUIDataGridResult;
import com.litchi.utils.LitchiMsgUtils;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentMapper contentMapper;

	@Override
	public List<EzUIDataGridResult> getContentList(Long categoryId) {
		// 查询节点列表
		ContentExample example = new ContentExample();
		// 设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		// 执行查询
		// List<Content> list = contentMapper.selectByExample(example);
		// List<EasyUITreeNode> resultList = new ArrayList<>();
		// PageHelper.startPage(pageNum, pageSize);
		// List<Item> list = itemMapper.selectByExample(example);
		// PageInfo<Item> pageInfo = new PageInfo<>(list);
		// EasyUIResult resutl = new EasyUIResult();
		// resutl.setTotal(pageInfo.getTotal());
		// resutl.setRows(list);
		// return resultList;
		return null;
	}

	@Override
	public LitchiMsgUtils addContent(Content content) {
		content.setCreated(new Date());
		content.setUpdated(new Date());
		// 插入数据
		contentMapper.insert(content);
		return LitchiMsgUtils.ok();
	}

}
