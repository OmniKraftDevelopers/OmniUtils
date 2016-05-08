package me.killerkoda13.okutil;

import me.killerkoda13.okutil.Utilities.WorldUtils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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

		if(cmd.getName().equalsIgnoreCase("omniutils"))
		{
			WorldUtils.getEntitiesByChunk();
		}
		return true;
	}
}
