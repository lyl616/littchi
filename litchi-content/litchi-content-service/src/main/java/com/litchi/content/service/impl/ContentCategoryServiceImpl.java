package com.litchi.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litchi.content.service.ContentCategoryService;
import com.litchi.mapper.ContentCategoryMapper;
import com.litchi.pojo.ContentCategory;
import com.litchi.pojo.ContentCategoryExample;
import com.litchi.pojo.ContentCategoryExample.Criteria;
import com.litchi.pojo.EzUITreNode;
import com.litchi.utils.LitchiMsgUtils;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	ContentCategoryMapper contentCategoryMapper;

	@Override
	public List<EzUITreNode> getContentCatList(Long parentId) {
		// 查询节点列表
		ContentCategoryExample example = new ContentCategoryExample();
		// 设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		// 执行查询
		List<ContentCategory> list = contentCategoryMapper.selectByExample(example);
		List<EzUITreNode> resultList = new ArrayList<>();
		for (ContentCategory contentCategory : list) {
			EzUITreNode node = new EzUITreNode();
			node.setId(contentCategory.getId());
			node.setText(contentCategory.getName());
			// 如果此节点下有子节点那就是“closed”，如果没有子节点就是“open”
			node.setState(contentCategory.getIsParent() ? "closed" : "open");

			resultList.add(node);
		}
		return resultList;

	}

	@Override
	public LitchiMsgUtils addCategoryNode(long parentId, String name) {
		// 1、创建对应_content_category表的pojo
		ContentCategory contentCategory = new ContentCategory();
		// 2、补全其他属性
		contentCategory.setName(name);
		contentCategory.setParentId(parentId);
		// 节点排序序号
		contentCategory.setSortOrder(1);
		// 可选值:1(正常),2(删除)
		contentCategory.setStatus(1);
		contentCategory.setIsParent(false);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		// 3、插入数据
		contentCategoryMapper.insert(contentCategory);
		// 判断父节点的isparent，如果为false，更新为true
		ContentCategory parentNode = contentCategoryMapper.selectByPrimaryKey(parentId);
		if (!parentNode.getIsParent()) {
			parentNode.setIsParent(true);
			// 更新数据库
			contentCategoryMapper.updateByPrimaryKey(parentNode);
		}
		// 使用LitchiResult包装ContentCategory对象返回
		return LitchiMsgUtils.ok(contentCategory);

	}

	@Override
	public LitchiMsgUtils delCategoryNode(Long parentId, Long id) {
		return null;
	}

	@Override
	public LitchiMsgUtils updateContentCategory(Long id, String name) {
		
		ContentCategory record=new ContentCategory();
		record.setId(id);
		record.setName(name);
		this.contentCategoryMapper.updateByPrimaryKey(record);
		return LitchiMsgUtils.ok();
	}

}
