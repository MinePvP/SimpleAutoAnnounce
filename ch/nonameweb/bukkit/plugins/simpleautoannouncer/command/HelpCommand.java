package ch.nonameweb.bukkit.plugins.simpleautoannouncer.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import ch.nonameweb.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.language.LangInterface;

public class HelpCommand {
	
	private LangInterface lang;
	
	public void execute( Player player, String[] subargs ) {
		
		lang = SimpleAutoAnnouncer.getInstance().getLangInterface();
		
		player.sendMessage( ChatColor.GREEN + "-----------------------------------------------------");
		
		if ( subargs.length > 0 ) {
			
			if ( subargs[0].equalsIgnoreCase("settings") ) {
				
				player.sendMessage( ChatColor.YELLOW + "/announce settings debug true/false" + ChatColor.GRAY + "// " + lang.get("Set de Debug Mode"));
				player.sendMessage( ChatColor.YELLOW + "/announce settings announce <name>" + ChatColor.GRAY + "// " + lang.get("Change de Announce Name"));
				player.sendMessage( ChatColor.YELLOW + "/announce settings time <minutes> " + ChatColor.GRAY + "// " + lang.get("Change the Announce Time"));
				player.sendMessage( ChatColor.YELLOW + "/announce settings lang EN / DE " + ChatColor.GRAY + "// " + lang.get("Change the Language"));
				player.sendMessage( ChatColor.YELLOW + "/announce settings spout true/false " + ChatColor.GRAY + "// " + lang.get("Change the SpoutNotification"));
			}
			
		} else {
			
			player.sendMessage( ChatColor.YELLOW + "/announce add <message>" + ChatColor.GRAY + "// " + lang.get("Add a new Message"));
			player.sendMessage( ChatColor.YELLOW + "/announce delete <message id>" + ChatColor.GRAY + "// " + lang.get("Delete a Message on his Id"));
			player.sendMessage( ChatColor.YELLOW + "/announce list " + ChatColor.GRAY + "// " + lang.get("List all Messages"));
			player.sendMessage( ChatColor.YELLOW + "/announce settings " + ChatColor.GRAY + "// " + lang.get("Change the Settings InGame"));
			
		}
		
		player.sendMessage( ChatColor.GREEN + "-----------------------------------------------------");
		
	}
	
}
