package com.pandapulsestudios.advanceblocks.PulseCommands;

import com.pandapulsestudios.advanceblocks.API.AdvanceBlocksAPI;
import com.pandapulsestudios.advanceblocks.AdvanceBlocks;
import com.pandapulsestudios.advanceblocks.Enums.Static.Message;
import com.pandapulsestudios.advanceblocks.Enums.Static.Permission;
import com.pandapulsestudios.advanceblocks.PulseConfigs.Static.AdvanceBlocksPlugin;
import com.pandapulsestudios.advanceblocks.PulseConfigs.Static.Messages;
import com.pandapulsestudios.advanceblocks.PulseConfigs.Static.Permissions;
import com.pandapulsestudios.api.Enum.TabType;
import com.pandapulsestudios.api.Interface.*;
import com.pandapulsestudios.pulsecommands.PlayerCommand;
import com.pandapulsestudios.pulsecore.JavaAPI.Interface.PulseAutoRegister;
import com.pandapulsestudios.pulsecore.VariableAPI.API.VariableAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_20_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@PulseAutoRegister
public class AdvanceBlocksCommands extends PlayerCommand {
    public AdvanceBlocksCommands() {
        super(AdvanceBlocks.getInstance(), "ablock", false);
    }

    @Override
    public void NoMethodFound(Player player, String s, String[] strings) {}

    @Override
    public String helpMenuPrefix(Player player) { return "#4254f5[#4298f5Advance Blocks Commands#4254f5]#68ed90"; }

    @Override
    public LinkedHashMap<String, String> helpMenuFormat(Player player, LinkedHashMap<String, String> linkedHashMap) {
        var data = new LinkedHashMap<String, String>();
        for(var key : linkedHashMap.keySet()) data.put("#28bf56" + key, "#28bf56" + linkedHashMap.get(key));
        return data;
    }

    @Override
    public String helpMenuSuffix(Player player) { return "#4254f5============"; }

    @PCMethod
    @PCSignature({"enable"})
    @PCAutoTab(pos = 1)
    public void EnableSystem(CraftPlayer craftPlayer, boolean state){
        if(!Permissions.ReturnStatic().DoesPlayerHavePermission(Permission.ENABLE_SYSTEM, craftPlayer, true)) return;
        AdvanceBlocksAPI.EnableSystem(state);
        if(craftPlayer != null) Messages.ReturnStatic().SendMessageToPlayer(state ? Message.ConsoleEnabledSystem : Message.ConsoleDisableSystem, craftPlayer);
    }

    @PCMethod
    @PCSignature({"configs", "reset"})
    public void ResetConfigs(CraftPlayer admin){
        if(!Permissions.ReturnStatic().DoesPlayerHavePermission(Permission.RESET_CONFIGS, admin, true)) return;
        if(!AdvanceBlocksPlugin.ReturnStatic().systemEnabled) return;
        AdvanceBlocksAPI.ResetConfigs();
        Messages.ReturnStatic().SendMessageToPlayer(Message.PlayerResetConfig, admin);
    }

    @PCMethod
    @PCSignature({"configs", "reload"})
    public void ReloadConfigs(CraftPlayer admin){
        if(!Permissions.ReturnStatic().DoesPlayerHavePermission(Permission.RELOAD_CONFIGS, admin, true)) return;
        if(!AdvanceBlocksPlugin.ReturnStatic().systemEnabled) return;
        AdvanceBlocksAPI.ReloadConfigs();
        Messages.ReturnStatic().SendMessageToPlayer(Message.PlayerReloadedConfig, admin);
    }

    @PCMethod
    @PCSignature({"edit"})
    @PCAutoTab(pos = 1)
    @PCTab(pos = 2, data = "WorldNames", type = TabType.Information_From_Function)
    @PCTab(pos = 3, type = TabType.Pure_Data, data = "[PERMISSION NODE]")
    public void EditDrop(CraftPlayer craftPlayer, Material material, String worldName, String permissionNode){
        if(!Permissions.ReturnStatic().DoesPlayerHavePermission(Permission.EDIT_DROPS, craftPlayer, true)) return;
        if(!AdvanceBlocksPlugin.ReturnStatic().systemEnabled) return;

        var worldContainer = AdvanceBlocks.GetContainer(worldName);
        if(worldContainer == null){
            Messages.ReturnStatic().SendMessageToPlayer(Message.WorldDoesNotExist, craftPlayer);
            return;
        }

        worldContainer.OpenInventory(craftPlayer, permissionNode, material);
    }

    @PCMethodData
    public ArrayList<String> WorldNames(String current){
        var data = new ArrayList<String>();
        for(var world : Bukkit.getWorlds()){
            if(world.getName().toLowerCase().contains(current.toLowerCase())) data.add(world.getName());
        }
        return data;
    }
}
