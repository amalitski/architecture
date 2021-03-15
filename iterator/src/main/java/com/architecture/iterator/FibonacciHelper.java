package com.architecture.iterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FibonacciHelper {
    public static int[] read(String filename) throws IOException {
        var file = Paths.get(filename);
        var data = Files.readString(file);
        return Arrays.stream(data.split(";")).mapToInt(Integer::parseInt).toArray();
    }

    public static void write(String data, String filename) throws IOException {
        var file = Paths.get(filename);
        Files.write(file, data.getBytes());
    }

    public static Integer getValueByNum(int n) {
        if (n < 1) {
            return 0;
        } else if (n <= 2) {
            return 1;
        } else {
            return getValueByNum(n - 1) + getValueByNum(n - 2);
        }
    }
}
