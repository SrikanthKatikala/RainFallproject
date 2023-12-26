package com.zettamine.rain.survice;

import java.util.List;

import com.zettamine.rain.dao.RainfallDao;
import com.zettamine.rain.dao.RainfallDaoImp;
import com.zettamine.rain.data.DataEntry;
import com.zettamine.rain.dto.AnnualRainfall;

public class RainfallSurviceImp implements RainfallSurvice {

	private RainfallDao rainDao = new RainfallDaoImp();
	private AnnualRainfall an;
	
	public void saveData(AnnualRainfall avg) {
		Integer save = rainDao.saveData(avg);
		if (save!=0) {
			System.out.println("Data inserted...!!!!\n");
		}
		else {
			System.out.println("data insert Operation failed....!!!\n");
		}
	}

	public void avgRainfallOfCity(Integer pincode) {
		Float avgRainfallOfCity = rainDao.avgRainfallOfCity(pincode);
		if (avgRainfallOfCity!=null) {
			System.out.println("The average rainfall of is: "+avgRainfallOfCity+"\n");
		} else {
			System.out.println(" Operation failed to find avgRainfallOfCity\n");
		}

	}

	public void avgRainfallOfAllCities() {
		List<AnnualRainfall> listOfAvgRainfall = rainDao.avgRainfallOfAllCities();
		if(listOfAvgRainfall!=null) {
				String str = String.format("%-4s | %-15s | %-5s","Pincode","City Name","Average Rainfall");
				System.out.println(str);
			for(AnnualRainfall ar: listOfAvgRainfall) {
				String s =String.format("%-5d   |  %-15s| %.2f", ar.getPincode() ,ar.getCityName(),ar.getAvgAnnualRainfall());
				System.out.println(s);
			}
			System.out.println();
		}
	}
	
	public void maxRainfall() {
		Float maxRainfall = rainDao.maxRainfall();
		if (maxRainfall!=null) {
			System.out.println("The maximum rain fall is: "+maxRainfall+"\n");
		} else {
			System.out.println("Operation failed to maximum rainfall...!\n");
		}
	}
	
	public void minRainfall() {
		Float minRainfall = rainDao.minRainfall();
		if (minRainfall!=null) {
			System.out.println("The minimum rain fall is: "+minRainfall+"\n");
		} else {
			System.out.println("Operation failed to maximum rainfall...!\n");
		}
	}
	

}
