package ch.nonameweb.bukkit.plugins.simpleautoannouncer.task;

import org.bukkit.entity.Player;

import ch.nonameweb.bukkit.plugins.simpleautoannouncer.Helper;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;

public class AnnounceTask extends Task{

	private SimpleAutoAnnouncer plugin;
	private Integer counter = 0;
	
	public AnnounceTask() {
		this.plugin = SimpleAutoAnnouncer.getInstance();
	}
	
	@Override
	public void run() {
		
		String message = plugin.getSettingsManager().getMessages().get( counter );
		
		Player[] players = this.plugin.getServer().getOnlinePlayers();
		
		String announce = plugin.getSettingsManager().getAnnounceName() + " : " + message;
		
		if ( plugin.getSettingsManager().getDebug() == true ) {
			plugin.log(announce);
		}
		
		for ( Player player : players ) {
			
			player.sendMessage( Helper.format(announce) );
			
		}
		
		counter++;
		
		if ( counter == plugin.getSettingsManager().getMessages().size() ) {
			counter = 0;
		}
		
	}
	
}
