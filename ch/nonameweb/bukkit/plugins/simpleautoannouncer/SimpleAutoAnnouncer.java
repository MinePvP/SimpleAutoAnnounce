package ch.nonameweb.bukkit.plugins.simpleautoannouncer;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import ch.nonameweb.bukkit.plugins.simpleautoannouncer.manager.CommandManager;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.manager.LocalManager;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.manager.SettingsManager;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.manager.TaskManager;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.task.AnnounceSpoutTask;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.task.AnnounceTask;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.task.Task;

public class SimpleAutoAnnouncer extends JavaPlugin {

	private static SimpleAutoAnnouncer plugin;
	
	private SettingsManager settingsManager;
	private CommandManager commandManager;
	private TaskManager taskManager;
	private LocalManager localManager;
	
	// Spout
	private Boolean isSpoutServer;
	
	private SimpleAutoAnnouncerPlayerListener playerListener;
	
	@Override
	public void onEnable() {
		
		plugin = this;
		
		// Spout server detection
		try {
			Class.forName("org.getspout.spoutapi.player.SpoutPlayer");
			isSpoutServer = true;
			
		} catch (ClassNotFoundException e) {
			isSpoutServer = false;
		}
		
		// Resources
		saveResource("en_US.yml", true);
		saveResource("de_DE.yml", true);
		
		// Manager
		this.settingsManager = new SettingsManager();
		this.localManager = new LocalManager();		
		this.commandManager = new CommandManager();
		this.taskManager = new TaskManager();
		
		// Listeners
		this.playerListener = new SimpleAutoAnnouncerPlayerListener();
		
		// Tasks
		this.createAutoAnnounceTask();
		
		this.log("Enabled");
	}
	
	@Override
	public void onDisable() {
		
		this.settingsManager.save();
		saveConfig();
		this.log("Disabled");
	}
	
	public void log( String message ) {
		Logger.getLogger("Minecraft").info("[SimpleAutoAnnounce] " + message);
	}
	
	public void createAutoAnnounceTask() {
		
		Task task = null;
		
		if ( this.isSpoutServer() == true ) {
			task = new AnnounceSpoutTask();
		} else {
			task = new AnnounceTask();
		}
		
		long delay = 0;
		long time = 0;
		
		time = ( 60 * settingsManager.getTime() ) * 20L;
		delay = time / 2;
		
		this.taskManager.createAsyncRepeatingTask(task, delay, time);
	}
	
	public void resetLocal() {
		localManager = new LocalManager();
	}
	
	public void restartAutoAnnounceTask() {
		this.taskManager.stopAllTask();
		this.createAutoAnnounceTask();
	}
	
	public static SimpleAutoAnnouncer getInstance() {
		return plugin;
	}
	
	public SettingsManager getSettingsManager() {
		return this.settingsManager;
	}
	
	public CommandManager getCommandManager() {
		return this.commandManager;
	}
	
	public TaskManager getTaskManager() {
		return this.taskManager;
	}
	
	public LocalManager getLocalManager() {
		return this.localManager;
	}
	
	public Boolean isSpoutServer() {
		return this.isSpoutServer;
	}
}
