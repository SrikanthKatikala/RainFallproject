package com.zettamine.rain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zettamine.rain.config.ConnectionFactory;
import com.zettamine.rain.dto.AnnualRainfall;

public class RainfallDaoImp implements RainfallDao {
	private static Connection con = ConnectionFactory.getDBConne();
	private static Statement st;
	private static PreparedStatement pst;
	private static AnnualRainfall avg;

	public Integer saveData(AnnualRainfall avg) {
		String sql  ="insert into annualrainfall values("+avg.getPincode()+",'"+avg.getCityName()+"',"+avg.getAvgAnnualRainfall()+");";
		try {
			 st=con.createStatement();
			 int num = st.executeUpdate(sql);
			 if (num!=0) {
				 
				return 1;
			} else {
				return 0;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Float avgRainfallOfCity(Integer pincode) {
		
		String sql = "select average_annual_rainfall from annualrainfall where city_pincode = "+pincode;
		try {
			 st=con.createStatement();
			 ResultSet rs = st.executeQuery(sql);
			 if (rs.next()) {
				return rs.getFloat(1);
			} else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<AnnualRainfall> avgRainfallOfAllCities() {
		ArrayList<AnnualRainfall> list = new ArrayList<AnnualRainfall>();
		String sql = "select * from annualrainfall";
		try{
			st=con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				avg = new AnnualRainfall(rs.getInt(1), rs.getString(2), rs.getFloat(3));
				list.add(avg);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public Float maxRainfall() {
		String sql = "select max(average_annual_rainfall) from annualrainfall";
		try{
			st=con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				return rs.getFloat(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Float minRainfall() {
		String sql = "select min(average_annual_rainfall) from annualrainfall";
		try{
			st=con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				return rs.getFloat(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
