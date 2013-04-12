package ch.minepvp.bukkit.plugins.simpleautoannouncer.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import ch.minepvp.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;
import ch.minepvp.bukkit.plugins.simpleautoannouncer.manager.LocalManager;

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

            if ( player.hasPermission("announce.add") ) {
                player.sendMessage( local.getStr("COMMAND_HELP_ADD"));
            }

            if ( player.hasPermission("announce.delete") ) {
                player.sendMessage( local.getStr("COMMAND_HELP_DELETE"));
            }

            if ( player.hasPermission("announce.force") ) {
                player.sendMessage( local.getStr("COMMAND_HELP_FORCE"));
            }

            if ( player.hasPermission("announce.list") ) {
                player.sendMessage( local.getStr("COMMAND_HELP_LIST"));
            }

            if ( player.hasPermission("announce.settings") ) {
                player.sendMessage( local.getStr("COMMAND_HELP_SETTINGS"));
            }

            if ( player.hasPermission("announce.reload") ) {
                player.sendMessage( local.getStr("COMMAND_HELP_RELOAD"));
            }

		}
		
		player.sendMessage( ChatColor.GREEN + "-----------------------------------------------------");
		
	}
	
}
