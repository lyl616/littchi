package com.litchi.content.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litchi.content.service.ContentCategoryService;
import com.litchi.mapper.ContentCategoryMapper;
import com.litchi.pojo.ContentCategory;
import com.litchi.pojo.ContentCategoryExample;
import com.litchi.pojo.ContentCategoryExample.Criteria;
import com.litchi.pojo.EasyUITreeNode;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	ContentCategoryMapper contentCategoryMapper;

	@Override
	public List<EasyUITreeNode> getContentCatList(Long parentId) {
		// 查询节点列表
		ContentCategoryExample example = new ContentCategoryExample();
		// 设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		// 执行查询
		List<ContentCategory> list = contentCategoryMapper.selectByExample(example);
		List<EasyUITreeNode> resultList = new ArrayList<>();
		for (ContentCategory tbContentCategory : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			// 如果此节点下有子节点那就是“closed”，如果没有子节点就是“open”
			node.setState(tbContentCategory.getIsParent() ? "closed" : "open");

			resultList.add(node);
		}
		return resultList;

	}

}
