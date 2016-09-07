package com.litchi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litchi.mapper.ItemCatMapper;
import com.litchi.pojo.EzUITreNode;
import com.litchi.pojo.ItemCat;
import com.litchi.pojo.ItemCatExample;
import com.litchi.pojo.ItemCatExample.Criteria;
import com.litchi.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private ItemCatMapper itemCatMapper;

	@Override
	public List<EzUITreNode> getItemCatList(Long parentId) {

		// 根据parentId查询子节点列表
		// 设置查询条件
		ItemCatExample example = new ItemCatExample();
		// 设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		// '状态。可选值:1(正常),2(删除)'
		criteria.andStatusEqualTo(1);
		// 执行查询
		List<ItemCat> list = itemCatMapper.selectByExample(example);
		// 转换成EasyUITreeNode列表
		List<EzUITreNode> nodeList = new ArrayList<>();
		for (ItemCat ItemCat : list) {
			EzUITreNode node = new EzUITreNode();
			node.setId(ItemCat.getId());
			node.setText(ItemCat.getName());
			// 节点状态，'open' 或 'closed'
			node.setState(ItemCat.getIsParent() ? "closed" : "open");
			nodeList.add(node);
		}
		// //返回子节点列表
		return nodeList;
	}

}
