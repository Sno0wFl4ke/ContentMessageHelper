package eu.beeadev.contentmessagehelper.commands

import eu.beeadev.contentmessagehelper.ContentMessageHelper
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/*
This command is used to create a clear message in chat so
the executer can type custom messages in that will be just shown in chat as typed

Example: /execute &8[&fPrefix&8] &7Message
Chat output (colored): [Prefix] Message
Permission: contentmessagehelper.use
 */

class EmptyCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>?): Boolean {
        if (sender !is Player) {
            sender.sendMessage("${ContentMessageHelper.PREFIX}§cYou can only execute this command as a player!")
            return false
        }
        val player: Player = sender
        if (!player.hasPermission("contentmessagehelper.use")) {
            sender.sendMessage("${ContentMessageHelper.PREFIX}§cYou don't have enough permissions to execute this command!")
            return false
        }

        if (args?.size == 0) {
            player.sendMessage("${ContentMessageHelper.PREFIX}§7Usage §9/§7empty §9(§7message§9)")
        } else {
            var message = ""
            repeat(args!!.size) { message = message + args[it] + " "; }
            message = ChatColor.translateAlternateColorCodes('&', message)
            player.sendMessage(message)
        }
        return false
    }
}