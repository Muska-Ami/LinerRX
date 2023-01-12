package moe.xmcn.guildbot.qqguildbot.listener

import moe.xmcn.guildbot.qqguildbot.api.bukkit.GuildAtEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin
import java.util.logging.Level

class ExampleListen: Listener {

    private var plugin: Plugin? = null

    fun ExampleListen(plugin: Plugin) {
        this.plugin = plugin
    }

    @EventHandler
    fun onAtEvent(event: GuildAtEvent) {
        plugin?.logger?.log(
            Level.INFO,
            "[Guild] (" +
                    event.getGuildId() +
                    "\\" +
                    event.getChannelId() +
                    ") - " +
                    event.getAuthor() +
                    ":" +
                    event.getMessage()
        )
    }

}