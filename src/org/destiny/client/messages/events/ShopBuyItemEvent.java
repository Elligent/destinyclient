package org.destiny.client.messages.events;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.backend.ItemDatabase;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class ShopBuyItemEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		try
		{
			GameClient.getInstance().getHUD().getNPCSpeech().advance();
			GameClient.getInstance().getHUD().getNPCSpeech().advance();
		}
		catch(Exception e)
		{
		}
		GameClient.getInstance().getHUD().talkToNPC("You bought a " + ItemDatabase.getInstance().getItem(Request.readInt()).getName());
	}
}
