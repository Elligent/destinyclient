package org.destiny.client.messages.events;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class LoggedElsewhereEvent implements MessageEvent
{

	@Override
	public void parse(Session session, ServerMessage request, ClientMessage message)
	{
		GameClient.getInstance().getGUI().invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				GameClient.getInstance().showMessageDialog("You seem to be logged onto another server, please log out there first.");
				GameClient.getInstance().getGUIPane().hideLoadingScreen();
				GameClient.getInstance().getLoginScreen().showLogin();
			}
		});
	}
}
