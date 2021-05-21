package com.elbert.overwatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
public class eventListener implements Listener{
	static HashMap<String, String> status = check.status;
	public Location forbow;
	Random random = new Random();
	Integer nd = 1;
	Location rr;
	String farest;
	@SuppressWarnings("deprecation")
	@EventHandler		
	public void itemuse(PlayerInteractEvent e) throws InterruptedException {
		Player pl = e.getPlayer();
		if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) {
			return;
		}
		if(pl.getCooldown(pl.getItemInHand().getType()) != 0){
			return;
		}
		String min = pl.getName();
		if (status.get(min).equalsIgnoreCase("Boss")) {
			if (pl.getItemInHand().getType() == Material.BAMBOO) {
				pl.setCooldown(Material.BAMBOO, 1800);
				for(String test : status.keySet()) {
					Integer highest = 0; 
					Double check;
					
					check = pl.getLocation().distance(Bukkit.getPlayer(test).getLocation());
					if (check > highest) {
						farest = Bukkit.getPlayer(test).getName();
						highest = check.intValue();
					}
				}
				pl.teleport(Bukkit.getPlayer(farest));
			}else if (pl.getItemInHand().getType() == Material.COAL) {
				pl.setCooldown(Material.COAL, 900);
				pl.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 1));
			}
		}else if (status.get(min).equalsIgnoreCase("tanker")) {
			if (pl.getItemInHand().getType() == Material.BAKED_POTATO) {
				pl.setCooldown(Material.BAKED_POTATO, 1800);
				Double heal = pl.getHealth();
				new Thread(new Runnable(){
				public void run() {
				    for (Integer i = 0; i < 4; i++) {
				    	try {
				    		Thread.sleep(1000);
				    	} catch (InterruptedException e) {
				    		e.printStackTrace();
				    	}
				    	
			    		pl.sendMessage(Integer.toString(3-i)+"초 남았습니다");
			    		Double r = pl.getHealth();
				    	if (heal.intValue() != r.intValue()) {
							pl.setHealth(heal.intValue());
						}
					}
					
				}
				
				}).start();
			}	
		}else if (status.get(min).equalsIgnoreCase("assesine")) {
			if (pl.getItemInHand().getType() == Material.BELL) {
				pl.setCooldown(Material.BELL, 1000);
				pl.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 600, 1));
			}
		}else if (status.get(min).equalsIgnoreCase("bow_master")) {
			if (pl.getItemInHand().getType() == Material.ARROW && pl.getItemInHand().getItemMeta().getDisplayName().equals("to teleport")) {
				pl.setCooldown(Material.ARROW, 1500);
				pl.teleport(forbow);
			}
		}else if (status.get(min).equalsIgnoreCase("healer")) {
			if (pl.getItemInHand().getType() == Material.PAPER) {
				pl.setCooldown(Material.PAPER, 200);
				Double ss = pl.getHealth();
				pl.setHealth(ss+2);
			}
		}else if (status.get(min).equalsIgnoreCase("wizard")) {
			if (pl.getItemInHand().getType() == Material.DIAMOND) {
				pl.setCooldown(Material.DIAMOND, 600);
				ItemStack potion = new ItemStack(Material.SPLASH_POTION,10);
				PotionMeta pot = (PotionMeta) potion.getItemMeta();
				pot.setBasePotionData(new PotionData(PotionType.INSTANT_DAMAGE));
				potion.setItemMeta(pot);
				pl.getInventory().addItem(potion);
			}
		}
	}
	@EventHandler
	public void nochange(InventoryClickEvent e) {
		e.setCancelled(true);
	}
	@EventHandler
	public void noeat(InventoryMoveItemEvent e) {
		e.setCancelled(true);
	}
	@EventHandler
	public void noeat(FoodLevelChangeEvent e) {
		e.setFoodLevel(20);
	}
	@EventHandler
	public void nochange(BlockBreakEvent e) {
		e.setCancelled(true);
		
	}
	@EventHandler
	public void gethe(EntityRegainHealthEvent e) {
		if (e.getRegainReason().equals(RegainReason.SATIATED)) {
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void forasses(EntityDamageEvent e) {
		List<String> mm = new ArrayList<String>();
		if (nd != 1) {
			return;
		}
		String r = null;
		for(String m : status.keySet()) {
			if (status.get(m).equalsIgnoreCase("assesine")) {
				r = m;
				break;
			}
		}
		if (r == null) {
			return;
		}
		Player asses = Bukkit.getPlayer(r);
		Double dam = asses.getHealth();
		if (dam.intValue() > 1 && dam.intValue() < 10) {
			for(String rs : status.keySet()) {
				mm.add(rs);
			}
			Integer gedt = random.nextInt(mm.size());
			asses.teleport(Bukkit.getPlayer(mm.get(gedt)));
			nd = 2;
		}
		
	}
	@EventHandler
	public void get(ProjectileHitEvent e) {
		if (e.getEntity() instanceof Arrow) {
			Arrow ss = (Arrow) e.getEntity();
			Player m = (Player) ss.getShooter();
			if (status.get(m.getName()).equalsIgnoreCase("bow_master")) {
				forbow = e.getEntity().getLocation();
			}
		}
		
	}
	@EventHandler
	public void damage(EntityDamageEvent e) {
		Player s = (Player) e.getEntity();
		DamageCause why = e.getCause();
		if (why.equals(DamageCause.ENTITY_ATTACK)) {
			return;
		}else if (why.equals(DamageCause.MAGIC)) {
			if (status.get(s.getName()).equalsIgnoreCase("wizard")) {
				e.setDamage(0);
			}else {
				e.setDamage(1);
			}
			
		}else if (why.equals(DamageCause.FALL)) {
			e.setDamage(0);
		}
		return;
		
	}
	@EventHandler
	public void noplace(BlockPlaceEvent e) {
		e.setCancelled(true);
	}
	@EventHandler
	public void nokill(InventoryPickupItemEvent e) {
		e.setCancelled(true);
	}
	@EventHandler
	public void damage2(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Arrow) {
			Integer ss = random.nextInt(5);
			if (ss == 0) {
				e.setDamage(2);
			}else {
				e.setDamage(1);
			}
			return;
		}
		Player get = (Player) e.getEntity();
		Player who = (Player) e.getDamager();
		if (status.get(e.getEntity().getName()).equalsIgnoreCase("boss")) {
			if (status.get(who.getName()).equalsIgnoreCase("assesine")) {
				e.setDamage(2);
			}else if (status.get(who.getName()).equalsIgnoreCase("bow_master")) {
				return;
			}else{
				e.setDamage(1);
			}
		}else if (status.get(who.getName()).equalsIgnoreCase("boss")) {
			if (status.get(get.getName()).equalsIgnoreCase("assesine")) {
				get.setHealth(get.getHealth()-4);
			}else {
				get.setHealth(get.getHealth()-5);
			}
		}
	}
}
