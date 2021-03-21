package com.architecture.solid.tank;

import java.util.Arrays;
import java.util.stream.Collectors;

public class VectorHelper {
    public static Integer[] plus(Integer[] a, Integer[] b) {
        int n = 0;
        var r = new Integer[a.length];
        while (n < a.length) {
            r[n] = a[n] + b[n];
            n++;
        }
        return r;
    }

    public static String str(Integer[] a) {
        var l = Arrays.asList(a).stream().map(String::valueOf).collect(Collectors.toList());
        return String.join(",", l);
    }
}
