
package de.devjava.playshot.addon.listener.labymod;

import de.devjava.playshot.addon.LabyAddon;
import de.devjava.playshot.addon.listener.custom.OnTickEventRender;
import de.devjava.playshot.addon.objects.modules.Module;
import de.devjava.playshot.addon.objects.register.LabyModEvent;
import de.devjava.playshot.addon.objects.register.Listener;
import net.labymod.core.LabyModCore;
import net.labymod.core.WorldRendererAdapter;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class Listener_OnTickEventRender implements Listener
{
	@LabyModEvent
	public void OnTickEvent(OnTickEventRender event)
	{
		if(!LabyAddon.getInstance().getLabyManager().getLabyClient().isConnected())
			return;

		for(Module module : LabyAddon.getInstance().getModuleManager().getModules())
			if(module.isEnabled())
				module.onTickRender();

	}
}
