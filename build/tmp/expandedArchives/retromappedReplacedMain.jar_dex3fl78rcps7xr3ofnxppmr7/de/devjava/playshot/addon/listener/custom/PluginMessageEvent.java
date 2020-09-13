package de.devjava.playshot.addon.listener.custom;

import de.devjava.playshot.addon.objects.register.Event;
import net.minecraft.network.PacketBuffer;

public class PluginMessageEvent extends Event
{

	private String arg0;
	private PacketBuffer packetBuffer;
	
	public PluginMessageEvent(final String arg0, final PacketBuffer packetBuffer)
	{
		this.arg0 = arg0;
		this.packetBuffer = packetBuffer;
	}
	
	public PacketBuffer getPacketBuffer()
	{
		return this.packetBuffer;
	}
	
	public String getarg0()
	{
		return this.arg0;
	}
}
