package org.destiny.client.messages.events;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class PokedexInitializeEvent implements MessageEvent
{

	@Override
	public void parse(Session session, ServerMessage Request, ClientMessage Message)
	{
		String[] details = Request.readString().split(",");
		GameClient.getInstance().getOurPlayer().initializePokedex(details);
	}

}
