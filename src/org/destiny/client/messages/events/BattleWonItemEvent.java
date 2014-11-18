package org.destiny.client.messages.events;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.backend.BattleManager;
import org.destiny.client.backend.ItemDatabase;
import org.destiny.client.backend.entity.Item;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class BattleWonItemEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		int itemID = Request.readInt();
		Item item = ItemDatabase.getInstance().getItem(itemID);
		GameClient.getInstance().getOurPlayer().addItem(item.getId(), 1);
		BattleManager.getInstance().getNarrator().informItemDropped(item.getName());
	}
}
