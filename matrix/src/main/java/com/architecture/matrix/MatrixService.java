package com.architecture.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class MatrixService {
    public int[][] product(int[][] m1, int[][] m2) {
        var rows = m1.length;
        var columns = m1[0].length;
        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(processors);

        List<Map.Entry> results = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Future<Integer> future = executor.submit(new Product(m1, m2, i, j));
                Map.Entry<Integer, Future<Integer>> e = Map.entry(i * columns + j, future);
                results.add(e);
            }
        }
        executor.shutdown();

        int[][] m = new int[rows][columns];
        try {
            for (var result : results) {
                Future<Integer> f = (Future<Integer>) result.getValue();
                int key = (int) result.getKey();
                int value = f.get();

                int posRow = key / rows;
                int posColumn = key - posRow * rows;
                m[posRow][posColumn] = value;
            }
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return m;
    }

    private static class Product implements Callable {
        private final int[][] m1;
        private final int[][] m2;
        private final int i;
        private final int j;

        public Product(int[][] m1, int[][] m2, int i, int j) {
            this.m1 = m1;
            this.m2 = m2;

            this.i = i;
            this.j = j;
        }

        @Override
        public Integer call() {
            System.out.println("Running Task! Position: " + i + "." + j);
            var r = productElement(m1, m2, i, j);
            System.out.println("Complete Task! Position: " + i + "." + j);
            return r;
        }
    }

    /**
     * |a11 a12|  *  |b11 b12| => |a11*b11+a12*b21 a11*b12+a12*b22|
     * |a21 a22|     |b21 b22|    |a21*b11+a21*b21 a21*b12+a22*b22|
     */
    private static int productElement(int[][] m1, int[][] m2, int i, int j) {
        int k = m1.length;
        int Cij = 0;
        var s = new StringBuilder();
        for (int ik = 0; ik < k; ik++) {
            Cij += m1[i][ik] * m2[ik][j];
            if (s.length() > 0) {
                s.append("*");
            }
            s.append((String) (m1[i][ik] + "*" + m2[ik][j]));
        }
        System.out.println("C[" + "i" + i + ".j" + j + "]: " + s + "=" + Cij);
        return Cij;
    }

    public static void print(int[][] m) {
        System.out.println("Result:");
        for (int[] ints : m) {
            var row = new StringBuilder();
            for (int anInt : ints) {
                if (row.length() > 0) {
                    row.append(";");
                }
                row.append(anInt);
            }
            System.out.println(row);
        }
    }
}