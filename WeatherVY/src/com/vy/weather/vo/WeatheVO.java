package com.vy.weather.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeatheVO
{
	private String city;
	private Date date = new Date();
	private String condition;
	private int tempF;
	private int tempC;
	private String humidity;
	private String icon;
	private String windCondition;
	private List<ForecastConditions> forecast = new ArrayList<ForecastConditions>();

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public Date getYear()
	{
		return date;
	}

	public void setData(int year, int month, int day)
	{
		date = new Date(year, month, day);
	}

	public List<ForecastConditions> getForecast()
	{
		return forecast;
	}

	public void setForecast(List<ForecastConditions> inForecast)
	{
		this.forecast = inForecast;
	}

	public void addForecast(ForecastConditions inForecast)
	{
		forecast.add(inForecast);
	}

	public void setCondition(String inCondition)
	{
		this.condition = inCondition;
	}

	public String getCondition()
	{
		return this.condition;
	}

	public void setTempF(int inTemp_f)
	{
		this.tempF = inTemp_f;
	}

	public int getTempF()
	{
		return this.tempF;
	}

	public void setTempC(int inTemp_c)
	{
		this.tempF = inTemp_c;
	}

	public int getTempC()
	{
		return this.tempC;
	}

	public void setHumidity(String inHumidity)
	{
		this.humidity = inHumidity;
	}

	public String getHumidity()
	{
		return this.humidity;
	}

	public void setIcon(String inIcon)
	{
		this.icon = inIcon;
	}

	public String getIcon()
	{
		return this.icon;
	}

	public void setWindCondition(String inWind_condition)
	{
		this.windCondition = inWind_condition;
	}

	public String getWindCondition()
	{
		return this.windCondition;
	}
}
