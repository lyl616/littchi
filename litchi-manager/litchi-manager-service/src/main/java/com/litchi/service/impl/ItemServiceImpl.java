package com.litchi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litchi.mapper.ItemMapper;
import com.litchi.pojo.EzUIDataGridResult;
import com.litchi.pojo.Item;
import com.litchi.pojo.ItemExample;
import com.litchi.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper itemMapper;

	@Override
	public Item getItemByItemId(Long itemId) {
		return this.itemMapper.selectByPrimaryKey(itemId);
	}

	@Override
	public EzUIDataGridResult getItemList(int pageNum, int pageSize) {
		ItemExample example = new ItemExample();
		PageHelper.startPage(pageNum, pageSize);
		List<Item> list = itemMapper.selectByExample(example);
		PageInfo<Item> pageInfo = new PageInfo<>(list);

		EzUIDataGridResult resutl = new EzUIDataGridResult();
		resutl.setTotal(pageInfo.getTotal());
		resutl.setRows(list);
		return resutl;
	}

}
