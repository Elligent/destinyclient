package org.destiny.client.messages.events;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class TravelEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		int mapx = GameClient.getInstance().getMapMatrix().getCurrentMap().m_x;
		int mapy = GameClient.getInstance().getMapMatrix().getCurrentMap().m_y;
		String travel = "no_travel";
		System.out.println(mapx + ", " + mapy);
		if(mapx == -49 && mapy == -12)
		{
			// System.out.println("kanto time");
			travel = "kanto";
		}
		else if(mapx == -30 && mapy == -38)
		{
			travel = "johto";
		}
		else if(mapx == -35 && mapy == -38)
		{
			travel = "phenac";
		}
		else if(mapx == 22 && mapy == 39)
		{
			travel = "pyrite";
		}
		else if(mapx == 13 && mapy == 18)
		{
			travel = "Fuchsia";
		}
		else if(mapx == -46 && mapy == -33)
		{
			travel = "mt.silver";
		}
		if(!travel.equals("no_travel"))
			GameClient.getInstance().getHUD().showTrainchooser(travel, GameClient.getInstance().getOurPlayer());
	}
}
