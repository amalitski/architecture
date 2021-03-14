package com.architecture.template;

import java.util.ArrayList;

public class MatrixSum extends Matrix {
    public MatrixSum(String inputFile, String outputFile) {
        super(inputFile, outputFile);
    }

    @Override
    public void execute() {
        var sum = MatrixHelper.product(this.matrices.get(0), this.matrices.get(1));
        this.resultMatrix = new ArrayList<int[][]>();
        this.resultMatrix.add(sum);
    }
}
