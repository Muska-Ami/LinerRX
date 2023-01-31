package moe.xmcn.linerrx.command

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor
import org.bukkit.plugin.Plugin
import org.jetbrains.annotations.NotNull

class QGB(
    private val plugin: Plugin
): TabExecutor {
    override fun onTabComplete(
        @NotNull sender: CommandSender,
        @NotNull command: Command,
        @NotNull alias: String,
        @NotNull args: Array<out String>
    ): ArrayList<String>? {
        return null
    }

    override fun onCommand(
        @NotNull sender: CommandSender,
        @NotNull command: Command,
        @NotNull label: String,
        @NotNull args: Array<out String>
    ): Boolean {
        sender.sendMessage("QQGuildBot Running!")
        return true
    }

}