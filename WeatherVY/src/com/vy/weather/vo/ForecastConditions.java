package com.vy.weather.vo;

public class ForecastConditions
{
	private String dayOfWeek;
	private float low;
	private float high;
	private String icon;
	private String condition;

	public void setDayOfWeek(String inDay)
	{
		this.dayOfWeek = inDay;
	}

	public String getDayOfWeek()
	{
		return this.dayOfWeek;
	}

	public float getLow()
	{
		return this.low;
	}

	public void setLow(float low)
	{
		this.low = low;
	}

	public float getHigh()
	{
		return this.high;
	}

	public void setHigh(float high)
	{
		this.high = high;
	}

	public String getIcon()
	{
		return this.icon;
	}

	public void setIcon(String icon)
	{
		this.icon = icon;
	}

	public String getCondition()
	{
		return this.condition;
	}

	public void setCondition(String condition)
	{
		this.condition = condition;
	}
}
