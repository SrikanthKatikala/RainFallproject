package com.zettamine.rain.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.zettamine.rain.dto.AnnualRainfall;

public class DataEntry {

	public AnnualRainfall dataEntry()
	{
		String path = "C:\\Users\\Srikanth K\\Desktop\\rainfalldata.txt";
		File file = new File(path);
		AnnualRainfall ar = new AnnualRainfall();
		
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			String line = br.readLine();
			String city = "";
			int pin=0;
			String str[] = line.split(",");
			if (line!=null) {
				//System.out.println(line);
				
				ar.setPincode(Integer.parseInt(str[0].trim()));
				ar.setCityName(str[1].trim());
				
				int sum=0;
				for(int i=2; i<str.length; i++) {
					sum = sum+Integer.parseInt(str[i].trim());
				}
				float avg = sum/12;
				ar.setAvgAnnualRainfall(avg);
				line = br.readLine();
			}
			return ar;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
