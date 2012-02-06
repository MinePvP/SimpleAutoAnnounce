package ch.nonameweb.bukkit.plugins.simpleautoannouncer.task;

import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.player.SpoutPlayer;

import ch.nonameweb.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;

public class NotificationTask extends Task{
	
	private SimpleAutoAnnouncer plugin;
	private SpoutPlayer player;
	private GenericLabel label;
	
	public NotificationTask( SpoutPlayer player, GenericLabel label ) {
		this.plugin = SimpleAutoAnnouncer.getInstance();
		this.player = player;
		this.label = label;
	}
	
	@Override
	public void run() {
		
		player.getMainScreen().removeWidget(label);		
		
		plugin.getTaskManager().setInaktiv(this);
		
	}
}
