package moe.xmcn.guildbot.qqguildbot;

import moe.xmcn.guildbot.qqguildbot.api.DoLogin;
import moe.xmcn.guildbot.qqguildbot.command.QGB;
import org.bukkit.plugin.java.JavaPlugin;

public final class QQGuildBotMC extends JavaPlugin {

    @Override
    public void onLoad() {
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        int botAppId = getConfig().getInt("app.botAppId");
        String botToken = getConfig().getString("app.botToken");

        getLogger().info("正在登录到网关...");
        try {
            DoLogin.Companion.login(
                    botAppId,
                    botToken,
                    false
            );
        } catch (Exception exception) {
            getLogger().warning("登录失败：");
            exception.printStackTrace();
        }

        getCommand("qgb").setExecutor(new QGB(this));
        getCommand("qqguildbot").setExecutor(new QGB(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
