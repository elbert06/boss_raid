package com.elbert.overwatch;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new eventListener(), this);
        getCommand("race").setExecutor(new choice());
        getCommand("svl").setExecutor(new check());
	}
	@Override
	public void onDisable() {
		for(Player r : Bukkit.getOnlinePlayers()) {
			for(Material s : Material.values()) {
				r.setCooldown(s, 0);
			}
		}
	}
}
