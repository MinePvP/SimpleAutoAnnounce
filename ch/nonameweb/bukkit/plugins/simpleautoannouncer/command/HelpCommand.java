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
				
				player.sendMessage( local.getStr("COMMAND_HELP_SETTINGS_DEBUG"));
				player.sendMessage( local.getStr("COMMAND_HELP_SETTINGS_ANNOUNCE"));
				player.sendMessage( local.getStr("COMMAND_HELP_SETTINGS_TIME"));
				player.sendMessage( local.getStr("COMMAND_HELP_SETTINGS_RANDOM"));
				player.sendMessage( local.getStr("COMMAND_HELP_SETTINGS_LOCAL"));
				player.sendMessage( local.getStr("COMMAND_HELP_SETTINGS_SPOUT"));
			}
			
		} else {
			
			player.sendMessage( local.getStr("COMMAND_HELP_ADD"));
			player.sendMessage( local.getStr("COMMAND_HELP_DELETE"));
			player.sendMessage( local.getStr("COMMAND_HELP_FORCE"));
			player.sendMessage( local.getStr("COMMAND_HELP_LIST"));
			player.sendMessage( local.getStr("COMMAND_HELP_SETTINGS"));
			
		}
		
		player.sendMessage( ChatColor.GREEN + "-----------------------------------------------------");
		
	}
	
}
