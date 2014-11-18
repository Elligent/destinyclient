package org.destiny.client.messages.events;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class HMHigherLevelEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{

		int level = Request.readInt();

		GameClient.getInstance().showMessageDialog("You are not strong enough to do this.\n" + "Your trainer level must be " + level + " to do this.");
	}
}
