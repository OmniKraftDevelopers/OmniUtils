package me.killerkoda13.okutil;

import me.killerkoda13.okutil.Utilities.WorldUtils;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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


	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("okutils"))
		{
			if(player.hasPermission("okutils.entityfinder"))
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
		}
		return true;
	}
}
