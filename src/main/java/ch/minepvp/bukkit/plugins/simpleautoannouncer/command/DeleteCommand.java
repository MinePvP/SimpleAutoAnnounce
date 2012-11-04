package ch.minepvp.bukkit.plugins.simpleautoannouncer.command;

import org.bukkit.entity.Player;

import ch.minepvp.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;
import ch.minepvp.bukkit.plugins.simpleautoannouncer.manager.LocalManager;
import ch.minepvp.bukkit.plugins.simpleautoannouncer.manager.SettingsManager;

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
				player.sendMessage( local.getStr("COMMAND_HOW_TO_DELETE") );
				return;
			}
			
			Integer id = null;
			id = Integer.parseInt( subargs[0] );
			
			if ( id >= settingsManager.getMessages().size() ) {
				player.sendMessage( local.getStr("COMMAND_DELETE_ERROR_NO_MESSAGE") );
				return;
			}
			
			settingsManager.removeMessage(id);
			settingsManager.save();
			player.sendMessage( local.getStr("COMMAND_DELETE_MESSAGE_DELETED") );
			
		} else {
			player.sendMessage( local.getStr("PERMISSION_YOU_HAVE_NOT_THE_PERMISSIONS") + " (announce.delete).");
		}
		
	}
	
}
