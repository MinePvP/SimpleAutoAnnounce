package ch.nonameweb.bukkit.plugins.simpleautoannouncer.manager;

import org.bukkit.entity.Player;

import ch.nonameweb.bukkit.plugins.simpleautoannouncer.Helper;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.command.AddCommand;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.command.DeleteCommand;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.command.HelpCommand;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.command.ListCommand;

public class CommandManager {	
	
	// Commands
	private HelpCommand helpCommand;
	private AddCommand addCommand;
	private ListCommand listCommand;
	private DeleteCommand deleteCommand;
	
	
	public CommandManager() {
		
		this.helpCommand = new HelpCommand();
		this.addCommand = new AddCommand();
		this.deleteCommand = new DeleteCommand();
		this.listCommand = new ListCommand();
		
	}
	
	
	public void processCommands( Player player, String[] args ) {
		
		if ( args.length > 0  ) {
			
			String subcommand = args[0];
	        String[] subargs = Helper.removeFirst(args);
	                
	        if ( subcommand.equalsIgnoreCase("add") ) {
	        	addCommand.execute(player, subargs);
	        } else if ( subcommand.equalsIgnoreCase("delete") ) {
	        	deleteCommand.execute(player, subargs);
	        } else if ( subcommand.equalsIgnoreCase("list") ) {
	        	listCommand.execute(player, subargs);
	        } else if ( subcommand.equalsIgnoreCase("help") ) {
	        	helpCommand.execute(player, subargs);
	        } else {
	        	Helper.playerMessage(player, "/announce help", "err");
	        }
			
		} else {
			Helper.playerMessage(player, "/announce help", "err");
		}
		
		
	
	}
	
}
