package org.destiny.client.messages.events;

import org.destiny.client.Session;
import org.destiny.client.backend.BattleManager;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class BattleVictoryEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		int condition = Request.readInt();
		switch(condition)
		{
			case 0: /* You won! */
				BattleManager.getInstance().getNarrator().informVictory();
				BattleManager.getInstance().deleteInstance();
				break;
			case 1: /* You lost! */
				BattleManager.getInstance().getNarrator().informLoss();
				BattleManager.getInstance().deleteInstance();
				break;
			case 2: /* We caught the Pokemon! */
				BattleManager.getInstance().endBattle();
				BattleManager.getInstance().deleteInstance();
				break;
		}
	}
}
