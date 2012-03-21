package com.vy.xml;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	private final SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
	private Date tDate = new Date();
	private final NumberFormat format = NumberFormat.getInstance();

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
			try
			{
				tDate = sdFormat.parse(value);
				weather.setDate(tDate);
			} catch (ParseException e)
			{
				e.printStackTrace();
			}
		} else if (inQname.equalsIgnoreCase("condition"))
		{
			weather.setCondition(value);
		} else if (inQname.equalsIgnoreCase("temp_f"))
		{
			try
			{
				Number inValue = format.parse(value);
				weather.setTempF(inValue.floatValue());
			} catch (ParseException e)
			{
				System.err.println(value + " not parseable");
			}
		} else if (inQname.equalsIgnoreCase("temp_c"))
		{
			try
			{
				Number inValue = format.parse(value);
				weather.setTempC(inValue.floatValue());
			} catch (ParseException e)
			{
				System.err.println(value + " not parseable");
			}
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
			try
			{
				Number inValue = format.parse(value);
				forecast.setLow(inValue.floatValue());
			} catch (ParseException e)
			{
				System.err.println(value + " not parseable");
			}
		} else if (inQname.equalsIgnoreCase("high"))
		{
			try
			{
				Number inValue = format.parse(value);
				forecast.setHigh(inValue.floatValue());
			} catch (ParseException e)
			{
				System.err.println(value + " not parseable");
			}
		} else if (inQname.equalsIgnoreCase("icon"))
		{
			forecast.setIcon(value);
		} else if (inQname.equalsIgnoreCase("condition"))
		{
			forecast.setCondition(value);
		}
	}
}
