package org.destiny.client.messages.events;

import org.destiny.client.Session;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class TestEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		// String AuthString = Request.readString();
		// String[] Bits = AuthString.split(";");
		// String Username = Bits[0];

		System.out.println("RECEIVED HEADER: " + Request.readBool());
	}

}
