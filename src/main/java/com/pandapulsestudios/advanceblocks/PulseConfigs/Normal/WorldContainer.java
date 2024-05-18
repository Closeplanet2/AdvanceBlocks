package com.pandapulsestudios.advanceblocks.PulseConfigs.Normal;

import com.pandapulsestudios.advanceblocks.AdvanceBlocks;
import com.pandapulsestudios.advanceblocks.Enums.Static.Message;
import com.pandapulsestudios.advanceblocks.Events.Custom.RandomDropEvent;
import com.pandapulsestudios.advanceblocks.PulseClass.WorldItem;
import com.pandapulsestudios.advanceblocks.PulseConfigs.Static.AdvanceBlocksPlugin;
import com.pandapulsestudios.advanceblocks.PulseConfigs.Static.Messages;
import com.pandapulsestudios.pulseconfig.Interface.PulseConfig;
import com.pandapulsestudios.pulseconfig.Objects.SaveAbleInventory;
import com.pandapulsestudios.pulseconfig.Objects.SaveableArrayList;
import com.pandapulsestudios.pulseconfig.Objects.SaveableHashmap;
import com.pandapulsestudios.pulsecore.SoundAPI.API.SoundAPI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class WorldContainer implements PulseConfig {
    @Override
    public JavaPlugin mainClass() {return AdvanceBlocks.getInstance();}
    @Override
    public boolean useSubFolder() { return true; }

    @Override
    public String documentID() { return documentID;}

    public String documentID;
    public String worldName = "";
    public SaveableHashmap<Material, WorldItem> worldItems = new SaveableHashmap<>(Material.class, WorldItem.class);

    @Override
    public void FirstLoadConfig() {
        var worldItem = new WorldItem();
        worldItem.saveableHashmap.put("TestNode", new SaveAbleInventory(ChatColor.GREEN + "Drop-able Items!", 9));
        worldItems.put(Material.GRASS_BLOCK, worldItem);
    }

    public WorldContainer(String documentID){
        this.documentID = documentID;
    }

    public WorldContainer(World world){
        this.documentID = world.getUID().toString();
        this.worldName = world.getName();
    }

    public void OpenInventory(Player player, String permissionNode, Material material){
        var items = worldItems.getOrDefault(material, new WorldItem());
        var inventory = items.saveableHashmap.getOrDefault(permissionNode, new SaveAbleInventory(ChatColor.GREEN + "Drop-able Items!", 9));
        inventory.OpenInventory(player);
        items.saveableHashmap.put(permissionNode, inventory);
        worldItems.put(material, items);
        SaveConfig(false);
    }

    public void PlayerBreakBlock(Player player, Block block){
        var worldItem = worldItems.getOrDefault(block.getType(), new WorldItem());
        var items = worldItem.ReturnAllItemsForPlayer(player);

        var randomNumber = new Random().nextInt(100);
        if(randomNumber > worldItem.itemDropChance) return;

        var randomItemIndex = new Random().nextInt(items.size());
        var randomItem = items.get(randomItemIndex);

        var dropEvent = new RandomDropEvent(player, randomItem);
        if(dropEvent.isCancelled()) return;

        var dropItems = AdvanceBlocksPlugin.ReturnStatic().dropItemsOnBreak;
        if(!dropItems) player.getInventory().addItem(randomItem);
        else block.getWorld().dropItem(block.getLocation(), randomItem);

        player.playSound(player.getLocation(), worldItem.blockDropSound, 1f, 1f);
        Messages.ReturnStatic().SendMessageToPlayer(Message.YouHaveGotBlockDrop, player, randomItem.getType().name());
    }
}
