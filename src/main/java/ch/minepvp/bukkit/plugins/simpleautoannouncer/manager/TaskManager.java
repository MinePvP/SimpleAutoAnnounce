package ch.minepvp.bukkit.plugins.simpleautoannouncer.manager;

import java.util.ArrayList;

import ch.minepvp.bukkit.plugins.simpleautoannouncer.SimpleAutoAnnouncer;
import ch.minepvp.bukkit.plugins.simpleautoannouncer.task.StopInaktiveTasksTask;
import ch.minepvp.bukkit.plugins.simpleautoannouncer.task.Task;

public class TaskManager {

	private SimpleAutoAnnouncer plugin;
	
	private ArrayList<Task> allTasks;
	private ArrayList<Task> inaktiveTasks;
	
	
	public TaskManager() {
		this.plugin = SimpleAutoAnnouncer.getInstance();
		
		this.inaktiveTasks = new ArrayList<Task>();
		this.allTasks = new ArrayList<Task>();
		
		// TaskManagerTask für stoppen von Tasks alle 10min oder so.
		
		plugin.getServer().getScheduler().runTaskTimer(plugin, new StopInaktiveTasksTask(), 0, 108000L);
		
	}
	
	public Boolean createAsyncDelayedTask( Task task, long delay ) {
		
		Integer pid = null;
		
        pid = plugin.getServer().getScheduler().runTaskLaterAsynchronously(plugin, task, delay).getTaskId();
		
		if ( pid != null ) {
			
			task.setPid(pid);
			this.allTasks.add(task);
			
			return true;
		}
		
		return false;
	}
	
	
	public Boolean createAsyncRepeatingTask( Task task, long delay, long time ) {
		
		Integer pid = null;
		
		pid = plugin.getServer().getScheduler().runTaskTimerAsynchronously(plugin, task, delay, time).getTaskId();
		
		if ( pid != null ) {
			
			task.setPid(pid);
			this.allTasks.add(task);
			
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
	
	
	public void stopAllTask() {
		
		if ( allTasks.size() > 0 ) {
			
			for ( Task task : this.allTasks ) {
				plugin.getServer().getScheduler().cancelTask( task.getPid() );
			}
			
		}
		
	}
	
}
