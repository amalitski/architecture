package com.architecture.solid.tank;

import java.security.InvalidParameterException;
import java.util.Vector;

public class IoC<T> {
    public static Integer[] resolve(String key, EntityInterface e){
//        (Vector<Integer>)e.getValue(key)

        var v = e.getValue(key);
        if (v instanceof Integer[]){
            return (Integer[]) v;
        }
        throw new InvalidParameterException("Type not accepted: " + v.getClass());
    }
}
