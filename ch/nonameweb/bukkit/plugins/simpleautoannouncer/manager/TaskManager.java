package ch.nonameweb.bukkit.plugins.simpleautoannouncer.manager;

import java.util.ArrayList;

import ch.nonameweb.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.task.StopInaktiveTasksTask;
import ch.nonameweb.bukkit.plugins.simpleautoannouncer.task.Task;

public class TaskManager {

	private SimpleAutoAnnouncer plugin;
	
	private ArrayList<Task> inaktiveTasks;
	
	
	public TaskManager() {
		this.plugin = SimpleAutoAnnouncer.getInstance();
		
		this.inaktiveTasks = new ArrayList<Task>();
		
		// TaskManagerTask für stoppen von Tasks alle 10min oder so.
		
		plugin.getServer().getScheduler().scheduleAsyncRepeatingTask(plugin, new StopInaktiveTasksTask(), 0, 108000L);
		
	}
	
	public Boolean createAsyncDelayedTask( Task task, long delay ) {
		
		Integer pid = null;
		
		pid = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, task, delay);
		
		if ( pid != null ) {
			
			task.setPid(pid);
						
			return true;
		}
		
		return false;
	}
	
	
	public Boolean createAsyncRepeatingTask( Task task, long delay, long time ) {
		
		Integer pid = null;
		
		pid = plugin.getServer().getScheduler().scheduleAsyncRepeatingTask(plugin, task, delay, time);
		
		if ( pid != null ) {
			
			task.setPid(pid);
						
			return true;
		}
		
		return false;
	}
	
	
	public void setInaktiv( Task task ) {
		
		if ( task != null ) {
			
			this.inaktiveTasks.add(task);
			
		}
		
		
	}
	
	public ArrayList<Task> getInaktiveTasks() {
		return this.inaktiveTasks;
	}
	
}
