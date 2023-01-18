package moe.xmcn.guildbot.qqguildbot.api.bukkit

import me.zhenxin.qqbot.api.ApiManager
import me.zhenxin.qqbot.entity.MessageAttachment
import me.zhenxin.qqbot.entity.MessageEmbed
import me.zhenxin.qqbot.entity.User
import me.zhenxin.qqbot.entity.ark.MessageArk
import me.zhenxin.qqbot.event.AtMessageEvent
import org.bukkit.event.Event
import org.bukkit.event.HandlerList
import java.time.LocalDateTime

class AtMessageEvent(private val api: ApiManager, private val event: AtMessageEvent) : Event() {

    val message: String
        get() = event.message.content
    val messageId: String
        get() = event.message.id
    val channelId: String
        get() = event.message.channelId
    val ark: MessageArk
        get() = event.message.ark
    val author: User
        get() = event.message.author
    val attachments: Array<MessageAttachment>
        get() = event.message.attachments
    val editedTimestamp: LocalDateTime
        get() = event.message.editedTimestamp
    val embeds: Array<MessageEmbed>
        get() = event.message.embeds
    val timestamp: LocalDateTime
        get() = event.message.timestamp
    val srcGuildId: String
        get() = event.message.srcGuildId
    val guildId: String
        get() = event.message.guildId

    override fun getHandlers(): HandlerList {
        return Companion.handlers
    }

    companion object {
        private val handlers = HandlerList()
        val handlerList: HandlerList
            get() = handlers
    }
}