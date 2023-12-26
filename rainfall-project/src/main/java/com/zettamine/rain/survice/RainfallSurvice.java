package com.zettamine.rain.survice;

import com.zettamine.rain.dto.AnnualRainfall;

public interface RainfallSurvice {

	void saveData(AnnualRainfall avgRainfall);
	void avgRainfallOfCity(Integer pincode);
	void avgRainfallOfAllCities();
	void maxRainfall();
	void minRainfall();
}
