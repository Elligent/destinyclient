package org.destiny.client.messages.events;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.backend.time.WeatherService.Weather;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class WeatherChangeEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		switch(Request.readInt())
		{
			case 1:
				GameClient.getInstance().getWeatherService().setWeather(Weather.NORMAL);
				break;
			case 2:
				GameClient.getInstance().getWeatherService().setWeather(Weather.RAIN);
				break;
			case 3:
				GameClient.getInstance().getWeatherService().setWeather(Weather.HAIL);
				break;
			case 4:
				GameClient.getInstance().getWeatherService().setWeather(Weather.SANDSTORM);
				break;

		}
	}
}
