package moe.xmcn.linerrx.api.bukkit.event

import me.zhenxin.qqbot.api.ApiManager
import me.zhenxin.qqbot.entity.MessageAttachment
import me.zhenxin.qqbot.entity.MessageEmbed
import me.zhenxin.qqbot.entity.User
import me.zhenxin.qqbot.entity.ark.MessageArk
import me.zhenxin.qqbot.event.UserMessageEvent
import org.bukkit.event.Event
import org.bukkit.event.HandlerList
import java.time.LocalDateTime

class UserMessageEvent(
    private val api: ApiManager,
    private val event: UserMessageEvent
) : Event() {

    /**
     * 获取消息内容
     * @return 消息
     */
    val message: String
        get() = event.message.content

    /**
     * 获取消息ID
     * @return 消息ID
     */
    val messageId: String
        get() = event.message.id

    /**
     * 获取子频道ID
     * @return 子频道ID
     */
    val channelId: String
        get() = event.message.channelId

    /**
     * 获取消息模板
     * @return 消息模板
     */
    val ark: MessageArk
        get() = event.message.ark

    /**
     * 获取发消息的人
     * @return 用户对象
     */
    val author: User
        get() = event.message.author

    /**
     * 获取消息附件
     * @return 消息附件
     */
    val attachments: Array<MessageAttachment>
        get() = event.message.attachments

    /**
     * 获取消息编辑时间
     * @return 编辑时间
     */
    val editedTimestamp: LocalDateTime
        get() = event.message.editedTimestamp

    /**
     * 获取嵌套消息列表
     * @return 嵌套消息列表
     */
    val embeds: Array<MessageEmbed>
        get() = event.message.embeds

    /**
     * 获取消息发送时间
     * @return 发送时间
     */
    val timestamp: LocalDateTime
        get() = event.message.timestamp

    /**
     * 获取消息源频道ID
     * @return 源频道ID
     */
    val srcGuildId: String
        get() = event.message.srcGuildId

    /**
     * 获取频道ID
     * @return 频道ID
     */
    val guildId: String
        get() = event.message.guildId

    /**
     * 获取API
     */
    val apiManager: ApiManager
        get() = api

    /**
     * 获取源事件（不安全）
     * @return AtMessageEvent
     */
    @Deprecated("Unsafe")
    val originSession: UserMessageEvent
        get() = event

    override fun getHandlers(): HandlerList {
        return Companion.handlers
    }

    companion object {
        private val handlers = HandlerList()
        @JvmStatic
        val handlerList: HandlerList
            get() = handlers
    }
}