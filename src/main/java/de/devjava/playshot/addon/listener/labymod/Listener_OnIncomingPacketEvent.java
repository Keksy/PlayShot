
package de.devjava.playshot.addon.listener.labymod;

import de.devjava.playshot.addon.LabyAddon;
import de.devjava.playshot.addon.listener.custom.OnIncomingPacketEvent;
import de.devjava.playshot.addon.objects.modules.Module;
import de.devjava.playshot.addon.objects.register.LabyModEvent;
import de.devjava.playshot.addon.objects.register.Listener;

public class Listener_OnIncomingPacketEvent implements Listener
{
	@LabyModEvent
	public void OnIncomingPacketEvent(OnIncomingPacketEvent event)
	{
		if(!LabyAddon.getInstance().getLabyManager().getLabyClient().isConnected())
			return;
		
		for(Module module : LabyAddon.getInstance().getModuleManager().getModules())
			if(module.isEnabled())
				module.OnIncomingPacketEvent(event);
	}
}
