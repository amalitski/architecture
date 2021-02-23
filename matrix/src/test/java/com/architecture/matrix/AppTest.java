package com.architecture.matrix;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {
    @Test
    public void oneTest() {
        int[][] m1 = {{2, -3}, {4, -6}};
        int[][] m2 = {{9, -6}, {6, -4}};
        var matrixService = new MatrixService();

        var r1 = matrixService.product(m1, m2);
        Assert.assertArrayEquals(r1, new int[][]{{0, 0}, {0, 0}});

        var r2 = matrixService.product(m2, m1);
        MatrixService.print(r2);
        Assert.assertArrayEquals(r2, new int[][]{{-6, 9}, {-4, 6}});
    }

    @Test
    public void twoTest() {
        int[][] m1 = {{3, 1}, {-4, 2}};
        int[][] m2 = {{5, 0}, {2, 1}};
        var matrixService = new MatrixService();

        var r1 = matrixService.product(m1, m2);
        Assert.assertArrayEquals(r1, new int[][]{{17, 1}, {-16, 2}});

        var r2 = matrixService.product(m2, m1);
        MatrixService.print(r2);
        Assert.assertArrayEquals(r2, new int[][]{{15, 5}, {2, 4}});
    }
}
