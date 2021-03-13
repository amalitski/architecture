package com.architecture.adapter;

import lombok.Builder;
import lombok.Getter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MatrixHelper {
    @Builder
    @Getter
    public static class Matrix {
        private int[][] a;
        private int[][] b;
    }

    public static int[][] readMatrix(String filename) throws IOException {
        var file = Paths.get(filename);
        var data = Files.readString(file).trim();
        return textToMatrix(data);
    }

    public static Matrix readMatrices(String filename) throws IOException {
        var file = Paths.get(filename);
        var data = Files.readString(file);
        String[] matrixes = data.split("---");
        return Matrix.builder()
                .a(textToMatrix(matrixes[0]))
                .b(textToMatrix(matrixes[1]))
                .build();
    }


    public static Path writeMatrix(int[][] m, String filename) throws IOException {
        var data = matrixToText(m);
        var file = Paths.get(filename);
        Files.write(file, data.getBytes());
        return file;
    }

    public static Path writeMatrices(int[][] m1, int[][] m2, String filename) throws IOException {
        var separator = "---";
        var data = matrixToText(m1) + separator + "\n" + matrixToText(m2);
        var file = Paths.get(filename);
        Files.write(file, data.getBytes());
        return file;
    }

    public static String matrixToText(int[][] m) {
        var n = m[0].length;
        var body = new StringBuilder();
        for (var i = 0; i < n; i++) {
            var row = Arrays.stream(m[i]).mapToObj(String::valueOf).collect(Collectors.joining(";")) + "\n";
            body.append(row);
        }
        return body.toString();
    }

    public static int[][] textToMatrix(String data) {
        var rows = data.trim().split("\n");
        var n = rows[0].split(";").length;
        var m = new int[n][n];
        for (var i = 0; i < n; i++) {
            m[i] = Arrays.stream(rows[i].split(";")).mapToInt(Integer::parseInt).toArray();
        }
        return m;
    }

    public static int[][] product(int[][] m1, int[][] m2) {
        int m1ColLength = m1[0].length; // m1 columns length
        int m2RowLength = m2.length;    // m2 rows length
        if(m1ColLength != m2RowLength) return null; // matrix multiplication is not possible
        int mRRowLength = m1.length;    // m result rows length
        int mRColLength = m2[0].length; // m result columns length
        int[][] mResult = new int[mRRowLength][mRColLength];
        for(int i = 0; i < mRRowLength; i++) {         // rows from m1
            for(int j = 0; j < mRColLength; j++) {     // columns from m2
                for(int k = 0; k < m1ColLength; k++) { // columns from m1
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return mResult;
    }
}
