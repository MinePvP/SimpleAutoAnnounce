package ch.nonameweb.bukkit.plugins.simpleautoannouncer.task;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

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
		
		String message = null;
		
		if ( plugin.getSettingsManager().getRandom() == true ) {
			
			SecureRandom random = null;
			try {
				random = SecureRandom.getInstance("SHA1PRNG");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			int randInt = 0;
			
			if ( random != null ) {
				randInt = random.nextInt( plugin.getSettingsManager().getMessages().size() );
			}	
			
			//Integer id = (int)Math.floor((Math.random() *  plugin.getSettingsManager().getMessages().size() ) + 1);
			message = plugin.getSettingsManager().getMessages().get( randInt );
			
		} else {
			message = plugin.getSettingsManager().getMessages().get( counter );
		}	
		
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
			
			Player[] players = this.plugin.getServer().getOnlinePlayers();
			
			String announce = plugin.getSettingsManager().getAnnounceName() + message;
			
			if ( plugin.getSettingsManager().getDebug() == true ) {
				plugin.log(announce);
			}
						
			for ( Player player : players ) {
				player.sendMessage( Helper.format(announce) );
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
		
		Player[] players = this.plugin.getServer().getOnlinePlayers();
		
		String announce = plugin.getSettingsManager().getAnnounceName() + message;
		
		for ( Player player : players ) {
			
			if ( player.getWorld().getName().equalsIgnoreCase(world) ) {
				player.sendMessage( Helper.format(announce) );
			}
			
		}
		
		if ( plugin.getSettingsManager().getDebug() == true ) {
			plugin.log( world + " -> " + announce );
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
	
}
