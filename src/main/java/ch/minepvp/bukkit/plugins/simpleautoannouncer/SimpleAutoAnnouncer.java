package ch.minepvp.bukkit.plugins.simpleautoannouncer;

import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import ch.minepvp.bukkit.plugins.simpleautoannouncer.manager.CommandManager;
import ch.minepvp.bukkit.plugins.simpleautoannouncer.manager.LocalManager;
import ch.minepvp.bukkit.plugins.simpleautoannouncer.manager.SettingsManager;
import ch.minepvp.bukkit.plugins.simpleautoannouncer.manager.TaskManager;
import ch.minepvp.bukkit.plugins.simpleautoannouncer.task.AnnounceTask;
import ch.minepvp.bukkit.plugins.simpleautoannouncer.task.Task;
import org.mcstats.Metrics;

public class SimpleAutoAnnouncer extends JavaPlugin {

	private static SimpleAutoAnnouncer plugin;
	
	private SettingsManager settingsManager;
	private CommandManager commandManager;
	private TaskManager taskManager;
	private LocalManager localManager;

	private SimpleAutoAnnouncerPlayerListener playerListener;
	
	@Override
	public void onEnable() {
		
		plugin = this;

		// Resources
		saveResource("en_US.yml", true);
		saveResource("de_DE.yml", true);
        saveResource("fr_FR.yml", true);
        saveResource("it_IT.yml", true);

		// Manager
		this.settingsManager = new SettingsManager();
		this.localManager = new LocalManager();
		this.commandManager = new CommandManager();
		this.taskManager = new TaskManager();

        // Metrics Statistik
        try {
            Metrics metrics = new Metrics(this);


            // Amount of MessageGroups
            metrics.addCustomData(new Metrics.Plotter("Total Messages") {

                @Override
                public int getValue() {
                    return settingsManager.getMessages().size();
                }

            });

            // Amount of MessageGroups
            metrics.addCustomData(new Metrics.Plotter("Messages Total") {

                @Override
                public int getValue() {
                    return settingsManager.getMessages().size();
                }

            });

            // Announce Time
            metrics.addCustomData(new Metrics.Plotter("Announce Time") {

                @Override
                public int getValue() {
                    return settingsManager.getTime();
                }

            });

            // Random?
            metrics.addCustomData(new Metrics.Plotter("Messages Random") {

                @Override
                public int getValue() {

                    if ( settingsManager.getRandom() ) {
                        return 1;
                    }

                    return 0;
                }

            });

            metrics.start();
        } catch (IOException e) { // Failed to submit the stats :-(
            System.out.println("Error Submitting stats!");
        }

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
		
		Task task = new AnnounceTask();

		
		long delay = 0;
		long time = 0;
		
		time = ( 60 * settingsManager.getTime() ) * 20L;
		delay = time / 2;
		
		this.taskManager.createAsyncRepeatingTask(task, delay, time);
	}
	
	public void resetLocal() {
		localManager = new LocalManager();
	}

    public void resetSettings() {
        reloadConfig();
        settingsManager = new SettingsManager();
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

}
