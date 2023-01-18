package moe.xmcn.guildbot.qqguildbot.api

import me.zhenxin.qqbot.api.ApiManager
import me.zhenxin.qqbot.websocket.EventHandler
import org.bukkit.Bukkit

open class EventTool(
    private val api : ApiManager
) : EventHandler() {

    override fun onError(e: Exception?) {
        e?.printStackTrace()
    }

    override fun onAtMessage(event: me.zhenxin.qqbot.event.AtMessageEvent) {
        val atMessageEvent = moe.xmcn.guildbot.qqguildbot.api.bukkit.AtMessageEvent(api, event)
        Bukkit.getScheduler().runTask(
            Bukkit.getServer().pluginManager.getPlugin("QQGuildBotMC")
        ) {
            Bukkit.getServer().pluginManager.callEvent(atMessageEvent)
        }
    }

    override fun onDirectMessage(event: me.zhenxin.qqbot.event.DirectMessageEvent) {
        val directMessageEvent = moe.xmcn.guildbot.qqguildbot.api.bukkit.DirectMessageEvent(api, event)
        Bukkit.getScheduler().runTask(
            Bukkit.getServer().pluginManager.getPlugin("QQGuildBotMC")
        ) {
            Bukkit.getServer().pluginManager.callEvent(directMessageEvent)
        }
    }

}