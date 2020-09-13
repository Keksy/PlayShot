package de.devjava.playshot.addon.listener.custom;

import de.devjava.playshot.addon.objects.register.Event;

public class MessageSendEvent extends Event
{

	private String arg0;
	private boolean canceled = false;
	
	public MessageSendEvent(final String arg0)
	{
		this.arg0 = arg0;
	}
	
	public String getarg0()
	{
		return this.arg0;
	}
	
	public void setCanceled(boolean canceled)
	{
		this.canceled = canceled;
	}

	public boolean isCanceled()
	{
		return this.canceled;
	}
}

