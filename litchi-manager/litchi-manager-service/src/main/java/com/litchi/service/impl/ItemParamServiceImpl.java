package com.litchi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litchi.mapper.ItemParamMapper;
import com.litchi.pojo.EzUIDataGridResult;
import com.litchi.pojo.ItemParam;
import com.litchi.pojo.ItemParamExample;
import com.litchi.service.ItemParamService;

@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private ItemParamMapper itemParamMapper;

	@Override
	public EzUIDataGridResult getItemParamList(int pageNum, int rows) {
		ItemParamExample example = new ItemParamExample();
		PageHelper.startPage(pageNum, rows);
		List<ItemParam> list = this.itemParamMapper.selectByExample(example);
		PageInfo<ItemParam> pageInfo = new PageInfo<>(list);
		return new EzUIDataGridResult(pageInfo.getTotal(), list);
	}

}
