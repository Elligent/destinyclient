package org.destiny.client.messages.events;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class BoatEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		int mapx = GameClient.getInstance().getMapMatrix().getCurrentMap().m_x;
		int mapy = GameClient.getInstance().getMapMatrix().getCurrentMap().m_y;
		String boat = "no_travel";
		if(mapx == 7 && mapy == 1)
		{
			boat = "kanto";
		}
		else if(mapx == -5 && mapy == -2)
		{
			boat = "johto";
		}
		else if(mapx == 28 && mapy == 25)
		{
			boat = "slateport";
		}
		else if(mapx == 33 && mapy == 21)
		{
			boat = "lilycove";
		}
		else if(mapx == 34 && mapy == -41)
		{
			boat = "canalave";
		}
		else if(mapx == -28 && mapy == 3)
		{
			boat = "one";
		}
		else if(mapx == -43 && mapy == 6)
		{
			boat = "two";
		}
		else if(mapx == -27 && mapy == 6)
		{
			boat = "three";
		}
		else if(mapx == -43 && mapy == 11)
		{
			boat = "four";
		}
		else if(mapx == -28 && mapy == 9)
		{
			boat = "five";
		}
		else if(mapx == -28 && mapy == 12)
		{
			boat = "six";
		}
		else if(mapx == -28 && mapy == 15)
		{
			boat = "seven";
		}
		else if(mapx == 40 && mapy == -47)
		{
			boat = "snowpoint";
		}
		else if(mapx == 44 && mapy == -46)
		{
			boat = "resort";
		}
		else if(mapx == -38 && mapy == 13)
		{
			boat = "navel";
		}
		else if(mapx == 2 && mapy == -45)
		{
			boat = "iron";
		}
		else if(mapx == 11 && mapy == 42)
		{
			boat = "gateon";
		}
		GameClient.getInstance().getHUD().showBoatDialog(boat);

	}
}
