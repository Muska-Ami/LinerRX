package moe.xmcn.linerrx

import me.zhenxin.qqbot.api.ApiManager
import me.zhenxin.qqbot.websocket.EventHandler
import moe.xmcn.linerrx.api.bukkit.event.AtMessageEvent
import moe.xmcn.linerrx.api.bukkit.event.DirectMessageEvent
import moe.xmcn.linerrx.api.bukkit.event.UserMessageEvent
import org.bukkit.Bukkit

open class EventTranslator(
    private val api : ApiManager
) : EventHandler() {

    override fun onError(e: Exception?) {
        e?.printStackTrace()
    }

    override fun onAtMessage(eventImpl: me.zhenxin.qqbot.event.AtMessageEvent) {
        val event = AtMessageEvent(api, eventImpl)
        Bukkit.getScheduler().runTask(
            LinerRX.INSTANCE
        ) {
            Bukkit.getServer().pluginManager.callEvent(event)
        }
    }

    override fun onDirectMessage(eventImpl: me.zhenxin.qqbot.event.DirectMessageEvent) {
        val event = DirectMessageEvent(api, eventImpl)
        Bukkit.getScheduler().runTask(
            LinerRX.INSTANCE
        ) {
            Bukkit.getServer().pluginManager.callEvent(event)
        }
    }

    override fun onUserMessage(eventImpl: me.zhenxin.qqbot.event.UserMessageEvent) {
        val event = UserMessageEvent(api, eventImpl)
        Bukkit.getScheduler().runTask(
            LinerRX.INSTANCE
        ) {
            Bukkit.getServer().pluginManager.callEvent(event)
        }
    }

}