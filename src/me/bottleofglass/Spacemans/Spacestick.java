package me.bottleofglass.Spacemans;

import lombok.Getter;
import lombok.Setter;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class Spacestick {
    @Getter private static ItemStack spaceStick = new ItemStack(Material.STICK, 1);
    @Getter private static HashMap<Player, Spacestick> spaceSticks = new HashMap<>();
    @Getter @Setter private SpacestickMode spacestickMode;
    static {
        spaceStick.addUnsafeEnchantment(Enchantment.SILK_TOUCH,1);
        ItemMeta im = spaceStick.getItemMeta();
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        im.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&5&ki&r&8Spacestick&5&ki"));
        spaceStick.setItemMeta(im);
    }
    public Spacestick(SpacestickMode mode) {
        spacestickMode = mode;
    }
}
