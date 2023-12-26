package com.zettamine.rain.dao;

import java.util.List; 

import com.zettamine.rain.dto.AnnualRainfall;

public interface RainfallDao {

	Integer saveData(AnnualRainfall avgRainfall);
	Float avgRainfallOfCity(Integer pincode);
	List<AnnualRainfall> avgRainfallOfAllCities();
	Float maxRainfall();
	Float minRainfall();
}
