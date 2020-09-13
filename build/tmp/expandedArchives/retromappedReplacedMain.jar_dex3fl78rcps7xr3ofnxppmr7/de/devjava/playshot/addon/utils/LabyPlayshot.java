package de.devjava.playshot.addon.utils;

import java.util.List;

import de.devjava.playshot.addon.LabyAddon;
import net.labymod.api.events.TabListEvent;
import net.labymod.servermanager.ChatDisplayAction;
import net.labymod.servermanager.Server;
import net.labymod.settings.elements.SettingsElement;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.network.PacketBuffer;

public class LabyPlayshot extends Server {


    public LabyPlayshot() {
        super("PlayShot", new String[] {"playshot.de", "mc-987.playshot.de"});
    }

    @Override
    public void onJoin(ServerData serverData) 
    {
        System.out.println("Join PlayShot \n\n");
        LabyAddon.getInstance().getLabyManager().getLabyClient().setConnected(true);
    }

    @Override
    public void reset() 
    {
        System.out.println("Left PlayShot \n\n");
        LabyAddon.getInstance().getLabyManager().getLabyClient().setConnected(false);
        LabyAddon.getInstance().getLabyManager().getLabyClient().setServer(de.devjava.playshot.addon.utils.Server.OFFLINE);
    }

    @Override
    public ChatDisplayAction handleChatMessage(String s, String s1) throws Exception
    {
        return ChatDisplayAction.NORMAL;
    }

    @Override
    public void handlePluginMessage(String s, PacketBuffer packetBuffer) throws Exception 
    {

    }

    @Override
    public void handleTabInfoMessage(TabListEvent.Type type, String s, String s1) throws Exception 
    {

    }

    @Override
    public void fillSubSettings(List<SettingsElement> list) 
    {

    }
}