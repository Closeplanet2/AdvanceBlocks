package com.pandapulsestudios.advanceblocks.PulseConfigs.Static;

import com.pandapulsestudios.advanceblocks.AdvanceBlocks;
import com.pandapulsestudios.advanceblocks.Events.Custom.EnableSystemEvent;
import com.pandapulsestudios.pulseconfig.API.StorageAPI;
import com.pandapulsestudios.pulseconfig.Enum.StorageType;
import com.pandapulsestudios.pulseconfig.Interface.PulseConfig;
import com.pandapulsestudios.pulseconfig.Interface.StorageComment;
import com.pandapulsestudios.pulsecore.JavaAPI.Interface.PulseAutoRegister;
import com.pandapulsestudios.pulsecore.WorldAPI.API.WorldAPI;
import org.bukkit.plugin.java.JavaPlugin;

@PulseAutoRegister
public class AdvanceBlocksPlugin implements PulseConfig {
    public static AdvanceBlocksPlugin ReturnStatic(){
        var stored = StorageAPI.ReturnStatic(AdvanceBlocksPlugin.class, StorageType.CONFIG, false);
        return stored == null ? new AdvanceBlocksPlugin() : (AdvanceBlocksPlugin) stored;
    }

    @Override
    public JavaPlugin mainClass() {return AdvanceBlocks.getInstance();}

    @StorageComment("WARNING: SYSTEM WONT RUN IF FALSE!")
    public boolean systemEnabled = true;
    public boolean debugConfig = false;
    public boolean dropItemsOnBreak = false;

    public void ToggleSystemEnabled(boolean newState){
        new EnableSystemEvent(systemEnabled, newState);
        systemEnabled = newState;
        SaveConfig(false);
    }
}
