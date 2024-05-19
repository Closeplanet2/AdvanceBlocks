# AdvanceBlocks

Random chance to drop addtional items when a block is broken by a player!
Plugin Forum Link: https://bukkit.org/threads/advance-blocks.503750/

# Devlog
[![Watch the video](https://img.youtube.com/vi/7A-eNlAXkg4/maxresdefault.jpg)](https://www.youtube.com/watch?v=7A-eNlAXkg4)

# Downloads
* 1.20.4 - [https://github.com/Closeplanet2/AdvanceBlocks/releases/tag/AdvanceBlocks-1.20.4-1.0.1-SNAPSHOT](https://github.com/Closeplanet2/AdvanceBlocks/releases/tag/AdvanceBlocks-1.20.4-1.0.1-SNAPSHOT)
* 1.8.8 - COMING SOON

# Mavern
```
<repository>
      <id>advanceblocks</id>
      <url>https://maven.pkg.github.com/closeplanet2/AdvanceBlocks</url>
</repository>
```

```
<dependency>
  <groupId>com.pandapulsestudios</groupId>
  <artifactId>advanceblocks</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

# Depends
* [https://github.com/Closeplanet2/PulseCommandsAbstract/releases/tag/1.0.6-SNAPSHOT](https://github.com/Closeplanet2/PulseCommandsAbstract/releases/tag/1.0.6-SNAPSHOT) -> Uses the auto register loops, auto register events and variable tests
* [https://github.com/Closeplanet2/PulseConfig/releases/tag/2.0.3](https://github.com/Closeplanet2/PulseConfig/releases/tag/2.0.3) -> Uses to auto srialise the configs!
* [https://github.com/Closeplanet2/PulseCoreAbstract/releases/tag/1.0.1-SNAPSHOT](https://github.com/Closeplanet2/PulseCoreAbstract/releases/tag/1.0.1-SNAPSHOT) -> USes the auto player command methods

# External Depends
* [https://www.spigotmc.org/resources/placeholderapi.6245/](https://www.spigotmc.org/resources/placeholderapi.6245/)

# How to use the plugin
1. Install this plugin on your server
2. Download the depends on your server
3. Run the server, the event will use the default settings

# Optional,
1. Change the settings in the config below
2. Reload The configs

# Other Work
* [http://joshuafiler.org](http://joshuafiler.org)


# AdvanceBlocks API for developers
```
public static void EnableSystem(boolean state)
public static void ResetConfigs()
public static void ReloadConfigs()
public static void OpenEdit(Player player, Material material, String worldName, String permissionNode)
```

# AdvanceBlocks Custom Events
```
public class EnableSystemEvent extends Event
public class RandomDropEvent extends Event implements Cancellable
public class ReloadConfigEvent extends Event
public class ResetConfigEvent extends Event
```

# Player Commands -> Permssions below
```
public void EnableSystem(CraftPlayer craftPlayer, boolean state)
public void ResetConfigs(CraftPlayer admin)
public void ReloadConfigs(CraftPlayer admin)
public void EditDrop(CraftPlayer craftPlayer, Material material, String worldName, String permissionNode)
```

# AdvanceBlocksPlugin.yml
```
AdvanceBlocksPlugin:
  '# +------------------WARNING: SYSTEM WONT RUN IF FALSE!': '------------------+
    #'
  systemEnabled: true
  debugConfig: false
  dropItemsOnBreak: false
```

# Messages.yml
```
Messages:
  ? '# +------------------Messages to be displayed on the server! Leave blank and
    message wont be sent! Remove to reset to default!'
  : '------------------+ #'
  messages:
    PlayerReloadedConfig: '#7fff36You have reloaded the configs!'
    ConsoleEnabledSystem: '#7fff36System has been enabled!'
    WorldDoesNotExist: '#fa3448The world you have selected doesn''t exist!'
    YouHaveGotBlockDrop: '#7fff36You have received 1x%s from random block drops'
    PlayerResetConfig: '#7fff36You have reset the configs!'
    ConsoleDisableSystem: '#fa3448System has been disabled!'
  '# +------------------Display debugs in the console logs for changes in this config!': '------------------+
    #'
  debugConfig: false
```

# Permissions.yml
```
Permissions:
  '# +------------------Stored Permissions!': '------------------+ #'
  permissions:
    RELOAD_CONFIGS: AdvanceBlocks.RELOAD_CONFIGS
    RESET_CONFIGS: AdvanceBlocks.RESET_CONFIGS
    EDIT_DROPS: AdvanceBlocks.EDIT_DROPS
    ENABLE_SYSTEM: AdvanceBlocks.ENABLE_SYSTEM
  '# +------------------Display debugs in the console logs for changes in this config!': '------------------+
    #'
  debugConfig: false
  '# +------------------Do you send player error message if doesn''t have permission?': '------------------+
    #'
  sendPlayerErrorMessage: true
```

# Example World Container YML
```
2625a649-c38d-4fff-b456-5b1cdca7ee58:
  documentID: 2625a649-c38d-4fff-b456-5b1cdca7ee58
  worldName: world
  worldItems:
    GRASS_BLOCK:
      saveableHashmap:
        TestNode:
          SIZE: 9
          TITLE: §aDrop-able Items!
          CONTENTS:
          - null
          - null
          - null
          - null
          - null
          - null
          - null
          - null
          - null
      blockDropSound: BLOCK_AMETHYST_BLOCK_BREAK
      itemDropChance: 20.0
    STONE_BRICK_WALL:
      saveableHashmap:
        Hello:
          SIZE: 9
          TITLE: §aDrop-able Items!
          CONTENTS:
          - ==: org.bukkit.inventory.ItemStack
            v: 3700
            type: BIRCH_WOOD
            amount: 10
          - ==: org.bukkit.inventory.ItemStack
            v: 3700
            type: OAK_PLANKS
          - null
          - null
          - null
          - null
          - null
          - null
          - null
      blockDropSound: BLOCK_AMETHYST_BLOCK_BREAK
      itemDropChance: 20.0
```

