package com.example.city;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.city.service.CitySearchService;
import com.example.city.service.CityUnregisterService;
import com.example.domain.City;

@Controller
@RequestMapping("/city")
public class CityUnregisterController {
	
	static Log log = LogFactory.getLog(CityUnregisterController.class);
	
	@Autowired
	CitySearchService citySearchService;
	
	@Autowired
	CityUnregisterService cityUnregisterService;
	
	@GetMapping("/unregister/{id}")
	public String unregisterForm(@PathVariable int id, Model model){	
		log.info("unregisterForm(" + id + ")");
		City city = citySearchService.getCityById(id);
		model.addAttribute("city", city);
		
		return "city/unregisterForm"; 		
	}  			
	
	@PostMapping("/unregister/{id}")
	public String unregister(@PathVariable int id, Integer pageNo){		
		log.info("unregister(" + id +")");
		
		cityUnregisterService.unregister(id);
			
		return "redirect:/city/unregisterSuccess/" + id + "?pageNo=" + pageNo;	
	}
	
	@GetMapping("/unregisterSuccess/{id}")
	public String unregisterSuccess(@PathVariable int id, Model model){
		model.addAttribute("id", id);		// model 안해줘도 삭제되니까 자동으로 request 되어서 안 써줘도 되는 부분.
		return "city/unregisterSuccess";
	}
}
