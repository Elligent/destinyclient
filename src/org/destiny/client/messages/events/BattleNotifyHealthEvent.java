package org.destiny.client.messages.events;

import org.destiny.client.Session;
import org.destiny.client.backend.BattleManager;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class BattleNotifyHealthEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		if(Request.readInt() == 0)
			// Our pokemon's health
			BattleManager.getInstance().getNarrator().informHealthChanged(Request.readString().split(","), 0);
		else
			// Enemy pokemon's health
			BattleManager.getInstance().getNarrator().informHealthChanged(Request.readString().split(","), 1);
	}
}
