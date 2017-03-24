package com.example.city;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.city.service.CityModifyService;
import com.example.city.service.CitySearchService;
import com.example.domain.City;
import com.example.form.CityForm;

@Controller
@RequestMapping("/city")
public class CityModifyController {
	
	static Log log = LogFactory.getLog(CityModifyController.class);
	
	@Autowired
	CitySearchService citySearchService;
	
	@Autowired
	CityModifyService cityModifyService;
	
	@GetMapping("/modify/{id}")
	public String modifyForm(CityForm cityForm, @PathVariable int id){	// pathvariable(url->java형태로) path에 있는 변수이끼 때문에 자바에 있는 변수기 때문에 변환해주기 위해 pathvariable 있어야 함        넘어가게해줌 
		log.info("modifyForm(" + id + ")");
		City city = citySearchService.getCityById(id);
		cityForm.setCity(city);
		
		return "city/modifyForm"; 		
	}  			// 양식으로 작성하라는 메소드
	
	@PostMapping("/modify")
	public String modify(@Valid CityForm cityForm, BindingResult errors, Integer pageNo){		// 쿼리스트링에 있는 파라미터이니깐 @pathvariable 안 넣어줘도 됨. pageNo는 jsp에서 필요해서 사용함.
		log.info("modify(" + cityForm +")");													// 그 당시에 있는 pageNo의 정보를 보기 위한거여서 파라미터 형태로 받아서 사용함.
		System.out.println(cityForm);
		
		if(errors.hasErrors()){
			System.out.println(errors);
			return "city/modifyForm";				// forward
		}
		
		cityModifyService.modify(cityForm, errors);
		
		if(errors.hasErrors()){
			System.out.println(errors);
			return "city/modifyForm";				// forward
		}
		
		return "redirect:/city/modifySuccess/" + cityForm.getId() + "?pageNo=" + pageNo;	// redirect 	쿼리 스트링 형태로 넘어감. 파라미터
	}
	
	@GetMapping("/modifySuccess/{id}")
	public String modifySuccess(@PathVariable int id, Model model){
		City city = citySearchService.getCityById(id);
		model.addAttribute("city", city);
		return "city/modifySuccess";
	}
}
