package org.destiny.client.messages.events;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class LoginSuccessEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		final int id = Request.readInt();
		final String time = Request.readString();
		GameClient.getInstance().getGUI().invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				GameClient.getInstance().getGUIPane().hideLoginScreen();
			}
		});
		GameClient.getInstance().setPlayerId(id);
		GameClient.getInstance().getHUD().showChat();
		GameClient.getInstance().getTimeService().setTime(Integer.parseInt(time.substring(0, 2)), Integer.parseInt(time.substring(2)));

	}
}
