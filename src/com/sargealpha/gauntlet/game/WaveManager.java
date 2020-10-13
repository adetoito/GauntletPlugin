package com.sargealpha.gauntlet.game;

import org.apache.commons.lang.StringUtils;
import org.bukkit.*;
import org.bukkit.boss.*;
import org.bukkit.entity.*;
import org.bukkit.scheduler.*;

import com.sargealpha.gauntlet.*;
import com.sargealpha.gauntlet.game.kits.PlayerKitData;
import com.sargealpha.gauntlet.tasks.*;
import com.sargealpha.gauntlet.waves.DefaultProgression;

import java.util.*;

/**
 * The WaveManager class manages all aspects of the Gauntlet game, from scoreboards and boss bars to the
 * mobs spawned. The class also actively monitors participating players.
 * 
 * @author SargeAlpha
 */
public class WaveManager {
	
	// PLUGIN
	private Main plugin;
	
	// WORLD INFORMATION
	private World world;
	private int x1 = -56, y1 = 57, z1 = -104;
	private int x2 = -120, z2 = -40;
	private Location spawn;
	
	// GAUNTLET INFORMATION
	private boolean isGameRunning;
	private boolean inRestPeriod;
	private boolean inPreGame;
	
	private BossBar bar; // the boss bar
	private int wave; // wave number
	private int timeLeft;
	private int playersAlive;
	private Set<Player> participatingPlayers;
	private Set<Player> initialPlayers;
	
	// WAVE INFORMATION
	private Map<Integer, Map<EntityType, Integer>> waves; // [wave -> [mob -> amount to spawn]]
	private Map<EntityType, Integer> defaultWave;
	
	// CONSTANTS
	public static final int REST_TIME = 30;
	public static int WAVE_TIME = 40;
	public static int KIT_TIME = 120;
	//public static final int KIT_TIME = 15; // DEBUG
	
	// TASKS
	private BukkitRunnable activeTask = null;
	private BukkitRunnable chooseKitTask = new BukkitRunnable() {
		@Override
		public void run() {
			timeLeft--;
			updateTitleInPreGame();
			bar.setProgress((double)timeLeft / KIT_TIME);
			if (timeLeft <= 0) {
				inPreGame = false;
				//isGameRunning = true;
				startTimer();
				this.cancel();
			}
		}
	};
	
	public WaveManager(ProgressionType type, BossBar bar, Main plugin) {
		this(type, bar, 1, plugin);
	}
	
	public WaveManager(ProgressionType type, BossBar bar, int wave, Main plugin) {
		this.isGameRunning = false;
		this.inRestPeriod = false;
		this.inPreGame = true;
		
		this.bar = bar;
		this.wave = wave;
		this.waves = new HashMap<>();
		timeLeft = KIT_TIME;
		
		this.plugin = plugin;
		this.participatingPlayers = new HashSet<>();
		participatingPlayers.addAll(Bukkit.getOnlinePlayers());
		this.initialPlayers = new HashSet<>(participatingPlayers);
		this.playersAlive = participatingPlayers.size();
		
		this.initializeWorldInfo();
		switch(type) {
		case DEFAULT:
			this.waves = DefaultProgression.initializeWaves();
		}
		
		defaultWave = new HashMap<>();
		defaultWave.put(EntityType.ZOMBIE, 12);
		
		bar.setProgress(1.0);
		this.showWaveBar();
	}
	
	/**
	 * The initializeWorldInfo method initializes all world-related variables to their defaults.
	 */
	private void initializeWorldInfo() {
		// Gets world
		if (participatingPlayers.isEmpty()) {
			return;
		}
		Iterator<? extends Player> it = this.participatingPlayers.iterator();
		this.world = it.next().getWorld();
		this.spawn = new Location(world, -88, 57, -72);
	}
	
	public Location getSpawn() {
		return spawn;
	}
	
	public void decrementPlayers() {
		playersAlive--;
	}
	
	public int getLivePlayerCount() {
		return playersAlive;
	}
	
	public void setTime(int timeLeft) {
		this.timeLeft = timeLeft;
	}
	
	public void decrementTime() {
		timeLeft--;
	}
	
	public int getTime() {
		return timeLeft;
	}
	
	public int getWave() {
		return wave;
	}
	
	public Set<Player> getParticipatingPlayers() {
		return new HashSet<>(this.participatingPlayers);
	}
	
	public boolean containsPlayer(Player p) {
		return this.participatingPlayers.contains(p);
	}
	
