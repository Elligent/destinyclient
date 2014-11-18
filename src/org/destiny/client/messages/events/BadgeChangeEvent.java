package org.destiny.client.messages.events;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.backend.entity.OurPlayer;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class BadgeChangeEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		int i = Request.readInt();
		OurPlayer player = GameClient.getInstance().getOurPlayer();

		// init badges
		if(i == 0)
		{
			player.initBadges(Request.readString());
			GameClient.getInstance().setOurPlayer(player);
		}
		else
			player.addBadge(Request.readInt());
	}
}
