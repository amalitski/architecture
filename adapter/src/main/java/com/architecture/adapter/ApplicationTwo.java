package com.architecture.adapter;

import lombok.Getter;

import java.io.IOException;
import java.util.Random;

public class ApplicationTwo implements ApplicationInterface {
    @Getter
    private final ApplicationOneAdapter adaptor;

    public ApplicationTwo(String output) {
        var app = new ApplicationOne("input.csv", output);
        this.adaptor = new ApplicationOneAdapter(app);
    }

    @Override
    public void run() throws IOException {
        var matrixA = generateMatrix();
        var matrixB = generateMatrix();
        this.adaptor.setMatrix(matrixA, matrixB);
    }

    private int[][] generateMatrix() {
        var n = 5;
        var matrix = new int[n][n];
        Random r = new Random();
        for (var i = 0; i < n; i++) {
            matrix[i] = r.ints(n, 0, 10).toArray();
        }
        return matrix;
    }
}
