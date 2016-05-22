package me.killerkoda13.okutil;

import me.killerkoda13.okutil.Utilities.WorldUtils;
import net.md_5.bungee.api.ChatColor;


import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	@Override
	public void onEnable()
    {
		
	}

	@Override
	public void onDisable()
	{

	}
	
	
	/**
	 * Permissions
	 */
	Permission lag = new Permission("okutils.lag");
	Permission entityfinder = new Permission("okutils.entityfinder");


	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("okutils"))
		{
			if(player.hasPermission(entityfinder))
			{
				if(args[0].equalsIgnoreCase("ef") || args[0].equalsIgnoreCase("entityfinder"))
				{
					if(args[1] != null)
					{
						int check = Integer.parseInt(args[1]);
						WorldUtils.getEntitiesByChunk(player.getWorld(), Integer.parseInt(args[1]), player);

					}else
					{
						WorldUtils.getEntitiesByChunk(player.getWorld(), 50, player);
					}
				}
			}
		}else if(cmd.getName().equalsIgnoreCase("lag"))
		{
			if(player.hasPermission(lag))
			{
				CraftPlayer craftplayer = (CraftPlayer) player;
				int ping = craftplayer.getHandle().ping;

					player.sendMessage(ChatColor.GRAY+"Ping profile");
				
					System.out.println("Ping:"+craftplayer.getHandle().ping);
				
			}
		}
		return true;
	}
}
