package de.devjava.playshot.addon.listener.custom;

import de.devjava.playshot.addon.objects.register.Event;

public class ReceiveChatMessage extends Event
{

	private String arg0, arg1;
	private boolean canceled = false;

	public ReceiveChatMessage(final String arg0, final String arg1)
	{
		this.arg0 = arg0;
		this.arg1 = arg1;
	}
	
	public String getarg0()
	{
		return this.arg0;
	}
	
	public String getarg1()
	{
		return this.arg1;
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

