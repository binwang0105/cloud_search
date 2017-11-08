package easyrent.search.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import easyrent.search.dao.SearchDao;
import easyrent.search.pojo.Home;
import easyrent.search.pojo.SearchResult;

@Repository
public class SearchDaoImpl implements SearchDao {
	
	@Autowired
	private SolrServer solrServer;

	@Override
	public SearchResult search(SolrQuery query) throws Exception {
		SearchResult result = new SearchResult();
		QueryResponse queryResponse = solrServer.query(query);
		SolrDocumentList solrDocumentList = queryResponse.getResults();
		result.setRecordCount(solrDocumentList.getNumFound());
		List<Home> homeList = new ArrayList<>();
		Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
		for (SolrDocument solrDocument : solrDocumentList) {
			Home home = new Home();
			home.setId((String) solrDocument.get("id"));
			List<String> list = highlighting.get(solrDocument.get("id")).get("home_name");
			String name = "";
			if (list != null && list.size()>0) {
				name = list.get(0);
			} else {
				name = (String) solrDocument.get("home_name");
			}
			home.setName(name);
			home.setImage((String) solrDocument.get("home_image"));
			home.setBed((long) solrDocument.get("home_bed"));
			home.setBath((long) solrDocument.get("home_bath"));
			home.setPrice((long) solrDocument.get("home_price"));
			home.setAddress((String) solrDocument.get("home_address"));
			home.setCategory_name((String) solrDocument.get("home_category_name"));
			homeList.add(home);
		}
		result.setHomeList(homeList);
		return result;
	}

}
