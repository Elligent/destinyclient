package org.destiny.client.messages.events;

import org.destiny.client.Session;
import org.destiny.client.backend.BattleManager;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class BattleStartEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		/* Dit heb ik veranderd van char naar bool! Want we kunnen nu bools lezen. */
		BattleManager.getInstance().startBattle(Request.readBool(), Request.readInt());
	}
}
