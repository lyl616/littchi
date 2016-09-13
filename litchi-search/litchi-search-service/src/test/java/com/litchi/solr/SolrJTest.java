package com.litchi.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrJTest {

	@Test
	public void testAddDocument() throws Exception {
		// 1、创建一个SolrServer对象，使用HttpSolrServer。
		SolrServer solrServer = new HttpSolrServer("http://192.168.224.112:8080/solr/collection1");
		// 2、创建一个SolrInputDocument对象。
		SolrInputDocument solrInputDocument = new SolrInputDocument();
		// 3、向文档中添加域
		// 文档中必须有id域，域名称必须在schema.xml中定义
		solrInputDocument.addField("id", "test001");
		solrInputDocument.addField("item_title", "测试商品");
		solrInputDocument.addField("item_price", 1000);
		// 4、把文档对象写入索引库
		solrServer.add(solrInputDocument);
		// 5、提交。
		solrServer.commit();

	}

	@Test
	public void searchDocument() throws Exception {
		SolrServer server = new HttpSolrServer("http://192.168.224.112:8080/solr");
		// 查询条件
		SolrQuery query = new SolrQuery();
		// query.setQuery("dkdk");
		query.set("q", "item_title:测试");
		// 执行查询
		QueryResponse response = server.query(query);
		// 取查询结果列表
		SolrDocumentList solrDocumentList = response.getResults();
		System.out.println("共查询到结果：" + solrDocumentList.getNumFound());
		for (SolrDocument solrDocument : solrDocumentList) {
			System.out.println(solrDocument.get("id"));
			System.out.println(solrDocument.get("item_title"));
			System.out.println(solrDocument.get("item_price"));
		}
	}

}
