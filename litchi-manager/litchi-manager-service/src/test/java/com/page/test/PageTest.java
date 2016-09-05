package com.page.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litchi.mapper.ItemMapper;
import com.litchi.pojo.Item;
import com.litchi.pojo.ItemExample;

public class PageTest {

	
	public  void test( ) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		ItemMapper itemMapper = applicationContext.getBean(ItemMapper.class);
		PageHelper.startPage(1, 30);
		ItemExample itemExample=new ItemExample();
		List<Item> selectByExample = itemMapper.selectByExample(itemExample);
		PageInfo<Item> list=new PageInfo<>(selectByExample);
		System.out.println("总页数："+list.getPages());
		System.out.println("总数量："+list.getTotal());
		System.out.println("当前页码："+list.getPageNum());
		System.out.println("每页数量："+list.getPageSize());
	}

}
