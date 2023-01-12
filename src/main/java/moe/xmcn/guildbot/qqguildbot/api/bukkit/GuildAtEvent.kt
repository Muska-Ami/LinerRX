package moe.xmcn.guildbot.qqguildbot.api.bukkit

import me.zhenxin.qqbot.api.ApiManager
import me.zhenxin.qqbot.entity.Message
import me.zhenxin.qqbot.entity.MessageAttachment
import me.zhenxin.qqbot.entity.MessageEmbed
import me.zhenxin.qqbot.entity.User
import me.zhenxin.qqbot.entity.ark.MessageArk
import me.zhenxin.qqbot.event.AtMessageEvent
import org.bukkit.event.Event
import org.bukkit.event.HandlerList
import java.time.LocalDateTime


open class GuildAtEvent(private val api: ApiManager, private val event: AtMessageEvent) : Event(true) {

    private val handlers = HandlerList()

    /**
     * 消息内容
     * @return 消息内容
     */
    fun getMessage(): String {
        return event.message.content
    }

    /**
     * 消息ID
     * @return 消息ID
     */
    fun getMessageId(): String {
        return event.message.id
    }

    /**
     * 子频道ID
     * @return 子频道ID
     */
    fun getChannelId(): String {
        return event.message.channelId
    }

    /**
     * Ark消息
     * @return Ark
     */
    fun getArk(): MessageArk {
        return event.message.ark
    }

    /**
     * 消息创建人
     * @return 创建人
     */
    fun getAuthor(): User {
        return event.message.author
    }

    /**
     * 消息附件
     * @return 附件列表
     */
    fun getAttachments(): Array<out MessageAttachment> {
        return event.message.attachments
    }

    /**
     * 消息编辑时间
     * @return 编辑时间
     */
    fun getEditedTimestamp(): LocalDateTime {
        return event.message.editedTimestamp
    }

    /**
     * 消息Embed对象
     * @return Embed对象
     */
    fun getEmbeds(): Array<out MessageEmbed> {
        return event.message.embeds
    }

    /**
     * 消息创建时间
     * @return 消息创建时间
     */
    fun getTimestamp(): LocalDateTime {
        return event.message.timestamp
    }

    /**
     * 来源频道ID
     * 用于私信场景下识别真实的来源频道。
     * @return 来源频道ID
     */
    fun getSrcGuildId(): String {
        return event.message.srcGuildId
    }

    /**
     * 频道ID
     * @return 频道ID
     */
    fun getGuildId(): String {
        return event.message.guildId
    }

    override fun getHandlers(): HandlerList {
        return handlers
    }

    open fun getHandlerList(): HandlerList {
        return handlers
    }

}
