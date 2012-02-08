package ch.nonameweb.bukkit.plugins.simpleautoannouncer.task;

import org.getspout.spoutapi.gui.GenericGradient;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.player.SpoutPlayer;

import ch.nonameweb.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;

public class NotificationTask extends Task{
	
	private SimpleAutoAnnouncer plugin;
	private SpoutPlayer player;
	private GenericLabel label;
	private GenericGradient gradient;
	
	public NotificationTask( SpoutPlayer player, GenericLabel label, GenericGradient gradient ) {
		this.plugin = SimpleAutoAnnouncer.getInstance();
		this.player = player;
		this.label = label;
		this.gradient = gradient;
	}
	
	@Override
	public void run() {
		
		player.getMainScreen().removeWidget(label);		
		player.getMainScreen().removeWidget(gradient);
		
		plugin.getTaskManager().setInaktiv(this);
		
	}
}
