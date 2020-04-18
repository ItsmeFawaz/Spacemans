package me.bottleofglass.Spacemans;


import lombok.Getter;
import me.bottleofglass.Spacemans.commands.StickCommand;
import me.bottleofglass.Spacemans.listeners.StickListener;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Spacemans extends JavaPlugin {
    @Getter private static Spacemans instance;

    @Override
    public void onEnable() {
        instance = this;
        getCommand("spacestick").setExecutor(new StickCommand());
        getServer().getPluginManager().registerEvents(new StickListener(), this);
    }

}
