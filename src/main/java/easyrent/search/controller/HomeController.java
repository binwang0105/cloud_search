package easyrent.search.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import easyrent.common.pojo.EasyrentResult;
import easyrent.search.service.HomeService;

@Controller
@RequestMapping("/manager")
public class HomeController {
	
	@Autowired
	private HomeService homeService;

	@RequestMapping("/importall")
	@ResponseBody
	public EasyrentResult importAllHomes() {
		EasyrentResult result = homeService.importAllHomes();
		return result;
	}
}
