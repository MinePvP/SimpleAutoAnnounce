package ch.nonameweb.bukkit.plugins.simpleautoannouncer.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import ch.nonameweb.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.manager.SettingsManager;

public class DeleteCommand {
	
	private SimpleAutoAnnouncer plugin;
	private SettingsManager settingsManager;
	
	public void execute( Player player, String[] subargs ) {
		
		this.plugin = SimpleAutoAnnouncer.getInstance();
		this.settingsManager = plugin.getSettingsManager();
		
		if ( player.hasPermission("announce.delete") || player.hasPermission("announce.admin") || player.isOp() ) {
			
			if ( subargs.length < 1 ) {
				player.sendMessage("How to use It:");
				player.sendMessage( ChatColor.YELLOW +"/announce delete 2");
				return;
			}
			
			Integer id = null;
			id = Integer.parseInt( subargs[0] );
			
			if ( id >= settingsManager.getMessages().size() ) {
				player.sendMessage( ChatColor.RED +"Fehler : There was no Message found with this Id.");
				return;
			}
			
			settingsManager.removeMessage(id);
			settingsManager.save();
			player.sendMessage( ChatColor.GREEN + "The Messages is Deletet.");
			
		} else {
			player.sendMessage("You have not the Permissions (announce.delete).");
		}
		
	}
	
}
