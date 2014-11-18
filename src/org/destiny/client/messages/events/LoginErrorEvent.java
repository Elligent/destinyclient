package org.destiny.client.messages.events;

import java.util.ArrayList;
import java.util.List;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.backend.Translator;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class LoginErrorEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		List<String> translated = new ArrayList<String>();
		translated = Translator.translate("_LOGIN");

		GameClient.getInstance().showMessageDialog(translated.get(21));
		GameClient.getInstance().getGUIPane().hideLoadingScreen();
		GameClient.getInstance().getLoginScreen().enableLogin();
	}
}
