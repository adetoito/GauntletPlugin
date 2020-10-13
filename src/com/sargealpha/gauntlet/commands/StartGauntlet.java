package com.sargealpha.gauntlet.commands;

import com.sargealpha.gauntlet.*;
import com.sargealpha.gauntlet.game.*;

import org.bukkit.*;
import org.bukkit.boss.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class StartGauntlet implements CommandExecutor {
	
	// PLUGIN
	private Main plugin;
	
	// GAUNTLET INFORMATION
	public WaveManager waveBar;

	public StartGauntlet(Main plugin) {
		this.plugin = plugin;
		PluginCommand cmd = plugin.getCommand("gstart");
		cmd.setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		Player p = (Player)sender;
		if (!(p.hasPermission("gauntlet.start"))) {
			return false;
		}

		// Do command stuff after here
		String title = ChatColor.YELLOW + "" + ChatColor.BOLD + "Pre-Game!" + ChatColor.GOLD + " *** " + ChatColor.YELLOW + "" +
					ChatColor.BOLD + "Time Until First Wave: " + ChatColor.RESET + WaveManager.KIT_TIME;
		BossBar bossBar = Bukkit.getServer().createBossBar(title, BarColor.BLUE, BarStyle.SEGMENTED_20, BarFlag.CREATE_FOG);
		waveBar = new WaveManager(ProgressionType.DEFAULT, bossBar, plugin);
		waveBar.startGame();
		
		// End command stuff here
		return true;
	}

}
