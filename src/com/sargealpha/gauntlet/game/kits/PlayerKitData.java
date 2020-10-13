package com.sargealpha.gauntlet.game.kits;

import java.util.*;
import org.bukkit.entity.*;

public class PlayerKitData {
	
	private static Map<Player, Kit> playerKits = new HashMap<>();
	private static Map<Player, Boolean> restoreStatuses = new HashMap<>();
	
	public static boolean containsPlayer(Player p) {
		return playerKits.containsKey(p);
	}
	
	public static Map<Player, Kit> putInPlayerKits(Player p, Kit k) {
		playerKits.put(p, k);
		return new HashMap<>(playerKits);
	}
	
	public static void retrieveKit(Player p) {
		Kit k = playerKits.get(p);
		Kit.giveKit(p, k);
	}
	
	public static Map<Player, Boolean> setStatus(Player p, boolean status) {
		restoreStatuses.put(p, status);
		return new HashMap<>(restoreStatuses);
	}
	
	public static boolean getStatus(Player p) {
		return restoreStatuses.get(p);
	}
	
	public static Map<Player, Boolean> setAllTrue() {
		for (Player p : restoreStatuses.keySet()) {
			restoreStatuses.put(p, true);
		}
		return new HashMap<>(restoreStatuses);
	}
	
	public static Map<Player, Boolean> setAllFalse() {
		for (Player p : restoreStatuses.keySet()) {
			restoreStatuses.put(p, false);
		}
		return new HashMap<>(restoreStatuses);
	}

}
