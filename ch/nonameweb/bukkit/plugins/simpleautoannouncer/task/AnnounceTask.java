package ch.nonameweb.bukkit.plugins.simpleautoannouncer.task;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.Spout;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.SpoutServer;
import org.getspout.spoutapi.player.SpoutPlayer;

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
		
		if ( plugin.isSpoutServer() ) {
			
			for ( SpoutPlayer spoutPlayer : Spout.getServer().getOnlinePlayers() ) {
				
				if ( spoutPlayer.isSpoutCraftEnabled() ) {
					
					// TODO Spout Notification
					spoutPlayer.sendNotification( Helper.format( plugin.getSettingsManager().getAnnounceName() ), Helper.format( message ), Material.REDSTONE_TORCH_ON);
					
					
					if ( plugin.getSettingsManager().getDebug() == true ) {
						spoutPlayer.sendMessage("Spout Notification");
					}
					
				} else {
					spoutPlayer.sendMessage( Helper.format( announce ) );
				}
				
			}
			
		} else {
			
			for ( Player player : players ) {
				player.sendMessage( Helper.format(announce) );
			}
			
		}
		
		counter++;
		
		if ( counter == plugin.getSettingsManager().getMessages().size() ) {
			counter = 0;
		}
		
	}
	
}
