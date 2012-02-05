package ch.nonameweb.bukkit.plugins.simpleautoannouncer.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class HelpCommand {

	
	public void execute( Player player, String[] subargs ) {
		
		player.sendMessage( ChatColor.GREEN + "-----------------------------------------------------");
		player.sendMessage( ChatColor.YELLOW + "/announce add <message>" + ChatColor.GRAY + "// Add a new Message");
		player.sendMessage( ChatColor.YELLOW + "/announce delete <message id>" + ChatColor.GRAY + "// Delete a Message on his Id");
		player.sendMessage( ChatColor.YELLOW + "/announce list " + ChatColor.GRAY + "// List all Messages");
		player.sendMessage( ChatColor.GREEN + "-----------------------------------------------------");
		
	}
	
}
