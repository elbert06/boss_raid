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
//6�� ���߱�
//		if (s.size() != 6) {
//			sender.sendMessage("�÷��� ���� �ο��� 6���� �ƴմϴ�.");
//			return false;
//		}
		Collections.shuffle(s);
		Bukkit.getPlayer(s.get(0)).sendMessage(ChatColor.RED+"����� �����Դϴ�");
		status.put(s.get(0),"boss");
		Bukkit.getPlayer(s.get(0)).sendTitle(ChatColor.RED+"����� �����Դϴ�","", 10, 100, 10);
//		Bukkit.getPlayer(s.get(1)).sendMessage(ChatColor.AQUA+"����� ��Ŀ�Դϴ�");
//		status.put(s.get(1),"Tanker");
//		Bukkit.getPlayer(s.get(1)).sendTitle(ChatColor.AQUA+"����� ��Ŀ�Դϴ�","", 10, 100, 10);
//		Bukkit.getPlayer(s.get(1)).sendMessage(ChatColor.DARK_GREEN+"����� ��ؽ��Դϴ�");
//		status.put(s.get(1),"assesine");
//		Bukkit.getPlayer(s.get(1)).sendTitle(ChatColor.DARK_GREEN+"����� ��ؽ��Դϴ�","", 10, 100, 10);
//		Bukkit.getPlayer(s.get(1)).sendMessage(ChatColor.GOLD+"����� ���츶�����Դϴ�");
//		status.put(s.get(1),"bow_master");
//		Bukkit.getPlayer(s.get(1)).sendTitle(ChatColor.GOLD+"����� ���츶�����Դϴ�","", 10, 100, 10);
//		Bukkit.getPlayer(s.get(3)).sendMessage(ChatColor.GREEN+"����� �����Դϴ�");
//		status.put(s.get(3),"healer");
//		Bukkit.getPlayer(s.get(3)).sendTitle(ChatColor.GREEN+"����� �����Դϴ�","", 10, 100, 10);
		Bukkit.getPlayer(s.get(1)).sendMessage(ChatColor.YELLOW+"����� ���ڵ��Դϴ�");
		status.put(s.get(1),"wizard");
		Bukkit.getPlayer(s.get(1)).sendTitle(ChatColor.YELLOW+"����� ���ڵ��Դϴ�","", 10, 100, 10);
		functionbad.disting(status);
		return true;
		
	}

}
