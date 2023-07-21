package moe.xmcn.linerrx.util

import me.zhenxin.qqbot.api.ApiManager
import moe.xmcn.linerrx.api.bukkit.extend.Guild

class InitExtend(
    private val apiManager: ApiManager
) {
    fun init() {
        Guild.api = apiManager
    }
}