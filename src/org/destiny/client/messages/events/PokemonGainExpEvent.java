package org.destiny.client.messages.events;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class PokemonGainExpEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		int p1 = Request.readInt();
		int exp = GameClient.getInstance().getOurPlayer().getPokemon()[p1].getExp() + Request.readInt();

		GameClient.getInstance().getOurPlayer().getPokemon()[p1].setExp(exp);
		GameClient.getInstance().getHUD().update(false);
	}
}
