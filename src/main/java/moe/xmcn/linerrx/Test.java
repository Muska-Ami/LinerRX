package moe.xmcn.linerrx;

import moe.xmcn.linerrx.api.bukkit.event.AtMessageEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class Test implements Listener {

    @EventHandler
    public void t(AtMessageEvent event) {
        event.getApiManager().getMessageApi().sendMessage(
                event.getChannelId(),
                "Hello world!",
                event.getMessageId());
    }

}
