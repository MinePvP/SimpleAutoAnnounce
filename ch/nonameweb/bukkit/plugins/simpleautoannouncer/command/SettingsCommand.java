package ch.nonameweb.bukkit.plugins.simpleautoannouncer.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import ch.nonameweb.bukkit.plugins.simpleautoannouncer.Helper;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.manager.LocalManager;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.manager.SettingsManager;

public class SettingsCommand {
	
	private SimpleAutoAnnouncer plugin;
	private SettingsManager settingsManager;
	private LocalManager local;
	
	public void execute( Player player, String[] subargs ) {
		
		this.plugin = SimpleAutoAnnouncer.getInstance();
		this.settingsManager = plugin.getSettingsManager();
		this.local = plugin.getLocalManager();
		
		if ( player.hasPermission("announce.settings") || player.hasPermission("announce.admin") || player.isOp() ) {
			
			if ( subargs.length > 0 ) {
				
				
				if ( subargs[0].equalsIgnoreCase("debug") ) {
					
					Boolean bool = null;
					bool = Boolean.parseBoolean( subargs[1] );
					
					if (  bool == true || bool == false ) {
						settingsManager.setDebug( Boolean.parseBoolean( subargs[1] ) );
						settingsManager.save();
						
						if ( Boolean.parseBoolean( subargs[1]) == true ) {
							player.sendMessage(ChatColor.GREEN + local.getStr("COMMAND_SETTINGS_DEBUG_ON"));
						} else {
							player.sendMessage(ChatColor.GREEN + local.getStr("COMMAND_SETTINGS_DEBUG_OFF"));
						}
						
						
					} else {
						player.sendMessage(ChatColor.RED + "/announce help settings");
					}
					
				} else if ( subargs[0].equalsIgnoreCase("announce") ) {
					
					if ( subargs[1].equalsIgnoreCase("") == false  ) {
						settingsManager.setAnnounceName( subargs[1] );
						settingsManager.save();
						player.sendMessage(ChatColor.GREEN + local.getStr("COMMAND_SETTINGS_ANNOUNCE") + Helper.format( subargs[1] ));
					} else {
						player.sendMessage(ChatColor.RED + "/announce help settings");
					}
					
				} else if ( subargs[0].equalsIgnoreCase("lang") ) {
					
					if ( subargs[1].equalsIgnoreCase("") == false  ) {
						settingsManager.setLocal( subargs[1] );
						settingsManager.save();
						plugin.resetLocal();						
						player.sendMessage(ChatColor.GREEN + local.getStr("COMMAND_SETTINGS_LOCAL") + subargs[1] );
					} else {
						player.sendMessage(ChatColor.RED + "/announce help settings");
					}
					
				} else if ( subargs[0].equalsIgnoreCase("spout") ) {
					
					Boolean bool = null;
					bool = Boolean.parseBoolean( subargs[1] );
					
					if (  bool == true || bool == false ) {
						settingsManager.setSpout( Boolean.parseBoolean( subargs[1] ) );
						settingsManager.save();
						
						if ( Boolean.parseBoolean( subargs[1]) == true ) {
							player.sendMessage(ChatColor.GREEN + local.getStr("COMMAND_SETTINGS_SPOU_ON"));
						} else {
							player.sendMessage(ChatColor.GREEN + local.getStr("COMMAND_SETTINGS_SPOU_OFF"));
						}
					
					} else {
						player.sendMessage(ChatColor.RED + "/announce help settings");
					}
					
				} else if ( subargs[0].equalsIgnoreCase("time") ) {
					
					try {
						Integer time = null;
						time = Integer.parseInt( subargs[1] );
						
						if ( time != null ) {
							settingsManager.setTime(time);
							settingsManager.save();
							plugin.restartAutoAnnounceTask();
							player.sendMessage(ChatColor.GREEN + local.getStr("COMMAND_SETTINGS_TIME", time.toString()) );
						} else {
							player.sendMessage(ChatColor.RED + "/announce help settings");
						}
						
					} catch (Exception e) {
						player.sendMessage(ChatColor.RED + "/announce help settings");
					}
					
					
				} else {
					player.sendMessage(ChatColor.RED + "/announce help settings");
				}
				
			}
			
			
		} else {
			player.sendMessage(  local.getStr("PERMISSION_YOU_HAVE_NOT_THE_PERMISSIONS") + " (announce.add).");
		}
		
	}
	
}
