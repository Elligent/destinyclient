package org.destiny.client.messages.events;

import org.destiny.client.Session;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class PasswordChangeEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		// 0 is failure // 1 is success;
		/* if (Request.readInt() == 1) { GameClient.getInstance().getUserManager().login(m_game.getPacketGenerator().getLastUsername(), m_game.getPacketGenerator().getLastPassword()); } else { GameClient.getInstance().getUserManager().login(m_game.getPacketGenerator().getLastUsername(), m_game.getPacketGenerator().getLastPassword()); } */
	}
}
