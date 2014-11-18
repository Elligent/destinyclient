package org.destiny.client.messages.events;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.backend.entity.Player;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class ChangeSpriteEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		int player = Request.readInt();
		int sprite = Request.readInt();

		Player p = GameClient.getInstance().getMapMatrix().getPlayer(player);
		if(p != null)
		{
			p.setSprite(sprite);
			p.loadSpriteImage();
		}
	}
}
