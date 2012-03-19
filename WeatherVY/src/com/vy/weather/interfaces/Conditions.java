package com.vy.weather.interfaces;

public abstract class Conditions
{
	public abstract void setIcon(String icon);

	public abstract String getIcon();

	public abstract String getCondition();

	public abstract void setCondition(String condition);
}
