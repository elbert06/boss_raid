package com.elbert.overwatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class choice implements CommandExecutor{
	List<String> s = new ArrayList<>();
	Random random = new Random();
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		for(Player player : Bukkit.getOnlinePlayers()) {
			if (player.getGameMode().equals(GameMode.SURVIVAL)) {
				s.add(player.getName());
			}
		}
		if (s.size() != 6) {
			sender.sendMessage("플레이 가능 인원인 6명이 아닙니다.");
			return false;
		}
		Collections.shuffle(s);
		Bukkit.getPlayer(s.get(0)).sendMessage(ChatColor.RED+"당신은 보스입니다");
		Bukkit.getPlayer(s.get(1)).sendMessage(ChatColor.AQUA+"당신은 탱커입니다");
		Bukkit.getPlayer(s.get(2)).sendMessage(ChatColor.GREEN+"당신은 어쌔신입니다");
		Bukkit.getPlayer(s.get(3)).sendMessage("당신은 보스입니다");
		Bukkit.getPlayer(s.get(4)).sendMessage("당신은 보스입니다");
		Bukkit.getPlayer(s.get(5)).sendMessage("당신은 보스입니다");

		
		return true;
		
	}

}
