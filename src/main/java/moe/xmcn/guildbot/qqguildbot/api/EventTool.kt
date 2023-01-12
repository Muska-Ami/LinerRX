package moe.xmcn.guildbot.qqguildbot.api

import me.zhenxin.qqbot.api.ApiManager
import me.zhenxin.qqbot.event.AtMessageEvent
import me.zhenxin.qqbot.websocket.EventHandler
import moe.xmcn.guildbot.qqguildbot.api.bukkit.GuildAtEvent
import org.bukkit.Bukkit

open class EventTool(private val api : ApiManager) : EventHandler() {

    override fun onError(e: Exception?) {
        e?.printStackTrace()
    }

    override fun onAtMessage(event: AtMessageEvent) {
        val atEvent = GuildAtEvent(api, event)
        Bukkit.getServer().pluginManager.callEvent(atEvent)
    }

}