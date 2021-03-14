package com.architecture.template;

import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {
        var inputFile = args[0]; // имя входного файла
        var outputFile = args[1]; // имя выходного файла
        var type = args[2]; // вид операции

        Matrix matrix = switch (type) {
            case ("transpose") -> new MatrixTranspose(inputFile, outputFile);
            case ("sum") -> new MatrixSum(inputFile, outputFile);
            case ("determinant") -> new MatrixDeterminant(inputFile, outputFile);
            default -> throw new IllegalArgumentException();
        };
        matrix.load();
        matrix.execute();
        matrix.format();
        matrix.write();
    }
}
