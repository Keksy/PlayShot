package de.devjava.playshot.addon.listener.custom;

import java.util.List;

import de.devjava.playshot.addon.objects.register.Event;
import net.labymod.user.User;
import net.labymod.user.util.UserActionEntry;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.player.EntityPlayer;

public class UserMenuActionEvent extends Event
{

	private NetworkPlayerInfo networkPlayerInfo;
	private EntityPlayer entityPlayer;
	private List<UserActionEntry> actionEntries;
	private User user;
	
	public UserMenuActionEvent(final User arg0, final EntityPlayer arg1, final NetworkPlayerInfo arg2, final List<UserActionEntry> arg3)
	{
		this.user = arg0;
		this.entityPlayer = arg1;
		this.networkPlayerInfo = arg2;
		this.actionEntries = arg3;
	}
	
	public List<UserActionEntry> getActionEntries()
	{
		return this.actionEntries;
	}
	
	public NetworkPlayerInfo getNetworkPlayerInfo()
	{
		return this.networkPlayerInfo;
	}
	
	public EntityPlayer getEntityPlayer()
	{
		return this.entityPlayer;
	}
	
	public User getUser()
	{
		return this.user;
	}
}
