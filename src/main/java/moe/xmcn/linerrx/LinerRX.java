package moe.xmcn.linerrx;

import moe.xmcn.linerrx.util.BWSConnect;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class LinerRX extends JavaPlugin {

    public static Plugin INSTANCE;

    @Override
    public void onLoad() {
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        INSTANCE = this;
        int botAppId = getConfig().getInt("app.botAppId");
        String botToken = getConfig().getString("app.botToken");

        getLogger().info("正在登录到网关...");
        try {
            BWSConnect.Companion.login(
                    botAppId,
                    botToken,
                    false
            );
        } catch (Exception exception) {
            getLogger().warning("登录失败：");
            exception.printStackTrace();
        }

        getCommand("linerrx").setExecutor(new moe.xmcn.linerrx.command.LinerRX(this));
        getCommand("lrx").setExecutor(new moe.xmcn.linerrx.command.LinerRX(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
