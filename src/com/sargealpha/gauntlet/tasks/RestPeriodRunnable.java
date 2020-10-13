package com.sargealpha.gauntlet.tasks;

import org.bukkit.scheduler.*;

import com.sargealpha.gauntlet.*;
import com.sargealpha.gauntlet.game.*;
import com.sargealpha.gauntlet.game.kits.PlayerKitData;

public class RestPeriodRunnable extends BukkitRunnable {
	
	// PLUGIN
	private Main plugin;
	private WaveManager manager;
	
	public RestPeriodRunnable(Main plugin, WaveManager manager) {
		this.plugin = plugin;
		this.manager = manager;
	}
	
	@Override
	public void run() {
		manager.decrementTime();
		manager.updateTitleInRest();
		manager.changeBarProgress((double)manager.getTime() / WaveManager.REST_TIME);
		if (manager.getTime() <= 0) {
			WaveManager.WAVE_TIME = 60;
			manager.changeRestStatus(false);
			manager.nextWave();
			
			WaveTimerRunnable waveTimerTask = new WaveTimerRunnable(plugin, manager);
			waveTimerTask.runTaskTimer(plugin, 20, 20);
			manager.setActiveTask(waveTimerTask);
			
			PlayerKitData.setAllTrue();
			this.cancel();
		}
	}

}
