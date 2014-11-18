package org.destiny.client.messages.events;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class StatsUpdateEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		int i = Request.readInt();
		String[] details = Request.readString().split(",");
		GameClient.getInstance().getOurPlayer().updatePokemon(i, details);
		GameClient.getInstance().getHUD().refreshParty();
	}
}