	public void removePlayer(Player p) {
		this.participatingPlayers.remove(p);
	}
	
	public boolean gameRunning() {
		return this.isGameRunning;
	}
	
	public boolean isGameInRest() {
		return this.inRestPeriod;
	}
	
	public boolean isInPreGame() {
		return this.inPreGame;
	}
	
	public void changeRestStatus(boolean inRestPeriod) {
		this.inRestPeriod = inRestPeriod;
	}
	
	public void setActiveTask(BukkitRunnable task) {
		this.activeTask = task;
	}
	
	/**
	 * The updateTitle method updates the wave number and time remaining in the boss bar's title.
	 * 
	 * @param a boolean representing whether the game is in a rest period or not
	 * @return a reference to the updated boss bar
	 */
	public BossBar updateTitle() {
		String title = ChatColor.GREEN + "" + ChatColor.BOLD + "Wave " + wave + ChatColor.DARK_GREEN + " *** " + ChatColor.GREEN + "" +
					ChatColor.BOLD + "Time Until Next Wave: " + ChatColor.RESET + timeLeft;
		bar.setTitle(title);
		return bar;
	}
	
	public BossBar updateTitleInRest() {
		String title = ChatColor.AQUA + "" + ChatColor.BOLD + "Rest Period!" + ChatColor.DARK_AQUA + " *** " + ChatColor.AQUA + "" +
					ChatColor.BOLD + "Time Until Next Wave: " + ChatColor.RESET + timeLeft;
		bar.setTitle(title);
		return bar;
	}
	
	public BossBar updateTitleInPreGame() {
		String title = ChatColor.YELLOW + "" + ChatColor.BOLD + "Pre-Game!" + ChatColor.GOLD + " *** " + ChatColor.YELLOW + "" +
					ChatColor.BOLD + "Time Until First Wave: " + ChatColor.RESET + timeLeft;
		bar.setTitle(title);
		return bar;
	}
	
	/**
	 * The showWaveBar method sets the boss bar visible for all participating players.
	 */
	public void showWaveBar() {
		for (Player p : this.participatingPlayers) {
			bar.addPlayer(p);
		}
		bar.setVisible(true);
	}
	
	public void changeBarProgress(double progress) {
		bar.setProgress(progress);
	}
	
	/**
	 * The hideWaveBar method sets the boss bar invisible for all participating players.
	 */
	public void hideWaveBar() {
		for (Player p : this.participatingPlayers) {
			bar.removePlayer(p);
		}
		bar.setVisible(false);
	}
	
	/**
	 * The getWorld method is a simple getter for the world that Gauntlet takes place in.
	 * 
	 * @return a reference to the Gauntlet game's world.
	 */
	public World getWorld() {
		return world;
	}
	
	/**
	 * The startGame method starts the game. The game gives all players thirty seconds to choose a
	 * kit.
	 */
	public void startGame() {
		this.isGameRunning = true;
		this.inRestPeriod = true;
		chooseKitTask.runTaskTimer(plugin, 20, 20);
		
		for (Player p : this.participatingPlayers) {
			p.sendMessage(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "------------");
			p.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Welcome to the Gauntlet!");
			p.sendMessage(ChatColor.GRAY + "Choose the class you want to use with " + ChatColor.WHITE + "/gkits"
					+ ChatColor.GRAY + "!");
			
			if (KIT_TIME % 60 == 0) {
				p.sendMessage(ChatColor.GRAY + "You have " + ChatColor.WHITE + (KIT_TIME / 60) + " " + ChatColor.GRAY + "minutes to choose.");
			} else {
				p.sendMessage(ChatColor.GRAY + "You have " + ChatColor.WHITE + KIT_TIME + " " + ChatColor.GRAY + "seconds to choose.");
			}
			
			p.sendMessage(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "------------");
		}
	}
	
	/**
	 * The startTimer method starts the game (officially) by starting all Gauntlet tasks, spawning
	 * the first wave, and sending the appropriate messages.
	 */
	private void startTimer() {
		this.timeLeft = WAVE_TIME;
		this.activeTask = new WaveTimerRunnable(plugin, this);
		this.activeTask.runTaskTimer(plugin, 20, 20);
		
		Map<EntityType, Integer> mobs = waves.get(this.wave);
		for (Map.Entry<EntityType, Integer> mob : mobs.entrySet()) {
			EntityType m = mob.getKey();
			for (int spawnNum = 0; spawnNum < mob.getValue(); spawnNum++) {
				this.spawnMobInRegion(m);
			}
		}
		
		for (Player p : this.participatingPlayers) {
			PlayerKitData.setStatus(p, true);
			p.setHealth(20);
			p.setFoodLevel(20);
			//p.sendMessage(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "------------");
			p.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Wave " + this.wave + " Incoming!");
			p.sendMessage(ChatColor.GRAY + "Mobs Spawned: " + ChatColor.WHITE + "ZOMBIE x12");
			p.sendMessage(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "------------");
		}
	}
	
