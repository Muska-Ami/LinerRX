package moe.xmcn.linerrx

import me.zhenxin.qqbot.api.ApiManager
import me.zhenxin.qqbot.websocket.EventHandler
import moe.xmcn.linerrx.api.bukkit.AtMessageEvent
import moe.xmcn.linerrx.api.bukkit.DirectMessageEvent
import org.bukkit.Bukkit

open class EventBridge(
    private val api : ApiManager
) : EventHandler() {

    override fun onError(e: Exception?) {
        e?.printStackTrace()
    }

    override fun onAtMessage(event: me.zhenxin.qqbot.event.AtMessageEvent) {
        val atMessageEvent = AtMessageEvent(api, event)
        Bukkit.getScheduler().runTask(
            Bukkit.getServer().pluginManager.getPlugin("LinerRX")
        ) {
            Bukkit.getServer().pluginManager.callEvent(atMessageEvent)
        }
    }

    override fun onDirectMessage(event: me.zhenxin.qqbot.event.DirectMessageEvent) {
        val directMessageEvent = DirectMessageEvent(api, event)
        Bukkit.getScheduler().runTask(
            Bukkit.getServer().pluginManager.getPlugin("LinerRX")
        ) {
            Bukkit.getServer().pluginManager.callEvent(directMessageEvent)
        }
    }

}