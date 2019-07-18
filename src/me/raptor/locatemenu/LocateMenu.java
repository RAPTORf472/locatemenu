package me.raptor.locatemenu;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class LocateMenu extends JavaPlugin{
	public Menu menu;
	public void onEnable() {
ColorLogging.logging("	Locate Menu has been enabled");
ColorLogging.logging("	Author: RAPTOR");
ColorLogging.logging("	Unstable version: 4.0");
ColorLogging.logging("	Work on 1.13 and above only");
		menu = new Menu(this);
	}
public boolean onCommand(CommandSender sd, Command cmd, String cmdlabel, String[] args) {
	if (cmd.getName().equalsIgnoreCase("menu")) {
	if (!(sd instanceof Player)) {
		sd.sendMessage(ChatColor.RED + "This command is for player only");
		return true;
	}
	Player p = (Player) sd;
menu.show(p);
		
	}
	return true;
}
}
