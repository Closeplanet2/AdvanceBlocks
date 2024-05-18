package com.pandapulsestudios.advanceblocks.Events.Static;

import com.pandapulsestudios.advanceblocks.AdvanceBlocks;
import com.pandapulsestudios.pulsecore.JavaAPI.Interface.PulseAutoRegister;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

@PulseAutoRegister
public class BlockBreak implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        var player = event.getPlayer();
        var block = event.getBlock();
        var worldContainer = AdvanceBlocks.GetContainer(block.getWorld().getName());
        if(worldContainer == null) return;
        worldContainer.PlayerBreakBlock(player, block);
    }
}
