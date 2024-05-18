package com.pandapulsestudios.advanceblocks.Enums.Static;

public enum Permission {
    RELOAD_CONFIGS("AdvanceBlocks.RELOAD_CONFIGS", "#fa3448You do not have the permissions to use this command!"),
    RESET_CONFIGS("AdvanceBlocks.RESET_CONFIGS", "#fa3448You do not have the permissions to use this command!"),
    ENABLE_SYSTEM("AdvanceBlocks.ENABLE_SYSTEM", "#fa3448You do not have the permissions to use this command!"),
    EDIT_DROPS("AdvanceBlocks.EDIT_DROPS", "#fa3448You do not have the permissions to use this command!");

    public final String permission;
    public final String error;
    Permission(String permission, String error){
        this.permission = permission;
        this.error = error;
    }
}
