package ch.nonameweb.bukkit.plugins.simpleautoannouncer.manager;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;

import ch.nonameweb.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;

public class SettingsManager {
	
	
	private SimpleAutoAnnouncer plugin;
	private Configuration config;
	
	private Boolean debug;
	private String lang;
	private Boolean spout;
	
	private String announceName;
	private Integer time;
	
	private ArrayList<String> messages;
	
	public SettingsManager() {
		
		this.plugin = SimpleAutoAnnouncer.getInstance();
		this.config = plugin.getConfig();
		
		this.addDeafaults();
		this.load();
	}

	
	public void addDeafaults() {
		
		config.addDefault("Settings.Debug", false);
		config.addDefault("Settings.Language", "EN");
		
		config.addDefault("Settings.SpoutNotification", true);
		
		config.addDefault("Settings.Announce.Name", "<red>Announcement");
		config.addDefault("Settings.Time", 10);
		
		
		// Beispiel Nachricht
		ArrayList<String> message = new ArrayList<String>();
		message.add("<yellow>MKD50 will be your new Master");
		message.add("<dark_red>Your Minecraft Client will Explode in 20sec <tick> <tick>");

		config.addDefault("Messages", message);
		
		config.options().copyDefaults(true);
		plugin.saveConfig();
		
		plugin.log("Config : Defaults load");
	}
	
	
	public void load() {
		
		plugin.reloadConfig();
		
		setDebug( config.getBoolean("Settings.Debug") );
		setLang( config.getString("Settings.Language") );
		setSpout( config.getBoolean("Settings.SpoutNotification") );
		
		setAnnounceName( config.getString("Settings.Announce.Name") );
		setTime( config.getInt("Settings.Time") );
		
		List<String> list= null;
		
		setMessages( config.getList("Messages"));
		
		plugin.log("Config : load");
	}
	
	
	public void save() {
		
		plugin.reloadConfig();
		this.config = plugin.getConfig();
		
		config.set("Settings.Debug", getDebug() );
		config.set("Settings.Language", getLang() );
		config.set("Settings.SpoutNotification", getSpout() );
		
		config.set("Settings.Announce.Name", getAnnounceName() );
		config.set("Settings.Time",	getTime() );
		
		config.set("Messages", getMessages().toArray() );
		
		config.set("Messages", this.messages.toArray());
		
		plugin.saveConfig();
		plugin.log("Config : save");
	}


	public Integer getTime() {
		return time;
	}


	public void setTime(Integer time) {
		this.time = time;
	}
	
	
	public void setMessages(List<String> messages) {
		
		this.messages = new ArrayList<String>();
		
		for ( String message : messages ) {
			this.messages.add(message);
		}
		
		
	}
	
	
	public ArrayList<String> getMessages() {
		return this.messages;
	}
	
	
	public void addMessage( String message ) {
		this.messages.add(message);
	}
	
	
	public void removeMessage( Integer id ) {
		
		ListIterator<String> listIterator = this.messages.listIterator();
		Integer counter = 0;
		
		listIterator.next();
		
		for ( String message : this.messages ) {
			
			if ( counter == id ) {
				listIterator.remove();
			} else {
				listIterator.next();
				counter++;
			}
			
		}
		
	}


	public String getAnnounceName() {
		return announceName;
	}


	public void setAnnounceName(String announceName) {
		this.announceName = announceName;
	}


	public Boolean getDebug() {
		return debug;
	}


	public void setDebug(Boolean debug) {
		this.debug = debug;
	}


	public String getLang() {
		return lang;
	}


	public void setLang(String lang) {
		this.lang = lang;
	}


	public Boolean getSpout() {
		return spout;
	}


	public void setSpout(Boolean spout) {
		this.spout = spout;
	}
}
