package com.example.form;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.domain.City;
import com.example.domain.Country;

public class CityForm extends City {
	
	public void setCity(City city){
		super.setId(city.getId());
		super.setName(city.getName());
		super.setCountryCode(city.getCountryCode());
		super.setDistrict(city.getDistrict());
		super.setPopulation(city.getPopulation());
	}

	@NotNull
	@Size(max=35)
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setName(String name) {
		if(name.equals(""))
			name = null;
		super.setName(name);
	}

	@Size(max=3)
	@Override
	public String getCountryCode() {
		// TODO Auto-generated method stub
		return super.getCountryCode();
	}

	@Override
	public void setCountryCode(String countryCode) {
		// TODO Auto-generated method stub
		if(countryCode.equals(""))
			countryCode = null;
		super.setCountryCode(countryCode);
	}

	@Size(max=20)
	@Override
	public String getDistrict() {
		return super.getDistrict();
	}

	@Override
	public void setDistrict(String district) {
		if(district.equals(""))
			district = null;
		super.setDistrict(district);
	}

	@Digits(integer=11, fraction=0)
	@Override
	public BigDecimal getPopulation() {
		// TODO Auto-generated method stub
		return super.getPopulation();
	}

	@Override
	public void setPopulation(BigDecimal population) {
		// TODO Auto-generated method stub
		super.setPopulation(population);
	}
}
