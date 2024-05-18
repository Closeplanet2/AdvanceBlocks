package com.pandapulsestudios.advanceblocks.VariableTests;

import com.pandapulsestudios.advanceblocks.Enums.Static.Permission;
import com.pandapulsestudios.pulsecore.JavaAPI.Interface.PulseAutoRegister;
import com.pandapulsestudios.pulsecore.NBTAPI.Enums.PersistentDataTypes;
import com.pandapulsestudios.pulsecore.VariableAPI.Interface.PulseVariableTest;

import java.util.ArrayList;
import java.util.List;

@PulseAutoRegister
public class PermissionVariableTest implements PulseVariableTest {
    @Override
    public PersistentDataTypes PersistentDataType() { return PersistentDataTypes.STRING; }

    @Override
    public boolean IsType(Object variable) {
        try{
            var test = Permission.valueOf(variable.toString());
            return true;
        }catch (IllegalArgumentException ignored){ return false; }
    }

    @Override
    public List<Class<?>> ClassTypes() {
        var data = new ArrayList<Class<?>>();
        data.add(Permission.class);
        data.add(Permission[].class);
        return data;
    }

    @Override
    public Object SerializeData(Object serializedData) {
        return serializedData.toString();
    }

    @Override
    public Object DeSerializeData(Object serializedData) {
        return Permission.valueOf(serializedData.toString());
    }

    @Override
    public Object ReturnDefaultValue() { return Permission.ENABLE_SYSTEM; }

    @Override
    public List<String> TabData(List<String> list, String s) {
        var data = new ArrayList<String>();
        for(var x : Permission.values()) if(x.name().contains(s)) data.add(x.name());
        return data;
    }
}
