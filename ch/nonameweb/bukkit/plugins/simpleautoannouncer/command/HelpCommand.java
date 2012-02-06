package ch.nonameweb.bukkit.plugins.simpleautoannouncer.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class HelpCommand {

	
	public void execute( Player player, String[] subargs ) {
		
		player.sendMessage( ChatColor.GREEN + "-----------------------------------------------------");
		
		if ( subargs.length > 0 ) {
			
			if ( subargs[0].equalsIgnoreCase("settings") ) {
				
				player.sendMessage( ChatColor.YELLOW + "/announce settings debug true/false" + ChatColor.GRAY + "// Set de Debug Mode");
				player.sendMessage( ChatColor.YELLOW + "/announce settings announce <name>" + ChatColor.GRAY + "// Change de Announce Name");
				player.sendMessage( ChatColor.YELLOW + "/announce settings time <minutes> " + ChatColor.GRAY + "// Change the Announce Time");
				
			}
			
		} else {
			
			player.sendMessage( ChatColor.YELLOW + "/announce add <message>" + ChatColor.GRAY + "// Add a new Message");
			player.sendMessage( ChatColor.YELLOW + "/announce delete <message id>" + ChatColor.GRAY + "// Delete a Message on his Id");
			player.sendMessage( ChatColor.YELLOW + "/announce list " + ChatColor.GRAY + "// List all Messages");
			player.sendMessage( ChatColor.YELLOW + "/announce settings " + ChatColor.GRAY + "// Change the Settings InGame");
			
		}
		
		player.sendMessage( ChatColor.GREEN + "-----------------------------------------------------");
		
	}
	
}
