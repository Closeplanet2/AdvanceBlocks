package com.pandapulsestudios.advanceblocks.VariableTests;

import com.pandapulsestudios.advanceblocks.Enums.Static.Message;
import com.pandapulsestudios.pulsecore.JavaAPI.Interface.PulseAutoRegister;
import com.pandapulsestudios.pulsecore.NBTAPI.Enums.PersistentDataTypes;
import com.pandapulsestudios.pulsecore.VariableAPI.Interface.PulseVariableTest;

import java.util.ArrayList;
import java.util.List;

@PulseAutoRegister
public class MessageVariableTest implements PulseVariableTest {
    @Override
    public PersistentDataTypes PersistentDataType() { return PersistentDataTypes.STRING; }

    @Override
    public boolean IsType(Object variable) {
        try{
            var test = Message.valueOf(variable.toString());
            return true;
        }catch (IllegalArgumentException ignored){ return false; }
    }

    @Override
    public List<Class<?>> ClassTypes() {
        var data = new ArrayList<Class<?>>();
        data.add(Message.class);
        data.add(Message[].class);
        return data;
    }

    @Override
    public Object SerializeData(Object serializedData) {
        return serializedData.toString();
    }

    @Override
    public Object DeSerializeData(Object serializedData) {
        return Message.valueOf(serializedData.toString());
    }

    @Override
    public Object ReturnDefaultValue() { return Message.ConsoleDisableSystem; }

    @Override
    public List<String> TabData(List<String> list, String s) {
        var data = new ArrayList<String>();
        for(var x : Message.values()) if(x.name().contains(s)) data.add(x.name());
        return data;
    }
}
