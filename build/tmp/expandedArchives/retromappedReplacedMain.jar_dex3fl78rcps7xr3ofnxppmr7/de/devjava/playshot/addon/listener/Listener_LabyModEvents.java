
package de.devjava.playshot.addon.listener;

import java.util.List;

import com.google.gson.JsonElement;

import de.devjava.playshot.addon.LabyAddon;
import de.devjava.playshot.addon.listener.custom.ModifyChatMessage;
import de.devjava.playshot.addon.listener.custom.ReceiveChatMessage;
import net.labymod.api.EventManager;
import net.labymod.api.LabyModAPI;
import net.labymod.api.events.MessageModifyChatEvent;
import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.api.events.MessageSendEvent;
import net.labymod.api.events.PluginMessageEvent;
import net.labymod.api.events.RenderEntityEvent;
import net.labymod.api.events.ServerMessageEvent;
import net.labymod.api.events.TabListEvent;
import net.labymod.api.events.UserMenuActionEvent;
import net.labymod.user.User;
import net.labymod.user.util.UserActionEntry;
import net.labymod.utils.Consumer;
import net.labymod.utils.ServerData;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;

public class Listener_LabyModEvents extends EventManager
{

	private LabyModAPI labyModAPI;

	public Listener_LabyModEvents(final LabyModAPI labyModAPI)
	{
		this.labyModAPI = labyModAPI;
	}

	public LabyModAPI getLabyModAPI()
	{
		return LabyAddon.getInstance().getApi();
	}

	public void register()
	{
		this.getLabyModAPI().getEventManager().register(new MessageModifyChatEvent()
		{

			@Override
			public Object onModifyChatMessage(Object arg0)
			{
				final ModifyChatMessage event = new ModifyChatMessage(arg0);
				LabyAddon.getInstance().getListenerManager().callListener(event);
				return event.getResult();
			}
		});

		this.getLabyModAPI().getEventManager().register(new MessageReceiveEvent()
		{

			@Override
			public boolean onReceive(String arg0, String arg1)
			{
				final ReceiveChatMessage event = new ReceiveChatMessage(arg0, arg1);
				LabyAddon.getInstance().getListenerManager().callListener(event);
				return event.isCanceled();
			}
		});

		this.getLabyModAPI().getEventManager().register(new MessageSendEvent()
		{

			@Override
			public boolean onSend(String arg0)
			{
				final de.devjava.playshot.addon.listener.custom.MessageSendEvent event = new de.devjava.playshot.addon.listener.custom.MessageSendEvent(arg0);
				LabyAddon.getInstance().getListenerManager().callListener(event);
				return event.isCanceled();
			}
		});

		this.getLabyModAPI().getEventManager().register(new PluginMessageEvent()
		{

			@Override
			public void receiveMessage(String arg0, PacketBuffer arg1)
			{
				LabyAddon.getInstance().getListenerManager().callListener(new de.devjava.playshot.addon.listener.custom.PluginMessageEvent(arg0, arg1));
			}
		});

		this.getLabyModAPI().getEventManager().register(new RenderEntityEvent()
		{

			@Override
			public void onRender(Entity arg0, double arg1, double arg2, double arg3, float arg4)
			{
				LabyAddon.getInstance().getListenerManager().callListener(new de.devjava.playshot.addon.listener.custom.RenderEntityEvent(arg0, arg1, arg2, arg3, arg4));
			}
		});

		this.getLabyModAPI().getEventManager().register(new ServerMessageEvent()
		{

			@Override
			public void onServerMessage(String arg0, JsonElement arg1)
			{
				LabyAddon.getInstance().getListenerManager().callListener(new de.devjava.playshot.addon.listener.custom.ServerMessageEvent(arg0, arg1));

			}
		});

		this.getLabyModAPI().getEventManager().register(new TabListEvent()
		{

			@Override
			public void onUpdate(Type arg0, String arg1, String arg2)
			{
				LabyAddon.getInstance().getListenerManager().callListener(new de.devjava.playshot.addon.listener.custom.TabListEvent(arg0, arg1, arg2));
			}
		});

		this.getLabyModAPI().getEventManager().register(new UserMenuActionEvent()
		{

			@Override
			public void createActions(User arg0, EntityPlayer arg1, NetworkPlayerInfo arg2, List<UserActionEntry> arg3)
			{
				LabyAddon.getInstance().getListenerManager().callListener(new de.devjava.playshot.addon.listener.custom.UserMenuActionEvent(arg0, arg1, arg2, arg3));

			}
		});

		this.getLabyModAPI().getEventManager().registerOnAttack(new Consumer<Entity>()
		{

			@Override
			public void accept(Entity arg0)
			{
				LabyAddon.getInstance().getListenerManager().callListener(new de.devjava.playshot.addon.listener.custom.OnAttackEvent(arg0));

			}
		});

		this.getLabyModAPI().getEventManager().registerOnIncomingPacket(new Consumer<Object>()
		{

			@Override
			public void accept(Object arg0)
			{
				LabyAddon.getInstance().getListenerManager().callListener(new de.devjava.playshot.addon.listener.custom.OnIncomingPacketEvent(arg0));

			}
		});

		this.getLabyModAPI().getEventManager().registerOnJoin(new Consumer<ServerData>()
		{

			@Override
			public void accept(ServerData arg0)
			{
				LabyAddon.getInstance().getListenerManager().callListener(new de.devjava.playshot.addon.listener.custom.OnJoinEvent(arg0));

			}
		});

		this.getLabyModAPI().getEventManager().registerOnQuit(new Consumer<ServerData>()
		{

			@Override
			public void accept(ServerData arg0)
			{
				LabyAddon.getInstance().getListenerManager().callListener(new de.devjava.playshot.addon.listener.custom.OnQuitEvent(arg0));

			}
		});
	}
}
