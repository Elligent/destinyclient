package org.destiny.client.messages.events;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class MoveTutorEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		String s = Request.readString();
		String name = s.split("_")[0];
		if(name.equals("MoveRelearner"))
		{
			GameClient.getInstance().getHUD().showRelearnDialog(s.split("_")[1]);
		}
		else if(name.equals("MoveTutor"))
		{
			GameClient.getInstance().getHUD().showTutorDialog(s.split("_")[1]);
		}
	}
}
