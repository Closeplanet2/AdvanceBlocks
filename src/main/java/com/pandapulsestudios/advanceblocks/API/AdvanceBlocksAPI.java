package com.pandapulsestudios.advanceblocks.API;

import com.pandapulsestudios.advanceblocks.AdvanceBlocks;
import com.pandapulsestudios.advanceblocks.Events.Custom.ReloadConfigEvent;
import com.pandapulsestudios.advanceblocks.Events.Custom.ResetConfigEvent;
import com.pandapulsestudios.advanceblocks.PulseConfigs.Normal.WorldContainer;
import com.pandapulsestudios.advanceblocks.PulseConfigs.Static.AdvanceBlocksPlugin;
import com.pandapulsestudios.advanceblocks.PulseConfigs.Static.Messages;
import com.pandapulsestudios.advanceblocks.PulseConfigs.Static.Permissions;
import com.pandapulsestudios.pulseconfig.API.StorageAPI;
import com.pandapulsestudios.pulseconfig.Enum.StorageType;
import org.bukkit.World;

public class AdvanceBlocksAPI {
    public static void EnableSystem(boolean state){
        AdvanceBlocksPlugin.ReturnStatic().ToggleSystemEnabled(state);
    }

    public static void ResetConfigs(){
        StorageAPI.ResetStatic(Messages.class, StorageType.CONFIG, false, Messages.ReturnStatic().debugConfig);
        StorageAPI.ResetStatic(Permissions.class, StorageType.CONFIG, false, Permissions.ReturnStatic().debugConfig);
        StorageAPI.ResetStatic(AdvanceBlocksPlugin.class, StorageType.CONFIG, false, AdvanceBlocksPlugin.ReturnStatic().debugConfig);
        new ResetConfigEvent();
    }

    public static void ReloadConfigs(){
        StorageAPI.ReloadStatic(Messages.class, StorageType.CONFIG, false, Messages.ReturnStatic().debugConfig);
        StorageAPI.ReloadStatic(Permissions.class, StorageType.CONFIG, false, Permissions.ReturnStatic().debugConfig);
        StorageAPI.ReloadStatic(AdvanceBlocksPlugin.class, StorageType.CONFIG, false, AdvanceBlocksPlugin.ReturnStatic().debugConfig);
        new ReloadConfigEvent();
    }
}
