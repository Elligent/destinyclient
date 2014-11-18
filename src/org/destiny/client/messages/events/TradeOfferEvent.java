package org.destiny.client.messages.events;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class TradeOfferEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		// String[] offerData = Request.readString().split(",");
		GameClient.getInstance().getHUD().getTradeDialog().getOffer(Request.readInt(), Request.readInt());
	}
}
