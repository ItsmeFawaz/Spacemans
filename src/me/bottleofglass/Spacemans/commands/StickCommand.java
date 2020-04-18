package me.bottleofglass.Spacemans.commands;

import me.bottleofglass.Spacemans.Spacemans;
import me.bottleofglass.Spacemans.Spacestick;
import me.bottleofglass.Spacemans.SpacestickMode;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class StickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cOnly players may execute this command!"));
            return true;
        }
        Player p = (Player) commandSender;
        if (p.hasPermission("spacemans.spacestick")) {
            p.getInventory().addItem(Spacestick.getSpaceStick());
            Spacestick.getSpaceSticks().put(p,new Spacestick(SpacestickMode.ENTITY));
        }
        return true;
    }
}
