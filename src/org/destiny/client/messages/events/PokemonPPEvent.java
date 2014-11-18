package org.destiny.client.messages.events;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class PokemonPPEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		int poke = Request.readInt();
		int move = Request.readInt();
		int curPP = Request.readInt();
		int maxPP = Request.readInt();
		GameClient.getInstance().getOurPlayer().getPokemon()[poke].setMoveCurPP(move, curPP);
		GameClient.getInstance().getOurPlayer().getPokemon()[poke].setMoveMaxPP(move, maxPP);
	}
}
