package com.pandapulsestudios.advanceblocks.Events.Static;

import com.pandapulsestudios.advanceblocks.AdvanceBlocks;
import com.pandapulsestudios.pulsecore.JavaAPI.Interface.PulseAutoRegister;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

@PulseAutoRegister
public class PlayerCloseInventory implements Listener {
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event){
        AdvanceBlocks.SaveAllConfigs();
    }
}
