package com.example.city.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.example.form.CityForm;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityModifyServiceTests {
	
	@Autowired
	CitySearchService citySearchService;
	
	@Autowired
	CityModifyService cityModifyService;
	
	@Autowired
	Validator validator;		// 자릿수 유효성 검사.
	
	@Test
	public void test00_confirmCitySearchService() {
		System.out.println("citySearchService=" + citySearchService);		
	}
	
	@Test
	public void test00_confirmCityModifyService() {
		System.out.println("cityModifyService=" + cityModifyService);		
	}
	
	@Test
	public void test00_confirmValidator() {
		System.out.println("validator=" + validator);	
	}
	
	@Test
	public void test01_modify(){
		CityForm cityForm = new CityForm();
		BindingResult errors = new BeanPropertyBindingResult(cityForm, "cityForm");
		
		cityForm.setId(4120);
		cityForm.setName("xxx");
		cityForm.setCountryCode("USA");
		
		validator.validate(cityForm, errors);				// 자리수랑 null 체크(입력양식) - 유효성 검사
		if(errors.hasErrors()){
			System.out.println("errors = " + errors);
			return;
		}
		
		cityModifyService.modify(cityForm, errors);		// country code가 유효한지 확인
		if(errors.hasErrors()){
			System.out.println("errors = " + errors);
			return;
		}						// error 체크 구문.
		
		System.out.println("city = " + citySearchService.getCityById(cityForm.getId()));
	}
}
