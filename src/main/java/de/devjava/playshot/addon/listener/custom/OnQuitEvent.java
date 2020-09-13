package de.devjava.playshot.addon.listener.custom;

import de.devjava.playshot.addon.objects.register.Event;
import net.labymod.utils.ServerData;

public class OnQuitEvent extends Event
{
	private ServerData serverData;
	
	public OnQuitEvent(final ServerData arg0)
	{
		this.serverData = arg0;
	}
	
	public ServerData getServerData()
	{
		return this.serverData;
	}
}
