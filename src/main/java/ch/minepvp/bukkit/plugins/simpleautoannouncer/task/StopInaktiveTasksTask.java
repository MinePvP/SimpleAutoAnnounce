package ch.minepvp.bukkit.plugins.simpleautoannouncer.task;

import ch.minepvp.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;

public class StopInaktiveTasksTask extends Task {
	
	private SimpleAutoAnnouncer plugin;
	
	public StopInaktiveTasksTask() {
		this.plugin = SimpleAutoAnnouncer.getInstance();		
	}
	
	@Override
	public void run() {
		
		for ( Task task : plugin.getTaskManager().getInaktiveTasks() ) {
			
			plugin.getServer().getScheduler().cancelTask( task.getPid() );
			
		}
		
	}

}
