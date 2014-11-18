package org.destiny.client.messages.events;

import org.destiny.client.GameClient;
import org.destiny.client.Session;
import org.destiny.client.messages.MessageEvent;
import org.destiny.client.protocol.ClientMessage;
import org.destiny.client.protocol.ServerMessage;

public class BoxAccessEvent implements MessageEvent
{

	@Override
	public void parse(Session Session, ServerMessage Request, ClientMessage Message)
	{
		// Box access - receiving a string of pokedex numbers, e.g. B15,23,24,
		int[] pokes = new int[30];
		/* NOTE: -1 identifies that no pokemon is in a slot */
		if(Request.readInt() == 1)
		{
			String[] indexes = Request.readString().split(",");
			for(int i = 0; i < 30; i++)
				if(indexes.length > i)
					if(indexes[i] == null || indexes[i].compareTo("") == 0)
						pokes[i] = -1;
					else
						pokes[i] = Integer.parseInt(indexes[i]);
				else
					pokes[i] = -1;
		}
		else
			for(int i = 0; i < pokes.length; i++)
				pokes[i] = -1;
		if(!GameClient.getInstance().getHUD().hasBoxDialog())
		{
			GameClient.getInstance().getHUD().showBoxDialog(pokes);
			GameClient.getInstance().getOurPlayer().setBoxing(true);
		}
		else
			GameClient.getInstance().getHUD().getBoxDialog().changeBox(pokes);
	}
}
