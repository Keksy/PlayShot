package de.devjava.playshot.addon.listener.custom;

import com.google.gson.JsonElement;

import de.devjava.playshot.addon.objects.register.Event;

public class ServerMessageEvent extends Event
{

	private String arg0;
	private JsonElement arg1;
	
	public ServerMessageEvent(final String arg0, final JsonElement arg1)
	{
		this.arg0 = arg0;
		this.arg1 = arg1;
	}
	
	public String getarg0()
	{
		return this.arg0;
	}
	
	public JsonElement getarg1()
	{
		return this.arg1;
	}
}
