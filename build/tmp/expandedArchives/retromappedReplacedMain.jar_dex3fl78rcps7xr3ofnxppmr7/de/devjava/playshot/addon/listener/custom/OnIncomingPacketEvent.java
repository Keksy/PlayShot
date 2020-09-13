package de.devjava.playshot.addon.listener.custom;

import de.devjava.playshot.addon.objects.register.Event;

public class OnIncomingPacketEvent extends Event
{

	private Object arg0;
	
	public OnIncomingPacketEvent(final Object arg0)
	{
		this.arg0 = arg0;
	}
	
	public Object getarg0()
	{
		return this.arg0;
	}
}
