package me.bottleofglass.Spacemans.listeners;

import me.bottleofglass.Spacemans.Spacestick;
import me.bottleofglass.Spacemans.SpacestickMode;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StickListener implements Listener {

    @EventHandler
    public void onEntityClick(EntityDamageByEntityEvent evt) {

        if(evt.getCause() == EntityDamageByEntityEvent.DamageCause.ENTITY_ATTACK &&
                evt.getDamager() instanceof Player &&
                evt.getEntity() instanceof Damageable) {
            Player p =((Player)evt.getDamager());
            if(Spacestick.getSpaceSticks().containsKey(p) && Spacestick.getSpaceStick().equals(((Player) evt.getDamager()).getInventory().getItemInMainHand()) && Spacestick.getSpaceSticks().get(p).getSpacestickMode().equals(SpacestickMode.ENTITY)) {
                Damageable dmg = (Damageable) evt.getEntity();
                dmg.setHealth(0);
                evt.setCancelled(true);
            }

        }
    }
    @EventHandler
    public void onAirClick(PlayerInteractEvent evt) {
        if(Spacestick.getSpaceSticks().containsKey(evt.getPlayer()) && Spacestick.getSpaceStick().equals(evt.getItem())) {
            Player player = evt.getPlayer();
            Spacestick spacestick = Spacestick.getSpaceSticks().get(player);
            if(evt.getAction() == Action.RIGHT_CLICK_AIR) {
                if(evt.getPlayer().isSneaking()) {
                    SpacestickMode newMode = SpacestickMode.DISABLED;
                    List<SpacestickMode> list = Arrays.asList(SpacestickMode.values());
                    Collections.sort(list);
                    for(SpacestickMode stickMode : list) {
                        if (spacestick.getSpacestickMode().equals(stickMode)) {
                            int index = list.indexOf(stickMode);
                            if(index != list.size()-1) {
                                newMode = list.get(index+1);
                            } else {
                                newMode = list.get(0);
                            }
                            break;
                        }
                    }
                    spacestick.setSpacestickMode(newMode);
                    Spacestick.getSpaceSticks().remove(player);
                    Spacestick.getSpaceSticks().put(player, spacestick);
                    TextComponent textComponent = new TextComponent();
                    textComponent.setText(ChatColor.GRAY + "Spacestick mode: " + newMode.toString());
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, textComponent);
                    return;
                }
                if(spacestick.getSpacestickMode() == SpacestickMode.FIREBALL) {
                    evt.getPlayer().launchProjectile(Fireball.class,evt.getPlayer().getVelocity());
                    return;
                }

            }

            if (evt.getAction() == Action.LEFT_CLICK_BLOCK && spacestick.getSpacestickMode() == SpacestickMode.BLOCK) {
                evt.getClickedBlock().setType(Material.AIR);
            }
        }

    }
}
