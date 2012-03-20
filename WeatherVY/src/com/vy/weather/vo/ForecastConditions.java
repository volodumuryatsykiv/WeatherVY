package com.vy.weather.vo;


public class ForecastConditions
{
	private String dayOfWeek;
	private int low;
	private int high;
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
