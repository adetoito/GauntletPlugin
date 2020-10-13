package com.sargealpha.gauntlet.tasks;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.*;

import com.sargealpha.gauntlet.*;
import com.sargealpha.gauntlet.game.*;

public class WaveTimerRunnable extends BukkitRunnable {
	
	// PLUGIN
	private Main plugin;
	private WaveManager manager;
	
	public WaveTimerRunnable(Main plugin, WaveManager manager) {
		this.plugin = plugin;
		this.manager = manager;
	}

	@Override
	public void run() {
		manager.decrementTime();
		manager.updateTitle();
		manager.changeBarProgress((double)manager.getTime() / WaveManager.WAVE_TIME);
		if (manager.getTime() <= 0) {
			if (manager.getWave() % 10 == 9) {
				manager.changeRestStatus(true);
				manager.setTime(WaveManager.REST_TIME);
				
				RestPeriodRunnable restPeriodTask = new RestPeriodRunnable(plugin, manager);
				restPeriodTask.runTaskTimer(plugin, 20, 20);
				manager.setActiveTask(restPeriodTask);
				
				for (Player p : manager.getParticipatingPlayers()) {
					//p.sendMessage(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "------------");
					p.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Rest Period:");
					p.sendMessage(ChatColor.GRAY + "If you're running low on supplies, replenish your kit with " + ChatColor.WHITE + "/grestore"
							+ ChatColor.GRAY + "!");
					p.sendMessage(ChatColor.GRAY + "You can only replenish your kit once during this rest period.");
					p.sendMessage(ChatColor.GRAY + "You have " + ChatColor.WHITE + WaveManager.REST_TIME + " " + ChatColor.GRAY + "seconds to rest.");
					p.sendMessage(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "------------");
				}
				
				this.cancel();
			} else {
				manager.nextWave();
			}
		}
	}
}