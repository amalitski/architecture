package com.architecture.solid.tank;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Entity implements EntityInterface {
    private Map<String, Object> map = new HashMap();

    @Override
    public Object getValue(String key) {
        return map.get(key);
    }

    @Override
    public void setValue(String key, Object newValue) {
        map.put(key, newValue);
    }
}





