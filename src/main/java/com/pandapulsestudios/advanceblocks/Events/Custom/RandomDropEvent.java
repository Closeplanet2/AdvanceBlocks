package com.pandapulsestudios.advanceblocks.Events.Custom;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

@Getter
public class RandomDropEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Player player;
    private final ItemStack itemStack;

    public RandomDropEvent(Player player, ItemStack itemStack){
        this.player = player;
        this.itemStack = itemStack;
        Bukkit.getPluginManager().callEvent(this);
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
    public HandlerList getHandlers() {
        return handlers;
    }
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
}
