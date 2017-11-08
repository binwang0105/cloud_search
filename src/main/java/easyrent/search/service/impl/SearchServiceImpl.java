package easyrent.search.service.impl;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import easyrent.search.dao.SearchDao;
import easyrent.search.pojo.SearchResult;
import easyrent.search.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchDao searchDao;
	@Override
	public SearchResult search(String queryString, int page, int rows) throws Exception {
		SolrQuery query = new SolrQuery();
		query.setQuery(queryString);
		query.setStart((page - 1) * rows);
		query.setRows(rows);
		query.set("df", "home_keywords");
		query.setHighlight(true);
		query.addHighlightField("home_name");
		query.setHighlightSimplePre("<em style=\"color:red\">");
		query.setHighlightSimplePost("</em>");
		SearchResult searchResult = searchDao.search(query);
		long recordCount = searchResult.getRecordCount();
		long pageCount = recordCount / rows;
		if (recordCount % rows > 0) {
			pageCount++;
		}
		searchResult.setPageCount(pageCount);
		searchResult.setCurPage(page);
		
		return searchResult;
	}

}
