package ch.nonameweb.bukkit.plugins.simpleautoannouncer.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import ch.nonameweb.bukkit.plugins.simpleautoannouncer.Helper;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.language.LangInterface;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.manager.SettingsManager;

public class AddCommand {
	
	private SimpleAutoAnnouncer plugin;
	private SettingsManager settingsManager;
	private LangInterface lang;
	
	public void execute( Player player, String[] subargs ) {
		
		this.plugin = SimpleAutoAnnouncer.getInstance();
		this.settingsManager = plugin.getSettingsManager();
		this.lang = plugin.getLangInterface();
		
		if ( player.hasPermission("announce.add") || player.hasPermission("announce.admin") || player.isOp() ) {
			
			
			if ( subargs.length < 1 ) {
				player.sendMessage( lang.get("How to use It:") );
				player.sendMessage( ChatColor.YELLOW +"/announce add <yellow> " + lang.get("This is a Message."));
				return;
			}
			
			String message = "";
			
			for ( String string : subargs ) {
				message = message + string + " ";
			}
			
			settingsManager.addMessage( message );
			settingsManager.save();
			player.sendMessage( ChatColor.GREEN + lang.get("The Message was added."));
			player.sendMessage(Helper.format(message));
			
		} else {
			player.sendMessage(  lang.get("You have not the Permissions") + " (announce.add).");
		}
		
	}
	
}
