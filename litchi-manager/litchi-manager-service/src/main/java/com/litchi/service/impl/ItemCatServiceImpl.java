package com.litchi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litchi.mapper.ItemCatMapper;
import com.litchi.pojo.ItemCat;
import com.litchi.pojo.ItemCatExample;
import com.litchi.pojo.ItemCatExample.Criteria;
import com.litchi.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private ItemCatMapper itemCatMapper;

	@Override
	public List<ItemCat> getItemCatList(Long parentId) {
		ItemCatExample example = new ItemCatExample();
		//设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//返回子节点列表
		List<ItemCat> list = this.itemCatMapper.selectByExample(example);
		return list;
	}

}
