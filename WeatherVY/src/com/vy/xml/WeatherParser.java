package com.vy.xml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

import com.vy.utils.NumberUtils;
import com.vy.weather.vo.ForecastConditions;
import com.vy.weather.vo.WeatherVO;

public class WeatherParser extends DefaultHandler2
{
	private final WeatherVO weather = new WeatherVO();
	private ForecastConditions forecast = new ForecastConditions();
	private final List<ForecastConditions> forecastList = new ArrayList<ForecastConditions>();
	private String thisString = "";
	private int currentLevel = -1;
	private final int forecastInformation = 1;
	private final int currentInformation = 0;
	private final SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");

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

		if (thisString.equalsIgnoreCase(XMLconstants.forecastInformation)
				|| thisString.equalsIgnoreCase(XMLconstants.currentCondition))
		{
			currentLevel = currentInformation;
		} else if (thisString.equalsIgnoreCase(XMLconstants.forecastCondition))
		{
			currentLevel = forecastInformation;
		}

		value = attributes.getValue(XMLconstants.data);
		if (currentLevel == currentInformation && value != null
				&& !value.isEmpty())
		{

			parseWeatherVO(thisString, value.trim());
		} else if (currentLevel == forecastInformation && value != null
				&& !value.isEmpty())
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
		Date tDate = new Date();
		if (inQname.equalsIgnoreCase(XMLconstants.city))
		{
			weather.setCity(value);
		} else if (inQname.equalsIgnoreCase(XMLconstants.date))
		{
			try
			{
				tDate = sdFormat.parse(value);
				weather.setDate(tDate);
			} catch (ParseException e)
			{
				e.printStackTrace();
			}
		} else if (inQname.equalsIgnoreCase(XMLconstants.condition))
		{
			weather.setCondition(value);
		} else if (inQname.equalsIgnoreCase(XMLconstants.tempF))
		{
			weather.setTempF(NumberUtils.parseNumber(value));
		} else if (inQname.equalsIgnoreCase(XMLconstants.tempC))
		{
			weather.setTempC(NumberUtils.parseNumber(value));
		} else if (inQname.equalsIgnoreCase(XMLconstants.humidity))
		{
			weather.setHumidity(value);
		} else if (inQname.equalsIgnoreCase(XMLconstants.icon))
		{
			weather.setIcon(value);
		} else if (inQname.equalsIgnoreCase(XMLconstants.windCondition))
		{
			weather.setWindCondition(value);
		}
	}

	public void parseForecastCondition(String inQname, String value)
	{
		if (inQname.equalsIgnoreCase(XMLconstants.dayOfWeek))
		{
			forecast.setDayOfWeek(value);
		} else if (inQname.equalsIgnoreCase(XMLconstants.low))
		{
			forecast.setLow(NumberUtils.parseNumber(value));
		} else if (inQname.equalsIgnoreCase(XMLconstants.high))
		{
			forecast.setHigh(NumberUtils.parseNumber(value));
		} else if (inQname.equalsIgnoreCase(XMLconstants.icon))
		{
			forecast.setIcon(value);
		} else if (inQname.equalsIgnoreCase(XMLconstants.condition))
		{
			forecast.setCondition(value);
		}
	}
}
