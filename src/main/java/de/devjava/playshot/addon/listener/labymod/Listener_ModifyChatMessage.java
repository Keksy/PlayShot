
package de.devjava.playshot.addon.listener.labymod;

import de.devjava.playshot.addon.LabyAddon;
import de.devjava.playshot.addon.listener.custom.ModifyChatMessage;
import de.devjava.playshot.addon.objects.modules.Module;
import de.devjava.playshot.addon.objects.register.LabyModEvent;
import de.devjava.playshot.addon.objects.register.Listener;

public class Listener_ModifyChatMessage implements Listener
{
	@LabyModEvent
	public void onModifyChatMessage(ModifyChatMessage event)
	{
		if(!LabyAddon.getInstance().getLabyManager().getLabyClient().isConnected())
			return;
		
		for(Module module : LabyAddon.getInstance().getModuleManager().getModules())
			if(module.isEnabled())
				module.onModifyChatMessage(event);
	}
}
