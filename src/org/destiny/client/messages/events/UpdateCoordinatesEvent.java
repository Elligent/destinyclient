package org.destiny.client.messages.events;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.backend.entity.Player;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class UpdateCoordinatesEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		// get coordinates
		int x = Request.readInt();
		int y = Request.readInt();

		// get player
		Player p = GameClient.getInstance().getOurPlayer();

		// set coordinates clientside/serverside
		p.setX(x);
		p.setY(y);
		p.setServerX(p.getX());
		p.setServerY(p.getY());

		/* Reposition screen above player */
		GameClient.getInstance().getMapMatrix().getCurrentMap().setXOffset(400 - p.getX(), false);
		GameClient.getInstance().getMapMatrix().getCurrentMap().setYOffset(300 - p.getY(), false);
		GameClient.getInstance().getMapMatrix().recalibrate();
	}
}
