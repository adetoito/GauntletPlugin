package com.sargealpha.gauntlet;

import com.sargealpha.gauntlet.commands.*;

import org.bukkit.plugin.java.*;
import org.bukkit.scheduler.*;

public class Main extends JavaPlugin {
	
	public final BukkitScheduler scheduler = getServer().getScheduler();
	
	@Override
	public void onEnable() {
		StartGauntlet starter = new StartGauntlet(this);
		new ChooseKit(this, starter);
		new RestoreKit(this, starter);
		new StopGauntlet(this, starter);
		new ForceNextWave(this, starter);
	}

}
