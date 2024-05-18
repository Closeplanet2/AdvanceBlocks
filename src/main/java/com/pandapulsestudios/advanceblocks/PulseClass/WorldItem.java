package com.pandapulsestudios.advanceblocks.PulseClass;

import com.pandapulsestudios.pulseconfig.Interface.PulseClass;
import com.pandapulsestudios.pulseconfig.Interface.StorageComment;
import com.pandapulsestudios.pulseconfig.Objects.SaveAbleInventory;
import com.pandapulsestudios.pulseconfig.Objects.SaveableHashmap;
import com.pandapulsestudios.pulsecore.SoundAPI.API.SoundAPI;
import net.minecraft.sounds.SoundEffect;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorldItem implements PulseClass {
    public SaveableHashmap<String, SaveAbleInventory> saveableHashmap = new SaveableHashmap<>(String.class, SaveAbleInventory.class);
    public Sound blockDropSound = Sound.BLOCK_AMETHYST_BLOCK_BREAK;
    public double itemDropChance = 20.0;

    public List<ItemStack> ReturnAllItemsForPlayer(Player player){
        var data = new ArrayList<ItemStack>();
        for(var permission : saveableHashmap.keySet()){
            if(!player.hasPermission(permission)) continue;
            for(var itemStack : saveableHashmap.get(permission).GetLiveContents()){
                if(itemStack == null) continue;
                var clone = itemStack.clone();
                clone.setAmount(1);
                for(var i = 0; i < itemStack.getAmount(); i++) data.add(clone);
            }
        }
        return data;
    }
}
