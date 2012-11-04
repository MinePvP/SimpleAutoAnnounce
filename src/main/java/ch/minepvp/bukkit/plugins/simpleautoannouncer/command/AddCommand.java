package ch.minepvp.bukkit.plugins.simpleautoannouncer.command;

import org.bukkit.entity.Player;

import ch.minepvp.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;
import ch.minepvp.bukkit.plugins.simpleautoannouncer.manager.LocalManager;
import ch.minepvp.bukkit.plugins.simpleautoannouncer.manager.SettingsManager;

public class AddCommand {
	
	private SimpleAutoAnnouncer plugin;
	private SettingsManager settingsManager;
	private LocalManager local;
	
	public void execute( Player player, String[] subargs ) {
		
		this.plugin = SimpleAutoAnnouncer.getInstance();
		this.settingsManager = plugin.getSettingsManager();
		
		this.local = plugin.getLocalManager();
		
		if ( player.hasPermission("announce.add") || player.hasPermission("announce.admin") || player.isOp() ) {
			
			if ( subargs.length < 1 ) {
				player.sendMessage( local.getStr("COMMAND_HOW_TO") );
				player.sendMessage( local.getStr("COMMAND_HOW_TO_ADD") );
				return;
			}
			
			String message = "";
			
			for ( String string : subargs ) {
				message = message + string + " ";
			}
			
			settingsManager.addMessage( message );
			settingsManager.save();
			player.sendMessage( local.getStr("COMMAND_ADD_MESSAGE_ADDED", message) );			
		} else {
			player.sendMessage( local.getStr("PERMISSION_YOU_HAVE_NOT_THE_PERMISSIONS") + " (announce.add).");
		}
		
	}
	
}
