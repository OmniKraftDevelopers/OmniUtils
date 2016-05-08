package me.killerkoda13.okutil.Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.entity.Entity;

/***
 *		---------------------------------
 *		@Author Killerkoda13 (Alex Jones)
 *		@date May 6, 2016
 *		---------------------------------
 */
public class WorldUtils {
	
	
	public static HashMap<Chunk, ArrayList<Entity>> Entities = new HashMap<Chunk, ArrayList<Entity>>();
	
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
	
	public static void getEntitiesByChunk()
	{
		int amount = Bukkit.getWorld("world").getEntities().size();
	
		Entity cached = null;
		boolean run = false;
		for(Entity e : Bukkit.getWorld("world").getEntities())
		{
			if(WorldUtils.Entities.containsKey(e.getLocation().getChunk()))
			{
				ArrayList<Entity> ents = WorldUtils.Entities.get(e.getLocation().getChunk());
				ents.add(e);
				WorldUtils.Entities.put(e.getLocation().getChunk(),ents);
				
			}else
			{
				ArrayList<Entity> ents = new ArrayList<Entity>();
				ents.add(e);
				WorldUtils.Entities.put(e.getLocation().getChunk(), ents);
			}
			
		}
		for(Chunk c : WorldUtils.Entities.keySet())
		{
			if(WorldUtils.Entities.get(c).size() > 50)
			{
				System.out.println("X:"+c.getX()+" Z:"+c.getZ());
			}
		}
	}
	
	

}

