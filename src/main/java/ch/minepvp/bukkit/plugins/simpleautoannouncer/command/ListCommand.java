package ch.minepvp.bukkit.plugins.simpleautoannouncer.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import ch.minepvp.bukkit.plugins.simpleautoannouncer.Helper;
import ch.minepvp.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;
import ch.minepvp.bukkit.plugins.simpleautoannouncer.manager.LocalManager;
import ch.minepvp.bukkit.plugins.simpleautoannouncer.manager.SettingsManager;

public class ListCommand {
	
	private SimpleAutoAnnouncer plugin;
	private SettingsManager settingsManager;
	private LocalManager local;
	
	public void execute( Player player, String[] subargs ) {
		
		this.plugin = SimpleAutoAnnouncer.getInstance();
		this.settingsManager = plugin.getSettingsManager();
		this.local = plugin.getLocalManager();
		
		if ( player.hasPermission("announce.list") || player.hasPermission("announce.admin") || player.isOp() ) {
			
			player.sendMessage( ChatColor.GREEN + "-----------------------------------------------------");
			
			player.sendMessage( local.getStr("COMMAND_LIST_MESSAGE"));
			
			Integer id = 0;
			
			for ( String message : settingsManager.getMessages() ) {
				
				player.sendMessage( ChatColor.GREEN + "" + id + " - " + ChatColor.WHITE + Helper.format(message) );
				
				id++;
			}
			
			player.sendMessage( ChatColor.GREEN + "-----------------------------------------------------");
		} else {
			player.sendMessage(  local.getStr("PERMISSION_YOU_HAVE_NOT_THE_PERMISSIONS") + " (announce.list).");
		}
		
	}
	
}
