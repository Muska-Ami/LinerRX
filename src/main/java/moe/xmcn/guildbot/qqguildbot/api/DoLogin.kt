package moe.xmcn.guildbot.qqguildbot.api

import me.zhenxin.qqbot.api.ApiManager
import me.zhenxin.qqbot.core.BotCore
import me.zhenxin.qqbot.entity.AccessInfo
import me.zhenxin.qqbot.enums.Intent

class DoLogin {

    fun login(botAppId: Int, botToken: String, sandbox: Boolean) {
        val accessInfo = AccessInfo()
        accessInfo.botAppId = botAppId //102034183 // 管理端的BotAppId
        accessInfo.botToken = botToken //"u6aKk6VDFLMqzWsZ4qZnfeVRE42Eog8R" // 管理端的BotToken
        // 使用沙盒模式
        if (sandbox) accessInfo.useSandBoxMode()
        // 创建实例
        val bot = BotCore(accessInfo)
        // 获取API管理器
        val api: ApiManager = bot.apiManager
        // 注册AT消息相关事件
        bot.registerIntents(Intent.AT_MESSAGES)
        // 设置事件处理器
        // handler.setRemoveAt(false); // 取消删除消息中的艾特
        bot.setEventHandler(EventTool(api))
        // 启动
        bot.start()
    }

}