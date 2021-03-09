package com.architecture.abstractfactory;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) throws IOException {
        var type = args[0];
        var inputFile = args[1];
        var outputFile = args[2];

        var array = read(inputFile);
        var factory = new SortFactory();
        SortInterface method = switch (type) {
            case ("selection") -> factory.sortSelection(array);
            case ("insertion") -> factory.sortInsertion(array);
            case ("merge") -> factory.sortMerge(array);
            default -> throw new IllegalArgumentException("Undefined method!");
        };

        var result = method.sort();

        write(outputFile, result);
        for (var i : result) {
            System.out.println(i);
        }
    }

    private static int[] read(String filename) throws FileNotFoundException {
        var file = new File(App.class.getClassLoader().getResource(filename).getFile());
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter(";");
        var result = IntStream.builder();
        while (scanner.hasNext()) {
            result.add(Integer.parseInt(scanner.next()));
        }
        return result.build().toArray();
    }

    private static void write(String filename, int[] array) throws IOException {
        var data = IntStream.of(array).mapToObj(String::valueOf).collect(Collectors.joining(";"));
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(data);
        writer.close();
    }
}
