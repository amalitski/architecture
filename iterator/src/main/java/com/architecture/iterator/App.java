package com.architecture.iterator;

import java.io.*;
import java.util.Iterator;

public class App {
    public static void main(String[] args) throws IOException {
        var start = Integer.valueOf(args[0]);
        var end = Integer.valueOf(args[1]);
        var type = args[2]; // порядок
        var output = args[3]; // имя выходного файла

        var factory = new FibonacciFactory(start, end, output);
        Fibonacci product = switch (type) {
            case ("direct") -> factory.createDirect();
            case ("reverse") -> factory.createReverse();
            default -> throw new IllegalArgumentException();
        };
        product.write();
    }
}
