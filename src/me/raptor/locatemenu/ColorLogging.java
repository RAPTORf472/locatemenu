package me.raptor.locatemenu;

import org.bukkit.Bukkit;

import net.md_5.bungee.api.ChatColor;

public class ColorLogging {
public static void logging(String s) {
	Bukkit.getConsoleSender().sendMessage(prefix() + color(s));
} 
public static String prefix() {
	return color("&3&l[&6&lLocate Menu&3&l]");
}
public static String color(String s) {
	return ChatColor.translateAlternateColorCodes('&', s);
}
}

