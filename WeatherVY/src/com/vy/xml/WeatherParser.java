package com.vy.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

import com.vy.weather.vo.ForecastConditions;
import com.vy.weather.vo.WeatherVO;

public class WeatherParser extends DefaultHandler2
{
	private final WeatherVO weather = new WeatherVO();
	private ForecastConditions forecast = new ForecastConditions();
	private final List<ForecastConditions> forecastList = new ArrayList<ForecastConditions>();
	private String thisString = "";
	private int currentLevel = -1;

	public WeatherVO getWeatherVO()
	{
		return this.weather;
	}

	public List<ForecastConditions> getForecastList()
	{
		return this.forecastList;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException
	{
		thisString = qName;
		String value = "";
		// System.out.println(value);

		if (thisString.equalsIgnoreCase("forecast_information")
				|| thisString.equalsIgnoreCase("current_conditions"))
		{
			currentLevel = 0;
		} else if (thisString.equalsIgnoreCase("forecast_conditions"))
		{
			currentLevel = 1;
		}

		value = attributes.getValue("data");
		if (currentLevel == 0 && value != null && !value.isEmpty())
		{

			parseWeatherVO(thisString, value.trim());
		} else if (currentLevel == 1 && value != null && !value.isEmpty())
		{
			parseForecastCondition(thisString, value.trim());
		}
	}

	@Override
	public void endElement(String namespaceURI, String localName, String qName)
			throws SAXException
	{
		thisString = "";

		if (qName.equalsIgnoreCase("forecast_conditions"))
		{
			ForecastConditions tempForecast = forecast;
			forecastList.add(tempForecast);
			forecast = new ForecastConditions();
		}
	}

	public void parseWeatherVO(String inQname, String value)
	{
		if (inQname.equalsIgnoreCase("city"))
		{
			weather.setCity(value);
		} else if (inQname.equalsIgnoreCase("forecast_date"))
		{
			weather.setData(Integer.valueOf(value.substring(0, 4)),
					Integer.valueOf(value.substring(5, 7)),
					Integer.valueOf(value.substring(8, 10)));
		} else if (inQname.equalsIgnoreCase("condition"))
		{
			weather.setCondition(value);
		} else if (inQname.equalsIgnoreCase("temp_f"))
		{
			weather.setTempF(Float.valueOf(value));
		} else if (inQname.equalsIgnoreCase("temp_c"))
		{
			weather.setTempC(Float.valueOf(value));
		} else if (inQname.equalsIgnoreCase("humidity"))
		{
			weather.setHumidity(value);
		} else if (inQname.equalsIgnoreCase("icon"))
		{
			weather.setIcon(value);
		} else if (inQname.equalsIgnoreCase("wind_condition"))
		{
			weather.setWindCondition(value);
		}
	}

	public void parseForecastCondition(String inQname, String value)
	{
		if (inQname.equalsIgnoreCase("day_of_week"))
		{
			forecast.setDayOfWeek(value);
		} else if (inQname.equalsIgnoreCase("low"))
		{
			forecast.setLow(Float.valueOf(value));
		} else if (inQname.equalsIgnoreCase("high"))
		{
			forecast.setHigh(Float.valueOf(value));
		} else if (inQname.equalsIgnoreCase("icon"))
		{
			forecast.setIcon(value);
		} else if (inQname.equalsIgnoreCase("condition"))
		{
			forecast.setCondition(value);
		}
	}
}
