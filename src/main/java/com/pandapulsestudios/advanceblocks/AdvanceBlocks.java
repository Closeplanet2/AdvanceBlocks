package com.pandapulsestudios.advanceblocks;

import com.pandapulsestudios.advanceblocks.PulseConfigs.Normal.WorldContainer;
import com.pandapulsestudios.advanceblocks.VariableTests.MessageVariableTest;
import com.pandapulsestudios.advanceblocks.VariableTests.PermissionVariableTest;
import com.pandapulsestudios.pulsecommands.PulseCommands;
import com.pandapulsestudios.pulseconfig.API.ConfigAPI;
import com.pandapulsestudios.pulseconfig.API.StorageAPI;
import com.pandapulsestudios.pulsecore.ChatAPI.Object.ChatBuilderAPI;
import com.pandapulsestudios.pulsecore.JavaAPI.API.ClassAPI;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class AdvanceBlocks extends JavaPlugin {
    @Getter
    private static AdvanceBlocks Instance;
    private static HashMap<UUID, WorldContainer> worldConfigHashMap = new HashMap<>();

    @Override
    public void onEnable() {
        Instance = this;
        ClassAPI.RegisterPulseVariableTest(new MessageVariableTest());
        ClassAPI.RegisterPulseVariableTest(new PermissionVariableTest());
        StorageAPI.RegisterStatic(this, false);
        ClassAPI.RegisterClasses(this);
        PulseCommands.RegisterRaw(this);
        worldConfigHashMap = ReturnAllWorldConfigs();
    }

    @Override
    public void onDisable() {
        for(var worldContainer : worldConfigHashMap.values()) worldContainer.SaveConfig(false);
    }

    public static WorldContainer GetContainer(String worldName){
        for(var world : worldConfigHashMap.values()){
            if(world.worldName.equals(worldName)) return world;
        }

        var bukkitWorld = Bukkit.getWorld(worldName);
        return bukkitWorld == null ?null : new WorldContainer(bukkitWorld);
    }

    public static void SaveAllConfigs(){
        for(var worldContainer : worldConfigHashMap.values()) worldContainer.SaveConfig(false);
    }

    private static HashMap<UUID, WorldContainer> ReturnAllWorldConfigs(){
        var hashmap = new HashMap<UUID, WorldContainer>();
        var returnedData = ConfigAPI.ReturnAllConfigDocuments(new WorldContainer(""), false);
        for(var key : returnedData.keySet()){
            var config = (WorldContainer) returnedData.get(key);
            hashmap.put(UUID.fromString(key), config);
        }
        for(var world : Bukkit.getWorlds()){
            if(!hashmap.containsKey(world.getUID())){
                hashmap.put(world.getUID(), new WorldContainer(world));
                hashmap.get(world.getUID()).SaveConfig(false);
            }
        }
        ChatBuilderAPI.chatBuilder().SendMessage(String.format("#88f78aRegistered %d world data!", hashmap.size()), true);
        return hashmap;
    }
}
