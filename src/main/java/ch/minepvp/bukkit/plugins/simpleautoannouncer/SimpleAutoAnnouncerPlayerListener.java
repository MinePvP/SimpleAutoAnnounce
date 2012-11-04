package ch.minepvp.bukkit.plugins.simpleautoannouncer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class SimpleAutoAnnouncerPlayerListener implements Listener {

	private SimpleAutoAnnouncer plugin;
	
	
	public SimpleAutoAnnouncerPlayerListener() {
		plugin = SimpleAutoAnnouncer.getInstance();
		
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	
	@EventHandler(priority = EventPriority.LOW)
	public void onPlayerCommandPreprocess( PlayerCommandPreprocessEvent event ) {
		
		plugin = SimpleAutoAnnouncer.getInstance();
		
		if ( event.isCancelled() ) {
			return;
		}
		
		Player player = event.getPlayer();
		
		if ( player == null ) {
			return;
		}
		
		String[] split = event.getMessage().substring(1).split(" ");
		
		if ( split.length == 0 ) {
			return;
		}
		
		String command = split[0];
		
		if ( command.equalsIgnoreCase("announce") || command.equalsIgnoreCase("saa") ) {
			
			plugin.log("Command from : " + event.getPlayer().getName() + " : " + event.getMessage().toString());
			
			plugin.getCommandManager().processCommands(player, Helper.removeFirst(split) );
		}
	}
		
	
	
}
