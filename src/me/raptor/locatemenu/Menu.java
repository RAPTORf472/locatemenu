package me.raptor.locatemenu;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.StructureType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

public class Menu extends Thread implements Listener{
	
	Inventory inv, inv2;
	ItemStack pyr, end, igl, jun, min, net, oce, str, swa, vil, man, bur, pil, rui, shi, yes, no;
	String name;
public Menu(Plugin p) {
	

	inv = Bukkit.getServer().createInventory(null, 45, "Locate Menu");
    inv2 = Bukkit.getServer().createInventory(null, 9, ChatColor.GOLD + "" +  ChatColor.BOLD  + "Teleport to the specified location?");
	pyr = createItem(ChatColor.YELLOW + "Desert Pyramid", Material.SANDSTONE);
	end = createItem(ChatColor.LIGHT_PURPLE + "End City", Material.END_STONE);	
	igl = createItem(ChatColor.WHITE + "Snow Igloo", Material.SNOW_BLOCK);
	jun = createItem(ChatColor.DARK_GREEN + "Jungle Pyramid", Material.MOSSY_COBBLESTONE);	
	min = createItem(ChatColor.RED + "Abandoned Mineshaft", Material.ACTIVATOR_RAIL);
	net = createItem(ChatColor.DARK_PURPLE + "Nether Fortress", Material.NETHER_BRICK);	
	oce = createItem(ChatColor.AQUA+ "Ocean Monument", Material.PRISMARINE);
	str = createItem(ChatColor.GRAY + "Stronghold", Material.ENDER_EYE);	
	swa = createItem(ChatColor.GREEN + "Witch Hut", Material.CAULDRON);	
	vil = createItem(ChatColor.GOLD + "Village", Material.EMERALD);
	man = createItem(ChatColor.DARK_RED + "Woodland Mansion", Material.TOTEM_OF_UNDYING);	
	bur = createItem(ChatColor.YELLOW + "Buried Treasure", Material.CHEST);
	pil = createItem(ChatColor.GOLD + "Pillager Outpost", Material.CROSSBOW);
	rui = createItem(ChatColor.BLUE + "Ocean Ruin", Material.MOSSY_STONE_BRICKS);
	shi = createItem(ChatColor.RED + "Shipwreck", Material.OAK_TRAPDOOR);
	yes = createItem(ChatColor.GREEN + "" + ChatColor.BOLD + "Yes", Material.GREEN_STAINED_GLASS_PANE, ChatColor.GREEN + "" + ChatColor.BOLD + "Teleport to the specified structure");
	no = createItem(ChatColor.RED + "" + ChatColor.BOLD + "No", Material.RED_STAINED_GLASS_PANE, ChatColor.RED + "" + ChatColor.BOLD + "Give the location of the specified structure");
	inv.setItem(11, pyr);
	inv.setItem(12, end);
	inv.setItem(13, igl);
	inv.setItem(14, jun);
	inv.setItem(15, min);
	inv.setItem(20, net);
	inv.setItem(21, oce);
	inv.setItem(22, str);
	inv.setItem(23, swa);
	inv.setItem(24, vil);
	inv.setItem(29, man);
	inv.setItem(30, bur);
	inv.setItem(31, rui);
	inv.setItem(32, pil);
	inv.setItem(33, shi);
for (int i = 0; i < 45; i++) {
	if (inv.getItem(i) != null) continue;
	inv.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
}
inv2.setItem(2, yes);
inv2.setItem(6, no);

for (int i = 0; i < 9; i++) {
	if (inv.getItem(i) != null) continue;
	inv2.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
}
    Bukkit.getServer().getPluginManager().registerEvents(this, p);
	
	
}
	private ItemStack createItem(String name, Material mat) {
		ItemStack i = new ItemStack(mat);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(Arrays.asList(ChatColor. RED + "" + ChatColor.BOLD + "Find the nearest " + ChatColor.RESET + "" + ChatColor.RED + "" + ChatColor.ITALIC + name.toLowerCase()));
		i.setItemMeta(meta);
		return i;
	}
	private ItemStack createItem(String name, Material mat, String lore) {
		ItemStack i = new ItemStack(mat);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(Arrays.asList(lore));
		i.setItemMeta(meta);
		return i;
	}
	public void show(Player p) {
		p.openInventory(inv);
	}
	Location a;
	String x, y, z;
	@EventHandler
	public void onMenuInteract(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (!p.getOpenInventory().getTitle().equals("Locate Menu")) return;
		if  (e.getCurrentItem() == null || e.getCurrentItem().getItemMeta() == null) return;
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Desert Pyramid")) {
			e.setCancelled(true);
			if (!p.getWorld().getName().equals("world")) {
				p.sendMessage(ChatColor.RED + "You must be in the Overworld to locate the " + e.getCurrentItem().getItemMeta().getDisplayName());
				return;
			}
			name = "Desert Pyramid";
			a = p.getWorld().locateNearestStructure(p.getLocation(), StructureType.DESERT_PYRAMID, 10000, false);
 x = String.valueOf(a.getX());
 y = String.valueOf(a.getY());
 z = String.valueOf(a.getZ());
			p.closeInventory();
			p.openInventory(inv2);


		} else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("End City")) {
			e.setCancelled(true);
			if (!p.getWorld().getName().equals("world_the_end")) {
				p.sendMessage(ChatColor.RED + "You must be in The End to locate the " + e.getCurrentItem().getItemMeta().getDisplayName());
				return;
			}
			name = "End City";
			Location a = p.getWorld().locateNearestStructure(p.getLocation(), StructureType.END_CITY, 10000, false);
String x = String.valueOf(a.getX());
String y = String.valueOf(a.getY());
String z = String.valueOf(a.getZ());
            p.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "End City" + ChatColor.WHITE + "" + ChatColor.BOLD + "\nX: " + x + "\nY: " + y + "\nZ: " + z);
			p.closeInventory();
		} else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Snow Igloo")) {
			e.setCancelled(true);
			if (!p.getWorld().getName().equals("world")) {
				p.sendMessage(ChatColor.RED + "You must be in the Overworld to locate the " + e.getCurrentItem().getItemMeta().getDisplayName());
			    return;
			}
			name = "Snow Igloo";
			a = p.getWorld().locateNearestStructure(p.getLocation(), StructureType.IGLOO, 10000, false);
 x = String.valueOf(a.getX());
 y = String.valueOf(a.getY());
 z = String.valueOf(a.getZ());
			p.closeInventory();
			p.openInventory(inv2);
		} else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Jungle Pyramid")) {
			e.setCancelled(true);
			if (!p.getWorld().getName().equals("world")) {
				p.sendMessage(ChatColor.RED + "You must be in the Overworld to locate the " + e.getCurrentItem().getItemMeta().getDisplayName());
				return;
			}
			a = p.getWorld().locateNearestStructure(p.getLocation(), StructureType.JUNGLE_PYRAMID, 10000, false);
 x = String.valueOf(a.getX());
 y = String.valueOf(a.getY());
 z = String.valueOf(a.getZ());
			p.closeInventory();
			p.openInventory(inv2);
		} else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Abandoned Mineshaft")) {
			e.setCancelled(true);
			if (!p.getWorld().getName().equals("world")) {
				p.sendMessage(ChatColor.RED + "You must be in the Overworld to locate the " + e.getCurrentItem().getItemMeta().getDisplayName());
				return;
			}
			name = "Abandoned Mineshaft";
			a = p.getWorld().locateNearestStructure(p.getLocation(), StructureType.MINESHAFT, 10000, false);
 x = String.valueOf(a.getX());
 y = String.valueOf(a.getY());
 z = String.valueOf(a.getZ());
			p.closeInventory();
			p.openInventory(inv2);
		}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Nether Fortress")) {
			e.setCancelled(true);
			if (!p.getWorld().getName().equals("world_nether")) {
				p.sendMessage(ChatColor.RED + "You must be in the Nether to locate the " + e.getCurrentItem().getItemMeta().getDisplayName());
				return;
			}
			name = "Nether Fortress";
			a = p.getWorld().locateNearestStructure(p.getLocation(), StructureType.NETHER_FORTRESS, 10000, false);
 x = String.valueOf(a.getX());
 y = String.valueOf(a.getY());
 z = String.valueOf(a.getZ());
			p.closeInventory();
			p.openInventory(inv2);
		}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Ocean Monument")) {
			e.setCancelled(true);
			if (!p.getWorld().getName().equals("world")) {
				p.sendMessage(ChatColor.RED + "You must be in the Overworld to locate the " + e.getCurrentItem().getItemMeta().getDisplayName());
				return;
			}
			name = "Ocean Monument";
			a = p.getWorld().locateNearestStructure(p.getLocation(), StructureType.OCEAN_MONUMENT, 10000, false);
 x = String.valueOf(a.getX());
 y = String.valueOf(a.getY());
 z = String.valueOf(a.getZ());
			p.closeInventory();
			p.openInventory(inv2);
		}else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Stronghold")) {
			e.setCancelled(true);
			if (!p.getWorld().getName().equals("world")) {
				p.sendMessage(ChatColor.RED + "You must be in the Overworld to locate the " + e.getCurrentItem().getItemMeta().getDisplayName());
				return;
			}
			name = "Stronghold";
			a = p.getWorld().locateNearestStructure(p.getLocation(), StructureType.STRONGHOLD, 10000, false);
 x = String.valueOf(a.getX());
 y = String.valueOf(a.getY());
 z = String.valueOf(a.getZ());
			p.closeInventory();
			p.openInventory(inv2);
		} else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Witch Hut")) {
			e.setCancelled(true);
			if (!p.getWorld().getName().equals("world")) {
				p.sendMessage(ChatColor.RED + "You must be in the Overworld to locate the " + e.getCurrentItem().getItemMeta().getDisplayName());
				return;
			}
			name = "Witch Hut";
			a = p.getWorld().locateNearestStructure(p.getLocation(), StructureType.SWAMP_HUT, 10000, false);
 x = String.valueOf(a.getX());
 y = String.valueOf(a.getY());
 z = String.valueOf(a.getZ());
			p.closeInventory();
			p.openInventory(inv2);
		} else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Village")) {
			e.setCancelled(true);
			if (!p.getWorld().getName().equals("world")) {
				p.sendMessage(ChatColor.RED + "You must be in the Overworld to locate the " + e.getCurrentItem().getItemMeta().getDisplayName());
				return;
			}
			name = "Village";
			a = p.getWorld().locateNearestStructure(p.getLocation(), StructureType.VILLAGE, 10000, false);
 x = String.valueOf(a.getX());
 y = String.valueOf(a.getY());
 z = String.valueOf(a.getZ());
			p.closeInventory();
			p.openInventory(inv2);
		} else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Woodland Mansion")) {
			e.setCancelled(true);
			if (!p.getWorld().getName().equals("world")) {
				p.sendMessage(ChatColor.RED + "You must be in the Overworld to locate the " + e.getCurrentItem().getItemMeta().getDisplayName());
				return;
			}
			name = "Woodland Mansion";
			a = p.getWorld().locateNearestStructure(p.getLocation(), StructureType.WOODLAND_MANSION, 10000, false);
 x = String.valueOf(a.getX());
 y = String.valueOf(a.getY());
 z = String.valueOf(a.getZ());
			p.closeInventory();
			p.openInventory(inv2);
		} else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Shipwreck")) {
			e.setCancelled(true);
			if (!p.getWorld().getName().equals("world")) {
				p.sendMessage(ChatColor.RED + "You must be in the Overworld to locate the " + e.getCurrentItem().getItemMeta().getDisplayName());
				return;
			}
			name = "Shipwreck";
			a = p.getWorld().locateNearestStructure(p.getLocation(), StructureType.SHIPWRECK, 10000, false);
 x = String.valueOf(a.getX());
 y = String.valueOf(a.getY());
 z = String.valueOf(a.getZ());
			p.closeInventory();
			p.openInventory(inv2);
		} else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Buried Treasure")) {
			e.setCancelled(true);
			if (!p.getWorld().getName().equals("world")) {
				p.sendMessage(ChatColor.RED + "You must be in the Overworld to locate the " + e.getCurrentItem().getItemMeta().getDisplayName());
				return;
			}
			name = "Buried Treasure";
			a = p.getWorld().locateNearestStructure(p.getLocation(), StructureType.BURIED_TREASURE, 10000, false);
 x = String.valueOf(a.getX());
 y = String.valueOf(a.getY());
 z = String.valueOf(a.getZ());
			p.closeInventory();
			p.openInventory(inv2);
		} else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Ocean Ruin")) {
			e.setCancelled(true);
			if (!p.getWorld().getName().equals("world")) {
				p.sendMessage(ChatColor.RED + "You must be in the Overworld to locate the " + e.getCurrentItem().getItemMeta().getDisplayName());
				return;
			}
			name = "Ocean Ruin";
			a = p.getWorld().locateNearestStructure(p.getLocation(), StructureType.OCEAN_RUIN, 10000, false);
 x = String.valueOf(a.getX());
 y = String.valueOf(a.getY());
 z = String.valueOf(a.getZ());
			p.closeInventory();
			p.openInventory(inv2);
		} else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Pillager Outpost")) {
			e.setCancelled(true);
			if (!p.getWorld().getName().equals("world")) {
				p.sendMessage(ChatColor.RED + "You must be in the Overworld to locate the " + e.getCurrentItem().getItemMeta().getDisplayName());
				return;
			}
			name = "Pillager Outpost";
			a = p.getWorld().locateNearestStructure(p.getLocation(), StructureType.PILLAGER_OUTPOST, 10000, false);
 x = String.valueOf(a.getX());
 y = String.valueOf(a.getY());
 z = String.valueOf(a.getZ());
			p.closeInventory();
			p.openInventory(inv2);
		} 
		
	} 
	
@EventHandler
public void onConfirmMenuInteract(InventoryClickEvent e) {
	if (!e.getWhoClicked().getOpenInventory().getTitle().contains("Teleport to the specified location?")) return;
	if (e.getCurrentItem() == null) return;
	if (e.getCurrentItem().getItemMeta() == null) { 
		e.setCancelled(true);
		return;
	}
	Player p = (Player) e.getWhoClicked();
	if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Yes")) {
		e.setCancelled(true);
		p.closeInventory();
		p.teleport(a.add(0, 70, 0));
		p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 100, 1));
		p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "You have arrived to your destination");
		return;
	} else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("No")) {
		e.setCancelled(true);
		p.closeInventory();
		 p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + name + ChatColor.WHITE + "" + ChatColor.BOLD + "\nX: " + x + "\nY: " + y + "\nZ: " + z);
	      return;
	}
	}
	
}
