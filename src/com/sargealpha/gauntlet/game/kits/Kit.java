package com.sargealpha.gauntlet.game.kits;

import org.bukkit.*;
import org.bukkit.enchantments.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.potion.*;

public enum Kit {
	
	SWORDSMAN, VIKING, ARCHER, HUNTER, ALCHEMIST, JUGGERNAUT;
	
	// CONSTANT ITEM STACKS
	private static final ItemStack DURABLE_BASIC_BOW = new ItemStack(Material.BOW, 1);
	private static final ItemStack ARROWS = new ItemStack(Material.ARROW, 64);
	private static final ItemStack HALF_ARROWS = new ItemStack(Material.ARROW, 32);
	private static final ItemStack STEAKS = new ItemStack(Material.COOKED_BEEF, 64);
	private static final ItemStack P_SHIELD = new ItemStack(Material.SHIELD, 1);
	
	public static void giveKit(Player p, Kit k) {
		// Clear inventory and equipment
		p.getInventory().clear();
		p.getEquipment().clear();
		
		// Adds constant item stack enchants
		DURABLE_BASIC_BOW.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
		P_SHIELD.addEnchantment(Enchantment.DURABILITY, 1);
		
		// Retrieves and declares requisite information
		Inventory playerInv = p.getInventory();
		EntityEquipment playerEquipment = p.getEquipment();
		ItemStack helmet, chestplate, leggings, boots;
		//p.sendMessage(ChatColor.YELLOW + "Giving kit... (Player kit: " + k + ")"); // DEBUG
		
		switch (k) {
		case SWORDSMAN:
			// Creates items
			ItemStack knightSword = new ItemStack(Material.IRON_SWORD, 1);
			knightSword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			knightSword.addEnchantment(Enchantment.SWEEPING_EDGE, 1);
			knightSword.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
			ItemStack knightHealingPot = new ItemStack(Material.POTION, 3);
			PotionMeta knightHealingPotMeta = (PotionMeta)knightHealingPot.getItemMeta();
			knightHealingPotMeta.setColor(Color.FUCHSIA);
			knightHealingPotMeta.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 1, 1), true);
			knightHealingPotMeta.setDisplayName("Royal Nectar");
			knightHealingPot.setItemMeta(knightHealingPotMeta);
			
