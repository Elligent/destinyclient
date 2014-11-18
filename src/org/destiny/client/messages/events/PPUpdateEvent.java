package org.destiny.client.messages.events;

import org.destiny.client.Session;
import org.destiny.client.backend.BattleManager;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class PPUpdateEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		for(int i = 0; i < 4; i++)
		{

			BattleManager.getInstance().getCurPoke().setMoveCurPP(i, Request.readInt());
			if(BattleManager.getInstance().getCurPoke().getMoveMaxPP()[i] != 0)
				BattleManager.getInstance().getBattleWindow().getPPLabel(i)
						.setText(BattleManager.getInstance().getCurPoke().getMoveCurPP()[i] + "/" + BattleManager.getInstance().getCurPoke().getMoveMaxPP()[i]);
		}
	}
}
