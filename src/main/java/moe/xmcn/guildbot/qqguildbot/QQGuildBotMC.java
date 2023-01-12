package moe.xmcn.guildbot.qqguildbot;

import moe.xmcn.guildbot.qqguildbot.api.DoLogin;
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

        new DoLogin().login(
                botAppId,
                botToken,
                false
        );
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
