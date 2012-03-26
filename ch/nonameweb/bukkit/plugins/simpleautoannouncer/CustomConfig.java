package ch.nonameweb.bukkit.plugins.simpleautoannouncer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class CustomConfig {
	
	private SimpleAutoAnnouncer plugin;
	
	private FileConfiguration config = null;
	private File file = null;
	
	
	public CustomConfig( String name ) {
		this.plugin = SimpleAutoAnnouncer.getInstance();
		
		this.reloadConfig(name);
	}
	
	
	public void reloadConfig( String name ) {
	    if (file == null) {
	    	file = new File(plugin.getDataFolder(), name);
	    }
	    config = YamlConfiguration.loadConfiguration(file);
	 
	    // Look for defaults in the jar
	    InputStream defConfigStream = plugin.getResource( name );
	    
	    if (defConfigStream != null) {
	    	
	        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	        config.setDefaults(defConfig);
	        
	    }
	}
	
	
	public void saveConfig() {
	    if (config == null || file == null) {
	    return;
	    }
	    try {
	        config.save(file);
	    } catch (IOException ex) {
	        Helper.log("Could not save config to " + file);
	    }
	}
	
	
	public FileConfiguration getConfig() {
		return this.config;
	}
	
}
