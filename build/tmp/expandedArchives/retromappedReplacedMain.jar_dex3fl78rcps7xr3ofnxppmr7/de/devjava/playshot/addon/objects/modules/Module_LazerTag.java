
package de.devjava.playshot.addon.objects.modules;

import de.devjava.playshot.addon.LabyAddon;
import de.devjava.playshot.addon.listener.custom.ReceiveChatMessage;
import de.devjava.playshot.addon.listener.custom.RenderEntityEvent;
import de.devjava.playshot.addon.objects.settings.Settings;
import de.devjava.playshot.addon.render.RenderUtils;
import de.devjava.playshot.addon.utils.CC;
import de.devjava.playshot.addon.utils.Color;
import de.devjava.playshot.addon.utils.DyeColor;
import de.devjava.playshot.addon.utils.EnumDyeColor;
import de.devjava.playshot.addon.utils.Server;
import net.labymod.core.LabyModCore;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.EnumChatFormatting;
import scala.collection.parallel.ParIterableLike.Min;

public class Module_LazerTag extends Module
{

	public Module_LazerTag()
	{
		super(Settings.LAZERTAG_SHOWTEAM);
	}

	public CC getTeamColor(EntityPlayer entityPlayer)
	{
		for(int i = 0; i < 4; i++)
			if(entityPlayer.func_82169_q(i) != null)
				if(entityPlayer.func_82169_q(i).func_77973_b().equals(Items.field_151021_T))
					if(entityPlayer.func_82169_q(i).serializeNBT().func_74775_l("tag").func_74775_l("display").func_74781_a("color") != null)
						return this.getColor(Integer.valueOf(entityPlayer.func_82169_q(i).serializeNBT().func_74775_l("tag").func_74775_l("display").func_74781_a("color") + ""));
		return null;
	}

	public CC getColor(int colorid)
	{
		for(CC cc : CC.values())
			if(colorid == cc.getColor())
				return cc;
		return null;
	}

	@Override
	public void onRenderEntityEvent(RenderEntityEvent event)
	{
		if(!isEnabled())
			return;

		if(LabyAddon.getInstance().getLabyManager().getLabyClient().getServer() != Server.LAZERTAG)
			return;

		if(this.getTeamColor(Minecraft.func_71410_x().field_71439_g) == null)
			return;

		for(Entity entity : Minecraft.func_71410_x().field_71441_e.field_72996_f)
			if(entity instanceof EntityPlayer)
			{
				EntityPlayer entityPlayer = (EntityPlayer) entity;

				if(this.getTeamColor(Minecraft.func_71410_x().field_71439_g) == this.getTeamColor(entityPlayer))
					new RenderUtils().renderName(this.getTeamColor(Minecraft.func_71410_x().field_71439_g).getChatColor() + "Teammate", event.getEntity(), event.getarg1(), event.getarg2(), event.getarg3());
			}
	}
}
