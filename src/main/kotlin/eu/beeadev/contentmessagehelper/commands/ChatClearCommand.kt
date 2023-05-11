package eu.beeadev.contentmessagehelper.commands

import eu.beeadev.contentmessagehelper.ContentMessageHelper
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/*
This command is used to create free room in chat.
This can make taking screenshots easier!

Permission: contentmessagehelper.use
 */

class ChatClearCommand : CommandExecutor {
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
        repeat(10) {
            player.sendMessage("§a")
        }
        return false
    }
}