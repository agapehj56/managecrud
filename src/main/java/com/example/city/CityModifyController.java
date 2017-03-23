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
	public String modifyForm(CityForm cityForm, @PathVariable int id){	// pathvariable로 넘어가게해줌 
		log.info("modifyForm(" + id + ")");
		City city = citySearchService.getCityById(id);
		cityForm.setCity(city);
		
		return "city/modifyForm"; 		
	}  			// 양식으로 작성하라는 메소드
	
	@PostMapping("/modify")
	public String register(@Valid CityForm cityForm, BindingResult errors){
		log.info("register(" + cityForm +")");
		System.out.println(cityForm);
		
		if(errors.hasErrors()){
			System.out.println(errors);
			return "city/registerForm";				// forward
		}
		
		cityModifyService.modify(cityForm, errors);
		
		if(errors.hasErrors()){
			System.out.println(errors);
			return "city/registerForm";				// forward
		}
		
		return "redirect:/city/registerSuccess/" + cityForm.getId();	// redirect
	}
	
	@GetMapping("/modifySuccess/{id}")
	public String registerSuccess(@PathVariable int id, Model model){
		City city = citySearchService.getCityById(id);
		model.addAttribute("city", city);
		return "city/registerSuccess";
	}
}
