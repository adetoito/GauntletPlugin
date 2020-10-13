package com.sargealpha.gauntlet.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import com.sargealpha.gauntlet.*;
import com.sargealpha.gauntlet.game.kits.*;

public class RestoreKit implements CommandExecutor {
	
	// PLUGIN
	@SuppressWarnings("unused")
	private Main plugin;
	private StartGauntlet start;
	
	public RestoreKit(Main plugin, StartGauntlet start) {
		this.plugin = plugin;
		this.start = start;
		PluginCommand cmd = plugin.getCommand("grestore");
		cmd.setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player) || start.waveBar == null) {
			return false;
		}
		Player p = (Player)sender;
		if (!(p.hasPermission("gauntlet.restore")) || !(PlayerKitData.containsPlayer(p))) {
			return false;
		}
		if (!(start.waveBar.isGameInRest())) {
			p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "WARNING! " + ChatColor.RESET + 
					"You can only replenish your kit during rest periods!");
			return false;
		}
		if (!(PlayerKitData.getStatus(p))) {
			p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "WARNING! " + ChatColor.RESET + 
					"You've already replenished your kit!");
			return false;
		}
		
		//p.sendMessage(ChatColor.YELLOW + "Retrieving kit..."); // DEBUG
		PlayerKitData.retrieveKit(p);
		PlayerKitData.setStatus(p, false);
		
		return true;
	}
	
}
