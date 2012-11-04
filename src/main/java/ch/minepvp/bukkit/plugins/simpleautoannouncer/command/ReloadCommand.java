package ch.minepvp.bukkit.plugins.simpleautoannouncer.command;

import ch.minepvp.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;
import ch.minepvp.bukkit.plugins.simpleautoannouncer.manager.LocalManager;
import ch.minepvp.bukkit.plugins.simpleautoannouncer.manager.SettingsManager;
import org.bukkit.entity.Player;

public class ReloadCommand {
	
	private SimpleAutoAnnouncer plugin;
	private SettingsManager settingsManager;
	private LocalManager local;
	
	public void execute( Player player, String[] subargs ) {
		
		this.plugin = SimpleAutoAnnouncer.getInstance();
		this.settingsManager = plugin.getSettingsManager();
		
		this.local = plugin.getLocalManager();
		
		if ( player.hasPermission("announce.reload") || player.hasPermission("announce.admin") || player.isOp() ) {
			
            plugin.resetLocal();
            plugin.resetSettings();
            plugin.restartAutoAnnounceTask();

			player.sendMessage( local.getStr("COMMAND_RELOAD_RELOADED") );
		} else {
			player.sendMessage( local.getStr("PERMISSION_YOU_HAVE_NOT_THE_PERMISSIONS") + " (announce.add).");
		}

	}
	
}
