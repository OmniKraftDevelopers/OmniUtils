package me.killerkoda13.okutil.Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/***
 *		---------------------------------
 *		@Author Killerkoda13 (Alex Jones)
 *		@date May 6, 2016
 *		---------------------------------
 */
public class WorldUtils {

	public static HashMap<Chunk, ArrayList<Entity>> Entities = new HashMap<Chunk, ArrayList<Entity>>();
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
		ArrayList<Entity> ents = new ArrayList<Entity>();
		ents.clear();
		run = false;
		WorldUtils.Entities.clear();
		for(Entity e : world.getEntities())
		{
			if(WorldUtils.Entities.containsKey(e.getLocation().getChunk()))
			{
				ArrayList<Entity> ents2 = WorldUtils.Entities.get(e.getLocation().getChunk());

				ents2.add(e);
				WorldUtils.Entities.put(e.getLocation().getChunk(), ents2);
			}else
			{
				ents.add(e);
				WorldUtils.Entities.put(e.getLocation().getChunk(), ents);
			}
		}
		
		for(Chunk c : WorldUtils.Entities.keySet())
		{		
			if(WorldUtils.Entities.get(c).size() >= check)
			{
				player.sendMessage("X: " + c.getEntities()[0].getLocation().getBlockX() + " Y: " + c.getEntities()[0].getLocation().getBlockY() + " Z: " + c.getEntities()[0].getLocation().getBlockZ() + " e: " + WorldUtils.Entities.get(c).size());
				run = true;
			}
		}
		if (run == false) {
			player.sendMessage(ChatColor.RED + "No entities of this amount found.");
		}
	}
	
	

}

