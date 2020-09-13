
package de.devjava.playshot.addon.listener.custom;

import de.devjava.playshot.addon.objects.register.Event;
import net.labymod.api.events.TabListEvent.Type;

public class TabListEvent extends Event
{

	private Type tpe;
	private String arg1, arg2;

	public TabListEvent(final Type arg0, final String arg1, final String arg2)
	{
		this.tpe = arg0;
		this.arg1 = arg1;
		this.arg2 = arg2;
	}

	public Type getTpe()
	{
		return this.tpe;
	}
	
	public String getarg1()
	{
		return this.arg1;
	}
	
	public String getarg2()
	{
		return this.arg2;
	}
	
}
