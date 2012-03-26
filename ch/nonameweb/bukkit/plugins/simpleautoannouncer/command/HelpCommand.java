package ch.nonameweb.bukkit.plugins.simpleautoannouncer.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import ch.nonameweb.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.manager.LocalManager;

public class HelpCommand {
	
	private LocalManager local;
	
	public void execute( Player player, String[] subargs ) {
		
		local = SimpleAutoAnnouncer.getInstance().getLocalManager();
		
		player.sendMessage( ChatColor.GREEN + "-----------------------------------------------------");
		
		if ( subargs.length > 0 ) {
			
			if ( subargs[0].equalsIgnoreCase("settings") ) {
				
				player.sendMessage( ChatColor.YELLOW + "/announce settings debug true/false" + ChatColor.GRAY + "// " + local.getStr("COMMAND_HELP_SETTINGS_DEBUG"));
				player.sendMessage( ChatColor.YELLOW + "/announce settings announce <name>" + ChatColor.GRAY + "// " + local.getStr("COMMAND_HELP_SETTINGS_ANNOUNCE"));
				player.sendMessage( ChatColor.YELLOW + "/announce settings time <minutes> " + ChatColor.GRAY + "// " + local.getStr("COMMAND_HELP_SETTINGS_TIME"));
				player.sendMessage( ChatColor.YELLOW + "/announce settings lang EN / DE " + ChatColor.GRAY + "// " + local.getStr("COMMAND_HELP_SETTINGS_LOCAL"));
				player.sendMessage( ChatColor.YELLOW + "/announce settings spout true/false " + ChatColor.GRAY + "// " + local.getStr("COMMAND_HELP_SETTINGS_SPOUT"));
			}
			
		} else {
			
			player.sendMessage( ChatColor.YELLOW + "/announce add <message>" + ChatColor.GRAY + "// " + local.getStr("COMMAND_HELP_ADD"));
			player.sendMessage( ChatColor.YELLOW + "/announce delete <message id>" + ChatColor.GRAY + "// " + local.getStr("COMMAND_HELP_DELETE"));
			player.sendMessage( ChatColor.YELLOW + "/announce list " + ChatColor.GRAY + "// " + local.getStr("COMMAND_HELP_LIST"));
			player.sendMessage( ChatColor.YELLOW + "/announce settings " + ChatColor.GRAY + "// " + local.getStr("COMMAND_HELP_SETTINGS"));
			
		}
		
		player.sendMessage( ChatColor.GREEN + "-----------------------------------------------------");
		
	}
	
}
