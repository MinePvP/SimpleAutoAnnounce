package ch.nonameweb.bukkit.plugins.simpleautoannouncer.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import ch.nonameweb.bukkit.plugins.simpleautoannouncer.Helper;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.manager.SettingsManager;

public class ListCommand {
	
	private SimpleAutoAnnouncer plugin;
	private SettingsManager settingsManager;
	
	public void execute( Player player, String[] subargs ) {
		
		this.plugin = SimpleAutoAnnouncer.getInstance();
		this.settingsManager = plugin.getSettingsManager();
		
		if ( player.hasPermission("announce.list") || player.hasPermission("announce.admin") || player.isOp() ) {
			
			player.sendMessage( ChatColor.GREEN + "-----------------------------------------------------");
			
			player.sendMessage( ChatColor.YELLOW + "ID - Message");
			
			Integer id = 0;
			
			for ( String message : settingsManager.getMessages() ) {
				
				player.sendMessage( ChatColor.GREEN + "" + id + " - " + ChatColor.WHITE + Helper.format(message) );
				
				id++;
			}
			
			player.sendMessage( ChatColor.GREEN + "-----------------------------------------------------");
		} else {
			player.sendMessage("You have not the Permissions (announce.list).");
		}
		
	}
	
}
