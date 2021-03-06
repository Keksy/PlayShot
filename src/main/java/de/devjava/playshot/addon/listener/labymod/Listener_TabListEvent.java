
package de.devjava.playshot.addon.listener.labymod;

import de.devjava.playshot.addon.LabyAddon;
import de.devjava.playshot.addon.listener.custom.TabListEvent;
import de.devjava.playshot.addon.objects.modules.Module;
import de.devjava.playshot.addon.objects.register.LabyModEvent;
import de.devjava.playshot.addon.objects.register.Listener;
import de.devjava.playshot.addon.utils.Server;
import net.labymod.api.events.TabListEvent.Type;
import net.minecraft.client.Minecraft;

public class Listener_TabListEvent implements Listener
{
	@LabyModEvent
	public void onRenderEntityEvent(TabListEvent event)
	{
		if(!LabyAddon.getInstance().getLabyManager().getLabyClient().isConnected())
			return;

		for(Module module : LabyAddon.getInstance().getModuleManager().getModules())
			if(module.isEnabled())
				module.onTabListEvent(event);

		if(event.getTpe() == Type.HEADER)
			for(Server server : Server.values())
				if(event.getarg1().toLowerCase().contains(server.name().toLowerCase()))
				{
					if(LabyAddon.getInstance().getLabyManager().getLabyClient().getServer() == server)
						return;
					
					LabyAddon.getInstance().getLabyManager().getLabyClient().setServer(server);
					return;
				}

	}
}
