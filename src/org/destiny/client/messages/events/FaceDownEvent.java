package org.destiny.client.messages.events;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.backend.entity.Player;
import org.destiny.client.backend.entity.Player.Direction;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class FaceDownEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		Player p = GameClient.getInstance().getMapMatrix().getPlayer(Request.readInt());
		if(p != null)
		{
			p.setDirection(Direction.Down);
			p.loadSpriteImage();
		}
	}
}
