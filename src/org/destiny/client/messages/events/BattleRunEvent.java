package org.destiny.client.messages.events;

import org.destiny.client.Session;
import org.destiny.client.backend.BattleManager;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class BattleRunEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		// hier in server bool van maken ;) Die kunnen we nu tenslotte lezen! :)
		boolean canRun = Request.readBool();
		BattleManager.getInstance().getNarrator().informRun(canRun);
	}
}
