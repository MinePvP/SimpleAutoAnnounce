package ch.nonameweb.bukkit.plugins.simpleautoannouncer.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import ch.nonameweb.bukkit.plugins.simpleautoannouncer.Helper;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.manager.SettingsManager;

public class SettingsCommand {
	
	private SimpleAutoAnnouncer plugin;
	private SettingsManager settingsManager;
	
	public void execute( Player player, String[] subargs ) {
		
		this.plugin = SimpleAutoAnnouncer.getInstance();
		this.settingsManager = plugin.getSettingsManager();
		
		if ( player.hasPermission("announce.settings") || player.hasPermission("announce.admin") || player.isOp() ) {
			
			if ( subargs.length > 0 ) {
				
				
				if ( subargs[0].equalsIgnoreCase("debug") ) {
					
					if ( Boolean.parseBoolean( subargs[1] ) ) {
						settingsManager.setDebug( Boolean.parseBoolean( subargs[1] ) );
						settingsManager.save();
						player.sendMessage(ChatColor.GREEN + "The Debug Mode is now ON");
					} else {
						player.sendMessage(ChatColor.RED + "/announce help settings");
					}
					
				} else if ( subargs[0].equalsIgnoreCase("announce") ) {
					
					if ( subargs[1].equalsIgnoreCase("") == false  ) {
						settingsManager.setAnnounceName( subargs[1] );
						settingsManager.save();
						player.sendMessage(ChatColor.GREEN + "The Announce will be now  " + Helper.format( subargs[1] ));
					} else {
						player.sendMessage(ChatColor.RED + "/announce help settings");
					}
					
				} else if ( subargs[0].equalsIgnoreCase("time") ) {
					
					try {
						Integer time = null;
						time = Integer.parseInt( subargs[1] );
						
						if ( time != null ) {
							settingsManager.setTime(time);
							settingsManager.save();
							plugin.restartAutoAnnounceTask();
							player.sendMessage(ChatColor.GREEN + "The Time will be now " + time + " Minutes." );
						} else {
							player.sendMessage(ChatColor.RED + "/announce help settings");
						}
						
					} catch (Exception e) {
						player.sendMessage(ChatColor.RED + "/announce help settings");
					}
					
					
				} else {
					player.sendMessage(ChatColor.RED + "/announce help settings");
				}
				
			}
			
			
		} else {
			player.sendMessage("You have not the Permissions (announce.settings).");
		}
		
	}
	
}
