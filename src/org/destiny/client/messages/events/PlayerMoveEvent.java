package org.destiny.client.messages.events;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.backend.entity.Player;
import org.destiny.client.backend.entity.Player.Direction;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class PlayerMoveEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		int player = Request.readInt();
		int dir = Request.readInt();
		Player p = GameClient.getInstance().getMapMatrix().getPlayer(player);
		if(p == null)
			return;

		switch(dir)
		{
			case 0:
				p.queueMovement(Direction.Down);
				break;
			case 1:
				p.queueMovement(Direction.Up);
				break;
			case 2:
				p.queueMovement(Direction.Left);
				break;
			case 3:
				p.queueMovement(Direction.Right);
				break;
		}
	}
}
