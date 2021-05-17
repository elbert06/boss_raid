package com.elbert.overwatch;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new eventListener(), this);
        getCommand("svl").setExecutor(new choice());
	}
}
