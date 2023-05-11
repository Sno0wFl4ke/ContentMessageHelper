package eu.beeadev.contentmessagehelper

import eu.beeadev.contentmessagehelper.commands.ChatClearCommand
import eu.beeadev.contentmessagehelper.commands.EmptyCommand
import org.bukkit.plugin.java.JavaPlugin

class ContentMessageHelper : JavaPlugin() {

    override fun onEnable() {
        super.onEnable()
        println("ContentMessageHelper by BeeADev")
        getCommand("empty")?.setExecutor(EmptyCommand())
        getCommand("chatclear")?.setExecutor(ChatClearCommand())
    }

    companion object {
        @JvmStatic
        val PREFIX: String = "§8◗◗◗ §9§LCMH§8│ "
    }
}