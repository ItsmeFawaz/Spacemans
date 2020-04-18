package me.bottleofglass.Spacemans;

import org.bukkit.ChatColor;

public enum SpacestickMode {
    BLOCK,
    ENTITY,
    DISABLED,
    FIREBALL;
    public String toString() {
        String s;
        switch(this) {
            case ENTITY:
                s = ChatColor.DARK_RED + "ENTITY";
                break;
            case BLOCK:
                s = ChatColor.GRAY + "BLOCK";
                break;
            case DISABLED:
                s = ChatColor.DARK_GRAY + "DISABLED";
                break;
            case FIREBALL:
                s = ChatColor.GOLD + "FIREBALL";
            default:
                s = "";
        }
        return s;
    }
}

