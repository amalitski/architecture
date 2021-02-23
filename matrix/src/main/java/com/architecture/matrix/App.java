package com.architecture.matrix;

public class App {
    public static void main(String[] args) {
        int[][] m1 = {
                {2, -3},
                {4, -6},
        };
        int[][] m2 = {
                {9, -6},
                {6, -4},
        };

        var matrixService = new MatrixService();
        var r1 = matrixService.product(m1, m2);
        MatrixService.print(r1);

        var r2 = matrixService.product(m2, m1);
        MatrixService.print(r2);
    }
}
