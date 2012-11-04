package ch.minepvp.bukkit.plugins.simpleautoannouncer.manager;

import ch.minepvp.bukkit.plugins.simpleautoannouncer.command.*;
import org.bukkit.entity.Player;

import ch.minepvp.bukkit.plugins.simpleautoannouncer.Helper;

public class CommandManager {	
	
	// Commands
	private HelpCommand helpCommand;
	private AddCommand addCommand;
	private ListCommand listCommand;
	private DeleteCommand deleteCommand;
	private SettingsCommand settingsCommand;
	private ForceCommand forceCommand;
    private ReloadCommand reloadCommand;

	
	public CommandManager() {
		
		this.helpCommand = new HelpCommand();
		this.addCommand = new AddCommand();
		this.deleteCommand = new DeleteCommand();
		this.forceCommand = new ForceCommand();
		this.listCommand = new ListCommand();
		this.settingsCommand = new SettingsCommand();
        this.reloadCommand = new ReloadCommand();
		
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
	        } else if ( subcommand.equalsIgnoreCase("settings") ) {
	        	settingsCommand.execute(player, subargs);
	        } else if ( subcommand.equalsIgnoreCase("force") ) {
	        	forceCommand.execute(player, subargs);
            } else if ( subcommand.equalsIgnoreCase("reload") ) {
                reloadCommand.execute(player, subargs);
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
