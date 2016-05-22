package me.killerkoda13.okutil;

import me.killerkoda13.okutil.Utilities.WorldUtils;
import net.md_5.bungee.api.ChatColor;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

    /**
     * Permissions
     */
    private Permission lag = new Permission("okutils.lag");
    private Permission entityfinder = new Permission("okutils.entityfinder");
    private Permission lagother = new Permission("okutils.lag.other");

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
        if (cmd.getName().equalsIgnoreCase("okutils")) {
            if (player.hasPermission(entityfinder)) {
                if (args[0].equalsIgnoreCase("ef") || args[0].equalsIgnoreCase("entityfinder")) {
                    if (args[1] != null) {
                        WorldUtils.getEntitiesByChunk(player.getWorld(), Integer.parseInt(args[1]), player);
                    } else {
                        WorldUtils.getEntitiesByChunk(player.getWorld(), 50, player);
					}
				}
			}
        } else if (cmd.getName().equalsIgnoreCase("lag")) {
            if (args.length == 1) {
                if (player.hasPermission(lagother)) {
                    if (getServer().getPlayer(args[1]) != null) {
                        Player other = Bukkit.getPlayer(args[1]);
                        CraftPlayer cp = (CraftPlayer) other;
                        player.sendMessage(ChatColor.GRAY + "Ping profile for " + other.getName());
                        player.sendMessage("Ping: " + cp.getHandle().ping);
                    } else {
                        player.sendMessage(ChatColor.RED + "Player " + args[1].toUpperCase() + " is not currently online.");
                    }
                }
            } else {
                if (player.hasPermission(lag)) {
                    CraftPlayer craftplayer = (CraftPlayer) player;
                    int ping = craftplayer.getHandle().ping;

                    player.sendMessage(ChatColor.GRAY + "Ping profile");
                    player.sendMessage("Ping: " + ping);
                }
            }
        }
        return true;
	}
}
