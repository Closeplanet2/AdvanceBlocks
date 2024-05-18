package com.pandapulsestudios.advanceblocks.Enums.Static;

public enum Message {
    ConsoleEnabledSystem("#7fff36System has been enabled!"),
    ConsoleDisableSystem("#fa3448System has been disabled!"),
    PlayerReloadedConfig("#7fff36You have reloaded the configs!"),
    PlayerResetConfig("#7fff36You have reset the configs!"),
    WorldDoesNotExist("#fa3448The world you have selected doesn't exist!"),
    YouHaveGotBlockDrop("#7fff36You have received 1x%s from random block drops");

    public final String message;
    Message(String message){
        this.message = message;
    }
}
