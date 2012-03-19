package com.vy.weather.vo;

import com.vy.weather.interfaces.Conditions;

public class Current_conditions extends Conditions
{
	private String condition;
	private int temp_f;
	private int temp_c;
	private String humidity;
	private String icon;
	private String wind_condition;

	@Override
	public void setCondition(String inCondition)
	{
		this.condition = inCondition;
	}

	@Override
	public String getCondition()
	{
		return this.condition;
	}

	public void setTemp_f(int inTemp_f)
	{
		this.temp_f = inTemp_f;
	}

	public int getTemp_f()
	{
		return this.temp_f;
	}

	public void setTemp_c(int inTemp_c)
	{
		this.temp_f = inTemp_c;
	}

	public int getTemp_c()
	{
		return this.temp_c;
	}

	public void setHumidity(String inHumidity)
	{
		this.humidity = inHumidity;
	}

	public String getHumidity()
	{
		return this.humidity;
	}

	@Override
	public void setIcon(String inIcon)
	{
		this.icon = inIcon;
	}

	@Override
	public String getIcon()
	{
		return this.icon;
	}

	public void setWind_condition(String inWind_condition)
	{
		this.wind_condition = inWind_condition;
	}

	public String getWind_condition()
	{
		return this.wind_condition;
	}
}
