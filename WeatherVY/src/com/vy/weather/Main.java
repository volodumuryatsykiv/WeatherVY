package com.vy.weather;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.vy.weather.vo.WeatherVO;
import com.vy.xml.WeatherParser;

public class Main
{

	public static void main(String[] args)
	{
		WeatherVO weather = new WeatherVO();

		try
		{
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			WeatherParser weatherParser = new WeatherParser();

			parser.parse(
					new File(
							"d:\\Java Projects\\Git\\WeatherVY\\WeatherVY\\assets\\api.xml"),
					weatherParser);
			weather = weatherParser.getWeatherVO();
			weather.setForecastList(weatherParser.getForecastList());
			System.out.println("Finish :)");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
