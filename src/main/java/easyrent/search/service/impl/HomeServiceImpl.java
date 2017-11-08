package easyrent.search.service.impl;
import java.io.IOException;
import java.util.List;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import easyrent.common.pojo.EasyrentResult;
import easyrent.common.utils.ExceptionUtil;
import easyrent.search.mapper.HomeMapper;
import easyrent.search.pojo.Home;
import easyrent.search.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private HomeMapper homeMapper;
	
	@Autowired
	private SolrServer solrServer;
	
	@Override
	public EasyrentResult importAllHomes() {
		try {
			List<Home> list = homeMapper.getHomeList();
			for (Home home : list) {
				SolrInputDocument document = new SolrInputDocument();
				document.setField("id", home.getId());
				document.setField("home_name", home.getName());
				document.setField("home_address", home.getAddress());
				document.setField("home_bed", home.getBed());
				document.setField("home_bath", home.getBath());
				document.setField("home_price", home.getPrice());
				document.setField("home_image", home.getImage());
				document.setField("home_category_name", home.getCategory_name());
				document.setField("home_desc", home.getHome_desc());
				solrServer.add(document);
			}
			solrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return EasyrentResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return EasyrentResult.ok();
	}

}
