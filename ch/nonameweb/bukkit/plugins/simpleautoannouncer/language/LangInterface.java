package ch.nonameweb.bukkit.plugins.simpleautoannouncer.language;

import ch.nonameweb.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;

public class LangInterface {

	private String lang;

	private LangInterface_EN langEN	= new LangInterface_EN();
	private LangInterface_DE langDE = new LangInterface_DE();

	public LangInterface() {
		this.lang = SimpleAutoAnnouncer.getInstance().getSettingsManager().getLang();
	}
	
	public String get(String msg){
		
		if ( lang.equalsIgnoreCase("EN") ) {
			return langEN.getString(msg);
		} else if ( lang.equalsIgnoreCase("DE") ) {
			return langDE.getString(msg);
		} else {
			return msg;
		}
	}

}
