package ch.nonameweb.bukkit.plugins.simpleautoannouncer.task;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.Spout;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.WidgetAnchor;
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
		
		String announce = plugin.getSettingsManager().getAnnounceName() + ChatColor.WHITE + " : " + message;
		
		if ( plugin.getSettingsManager().getDebug() == true ) {
			plugin.log(announce);
		}
		
		if ( plugin.isSpoutServer() && plugin.getSettingsManager().getSpout() == true ) {
			
			for ( SpoutPlayer spoutPlayer : Spout.getServer().getOnlinePlayers() ) {
				
				if ( spoutPlayer.isSpoutCraftEnabled() ) {
					
					// TODO Spout Notification
					this.addSpoutNotification(spoutPlayer, announce);
					
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
	
	private void addSpoutNotification( SpoutPlayer player, String announce ) {
		
		GenericLabel label = new GenericLabel( Helper.format(announce) );
		label.setAuto(true).setX(10).setY(10);
		label.setMaxHeight(20);
		label.setMaxWidth(400);
		label.setMarginTop(10);
		label.setMarginLeft(10);
		label.setAnchor(WidgetAnchor.TOP_LEFT);
		
		player.getMainScreen().attachWidget(plugin, label);
		
		NotificationTask task = new NotificationTask(player, label);
		
		plugin.getTaskManager().createAsyncDelayedTask(task, 200L);
		
		
	}
	
}
