package com.elbert.overwatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
    static HashMap<String, String> status = new HashMap<String, String>();
	List<String> s = new ArrayList<>();
	Random random = new Random();
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		for(Player player : Bukkit.getOnlinePlayers()) {
			if (player.getGameMode().equals(GameMode.SURVIVAL)) {
				s.add(player.getName());
			}
		}
//		Player player = (Player) sender;
//		s.add(player);
//		s.add(player);
//		s.add(player);
//		s.add(player);
//		s.add(player);
//6명 맞추기
//		if (s.size() != 6) {
//			sender.sendMessage("플레이 가능 인원인 6명이 아닙니다.");
//			return false;
//		}
		Collections.shuffle(s);
		Bukkit.getPlayer(s.get(0)).sendMessage(ChatColor.RED+"당신은 보스입니다");
		status.put(s.get(0),"boss");
		Bukkit.getPlayer(s.get(0)).sendTitle(ChatColor.RED+"당신은 보스입니다","", 10, 100, 10);
//		Bukkit.getPlayer(s.get(1)).sendMessage(ChatColor.AQUA+"당신은 탱커입니다");
//		status.put(s.get(1),"Tanker");
//		Bukkit.getPlayer(s.get(1)).sendTitle(ChatColor.AQUA+"당신은 탱커입니다","", 10, 100, 10);
//		Bukkit.getPlayer(s.get(1)).sendMessage(ChatColor.DARK_GREEN+"당신은 어쌔신입니다");
//		status.put(s.get(1),"assesine");
//		Bukkit.getPlayer(s.get(1)).sendTitle(ChatColor.DARK_GREEN+"당신은 어쌔신입니다","", 10, 100, 10);
//		Bukkit.getPlayer(s.get(1)).sendMessage(ChatColor.GOLD+"당신은 보우마스터입니다");
//		status.put(s.get(1),"bow_master");
//		Bukkit.getPlayer(s.get(1)).sendTitle(ChatColor.GOLD+"당신은 보우마스터입니다","", 10, 100, 10);
//		Bukkit.getPlayer(s.get(3)).sendMessage(ChatColor.GREEN+"당신은 힐러입니다");
//		status.put(s.get(3),"healer");
//		Bukkit.getPlayer(s.get(3)).sendTitle(ChatColor.GREEN+"당신은 힐러입니다","", 10, 100, 10);
		Bukkit.getPlayer(s.get(1)).sendMessage(ChatColor.YELLOW+"당신은 위자드입니다");
		status.put(s.get(1),"wizard");
		Bukkit.getPlayer(s.get(1)).sendTitle(ChatColor.YELLOW+"당신은 위자드입니다","", 10, 100, 10);
		functionbad.disting(status);
		return true;
		
	}

}
