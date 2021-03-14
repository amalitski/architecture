package com.architecture.template;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixHelper {
    public static List<int[][]> readMatrices(String filename) throws IOException {
        var file = Paths.get(filename);
        var data = Files.readString(file);
        String[] mm = data.split("---");
        return Arrays.stream(mm).map(MatrixHelper::textToMatrix).collect(Collectors.toList());
    }

    public static List<Integer> readInts(String filename) throws IOException {
        var file = Paths.get(filename);
        var data = Files.readString(file);
        String[] mm = data.split("---");
        return Arrays.stream(mm).map(String::trim).map(Integer::valueOf).collect(Collectors.toList());
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
        if (m1ColLength != m2RowLength) return null; // matrix multiplication is not possible
        int mRRowLength = m1.length;    // m result rows length
        int mRColLength = m2[0].length; // m result columns length
        int[][] mResult = new int[mRRowLength][mRColLength];
        for (int i = 0; i < mRRowLength; i++) {         // rows from m1
            for (int j = 0; j < mRColLength; j++) {     // columns from m2
                for (int k = 0; k < m1ColLength; k++) { // columns from m1
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return mResult;
    }
}
