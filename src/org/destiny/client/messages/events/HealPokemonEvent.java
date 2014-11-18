package org.destiny.client.messages.events;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class HealPokemonEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		for(int i = 0; i < GameClient.getInstance().getOurPlayer().getPokemon().length; i++)
			if(GameClient.getInstance().getOurPlayer().getPokemon()[i] != null)
			{
				GameClient.getInstance().getOurPlayer().getPokemon()[i].setCurHP(GameClient.getInstance().getOurPlayer().getPokemon()[i].getMaxHP());
				for(int x = 0; x < 4; x++)
					GameClient.getInstance().getOurPlayer().getPokemon()[i].setMoveCurPP(x, GameClient.getInstance().getOurPlayer().getPokemon()[i].getMoveMaxPP()[x]);
			}
		GameClient.getInstance().getHUD().update(false);
	}
}
