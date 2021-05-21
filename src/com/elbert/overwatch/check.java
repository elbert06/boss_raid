package com.elbert.overwatch;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class check implements CommandExecutor{
	static HashMap<String, String> status = choice.status;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		String p1 = args[0];
		String p2status = args[1];
		String p1status = status.get(p1);
		String p2 = null;
		for(String s : status.keySet()) {
			if (status.get(s).equals(p2status)) {
				p2 = s;
				break;
			}
		}
		status.remove(p1status);
		status.remove(p2status);
		status.put(p1, p2status);
		status.put(p2, p1status);
		sender.sendMessage(p1+" = "+p2status);
		sender.sendMessage(p2+" = "+p1status);
		functionbad.disting(status);
		return false;
	}

}
