package com.sargealpha.gauntlet.listeners;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.inventory.*;

import com.sargealpha.gauntlet.commands.*;

public class CreatureSpawnListener implements Listener {
	
	private StartGauntlet starter;
	
	public CreatureSpawnListener(StartGauntlet starter) {
		this.starter = starter;
	}
	
	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent event) {
		if (starter.waveBar == null) {
			return;
		}
		if (starter.waveBar.getWave() >= 40 && event.getEntityType() == EntityType.ZOMBIE) {
			ItemStack helmet = new ItemStack(Material.IRON_HELMET, 1);
			ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
			ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
			ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
			ItemStack[] equipment = {boots, leggings, chestplate, helmet};
			
			Zombie zombie = (Zombie)event.getEntity();
			zombie.getEquipment().setArmorContents(equipment);
		}
	}

}
