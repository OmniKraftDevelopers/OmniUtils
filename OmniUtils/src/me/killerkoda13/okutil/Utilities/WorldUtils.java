package me.killerkoda13.okutil.Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import me.killerkoda13.okutil.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.entity.Player;

/***
 *		---------------------------------
 *		@Author Killerkoda13 (Alex Jones)
 *		@date May 6, 2016
 *		---------------------------------
 */
public class WorldUtils {

	static boolean run = false;

	public static World fromName(String name)
	{
		return Bukkit.getWorld(name);
	}
	
	public static World fromUUID(UUID uuid)
	{
		return Bukkit.getWorld(uuid);
	}
	
	public static World fromUUID(String uuid)
	{
		return Bukkit.getWorld(UUID.fromString(uuid));
	}
	
	public static void getEntitiesByChunk(World world,int check, Player player)
	{
		run = false;
		player.sendMessage(ChatColor.GRAY + "Performance profile for " + world.getName());
		player.sendMessage(ChatColor.GOLD + "Chunks loaded: " + world.getLoadedChunks().length);
		player.sendMessage(ChatColor.GOLD + "Entities: " + world.getEntities().size());
		player.sendMessage(ChatColor.RED + "Entity locations: ");
		for (Chunk c : world.getLoadedChunks())
		{
			if (c.getEntities().length >= check)
			{
				player.sendMessage("X: " + c.getEntities()[0].getLocation().getBlockX() + " Y: " + c.getEntities()[0].getLocation().getBlockY() + " Z: " + c.getEntities()[0].getLocation().getBlockZ() + " Entities: " + c.getEntities().length);
				run = true;
			}
		}
		if (run == false) {
			player.sendMessage(ChatColor.RED + "No chunk with greater or equal to that amount found.");
		}

	}
	
	

}

