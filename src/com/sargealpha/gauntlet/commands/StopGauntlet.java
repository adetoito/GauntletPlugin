package com.sargealpha.gauntlet.commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;

import com.sargealpha.gauntlet.*;

public class StopGauntlet implements CommandExecutor {
	
	// PLUGIN
	@SuppressWarnings("unused")
	private Main plugin;
	private StartGauntlet start;
	
	public StopGauntlet(Main plugin, StartGauntlet start) {
		this.plugin = plugin;
		this.start = start;
		PluginCommand cmd = plugin.getCommand("gstop");
		cmd.setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (start.waveBar == null || !(sender instanceof Player)) {
			return false;
		}
		Player p = (Player)sender;
		if (!(p.hasPermission("gauntlet.stop"))) {
			return false;
		}
		
		// Despawns all Gauntlet mobs
		for (Entity e : start.waveBar.getWorld().getEntities()) {
			if (e instanceof Monster) {
				e.remove();
			}
		}
		
		// Manages Gauntlet game
		start.waveBar.stopGame();
		start.waveBar.hideWaveBar();
		return true;
	}

}
