package com.sargealpha.gauntlet.commands;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import java.util.*;
import com.sargealpha.gauntlet.*;
import com.sargealpha.gauntlet.game.kits.*;

public class ChooseKit implements CommandExecutor, Listener {
	
	// PLUGIN
	private Main plugin;
	private StartGauntlet start;
	
	// INVENTORY
	public static Inventory kitInv = Bukkit.createInventory(null, 9, "Choose your Kit:");
	
	// KIT LOCATIONS
	private static final int SWORDSMAN = 0;
	private static final int VIKING = 1;
	private static final int ARCHER = 2;
	private static final int HUNTER = 3;
	private static final int ALCHEMIST = 4;
	private static final int JUGGERNAUT = 5;
	
	public ChooseKit(Main plugin, StartGauntlet start) {
		this.plugin = plugin;
		this.start = start;
		PluginCommand cmd = plugin.getCommand("gkits");
		cmd.setExecutor(this);
		
		// Create kit item stacks (there is probably a more compact way to do this lmao)
		ItemStack swordsman = new ItemStack(Material.IRON_SWORD, 1);
		ItemMeta swordsmanMeta = swordsman.getItemMeta();
		swordsmanMeta.setDisplayName(ChatColor.WHITE + "Swordsman");
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.RESET + "Main Attack Type: " + ChatColor.GRAY + "Melee (Sword)");
		swordsmanMeta.setLore(lore);
		swordsman.setItemMeta(swordsmanMeta);
		
		ItemStack viking = new ItemStack(Material.IRON_AXE, 1);
		ItemMeta vikingMeta = viking.getItemMeta();
		vikingMeta.setDisplayName(ChatColor.WHITE + "Viking");
		lore.clear();
		lore.add(ChatColor.RESET + "Main Attack Type: " + ChatColor.GRAY + "Melee (Axe)");
		vikingMeta.setLore(lore);
		viking.setItemMeta(vikingMeta);
		
		ItemStack archer = new ItemStack(Material.BOW, 1);
		ItemMeta archerMeta = archer.getItemMeta();
		archerMeta.setDisplayName(ChatColor.WHITE + "Archer");
		lore.clear();
		lore.add(ChatColor.RESET + "Main Attack Type: " + ChatColor.GRAY + "Ranged (Bow)");
		archerMeta.setLore(lore);
		archer.setItemMeta(archerMeta);
		
		ItemStack hunter = new ItemStack(Material.CROSSBOW, 1);
		ItemMeta hunterMeta = hunter.getItemMeta();
		hunterMeta.setDisplayName(ChatColor.WHITE + "Hunter");
		lore.clear();
		lore.add(ChatColor.RESET + "Main Attack Type: " + ChatColor.GRAY + "Ranged (Crossbow)");
		hunterMeta.setLore(lore);;
		hunter.setItemMeta(hunterMeta);
		
		ItemStack alchemist = new ItemStack(Material.POTION, 1);
		ItemMeta alchemistMeta = alchemist.getItemMeta();
		alchemistMeta.setDisplayName(ChatColor.WHITE + "Alchemist");
		lore.clear();
		lore.add(ChatColor.RESET + "Main Attack Type: " + ChatColor.GRAY + "Ranged (Splash Potions)");
		alchemistMeta.setLore(lore);
		alchemist.setItemMeta(alchemistMeta);
		
		ItemStack juggernaut = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
		ItemMeta juggernautMeta = juggernaut.getItemMeta();
		juggernautMeta.setDisplayName(ChatColor.WHITE + "Juggernaut");
		lore.clear();
		lore.add(ChatColor.RESET + "Main Attack Type: " + ChatColor.GRAY + "Melee (Knockback)");
		juggernautMeta.setLore(lore);
		juggernaut.setItemMeta(juggernautMeta);
		
		// Set up inventory
		kitInv.setItem(SWORDSMAN, swordsman);
		kitInv.setItem(VIKING, viking);
		kitInv.setItem(ARCHER, archer);
		kitInv.setItem(HUNTER, hunter);
		kitInv.setItem(ALCHEMIST, alchemist);
		kitInv.setItem(JUGGERNAUT, juggernaut);
		
		// Register events
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)|| start.waveBar == null) {
			return false;
		}
		Player p = (Player)sender;
		if (!(p.hasPermission("gauntlet.kits")) || !(start.waveBar.gameRunning())) {
			return false;
		}
		if (!(start.waveBar.isInPreGame())) {
			p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "WARNING! " + ChatColor.RESET + 
					"You can only choose a kit during pre-game!");
			return false;
		}
		p.openInventory(kitInv);
		return true;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		Player p = (Player)event.getWhoClicked();
		int slot = event.getSlot();
		String thisTitle = event.getView().getTitle();
		
		if (thisTitle.equalsIgnoreCase("Choose your Kit:")) {
			event.setCancelled(true);
			plugin.scheduler.runTask(plugin, new Runnable() {
				@Override
				public void run() {
					p.closeInventory();
				}
			});
			
			// Assigns kit to player and notes information
			Kit playerKit = null;
			switch (slot) {
			case SWORDSMAN:
				playerKit = Kit.SWORDSMAN;
				PlayerKitData.putInPlayerKits(p, playerKit);
				PlayerKitData.retrieveKit(p);
				break;
			case VIKING:
				playerKit = Kit.VIKING;
				PlayerKitData.putInPlayerKits(p, playerKit);
				PlayerKitData.retrieveKit(p);
				break;
			case ARCHER:
				playerKit = Kit.ARCHER;
				PlayerKitData.putInPlayerKits(p, playerKit);
				PlayerKitData.retrieveKit(p);
				break;
			case HUNTER:
				playerKit = Kit.HUNTER;
				PlayerKitData.putInPlayerKits(p, playerKit);
				PlayerKitData.retrieveKit(p);
				break;
			case ALCHEMIST:
				playerKit = Kit.ALCHEMIST;
				PlayerKitData.putInPlayerKits(p, playerKit);
				PlayerKitData.retrieveKit(p);
				break;
			case JUGGERNAUT:
				playerKit = Kit.JUGGERNAUT;
				PlayerKitData.putInPlayerKits(p, playerKit);
				PlayerKitData.retrieveKit(p);
				break;
			default:
				break;
			}
			//p.sendMessage(ChatColor.YELLOW + "" + playerKit + " registered in PlayerKitData class."); // DEBUG
		}
	}

}
