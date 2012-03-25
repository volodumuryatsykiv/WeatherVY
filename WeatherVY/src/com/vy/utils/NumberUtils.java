package com.vy.utils;

import java.text.NumberFormat;
import java.text.ParseException;

public class NumberUtils
{
	private final static NumberFormat format = NumberFormat.getInstance();

	public static float parseNumber(String value)

	{
		try
		{
			Number inValue = format.parse(value);
			return inValue.floatValue();
		} catch (ParseException e)
		{
			System.err.println(value + " not parseable");
			return 0.0f;
		}
	}
}
