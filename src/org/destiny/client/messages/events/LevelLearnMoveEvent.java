package org.destiny.client.messages.events;

import org.destiny.client.Session;
import org.destiny.client.backend.MoveLearningManager;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class LevelLearnMoveEvent implements MessageEvent
{
	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		int i = Request.readInt();
		MoveLearningManager.getInstance().queueMoveLearning(i, Request.readString());
	}
}
