package ch.nonameweb.bukkit.plugins.simpleautoannouncer.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import ch.nonameweb.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.manager.LocalManager;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.manager.SettingsManager;

public class DeleteCommand {
	
	private SimpleAutoAnnouncer plugin;
	private SettingsManager settingsManager;
	private LocalManager local;
	
	public void execute( Player player, String[] subargs ) {
		
		this.plugin = SimpleAutoAnnouncer.getInstance();
		this.settingsManager = plugin.getSettingsManager();
		this.local = plugin.getLocalManager();

		
		if ( player.hasPermission("announce.delete") || player.hasPermission("announce.admin") || player.isOp() ) {
			
			if ( subargs.length < 1 ) {
				player.sendMessage( local.getStr("COMMAND_HOW_TO") );
				player.sendMessage( ChatColor.YELLOW +"/announce delete 2");
				return;
			}
			
			Integer id = null;
			id = Integer.parseInt( subargs[0] );
			
			if ( id >= settingsManager.getMessages().size() ) {
				player.sendMessage( ChatColor.RED + local.getStr("COMMAND_DELETE_ERROR_NO_MESSAGE") );
				return;
			}
			
			settingsManager.removeMessage(id);
			settingsManager.save();
			player.sendMessage( ChatColor.GREEN +  local.getStr("COMMAND_DELETE_MESSAGE_DELETET") );
			
		} else {
			player.sendMessage( local.getStr("PERMISSION_YOU_HAVE_NOT_THE_PERMISSIONS") + " (announce.delete).");
		}
		
	}
	
}
