package com.sargealpha.gauntlet.waves;

import java.util.*;
import org.bukkit.entity.*;

public class DefaultProgression {
	
	public static Map<Integer, Map<EntityType, Integer>> initializeWaves() {
		Map<Integer, Map<EntityType, Integer>> waves = new HashMap<>();
		Map<EntityType, Integer> wave = new HashMap<>();
		int waveNum = 1;
		
		// Wave 1
		wave.put(EntityType.ZOMBIE, 12);
		waves.put(waveNum, wave);
		// Wave 2
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.SKELETON, 8);
		waves.put(waveNum, wave);
		// Wave 3
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.SPIDER, 12);
		waves.put(waveNum, wave);
		// Wave 4
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.ZOMBIE, 8);
		wave.put(EntityType.SKELETON, 6);
		waves.put(waveNum, wave);
		// Wave 5
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.SPIDER, 10);
		wave.put(EntityType.CREEPER, 7);
		waves.put(waveNum, wave);
		// Wave 6
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.CREEPER, 8);
		wave.put(EntityType.SKELETON, 6);
		waves.put(waveNum, wave);
		// Wave 7
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.ZOMBIE, 8);
		wave.put(EntityType.SKELETON, 8);
		wave.put(EntityType.SPIDER, 8);
		wave.put(EntityType.CREEPER, 4);
		waves.put(waveNum, wave);
		// Wave 8
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.SKELETON, 7);
		wave.put(EntityType.SPIDER, 7);
		waves.put(waveNum, wave);
		// Wave 9
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.ZOMBIE, 16);
		wave.put(EntityType.SPIDER, 8);
		waves.put(waveNum, wave);
		// Wave 10
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.CREEPER, 8);
		wave.put(EntityType.ZOMBIE, 10);
		wave.put(EntityType.SKELETON, 4);
		waves.put(waveNum, wave);
		// Wave 11
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.SLIME, 16);
		waves.put(waveNum, wave);
		// Wave 12
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.SLIME, 8);
		wave.put(EntityType.ZOMBIE, 12);
		wave.put(EntityType.CREEPER, 4);
		waves.put(waveNum, wave);
		// Wave 13
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.SLIME, 8);
		wave.put(EntityType.SPIDER, 6);
		wave.put(EntityType.SKELETON, 6);
		waves.put(waveNum, wave);
		// Wave 14
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.HUSK, 10);
		wave.put(EntityType.ZOMBIE, 16);
		waves.put(waveNum, wave);
		// Wave 15
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.PILLAGER, 8);
		wave.put(EntityType.SPIDER, 12);
		waves.put(waveNum, wave);
		// Wave 16
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.CREEPER, 15);
		wave.put(EntityType.PILLAGER, 10);
		waves.put(waveNum, wave);
		// Wave 17
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.SLIME, 14);
		wave.put(EntityType.HUSK, 6);
		waves.put(waveNum, wave);
		// Wave 18
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.HUSK, 8);
		wave.put(EntityType.ZOMBIE, 10);
		wave.put(EntityType.PILLAGER, 7);
		waves.put(waveNum, wave);
		// Wave 19
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.STRAY, 12);
		waves.put(waveNum, wave);
		// Wave 20
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.WITCH, 6);
		wave.put(EntityType.ZOMBIE, 12);
		wave.put(EntityType.SPIDER, 10);
		waves.put(waveNum, wave);
		// Wave 21
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.PILLAGER, 12);
		wave.put(EntityType.PHANTOM, 2);
		wave.put(EntityType.STRAY, 4);
		waves.put(waveNum, wave);
		// Wave 22
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.CREEPER, 8);
		wave.put(EntityType.HUSK, 12);
		wave.put(EntityType.SLIME, 6);
		waves.put(waveNum, wave);
		// Wave 23
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.HUSK, 25);
		waves.put(waveNum, wave);
		// Wave 24
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.STRAY, 12);
		wave.put(EntityType.CREEPER, 12);
		waves.put(waveNum, wave);
		// Wave 25
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.SLIME, 10);
		wave.put(EntityType.MAGMA_CUBE, 10);
		waves.put(waveNum, wave);
		// Wave 26
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.PILLAGER, 15);
		waves.put(waveNum, wave);
		// Wave 27
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.HUSK, 12);
		wave.put(EntityType.PILLAGER, 8);
		wave.put(EntityType.VINDICATOR, 1);
		waves.put(waveNum, wave);
		// Wave 28
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.MAGMA_CUBE, 12);
		wave.put(EntityType.PHANTOM, 2);
		wave.put(EntityType.PILLAGER, 6);
		waves.put(waveNum, wave);
		// Wave 29
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.SPIDER, 11);
		wave.put(EntityType.STRAY, 11);
		waves.put(waveNum, wave);
		// Wave 30
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.ZOGLIN, 1);
		wave.put(EntityType.VINDICATOR, 3);
		wave.put(EntityType.WITCH, 6);
		waves.put(waveNum, wave);
		// Wave 31
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.PILLAGER, 15);
		wave.put(EntityType.ZOGLIN, 3);
		waves.put(waveNum, wave);
		// Wave 32
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.BLAZE, 12);
		waves.put(waveNum, wave);
		// Wave 33
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.MAGMA_CUBE, 14);
		wave.put(EntityType.ZOMBIE, 8);
		wave.put(EntityType.CREEPER, 7);
		waves.put(waveNum, wave);
		// Wave 34
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.BLAZE, 12);
		wave.put(EntityType.STRAY, 8);
		waves.put(waveNum, wave);
		// Wave 35
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.WITHER_SKELETON, 12);
		waves.put(waveNum, wave);
		// Wave 36
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.WITCH, 15);
		waves.put(waveNum, wave);
		// Wave 37
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.GHAST, 1);
		waves.put(waveNum, wave);
		// Wave 38
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.VEX, 1);
		wave.put(EntityType.WITHER_SKELETON, 8);
		wave.put(EntityType.ZOGLIN, 2);
		waves.put(waveNum, wave);
		// Wave 39
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.ZOMBIE, 12);
		wave.put(EntityType.HUSK, 12);
		wave.put(EntityType.SKELETON, 6);
		wave.put(EntityType.STRAY, 6);
		waves.put(waveNum, wave);
		// Wave 40
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.GHAST, 2);
		wave.put(EntityType.BLAZE, 12);
		waves.put(waveNum, wave);
		// Wave 41
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.EVOKER, 1);
		wave.put(EntityType.PILLAGER, 13);
		waves.put(waveNum, wave);
		// Wave 42
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.ZOGLIN, 3);
		wave.put(EntityType.PILLAGER, 3);
		wave.put(EntityType.VEX, 3);
		wave.put(EntityType.STRAY, 3);
		wave.put(EntityType.HUSK, 3);
		wave.put(EntityType.CREEPER, 3);
		wave.put(EntityType.BLAZE, 3);
		wave.put(EntityType.WITCH, 3);
		waves.put(waveNum, wave);
		// Wave 43
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.GHAST, 2);
		wave.put(EntityType.ZOMBIE, 18);
		waves.put(waveNum, wave);
		// Wave 44
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.WITCH, 12);
		waves.put(waveNum, wave);
		// Wave 45
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.EVOKER, 2);
		wave.put(EntityType.SILVERFISH, 25);
		waves.put(waveNum, wave);
		// Wave 46
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.RAVAGER, 1);
		wave.put(EntityType.EVOKER, 1);
		wave.put(EntityType.VINDICATOR, 3);
		waves.put(waveNum, wave);
		// Wave 47
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.EVOKER, 2);
		wave.put(EntityType.CREEPER, 8);
		wave.put(EntityType.VINDICATOR, 10);
		waves.put(waveNum, wave);
		// Wave 48
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.SILVERFISH, 16);
		wave.put(EntityType.HUSK, 16);
		waves.put(waveNum, wave);
		// Wave 49
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.CREEPER, 12);
		wave.put(EntityType.EVOKER, 3);
		wave.put(EntityType.RAVAGER, 1);
		wave.put(EntityType.WITHER_SKELETON, 4);
		wave.put(EntityType.GHAST, 1);
		wave.put(EntityType.ZOGLIN, 1);
		waves.put(waveNum, wave);
		// Wave 50
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.ILLUSIONER, 5);
		waves.put(waveNum, wave);
		// Wave 51
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.ZOMBIE, 10);
		wave.put(EntityType.RAVAGER, 4);
		waves.put(waveNum, wave);
		// Wave 52
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.HUSK, 10);
		wave.put(EntityType.RAVAGER, 4);
		waves.put(waveNum, wave);
		// Wave 53
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.SKELETON, 10);
		wave.put(EntityType.GHAST, 4);
		waves.put(waveNum, wave);
		// Wave 54
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.CREEPER, 10);
		wave.put(EntityType.SILVERFISH, 30);
		waves.put(waveNum, wave);
		// Wave 55
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.ZOMBIE, 10);
		wave.put(EntityType.SKELETON, 10);
		waves.put(waveNum, wave);
		// Wave 56
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.VINDICATOR, 8);
		wave.put(EntityType.PILLAGER, 10);
		waves.put(waveNum, wave);
		// Wave 57
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.PILLAGER, 10);
		waves.put(waveNum, wave);
		// Wave 58
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.HUSK, 10);
		wave.put(EntityType.PILLAGER, 5);
		waves.put(waveNum, wave);
		// Wave 59
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.VINDICATOR, 4);
		waves.put(waveNum, wave);
		// Wave 60
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.ILLUSIONER, 8);
		waves.put(waveNum, wave);
		// Wave 61
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.ZOMBIE, 12);
		waves.put(waveNum, wave);
		// Wave 62
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.PHANTOM, 3);
		waves.put(waveNum, wave);
		// Wave 63
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.PILLAGER, 12);
		wave.put(EntityType.VINDICATOR, 4);
		waves.put(waveNum, wave);
		// Wave 64
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.WITHER_SKELETON, 10);
		waves.put(waveNum, wave);
		// Wave 65
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.EVOKER, 3);
		wave.put(EntityType.ZOMBIE, 7);
		waves.put(waveNum, wave);
		// Wave 66
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.SILVERFISH, 20);
		waves.put(waveNum, wave);
		// Wave 67
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.BLAZE, 8);
		waves.put(waveNum, wave);
		// Wave 68
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.PHANTOM, 10);
		waves.put(waveNum, wave);
		// Wave 69
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.GHAST, 1);
		waves.put(waveNum, wave);
		// Wave 70
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.WITHER, 1);
		waves.put(waveNum, wave);
		// Wave 71
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.ZOGLIN, 3);
		waves.put(waveNum, wave);
		// Wave 72
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.MAGMA_CUBE, 10);
		waves.put(waveNum, wave);
		// Wave 73
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.BLAZE, 12);
		waves.put(waveNum, wave);
		// Wave 74
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.WITCH, 10);
		waves.put(waveNum, wave);
		// Wave 75
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.RAVAGER, 3);
		waves.put(waveNum, wave);
		// Wave 76
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.GHAST, 4);
		waves.put(waveNum, wave);
		// Wave 77
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.BLAZE, 8);
		waves.put(waveNum, wave);
		// Wave 78
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.STRAY, 12);
		waves.put(waveNum, wave);
		// Wave 79
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.ILLUSIONER, 5);
		waves.put(waveNum, wave);
		// Wave 80
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.ZOGLIN, 5);
		waves.put(waveNum, wave);
		// Wave 81
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.ZOMBIE, 10);
		wave.put(EntityType.HUSK, 10);
		waves.put(waveNum, wave);
		// Wave 82
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.ENDERMITE, 30);
		waves.put(waveNum, wave);
		// Wave 83
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.PHANTOM, 12);
		wave.put(EntityType.VEX, 6);
		waves.put(waveNum, wave);
		// Wave 84
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.PILLAGER, 10);
		waves.put(waveNum, wave);
		// Wave 85
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.WITCH, 16);
		waves.put(waveNum, wave);
		// Wave 86
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.VINDICATOR, 12);
		waves.put(waveNum, wave);
		// Wave 87
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.GHAST, 8);
		waves.put(waveNum, wave);
		// Wave 88
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.ENDERMITE, 50);
		waves.put(waveNum, wave);
		// Wave 89
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.WITHER_SKELETON, 18);
		waves.put(waveNum, wave);
		// Wave 90
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.WITHER, 1);
		waves.put(waveNum, wave);
		// Wave 91
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.MAGMA_CUBE, 20);
		waves.put(waveNum, wave);
		// Wave 92
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.BLAZE, 16);
		waves.put(waveNum, wave);
		// Wave 93
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.ZOMBIE, 30);
		waves.put(waveNum, wave);
		// Wave 94
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.PILLAGER, 5);
		wave.put(EntityType.VINDICATOR, 5);
		wave.put(EntityType.EVOKER, 5);
		wave.put(EntityType.ILLUSIONER, 1);
		waves.put(waveNum, wave);
		// Wave 95
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.STRAY, 20);
		waves.put(waveNum, wave);
		// Wave 96
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.HUSK, 30);
		waves.put(waveNum, wave);
		// Wave 97
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.RAVAGER, 5);
		waves.put(waveNum, wave);
		// Wave 98
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.ENDERMITE, 20);
		waves.put(waveNum, wave);
		// Wave 99
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.ENDERMITE, 10);
		waves.put(waveNum, wave);
		// Wave 100
		waveNum++;
		wave = new HashMap<>();
		wave.put(EntityType.ENDER_DRAGON, 1);
		waves.put(waveNum, wave);
		
		
		return waves;
	}

}
