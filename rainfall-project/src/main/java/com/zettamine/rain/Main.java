package com.zettamine.rain;

import java.io.BufferedReader; 
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import com.zettamine.rain.dao.RainfallDao;
import com.zettamine.rain.dao.RainfallDaoImp;
import com.zettamine.rain.dto.AnnualRainfall;
import com.zettamine.rain.survice.RainfallSurvice;
import com.zettamine.rain.survice.RainfallSurviceImp;

public class Main {
	private static RainfallDao rainDao = new RainfallDaoImp();
	private static AnnualRainfall an;
	private static RainfallSurvice ra = new RainfallSurviceImp();
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. Insert data: ");
			System.out.println("2. Average annual rainfall of city: ");
			System.out.println("3. All cities Average rainfall: ");
			System.out.println("4. Maximum rainfall: ");
			System.out.println("5. Minimum rainfall: ");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1:{
					String path = "/rainfall-project/src/main/resources/rainfalldata.txt";
					File file = new File(path);
					AnnualRainfall ar = new AnnualRainfall();
					String city = "";
					int pin=0;
					float avg =0;
					try {
						FileReader fileReader = new FileReader(file);
						BufferedReader br = new BufferedReader(fileReader);
						String line = br.readLine();
						int n=1;
						String str[] = line.split(",");
						while(line!=null) {
							int sum=0;
							pin=Integer.parseInt(str[0].trim());
							city=str[1].trim();
							
							
							for(int i=2; i<str.length; i++) {
								sum = sum+Integer.parseInt(str[i].trim());
							}
							 avg=sum/12;
							 
							line = br.readLine();
						}
						if (pin!=0) {
							ra.saveData(new AnnualRainfall(pin, city, avg));
						}
						else {
							System.out.println("No data saved...!!!");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
				case 2:{
					System.out.println("Enter city pincode: ");
					Integer pin = sc.nextInt();
					ra.avgRainfallOfCity(pin);
					break;
				}
				case 3:{
					System.out.println("All cities Average rainfall: ");
					ra.avgRainfallOfAllCities();
					break;
				}
				case 4:{
					System.out.println("Maximum rainfall: ");
					ra.maxRainfall();
					break;
				}
				case 5:{
					System.out.println("Minimum rainfall: ");
					ra.minRainfall();
					break;
				}
				case 6:{
					System.out.println("Exit");
					System.exit(0);
					break;
				}
				default :{
					break;
				}
			}
		}
	}
}
