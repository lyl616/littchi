package com.litchi.content.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	public LitchiMsgUtils addContent(Content content) {
		content.setCreated(new Date());
		content.setUpdated(new Date());
		// 插入数据
		contentMapper.insert(content);
		return LitchiMsgUtils.ok();
	}

	@Override
	public EzUIDataGridResult listContent(Integer page, Integer rows, Long categoryId) {
		// // 查询节点列表
		ContentExample example = new ContentExample();
		Criteria criteria = example.createCriteria();
		// // 根据category_id查询内容列表
		criteria.andCategoryIdEqualTo(categoryId);
		// 分页处理
		PageHelper.startPage(page, rows);
		List<Content> list = contentMapper.selectByExample(example);
		// 取分页信息
		PageInfo<Content> pageInfo = new PageInfo<>(list);
		return new EzUIDataGridResult(pageInfo.getTotal(), list);
	}

}
