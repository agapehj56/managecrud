package com.example.city.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.domain.City;
import com.example.domain.Country;
import com.example.mapper.CityMapper;
import com.example.mapper.CountryMapper;

@Service		// 있어야 autowired 사용가능
public class CityModifyService {
	
	@Autowired
	CityMapper cityMapper;
	
	@Autowired
	CountryMapper countryMapper;		// country code가 있는지 없는지 조회해서 확인해야 하므로 필요
	
	public void modify(City city, BindingResult errors) {
		
		if(city.getCountryCode() != null){		// country code가 맞는게 있는지 확인.
			Country country = countryMapper.selectByCode(city.getCountryCode());
			if(country == null)
				errors.reject("InvalidCountryCode", "유효한 Country Code가 아닙니다.");
		}
			
		if(!errors.hasErrors())
			cityMapper.updateById(city);
	}
}
