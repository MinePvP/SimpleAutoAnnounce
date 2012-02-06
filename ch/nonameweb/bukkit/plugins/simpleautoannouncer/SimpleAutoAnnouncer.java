package ch.nonameweb.bukkit.plugins.simpleautoannouncer;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import ch.nonameweb.bukkit.plugins.simpleautoannouncer.manager.CommandManager;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.manager.SettingsManager;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.manager.TaskManager;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.task.AnnounceTask;

public class SimpleAutoAnnouncer extends JavaPlugin {

	private static SimpleAutoAnnouncer plugin;
	
	private SettingsManager settingsManager;
	private CommandManager commandManager;
	private TaskManager taskManager;
	
	private SimpleAutoAnnouncerPlayerListener playerListener;
	
	@Override
	public void onEnable() {
		
		plugin = this;
		
		// Manager
		this.settingsManager = new SettingsManager();
		this.commandManager = new CommandManager();
		this.taskManager = new TaskManager();
		
		// Listeners
		this.playerListener = new SimpleAutoAnnouncerPlayerListener();
		
		
		AnnounceTask task = new AnnounceTask();
		
		long delay = 0;
		long time = 0;
		
		time = ( 60 * settingsManager.getTime() ) * 20L;
		delay = time / 2;
		
		this.taskManager.createAsyncRepeatingTask(task, delay, time);
		
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
	
	public void restartAutoAnnounceTask() {
		
		this.taskManager.stopAllTask();
		
		AnnounceTask task = new AnnounceTask();
		
		long delay = 0;
		long time = 0;
		
		time = ( 60 * settingsManager.getTime() ) * 20L;
		delay = time / 2;
		
		this.taskManager.createAsyncRepeatingTask(task, delay, time);
		
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
	
}
