package org.destiny.client.messages.events;

import org.destiny.client.Session;
import org.destiny.client.backend.BattleManager;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class BattleLevelupEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		final String[] levelData = Request.readString().split(",");
		BattleManager.getInstance().getNarrator().informLevelUp(levelData[0], Integer.parseInt(levelData[1]));
	}
}
