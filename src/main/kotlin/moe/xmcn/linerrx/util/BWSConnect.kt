package moe.xmcn.linerrx.util

import me.zhenxin.qqbot.api.ApiManager
import me.zhenxin.qqbot.core.BotCore
import me.zhenxin.qqbot.entity.AccessInfo
import me.zhenxin.qqbot.enums.Intent
import moe.xmcn.linerrx.EventTranslator

class BWSConnect {

    companion object {

        @JvmStatic
        lateinit var bot: BotCore

        fun login(botAppId: Int, botToken: String, sandbox: Boolean) {
            val accessInfo = AccessInfo()
            accessInfo.botAppId = botAppId // 管理端的BotAppId
            accessInfo.botToken = botToken // 管理端的BotToken
            // 使用沙盒模式
            if (sandbox) accessInfo.useSandBoxMode()
            // 创建实例
            bot = BotCore(accessInfo)
            // 获取API管理器
            val api: ApiManager = bot.apiManager
            // 注册AT消息相关事件
            bot.registerIntents(Intent.AT_MESSAGES)
            bot.registerIntents(Intent.DIRECT_MESSAGE)
            bot.registerIntents(Intent.USER_MESSAGES)
            // 设置事件处理器
            // handler.setRemoveAt(false); // 取消删除消息中的艾特
            bot.setEventHandler(EventTranslator(api))
            InitExtend(api).init()
            // 启动
            bot.start()
        }
    }

}