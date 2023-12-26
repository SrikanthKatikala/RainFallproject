package com.zettamine.rain.dto;

import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnualRainfall {
	@NonNull
	private Integer pincode;
	private String cityName;
	private Float avgAnnualRainfall;
	public AnnualRainfall(@NonNull Integer pincode, String cityName, Float avgAnnualRainfall) {
		super();
		this.pincode = pincode;
		this.cityName = cityName;
		this.avgAnnualRainfall = avgAnnualRainfall;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Float getAvgAnnualRainfall() {
		return avgAnnualRainfall;
	}
	public void setAvgAnnualRainfall(Float avgAnnualRainfall) {
		this.avgAnnualRainfall = avgAnnualRainfall;
	}
	public AnnualRainfall() {
		super();
	}
	
}