	/**
	 * The nextWave method spawns the next wave of mobs, increments the wave number, and updates all visual
	 * aspects of the game. This method runs at the end of each wave, as dictated by its respective task.
	 */
	public void nextWave() {
		this.wave++;
		boolean usingDefaultWave;
		
		// Spawn mobs
		if (waves.containsKey(wave)) {
			usingDefaultWave = false;
			Map<EntityType, Integer> mobs = waves.get(this.wave);
			for (Map.Entry<EntityType, Integer> mob : mobs.entrySet()) {
				EntityType m = mob.getKey();
				for (int spawnNum = 0; spawnNum < mob.getValue(); spawnNum++) {
					this.spawnMobInRegion(m);
				}
			}
		} else { // Spawn default wave
			usingDefaultWave = true;
			for (Map.Entry<EntityType, Integer> defaultWave : defaultWave.entrySet()) {
				EntityType m = defaultWave.getKey();
				for (int spawnNum = 0; spawnNum < defaultWave.getValue(); spawnNum++) {
					this.spawnMobInRegion(m);
				}
			}
		}
		
		// Update everything
		timeLeft = WAVE_TIME;
		bar.setProgress(1.0);
		this.updateTitle();
		
		// Announce next wave
		for (Player p : this.participatingPlayers) {
			//p.sendMessage(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "------------");
			p.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Wave " + this.wave + " Incoming!");
			StringBuffer mobsSpawned = new StringBuffer();
			if (usingDefaultWave) {
				mobsSpawned.append(ChatColor.GRAY + "Mobs Spawned: ");
				mobsSpawned.append(ChatColor.WHITE);
				for (Map.Entry<EntityType, Integer> defaultWave : defaultWave.entrySet()) {
					String mobProperCase = StringUtils.capitalize(defaultWave.getKey().toString());
					mobsSpawned.append(mobProperCase);
					mobsSpawned.append(" x");
					mobsSpawned.append(defaultWave.getValue());
					mobsSpawned.append(", ");
				}
			} else {
				Map<EntityType, Integer> mobs = waves.get(this.wave);
				mobsSpawned.append(ChatColor.GRAY + "Mobs Spawned: ");
				mobsSpawned.append(ChatColor.WHITE);
				for (Map.Entry<EntityType, Integer> mob : mobs.entrySet()) {
					String mobProperCase = StringUtils.capitalize(mob.getKey().toString());
					mobsSpawned.append(mobProperCase);
					mobsSpawned.append(" x");
					mobsSpawned.append(mob.getValue());
					mobsSpawned.append(", ");
				}
			}
			String mobsSpawnedStr = mobsSpawned.toString();
			p.sendMessage(mobsSpawnedStr);
			p.sendMessage(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "------------");
		}
	}
	
	/**
	 * The stopGame method stops the Gauntlet game in its tracks. This method is run solely
	 * from Gauntlet's cancel command (see StopGauntlet.java).
	 */
	public void stopGame() {
		if (activeTask == null) {
			this.chooseKitTask.cancel();
		} else {
			this.activeTask.cancel();
		}
		
		for (Player onlinePlayer : this.initialPlayers) {
			onlinePlayer.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
		}
		
		this.isGameRunning = false;
	}
	
	/**
	 * The spawnMobInRegion method spawns a mob within the region bounds.
	 * 
	 * @param mob the mob to spawn.
	 */
	private void spawnMobInRegion(EntityType mob) {
		Random rand = new Random();
		int x = rand.nextInt((Math.max(x1, x2) - Math.min(x1, x2)) + 1) + Math.min(x1, x2);
		int z = rand.nextInt((Math.max(z1, z2) - Math.min(z1, z2)) + 1) + Math.min(z1, z2);
		Location spawnLocation = new Location(this.world, x, this.y1, z);
		this.world.spawnEntity(spawnLocation, mob);
	}
}
