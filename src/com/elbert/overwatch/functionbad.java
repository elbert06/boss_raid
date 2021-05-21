package com.elbert.overwatch;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class functionbad{
	@SuppressWarnings("deprecation")
	public static void disting(Map<String, String> s) {
		for(String r : s.keySet()) {
			Player player = Bukkit.getPlayer(r);
			player.getInventory().clear();
			System.out.print(s.get(r));
			if (s.get(r).equalsIgnoreCase("Boss")) {
				player.setMaxHealth(60);
				player.setHealth(player.getMaxHealth());
				player.setCooldown(Material.BAMBOO, 1000);
				Inventory bo = player.getInventory();
				ItemStack bam = new ItemStack(Material.BAMBOO,1);
				ItemMeta bam_meta = bam.getItemMeta();
				bam_meta.setDisplayName("far teleport");
				bam.setItemMeta(bam_meta);
				bo.setItem(0, bam);
				ItemStack bam2 = new ItemStack(Material.STICK,1);
				ItemMeta bam_meta2 = bam2.getItemMeta();
				bam_meta2.setDisplayName("to hit");
				bam2.setItemMeta(bam_meta2);
				bo.setItem(1, bam2);
				ItemStack bam3 = new ItemStack(Material.COAL,1);
				ItemMeta bam_meta3 = bam3.getItemMeta();
				bam_meta3.setDisplayName("faster");
				bam3.setItemMeta(bam_meta3);
				bo.setItem(2, bam3);
			
			}else if (s.get(r).equalsIgnoreCase("tanker")) {
				player.setMaxHealth(20);
				player.setHealth(player.getMaxHealth());
				Inventory bo = player.getInventory();
				ItemStack aca = new ItemStack(Material.BAKED_POTATO,1);
				ItemMeta aca_meta = aca.getItemMeta();
				aca_meta.setDisplayName("free 3 seconds");
				aca.setItemMeta(aca_meta);
				bo.setItem(0, aca);
				ItemStack bam2 = new ItemStack(Material.STICK,1);
				ItemMeta bam_meta2 = aca.getItemMeta();
				bam_meta2.setDisplayName("to hit");
				bam_meta2.addEnchant(Enchantment.KNOCKBACK, 2, false);
				bam2.setItemMeta(bam_meta2);
				bo.setItem(1, bam2);
				player.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE,1));
				player.sendMessage("°©¿ÊÀÌ Àû¿ëµÇ¾ú½À´Ï´Ù");
			}else if (s.get(r).equalsIgnoreCase("assesine")) {
				player.setMaxHealth(20);
				player.setHealth(player.getMaxHealth());
				Inventory bo = player.getInventory();
				ItemStack aca = new ItemStack(Material.BELL,1);
				bo.setItem(0, aca);
			}else if (s.get(r).equalsIgnoreCase("bow_master")) {
				player.setMaxHealth(20);
				player.setHealth(player.getMaxHealth());
				Inventory bo = player.getInventory();
				ItemStack arrow = new ItemStack(Material.ARROW,1);
				ItemMeta arrow_meta = arrow.getItemMeta();
				arrow_meta.setDisplayName("to teleport");
				arrow.setItemMeta(arrow_meta);
				bo.setItem(2, arrow);
				ItemStack bowget = new ItemStack(Material.BOW,1);
				ItemMeta bowget_meta2 = bowget.getItemMeta();
				bowget_meta2.setDisplayName("to hit");
				bowget_meta2.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
				bowget.setItemMeta(bowget_meta2);
				bo.setItem(0, bowget);
				bo.setItem(1, new ItemStack(Material.ARROW, 1));
			}else if (s.get(r).equalsIgnoreCase("healer")) {
				player.setMaxHealth(20);
				player.setHealth(player.getMaxHealth());
				Inventory bo = player.getInventory();
				ItemStack stick_hit = new ItemStack(Material.STICK,1);
				ItemMeta stick_hit_meta = stick_hit.getItemMeta();
				stick_hit_meta.addEnchant(Enchantment.KNOCKBACK, 2, false);
				stick_hit_meta.setDisplayName("to hit");
				stick_hit.setItemMeta(stick_hit_meta);
				bo.setItem(1, stick_hit);
				ItemStack heal = new ItemStack(Material.PAPER,1);
				ItemMeta heal_meta = heal.getItemMeta();
				heal_meta.setDisplayName("heal");
				heal.setItemMeta(heal_meta);
				bo.setItem(0, heal);
			}else if (s.get(r).equalsIgnoreCase("wizard")) {
				player.setMaxHealth(20);
				player.setHealth(player.getMaxHealth());
				Inventory bo = player.getInventory();
				ItemStack diamond = new ItemStack(Material.DIAMOND,1);
//				ItemStack potion = new ItemStack(Material.SPLASH_POTION,64);
//				PotionMeta pot = (PotionMeta) potion.getItemMeta();
//				pot.setBasePotionData(new PotionData(PotionType.INSTANT_DAMAGE));
//				potion.setItemMeta(pot);
				bo.setItem(0, diamond);
				
			}
		}
	}
	//new Thread(new Runnable(){
	//public void run() {
//		pl.setWalkSpeed((float) (pl.getWalkSpeed()*1.5));
//	    for (Integer i = 0; i < 16; i++) {
//	    	try {
//	    		Thread.sleep(1000);
//	    	} catch (InterruptedException e) {
//	    		e.printStackTrace();
//	    	}
//		}
	//	
	//}
	//
	//}).start();
}
