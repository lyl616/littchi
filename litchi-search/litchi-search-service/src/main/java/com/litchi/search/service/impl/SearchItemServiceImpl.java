package com.litchi.search.service.impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litchi.search.mapper.SearchItemMapper;
import com.litchi.search.pojo.SearchItem;
import com.litchi.search.service.SearchItemService;
import com.litchi.utils.LitchiMsgUtils;

@Service
public class SearchItemServiceImpl implements SearchItemService {

	@Autowired
	private SearchItemMapper searchItemMapper;

	@Autowired
	private SolrServer solrServer;

	@Override
	public LitchiMsgUtils importItemToIndex() throws Exception {
		// 查询商品列表
		List<SearchItem> itemList = this.searchItemMapper.getItemList();
		// 将商品导入 solr
		for (SearchItem item : itemList) {
			SolrInputDocument document = new SolrInputDocument();
			document.addField("id", item.getId());
			document.addField("item_title", item.getTitle());
			document.addField("item_sell_point", item.getSell_point());
			document.addField("item_price", item.getPrice());
			document.addField("item_image", item.getImage());
			document.addField("item_category_name", item.getCategory_name());
			// 将文档写稿索引
			solrServer.add(document);
		}
		// 提交修改
		solrServer.commit();
		return LitchiMsgUtils.ok();
	}

}
