package ch.nonameweb.bukkit.plugins.simpleautoannouncer.task;

import org.bukkit.entity.Player;
import org.getspout.spoutapi.Spout;
import org.getspout.spoutapi.gui.GenericGradient;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

import ch.nonameweb.bukkit.plugins.simpleautoannouncer.Helper;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;

public class AnnounceSpoutTask extends Task{

	private SimpleAutoAnnouncer plugin;
	private Integer counter = 0;
	
	public AnnounceSpoutTask() {
		this.plugin = SimpleAutoAnnouncer.getInstance();
	}
	
	@Override
	public void run() {
		
		String message = plugin.getSettingsManager().getMessages().get( counter );
		
		// Commands
		if ( message.startsWith("!") ) {
			
			String messageNew = message.replaceFirst("!", "");			
			
			executeCommand(messageNew);
			
		} else if ( message.startsWith("@") ) {
			
			String[] split = message.split(" ");
			String world = split[0].replaceFirst("@", "");
			String messageNew = message.replaceFirst( split[0] + " ", "");
			sendAnnounceToWorld(world, messageNew);
			
		} else if ( message.startsWith(")") ) {
			next();
		} else {
			
			String announce = plugin.getSettingsManager().getAnnounceName() + message;
			
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
				
				Player[] players = this.plugin.getServer().getOnlinePlayers();
				
				for ( Player player : players ) {
					player.sendMessage( Helper.format(announce) );
				}
				
			}
			
			next();
		}
		
	}
	
	
	public void executeCommand( String command ) {
		
		plugin.getServer().dispatchCommand( plugin.getServer().getConsoleSender(), command);
		
		if ( plugin.getSettingsManager().getDebug() == true ) {
			plugin.log(command);
		}
		
		next();
		run();
	}
	
	
	public void sendAnnounceToWorld( String world, String message ) {
		
		String announce = plugin.getSettingsManager().getAnnounceName() + message;
		
		if ( plugin.isSpoutServer() && plugin.getSettingsManager().getSpout() == true ) {
			
			for ( SpoutPlayer spoutPlayer : Spout.getServer().getOnlinePlayers() ) {
				
				if ( spoutPlayer.isSpoutCraftEnabled() ) {
					
					if ( spoutPlayer.getWorld().getName().equalsIgnoreCase( world ) ) {
						this.addSpoutNotification(spoutPlayer, announce);
					}
					
				} else {
					if ( spoutPlayer.getWorld().getName().equalsIgnoreCase( world ) ) {
						spoutPlayer.sendMessage( Helper.format( announce ) );
					}
				}
				
			}
			
		} else {
			
			Player[] players = this.plugin.getServer().getOnlinePlayers();
			
			for ( Player player : players ) {
				player.sendMessage( Helper.format(announce) );
			}
			
		}
		
		next();
		run();
	}
	
	
	public void next() {
		
		counter++;
		
		if ( counter == plugin.getSettingsManager().getMessages().size() ) {
			counter = 0;
		}
		
	}
	
	private void addSpoutNotification( SpoutPlayer player, String announce ) {
		
		// TODO Gradian Width anpassen an stringlänge
		
		GenericGradient gradient = new GenericGradient();
		//gradient.setTopColor( new Color(00,00,00) );
		//gradient.setBottomColor( new Color(00,00,00)  );
		gradient.setHeight(30).setWidth(200);
		
		gradient.setPriority(RenderPriority.High);
		
		GenericLabel label = new GenericLabel( Helper.format(announce) );
		label.setAuto(true).setX(10).setY(10);
		label.setMaxHeight(20);
		label.setMaxWidth(400);
		label.setAnchor(WidgetAnchor.TOP_LEFT);
		
		player.getMainScreen().attachWidget(plugin, gradient);
		player.getMainScreen().attachWidget(plugin, label);
		
		NotificationTask task = new NotificationTask(player, label, gradient);
		
		plugin.getTaskManager().createAsyncDelayedTask(task, 200L);
		
	}
	
	
}
