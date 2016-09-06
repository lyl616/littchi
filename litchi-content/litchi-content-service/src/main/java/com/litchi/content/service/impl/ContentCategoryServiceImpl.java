package com.litchi.content.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.litchi.content.service.ContentCategoryService;
import com.litchi.mapper.ContentCategoryMapper;
import com.litchi.pojo.ContentCategory;
import com.litchi.pojo.ContentCategoryExample;
import com.litchi.pojo.ContentCategoryExample.Criteria;
import com.litchi.pojo.EasyUITreeNode;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private ContentCategoryMapper contentCategoryMapper;

	@Override
	public List<EasyUITreeNode> getContentCategoryList(Long parentId) {
		// 查询 列表节点
		ContentCategoryExample example = new ContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		// 执行查询
		List<ContentCategory> list = this.contentCategoryMapper.selectByExample(example);
		List<EasyUITreeNode> result = new ArrayList<>();
		for (ContentCategory category : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(category.getId());
			node.setText(category.getName());
			node.setState(category.getIsParent() ? "closed" : "open");
			result.add(node);
		}

		return result;
	}

}
