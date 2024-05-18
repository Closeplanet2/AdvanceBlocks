package com.pandapulsestudios.advanceblocks.Events.Custom;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
public class ReloadConfigEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    public ReloadConfigEvent(){
        Bukkit.getPluginManager().callEvent(this);
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
    public HandlerList getHandlers() {
        return handlers;
    }
}
