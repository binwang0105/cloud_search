package easyrent.search.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import easyrent.common.pojo.EasyrentResult;
import easyrent.common.utils.ExceptionUtil;
import easyrent.search.pojo.SearchResult;
import easyrent.search.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@RequestMapping(value="/query", method=RequestMethod.GET)
	@ResponseBody
	public EasyrentResult search(@RequestParam("q")String queryString, 
			@RequestParam(defaultValue="1")Integer page, 
			@RequestParam(defaultValue="60")Integer rows) {

		if (StringUtils.isBlank(queryString)) {
			return EasyrentResult.build(400, "Null Error");
		}
		SearchResult searchResult = null;
		try {
			searchResult = searchService.search(queryString, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			return EasyrentResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return EasyrentResult.ok(searchResult);
	}
}
