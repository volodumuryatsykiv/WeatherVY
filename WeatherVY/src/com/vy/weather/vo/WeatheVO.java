package com.vy.weather.vo;

import java.util.ArrayList;
import java.util.List;

public class WeatheVO
{
	private String city;
	private String data;
	private Current_conditions current = new Current_conditions();
	private List<Forecast_conditions> forecast = new ArrayList<Forecast_conditions>();

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getData()
	{
		return data;
	}

	public void setData(String data)
	{
		this.data = data;
	}

	public Current_conditions getCurrent()
	{
		return current;
	}

	public void setCurrent(Current_conditions inCurrent)
	{
		this.current = inCurrent;
	}

	public List<Forecast_conditions> getForecast()
	{
		return forecast;
	}

	public void setForecast(List<Forecast_conditions> inForecast)
	{
		this.forecast = inForecast;
	}

	public void addForecast(Forecast_conditions inForecast)
	{
		forecast.add(inForecast);
	}
}
