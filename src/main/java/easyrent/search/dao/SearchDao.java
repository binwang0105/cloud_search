package easyrent.search.dao;
import org.apache.solr.client.solrj.SolrQuery;
import easyrent.search.pojo.SearchResult;

public interface SearchDao {
	SearchResult search(SolrQuery query) throws Exception;
}
