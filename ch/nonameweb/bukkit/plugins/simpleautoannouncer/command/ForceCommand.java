package ch.nonameweb.bukkit.plugins.simpleautoannouncer.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.dthielke.herochat.Channel;
import com.dthielke.herochat.Herochat;

import ch.nonameweb.bukkit.plugins.simpleautoannouncer.Helper;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.manager.LocalManager;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.manager.SettingsManager;

public class ForceCommand {
	
	private SimpleAutoAnnouncer plugin;
	private SettingsManager settingsManager;
	private LocalManager local;
	
	public void execute( Player player, String[] subargs ) {
		
		this.plugin = SimpleAutoAnnouncer.getInstance();
		this.settingsManager = plugin.getSettingsManager();
		this.local = plugin.getLocalManager();

		
		if ( player.hasPermission("announce.force") || player.hasPermission("announce.admin") || player.isOp() ) {
			
			if ( subargs.length < 1 ) {
				player.sendMessage( local.getStr("COMMAND_HOW_TO") );
				player.sendMessage( ChatColor.YELLOW +"/announce force 2");
				return;
			}
			
			Integer id = null;
			id = Integer.parseInt( subargs[0] );
			
			if ( id >= settingsManager.getMessages().size() ) {
				player.sendMessage( ChatColor.RED + local.getStr("COMMAND_FORCE_ERROR_NO_MESSAGE") );
				return;
			}
			
			String world = null;
			String channel = null;
			
			String message = settingsManager.getMessages().get(id);
			
			if ( message.startsWith("@") ) {
				
				String[] split = message.split(" ");
				world = split[0].replaceFirst("@", "");
				message = message.replaceFirst( split[0] + " ", "");
				
			} else if ( message.startsWith("#") ) {
				
				String[] split = message.split(" ");
				channel = split[0].replaceFirst("#", "");
				message = message.replaceFirst( split[0] + " ", "");
				
			} else {
				
			}
			
			String announce =  settingsManager.getAnnounceName() + message;
			
			if ( channel != null ) {
				
				Channel heroChannel = Herochat.getChannelManager().getChannel( channel );
				heroChannel.announce(  Helper.format( announce ) );		
				
			} else {
				
				for ( Player player2 : plugin.getServer().getOnlinePlayers() ) {
					
					if ( world != null ) {
						
						if ( player2.getWorld().getName().equalsIgnoreCase(world) ) {
							player2.sendMessage( Helper.format(announce) );
						}					
						
					} else {
						player2.sendMessage( Helper.format(announce) );
					}
				
				}
				
			}
			
			player.sendMessage( local.getStr("COMMAND_FORCE_SENDT") );
			
			
		} else {
			player.sendMessage( local.getStr("PERMISSION_YOU_HAVE_NOT_THE_PERMISSIONS") + " (announce.force).");
		}
		
	}
	
}
