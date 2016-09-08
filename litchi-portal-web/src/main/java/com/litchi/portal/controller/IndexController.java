package com.litchi.portal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.litchi.content.service.ContentService;
import com.litchi.pojo.Content;
import com.litchi.portal.pojo.AdNode;
import com.litchi.utils.JsonUtils;

@Controller
public class IndexController {

	@Autowired
	private ContentService contentService;

	@Value("${AD1_CID}")
	private Long AD1_CID;
	@Value("${AD1_HEIGHT}")
	private Integer AD1_HEIGHT;
	@Value("${AD1_WIDTH}")
	private Integer AD1_WIDTH;
	@Value("${AD1_HEIGHT_B}")
	private Integer AD1_HEIGHT_B;
	@Value("${AD1_WIDTH_B}")
	private Integer AD1_WIDTH_B;

	@RequestMapping("/index")
	public String showIndex(Model model) {
		// 1、需要从配置文件中取cid
		// 2、调用服务查询内容列表
		List<Content> ad1List = contentService.getContentListByCid(AD1_CID);
		List<AdNode> adNodes = new ArrayList<>();
		// 3、把TbContent列表转换成AdNode列表。
		for (Content tbContent : ad1List) {
			AdNode adNode = new AdNode();
			adNode.setHeight(AD1_HEIGHT);
			adNode.setWidth(AD1_WIDTH);
			adNode.setHeightB(AD1_HEIGHT_B);
			adNode.setWidthB(AD1_WIDTH_B);
			adNode.setAlt(tbContent.getSubTitle());
			adNode.setSrc(tbContent.getPic());
			adNode.setSrcB(tbContent.getPic2());
			adNode.setHref(tbContent.getUrl());
			adNodes.add(adNode);
		}
		// 4、把AdNode列表转换成json字符串。
		String ad1Json = JsonUtils.objectToJson(adNodes);
		System.out.println("ad1Json:"+ad1Json);
		// 5、使用Model传递json字符串给jsp。
		model.addAttribute("ad1", ad1Json);

		return "index";

	}

}
