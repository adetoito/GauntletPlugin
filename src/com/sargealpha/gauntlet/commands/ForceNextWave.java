package com.sargealpha.gauntlet.commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;

import com.sargealpha.gauntlet.*;

public class ForceNextWave implements CommandExecutor {
	
	// PLUGIN
	@SuppressWarnings("unused")
	private Main plugin;
	
	// GAUNTLET INFORMATION
	public StartGauntlet start;

	public ForceNextWave(Main plugin, StartGauntlet start) {
		this.plugin = plugin;
		this.start = start;
		PluginCommand cmd = plugin.getCommand("gnext");
		cmd.setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(start.waveBar.gameRunning()) || !(sender instanceof Player)) {
			return false;
		}
		Player p = (Player)sender;
		if (!(p.hasPermission("gauntlet.start"))) {
			return false;
		}

		start.waveBar.nextWave();
		return true;
	}

}
