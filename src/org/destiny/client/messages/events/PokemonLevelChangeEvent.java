package org.destiny.client.messages.events;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class PokemonLevelChangeEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		String[] levelData = Request.readString().split(",");

		GameClient.getInstance().getOurPlayer().getPokemon()[Integer.parseInt(levelData[0])].setLevel(Integer.parseInt(levelData[1]));
		GameClient.getInstance().getOurPlayer().getPokemon()[Integer.parseInt(levelData[0])].setExpLvlUp(Integer.parseInt(levelData[2]));
		GameClient.getInstance().getOurPlayer().getPokemon()[Integer.parseInt(levelData[0])].setExpLvl((Integer.parseInt(levelData[3])));
		GameClient.getInstance().getHUD().update(false);
	}
}
