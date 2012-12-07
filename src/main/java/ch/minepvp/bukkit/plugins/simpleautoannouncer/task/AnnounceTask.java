package ch.minepvp.bukkit.plugins.simpleautoannouncer.task;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.bukkit.entity.Player;

import com.dthielke.herochat.Channel;
import com.dthielke.herochat.Herochat;

import ch.minepvp.bukkit.plugins.simpleautoannouncer.Helper;
import ch.minepvp.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;

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
				
				if ( plugin.getSettingsManager().getMessages().size() > 0 ) {
					randInt = random.nextInt( plugin.getSettingsManager().getMessages().size() );
				}				
				
			}	
			
			//Integer id = (int)Math.floor((Math.random() *  plugin.getSettingsManager().getMessages().size() ) + 1);
			if ( plugin.getSettingsManager().getMessages().size() > 0 ) {
				message = plugin.getSettingsManager().getMessages().get( randInt );
			}
			
		} else {
			
			if ( plugin.getSettingsManager().getMessages().size() > 0 ) {
				message = plugin.getSettingsManager().getMessages().get( counter );
			}
			
		}	
		
		if ( message != null ) {
			
			// Commands
			if ( message.startsWith("!") ) {
				
				String messageNew = message.replaceFirst("!", "");			
				
				executeCommand(messageNew);
				
			}
            // World
            else if ( message.startsWith("@") ) {
				
				String[] split = message.split(" ");
				String world = split[0].replaceFirst("@", "");
				String messageNew = message.replaceFirst( split[0] + " ", "");
				sendAnnounceToWorld(world, messageNew);
				
			}
            // HeroChatChannel
            else if ( message.startsWith("#") ) {
				
				String[] split = message.split(" ");
				String channel = split[0].replaceFirst("#", "");
				String messageNew = message.replaceFirst( split[0] + " ", "");
				
				
				Channel heroChannel = Herochat.getChannelManager().getChannel( channel );
				
				if ( heroChannel != null ) {
					
					String announce = plugin.getSettingsManager().getAnnounceName() + messageNew;
					
					heroChannel.announce(  Helper.format( announce ) );
					
					next();
					run();
				}
				
			}
            // Permission
            else if ( message.startsWith("&") ) {

                String[] split = message.split(" ");
                String permission = split[0].replaceFirst("&", "");
                String messageNew = message.replaceFirst( split[0] + " ", "");
                sendAnnounceToPermission(permission, messageNew);

            } else if ( message.startsWith(")") ) {

				next();

			} else {
				
				Player[] players = this.plugin.getServer().getOnlinePlayers();
                String[] lines = message.split("<line>");

				for ( Player player : players ) {

                    if ( lines.length > 0 ) {

                        for ( String line : lines ) {
                            player.sendMessage( Helper.format( plugin.getSettingsManager().getAnnounceName() + line ) );
                        }

                    } else {
                        player.sendMessage( Helper.format( plugin.getSettingsManager().getAnnounceName() + message ) );
                    }

				}
				
				next();
			}
			
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

        String[] lines = message.split("<line>");
		
		for ( Player player : players ) {

			if ( player.getWorld().getName().equalsIgnoreCase(world) ) {

                if ( lines.length > 0 ) {

                    for ( String line : lines ) {
                        player.sendMessage( Helper.format( plugin.getSettingsManager().getAnnounceName() + line ) );
                    }

                } else {
                    player.sendMessage( Helper.format( plugin.getSettingsManager().getAnnounceName() + message ) );
                }

			}
			
		}
		
		next();
		run();
	}

    private void sendAnnounceToPermission( String permission, String message ) {

        Player[] players = this.plugin.getServer().getOnlinePlayers();

        String[] lines = message.split("<line>");

        for ( Player player : players ) {

            if ( player.hasPermission(permission) ) {

                if ( lines.length > 0 ) {

                    for ( String line : lines ) {
                        player.sendMessage( Helper.format( plugin.getSettingsManager().getAnnounceName() + line ) );
                    }

                } else {
                    player.sendMessage( Helper.format( plugin.getSettingsManager().getAnnounceName() + message ) );
                }

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
	
}