			helmet = new ItemStack(Material.IRON_HELMET, 1);
			helmet.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
			chestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			LeatherArmorMeta knightLegsMeta = (LeatherArmorMeta)leggings.getItemMeta();
			knightLegsMeta.setColor(Color.fromRGB(157, 157, 151));
			leggings.setItemMeta(knightLegsMeta);
			leggings.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			boots = new ItemStack(Material.IRON_BOOTS, 1);
			boots.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			
			// Adds items
			ItemStack[] knightEquips = {boots, leggings, chestplate, helmet};
			playerInv.addItem(knightSword);
			playerInv.addItem(DURABLE_BASIC_BOW);
			playerInv.addItem(knightHealingPot);
			playerInv.addItem(ARROWS);
			playerInv.addItem(STEAKS);
			playerInv.addItem(P_SHIELD);
			playerEquipment.setArmorContents(knightEquips);
			break;
		case VIKING:
			// Creates items
			ItemStack vikingAxe = new ItemStack(Material.IRON_AXE, 1);
			vikingAxe.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
			ItemStack vikingSword = new ItemStack(Material.STONE_SWORD, 1);
			vikingSword.addEnchantment(Enchantment.KNOCKBACK, 1);
			vikingSword.addEnchantment(Enchantment.DURABILITY, 1);
			ItemStack vikingStrengthPot = new ItemStack(Material.POTION, 1);
			PotionMeta vikingStrengthPotMeta = (PotionMeta)vikingStrengthPot.getItemMeta();
			vikingStrengthPotMeta.setColor(Color.PURPLE);
			vikingStrengthPotMeta.addCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 90 * 20, 1), true);
			vikingStrengthPotMeta.setDisplayName("Viking Vigor");
			vikingStrengthPot.setItemMeta(vikingStrengthPotMeta);
			ItemStack vikingSpeedPot = new ItemStack(Material.POTION, 2);
			PotionMeta vikingSpeedPotMeta = (PotionMeta)vikingSpeedPot.getItemMeta();
			vikingSpeedPotMeta.setColor(Color.SILVER);
			vikingSpeedPotMeta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 60 * 20, 1), true);
			vikingSpeedPotMeta.setDisplayName("Viking Charge");
			vikingSpeedPot.setItemMeta(vikingSpeedPotMeta);
			
			helmet = new ItemStack(Material.NETHERITE_HELMET, 1);
			helmet.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			helmet.addEnchantment(Enchantment.THORNS, 2);
			chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			chestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			leggings.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			boots.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			LeatherArmorMeta commonVikingMeta = (LeatherArmorMeta)chestplate.getItemMeta();
			commonVikingMeta.setColor(Color.fromRGB(71, 79, 82));
			chestplate.setItemMeta(commonVikingMeta);
			leggings.setItemMeta(commonVikingMeta);
			boots.setItemMeta(commonVikingMeta);
			
			// Adds items
			ItemStack[] vikingEquips = {boots, leggings, chestplate, helmet};
			playerInv.addItem(vikingAxe);
			playerInv.addItem(vikingSword);
			playerInv.addItem(vikingStrengthPot);
			playerInv.addItem(vikingSpeedPot);
			playerInv.addItem(DURABLE_BASIC_BOW);
			playerInv.addItem(HALF_ARROWS);
			playerInv.addItem(STEAKS);
			playerInv.addItem(P_SHIELD);
			playerEquipment.setArmorContents(vikingEquips);
			break;
		case ARCHER:
			// Creates items
			ItemStack archBow = new ItemStack(Material.BOW, 1);
			archBow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
			archBow.addEnchantment(Enchantment.ARROW_FIRE, 1);
			archBow.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
			
			/*
			ItemStack archerRegenArrows = new ItemStack(Material.TIPPED_ARROW, 64);
			PotionMeta regenArrowMeta = (PotionMeta)archerRegenArrows.getItemMeta();
			regenArrowMeta.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 10 * 20, 1), true);
			regenArrowMeta.setColor(Color.FUCHSIA);
			regenArrowMeta.setDisplayName("Regen-Infused Arrows");
			archerRegenArrows.setItemMeta(regenArrowMeta);
			
			ItemStack archerPoisonArrows = new ItemStack(Material.TIPPED_ARROW, 64);
			PotionMeta poisonArrowMeta = (PotionMeta)archerPoisonArrows.getItemMeta();
			poisonArrowMeta.addCustomEffect(new PotionEffect(PotionEffectType.POISON, 10 * 20, 1), true);
			poisonArrowMeta.setColor(Color.GREEN);
			poisonArrowMeta.setDisplayName("Poison-Infused Arrows");
			archerPoisonArrows.setItemMeta(poisonArrowMeta);
			*/
			
			ItemStack archerHealPots = new ItemStack(Material.SPLASH_POTION, 4);
			PotionMeta archerHealMeta = (PotionMeta)archerHealPots.getItemMeta();
			archerHealMeta.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 1, 2), true);
			archerHealMeta.setColor(Color.FUCHSIA);
			archerHealMeta.setDisplayName("Quick Heal");
			archerHealPots.setItemMeta(archerHealMeta);
			
			ItemStack archerInvisPot = new ItemStack(Material.POTION, 2);
			PotionMeta archerInvisPotMeta = (PotionMeta)archerInvisPot.getItemMeta();
			archerInvisPotMeta.setColor(Color.SILVER);
			archerInvisPotMeta.addCustomEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 120 * 20, 1), true);
			archerInvisPotMeta.setDisplayName("Archer's Cloak");
			archerInvisPot.setItemMeta(archerInvisPotMeta);
			
			ItemStack archerSword = new ItemStack(Material.WOODEN_SWORD, 1);
			archerSword.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
			
			helmet = new ItemStack(Material.LEATHER_HELMET, 1);
			helmet.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			helmet.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
			chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			chestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			chestplate.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
			leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			leggings.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			leggings.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
			boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			boots.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			boots.addEnchantment(Enchantment.PROTECTION_FALL, 2);
			
			// Adds items
			ItemStack[] archEquips = {boots, leggings, chestplate, helmet};
			playerInv.addItem(archBow);
			playerInv.addItem(new ItemStack(Material.ARROW, 1));
			//playerInv.addItem(archerPoisonArrows);
			//playerInv.addItem(archerRegenArrows);
			playerInv.addItem(archerHealPots);
			playerInv.addItem(archerInvisPot);
			playerInv.addItem(archerSword);
			playerInv.addItem(new ItemStack(Material.GOLDEN_APPLE, 3));
			playerInv.addItem(new ItemStack(Material.MILK_BUCKET, 1));
			playerInv.addItem(STEAKS);
			playerInv.addItem(P_SHIELD);
			playerEquipment.setArmorContents(archEquips);
			break;
		case HUNTER:
			// Creates items
			ItemStack crossbowPiercing = new ItemStack(Material.CROSSBOW, 1);
			crossbowPiercing.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
			crossbowPiercing.addEnchantment(Enchantment.PIERCING, 3);
			crossbowPiercing.addEnchantment(Enchantment.QUICK_CHARGE, 2);
			ItemStack crossbowMultishot = new ItemStack(Material.CROSSBOW, 1);
			crossbowMultishot.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
			crossbowMultishot.addEnchantment(Enchantment.MULTISHOT, 1);
			crossbowMultishot.addEnchantment(Enchantment.QUICK_CHARGE, 2);
			ItemStack hunterSword = new ItemStack(Material.WOODEN_SWORD, 1);
			hunterSword.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
			
			ItemStack hunterHealPots = new ItemStack(Material.SPLASH_POTION, 6);
			PotionMeta hunterHealMeta = (PotionMeta)hunterHealPots.getItemMeta();
			hunterHealMeta.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 1, 2), true);
			hunterHealMeta.setColor(Color.FUCHSIA);
			hunterHealMeta.setDisplayName("Healing Ready-to-Use");
			hunterHealPots.setItemMeta(hunterHealMeta);
			
			ItemStack hunterSpeedPot = new ItemStack(Material.POTION, 2);
			PotionMeta hunterSpeedPotMeta = (PotionMeta)hunterSpeedPot.getItemMeta();
			hunterSpeedPotMeta.setColor(Color.SILVER);
			hunterSpeedPotMeta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 120 * 20, 1), true);
			hunterSpeedPotMeta.setDisplayName("Hunter's Ambush");
			hunterSpeedPot.setItemMeta(hunterSpeedPotMeta);
			
			ItemStack hunterSlowPots = new ItemStack(Material.SPLASH_POTION, 4);
			PotionMeta hunterSlowPotMeta = (PotionMeta)hunterSlowPots.getItemMeta();
			hunterSlowPotMeta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 15 * 20, 4), true);
			hunterSlowPotMeta.setColor(Color.PURPLE);
			hunterSlowPotMeta.setDisplayName("Trap-in-a-Pot");
			hunterSlowPots.setItemMeta(hunterSlowPotMeta);
			
			//helmet = new ItemStack(Material.LEATHER_HELMET, 1);
			//helmet.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
			chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			chestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			//leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			//leggings.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
			boots = new ItemStack(Material.IRON_BOOTS, 1);
			boots.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			
			// Adds items
			//ItemStack[] hunterEquips = {boots, leggings, chestplate, helmet};
			playerInv.addItem(crossbowPiercing);
			playerInv.addItem(crossbowMultishot);
			playerInv.addItem(hunterSword);
			playerInv.addItem(hunterHealPots);
			playerInv.addItem(hunterSpeedPot);
			playerInv.addItem(hunterSlowPots);
			playerInv.addItem(new ItemStack(Material.MILK_BUCKET, 1));
			playerInv.addItem(STEAKS);
			playerInv.addItem(P_SHIELD);
			playerInv.addItem(new ItemStack(Material.ARROW, 256));
			//playerEquipment.setArmorContents(hunterEquips);
			playerEquipment.setChestplate(chestplate);
			playerEquipment.setBoots(boots);
			break;
		case ALCHEMIST:
			// Creates items
			ItemStack alchemistSword = new ItemStack(Material.STONE_SWORD, 1);
			alchemistSword.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
			
			ItemStack healSplashPotion = new ItemStack(Material.SPLASH_POTION, 20);
			PotionMeta healSplashMeta = (PotionMeta)healSplashPotion.getItemMeta();
			healSplashMeta.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 1, 1), true);
			healSplashMeta.setColor(Color.FUCHSIA);
			healSplashMeta.setDisplayName("Alchemist's Healing Set");
			healSplashPotion.setItemMeta(healSplashMeta);
			
			ItemStack harmSplashPotion = new ItemStack(Material.SPLASH_POTION, 20);
			PotionMeta harmSplashMeta = (PotionMeta)harmSplashPotion.getItemMeta();
			harmSplashMeta.addCustomEffect(new PotionEffect(PotionEffectType.HARM, 1, 1), true);
			harmSplashMeta.setColor(Color.PURPLE);
			harmSplashMeta.setDisplayName("Alchemist's Damage Set");
			harmSplashPotion.setItemMeta(harmSplashMeta);
			
			ItemStack cushionPotion = new ItemStack(Material.POTION, 1);
			PotionMeta cushionMeta = (PotionMeta)cushionPotion.getItemMeta();
			cushionMeta.addCustomEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 240 * 20, 0), true);
			cushionMeta.addCustomEffect(new PotionEffect(PotionEffectType.ABSORPTION, 240 * 20, 2), true);
			cushionMeta.setColor(Color.WHITE);
			cushionMeta.setDisplayName("Cushioning Potion");
			cushionPotion.setItemMeta(cushionMeta);
			
			ItemStack hastePotion = new ItemStack(Material.POTION, 1);
			PotionMeta hastePotionMeta = (PotionMeta)hastePotion.getItemMeta();
			hastePotionMeta.addCustomEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 120 * 20, 7), true);
			hastePotionMeta.setColor(Color.ORANGE);
			hastePotionMeta.setDisplayName("Last Stand Potion");
			hastePotion.setItemMeta(hastePotionMeta);
			
			helmet = new ItemStack(Material.GOLDEN_HELMET, 1);
			helmet.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			chestplate = new ItemStack(Material.GOLDEN_CHESTPLATE, 1);
			chestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			leggings = new ItemStack(Material.GOLDEN_LEGGINGS, 1);
			leggings.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			boots = new ItemStack(Material.GOLDEN_BOOTS, 1);
			boots.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			
			// Adds items
			ItemStack[] alchemistEquips = {boots, leggings, chestplate, helmet};
			playerInv.addItem(alchemistSword);
			playerInv.addItem(healSplashPotion);
			playerInv.addItem(harmSplashPotion);
			playerInv.addItem(cushionPotion);
			playerInv.addItem(hastePotion);
			playerInv.addItem(new ItemStack(Material.GOLDEN_APPLE, 1));
			playerInv.addItem(new ItemStack(Material.MILK_BUCKET, 3));
			playerInv.addItem(STEAKS);
			playerInv.addItem(P_SHIELD);
			playerEquipment.setArmorContents(alchemistEquips);
			break;
		case JUGGERNAUT:
			// Creates items
			ItemStack juggSword = new ItemStack(Material.STONE_SWORD, 1);
			juggSword.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
			juggSword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			
			ItemStack juggStick = new ItemStack(Material.STICK, 1);
			juggStick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
			ItemMeta juggStickMeta = juggStick.getItemMeta();
			juggStickMeta.setDisplayName("Sumo Stick");
			juggStick.setItemMeta(juggStickMeta);
			
			ItemStack megaPunch = new ItemStack(Material.NETHERITE_SHOVEL, 1);
			megaPunch.addUnsafeEnchantment(Enchantment.KNOCKBACK, 30);
			ItemMeta megaPunchMeta = megaPunch.getItemMeta();
			megaPunchMeta.setDisplayName("Mega Punch");
			megaPunch.setItemMeta(megaPunchMeta);
			Damageable megaPunchDamageMeta = (Damageable)megaPunch.getItemMeta();
			megaPunchDamageMeta.setDamage(2029); // 2 hits left
			megaPunch.setItemMeta((ItemMeta)megaPunchDamageMeta);
			
			helmet = new ItemStack(Material.IRON_HELMET, 1);
			helmet.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
			chestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			leggings = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
			leggings.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			boots = new ItemStack(Material.IRON_BOOTS, 1);
			boots.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			
			// Adds items
			ItemStack[] juggEquips = {boots, leggings, chestplate, helmet};
			playerInv.addItem(juggSword);
			playerInv.addItem(juggStick);
			playerInv.addItem(megaPunch);
			playerInv.addItem(STEAKS);
			playerEquipment.setArmorContents(juggEquips);
			break;
		default:
			break;
		}
	}

}
