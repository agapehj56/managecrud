package com.example.city.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.CityMapper;

@Service
public class CityUnregisterService {

	@Autowired
	CityMapper cityMapper;
	
	public void unregister(int id) {
		
		cityMapper.deleteById(id);
	}
}
