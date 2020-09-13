
package de.devjava.playshot.addon.listener.labymod;

import de.devjava.playshot.addon.LabyAddon;
import de.devjava.playshot.addon.listener.custom.RenderEntityEvent;
import de.devjava.playshot.addon.objects.modules.Module;
import de.devjava.playshot.addon.objects.register.LabyModEvent;
import de.devjava.playshot.addon.objects.register.Listener;
import de.devjava.playshot.addon.render.RenderUtils;
import de.devjava.playshot.addon.utils.Server;
import net.minecraft.util.EnumChatFormatting;

public class Listener_RenderEntityEvent implements Listener
{
	@LabyModEvent
	public void onRenderEntityEvent(RenderEntityEvent event)
	{

		if(!LabyAddon.getInstance().getLabyManager().getLabyClient().isConnected())
			return;

		for(Module module : LabyAddon.getInstance().getModuleManager().getModules())
			if(module.isEnabled())
				module.onRenderEntityEvent(event);
		
		
		if(event.getEntity().isSneaking())
			return;
		
		if(LabyAddon.getInstance().getLabyManager().getLabyClient().getServer() == Server.LAZERTAG)
			return;
		
		if(event.getEntity().getName().equals("DevJava") || event.getEntity().getName().equals("JavaVirus"))
				new RenderUtils().renderName(EnumChatFormatting.WHITE + "LabyAddon " + EnumChatFormatting.DARK_GRAY + "| " + EnumChatFormatting.AQUA + "Developer", event.getEntity(), event.getarg1(), event.getarg2(), event.getarg3());
	
		if(event.getEntity().getName().equals("Baum_Kind"))
				new RenderUtils().renderName(EnumChatFormatting.WHITE + "PlayShot " + EnumChatFormatting.DARK_GRAY + "| " + EnumChatFormatting.DARK_RED + "Inhaber", event.getEntity(), event.getarg1(), event.getarg2(), event.getarg3());

	}
}
