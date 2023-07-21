package moe.xmcn.linerrx.api.bukkit.extend

import me.zhenxin.qqbot.api.ApiManager
import me.zhenxin.qqbot.entity.Guild
import me.zhenxin.qqbot.entity.Member

class Guild {
    companion object {
        var api: ApiManager? = null
    }

    /**
     * 获取频道信息
     *
     * @param guildId 频道ID
     */
    fun guildInfo(guildId: String): Guild? {
        return api?.guildApi?.getGuildInfo(guildId)
    }

    /**
     * 获取频道成员列表 (仅私域可用)
     * @param guildId 频道ID
     * @param limit   返回的成员数量 (1-1000)
     */
    fun getGuildMembers(guildId: String, limit: Int): List<Member>? {
        return api?.guildApi?.getGuildMembers(guildId, limit)
    }

    /**
     * 获取频道成员列表 (仅私域可用)
     * @param after 上一次请求返回的最后一个成员的ID
     * @param limit 返回的成员数量 (1-1000)
     */
    fun getGuildMembers(guildId: String, after: String, limit: Int): List<Member>? {
        return api?.guildApi?.getGuildMembers(guildId, after, limit)
    }
}