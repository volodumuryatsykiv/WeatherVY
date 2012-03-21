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
		// System.out.println("First");
		//
		// Date date = new Date(112, 2, 10);
		// System.out.println(date);
		//
		// String temp = "2012-03-20";
		// String temp1 = "10.1";
		// System.out.println(Integer.valueOf(temp.substring(0, 4)));
		// System.out.println(Integer.valueOf(temp.substring(5, 7)));
		// System.out.println(Integer.valueOf(temp.substring(8, 10)));
		//
		// float p = Float.valueOf(temp1);
		// System.out.println(p);

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
