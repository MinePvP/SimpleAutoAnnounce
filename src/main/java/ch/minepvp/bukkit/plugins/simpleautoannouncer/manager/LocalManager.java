package ch.minepvp.bukkit.plugins.simpleautoannouncer.manager;

import ch.minepvp.bukkit.plugins.simpleautoannouncer.CustomConfig;
import ch.minepvp.bukkit.plugins.simpleautoannouncer.Helper;
import ch.minepvp.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;

public class LocalManager {

	private SimpleAutoAnnouncer plugin;
	private CustomConfig config;
	
	// Strings
	
	public LocalManager() {
		this.plugin = SimpleAutoAnnouncer.getInstance();
		
		load();
	}
	
	public void load() {
		config = new CustomConfig( plugin.getSettingsManager().getLocal() + ".yml" );
	}
	
	public String getStr( String name ) {
		
		String string = config.getConfig().getString( "MESSAGES." + name );
		
		return Helper.format(string);
		
	}
	
	public String getStr( String name, String attr1 ) {
		
		String string = config.getConfig().getString( "MESSAGES." + name );
		
		if ( attr1.equalsIgnoreCase("") == false ) {
			string = string.replace("$1", attr1);
		}
		
		return Helper.format(string);
		
	}
	
	public String getStr( String name, String attr1, String attr2 ) {
		
		String string = config.getConfig().getString( "MESSAGES." + name );
		
		if ( attr1.equalsIgnoreCase("") == false ) {
			string = string.replace("$1", attr1);
		}
		
		if ( attr2.equalsIgnoreCase("") == false ) {
			string = string.replace("$2", attr2);
		}
		
		return Helper.format(string);
		
	}	
	
	public String getStr( String name, String attr1, String attr2, String attr3 ) {
		
		String string = config.getConfig().getString( "MESSAGES." + name );
		
		if ( attr1.equalsIgnoreCase("") == false ) {
			string = string.replace("$1", attr1);
		}
		
		if ( attr2.equalsIgnoreCase("") == false ) {
			string = string.replace("$2", attr2);
		}
		
		if ( attr3.equalsIgnoreCase("") == false ) {
			string = string.replace("$3", attr3);
		}
		
		return Helper.format(string);
		
	}
	
}
