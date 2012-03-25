package com.vy.weather.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeatherVO
{
	private String city;
	private Date date = new Date();
	private String condition;
	private float tempF;
	private float tempC;
	private String humidity;
	private String icon;
	private String windCondition;
	private List<ForecastConditions> forecast = new ArrayList<ForecastConditions>();

	public String getCity()
	{
		return this.city;
	}

	public void setCity(String inCity)
	{
		this.city = inCity;
	}

	public Date getDate()
	{
		return this.date;
	}

	public void setDate(Date inDate)
	{
		date = inDate;
	}

	public List<ForecastConditions> getForecast()
	{
		return forecast;
	}

	public void setForecastList(List<ForecastConditions> inForecast)
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

	public void setTempF(float inTempF)
	{
		this.tempF = inTempF;
	}

	public float getTempF()
	{
		return this.tempF;
	}

	public void setTempC(float inTempC)
	{
		this.tempF = inTempC;
	}

	public float getTempC()
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
