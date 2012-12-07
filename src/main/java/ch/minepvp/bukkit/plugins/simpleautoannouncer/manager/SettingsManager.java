package ch.minepvp.bukkit.plugins.simpleautoannouncer.manager;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.bukkit.configuration.Configuration;

import ch.minepvp.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;

public class SettingsManager {
	
	
	private SimpleAutoAnnouncer plugin;
	private Configuration config;
	
	private Boolean debug;
	private String local;

	private String announceName;
	private Integer time;
	private Boolean random;
	
	private ArrayList<String> messages;
	
	public SettingsManager() {
		
		this.plugin = SimpleAutoAnnouncer.getInstance();
		this.config = plugin.getConfig();
		
		this.addDeafaults();
		this.load();
	}

	
	public void addDeafaults() {
		
		config.addDefault("Settings.Debug", false);
		config.addDefault("Settings.Local", "en_US");
		
		config.addDefault("Settings.Announce.Name", "<red>Announcement <white>: ");
		config.addDefault("Settings.Time", 10);
		config.addDefault("Settings.Random", false);
		
		
		// Beispiel Nachricht
		ArrayList<String> message = new ArrayList<String>();
		message.add("<yellow>Test Message 1");
		message.add("<yellow>Test Message 2");
		message.add("<yellow>Test <bold>Message 3");
        message.add("<yellow>Test <underline>Message 4");

		config.addDefault("Messages", message);
		
		config.options().copyDefaults(true);
		plugin.saveConfig();
		
		plugin.log("Config : Defaults load");
	}
	
	
	public void load() {
		
		plugin.reloadConfig();
		
		setDebug( config.getBoolean("Settings.Debug") );
		setLocal( config.getString("Settings.Local") );

		setAnnounceName( config.getString("Settings.Announce.Name") );
		setTime( config.getInt("Settings.Time") );
		
		setRandom( config.getBoolean("Settings.Random") );
		
		List<String> list = null;
		
		setMessages( (List<String>) config.getList("Messages"));
		
		plugin.log("Config : load");
	}
	
	
	public void save() {
		
		plugin.reloadConfig();
		this.config = plugin.getConfig();
		
		config.set("Settings.Debug", getDebug() );
		config.set("Settings.Local", getLocal() );

		config.set("Settings.Announce.Name", getAnnounceName() );
		config.set("Settings.Time",	getTime() );
		
		config.set("Settings.Random", getRandom() );
		
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
		
		if ( this.messages.size() > 1 ) {
			
			for ( String message : this.messages ) {
				
				if ( counter == id ) {
					listIterator.remove();
					return;
				} else {
					listIterator.next();
					counter++;
				}
				
			}
			
		} else {
			this.messages = new ArrayList<String>();
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


	public String getLocal() {
		return local;
	}


	public void setLocal(String lang) {
		this.local = lang;
	}

	public Boolean getRandom() {
		return random;
	}


	public void setRandom(Boolean random) {
		this.random = random;
	}
}
