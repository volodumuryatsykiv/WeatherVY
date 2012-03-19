package com.vy.weather.vo;

import com.vy.weather.interfaces.Conditions;

public class Forecast_conditions extends Conditions
{
	private String day_of_week;
	private int low;
	private int high;
	private String icon;
	private String condition;

	public void setDayOfWeek(String inDay)
	{
		this.day_of_week = inDay;
	}

	public String getDayOfWeek()
	{
		return this.day_of_week;
	}

	public int getLow()
	{
		return this.low;
	}

	public void setLow(int low)
	{
		this.low = low;
	}

	public int getHigh()
	{
		return this.high;
	}

	public void setHigh(int high)
	{
		this.high = high;
	}

	@Override
	public String getIcon()
	{
		return this.icon;
	}

	@Override
	public void setIcon(String icon)
	{
		this.icon = icon;
	}

	@Override
	public String getCondition()
	{
		return this.condition;
	}

	@Override
	public void setCondition(String condition)
	{
		this.condition = condition;
	}
}
