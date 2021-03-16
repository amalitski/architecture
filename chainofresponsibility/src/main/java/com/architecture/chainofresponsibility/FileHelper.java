package com.architecture.chainofresponsibility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileHelper {
    public static List<String> readFiles(String filename) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        var f = classloader.getResource(filename).getFile();
        var file = Paths.get(f);
        return Files.readAllLines(file);
    }

    public static String readResource(String filename) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        var f = classloader.getResource(filename).getFile();
        var file = Paths.get(f);
        return Files.readString(file);
    }

    public static void write(String filename, String data) throws IOException {
        var file = Paths.get(filename);
        Files.write(file, data.getBytes());
    }
}

