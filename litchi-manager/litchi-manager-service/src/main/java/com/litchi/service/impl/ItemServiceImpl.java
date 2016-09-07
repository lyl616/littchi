package com.litchi.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litchi.mapper.ItemDescMapper;
import com.litchi.mapper.ItemMapper;
import com.litchi.pojo.EzUIDataGridResult;
import com.litchi.pojo.Item;
import com.litchi.pojo.ItemDesc;
import com.litchi.pojo.ItemExample;
import com.litchi.service.ItemService;
import com.litchi.utils.IDUtils;
import com.litchi.utils.LitchiMsgUtils;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper itemMapper;

	@Autowired
	private ItemDescMapper itemDescMapper;

	@Override
	public Item getItemById(Long itemId) {
		return this.itemMapper.selectByPrimaryKey(itemId);
	}

	@Override
	public EzUIDataGridResult getItemList(int pageNum, int pageSize) {
		ItemExample example = new ItemExample();
		// 分页查询
		PageHelper.startPage(pageNum, pageSize);
		List<Item> list = itemMapper.selectByExample(example);
		PageInfo<Item> pageInfo = new PageInfo<>(list);
		EzUIDataGridResult resutl = new EzUIDataGridResult();
		resutl.setTotal(pageInfo.getTotal());
		resutl.setRows(list);
		return resutl;
	}

	@Override
	public LitchiMsgUtils saveItem(Item item, String desc) {
		// 1、生成商品id
		long itemId = IDUtils.genItemId();
		// 2、对TbItem对象补全属性。
		item.setId(itemId);
		// '商品状态，1-正常，2-下架，3-删除'
		item.setStatus((byte) 1);
		Date date = new Date();
		item.setCreated(date);
		item.setUpdated(date);
		// 3、向商品表插入数据。
		itemMapper.insert(item);
		// 4、创建一个商品描述表对应的pojo对象。
		ItemDesc itemDesc = new ItemDesc();
		// 5、补全属性
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		// 6、插入商品描述
		itemDescMapper.insert(itemDesc);
		// 7、返回TaotaoResult
		return LitchiMsgUtils.ok();

	}

}
