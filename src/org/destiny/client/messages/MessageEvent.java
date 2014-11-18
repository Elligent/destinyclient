package org.destiny.client.messages;

import org.destiny.client.Session;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public interface MessageEvent
{
	public void parse(Session session, ServerMessage request, ClientMessage message);
}