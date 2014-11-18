package org.destiny.client.messages.events;

import org.destiny.client.Session;
import org.destiny.client.backend.BattleManager;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class BattleEnemyDataEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		BattleManager.getInstance().setEnemyPoke(Request.readInt(), Request.readString(), Request.readInt(), Request.readInt(), Request.readInt(), Request.readInt(), Request.readInt(),
				Request.readBool());
	}
}
