package com.architecture.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixDeterminant extends Matrix {
    protected List<Integer> resultMatrix = new ArrayList<>();

    public MatrixDeterminant(String inputFile, String outputFile) {
        super(inputFile, outputFile);
    }

    @Override
    public void execute() {
        for (var m: this.matrices) {
            this.resultMatrix.add(det(m));
        }
    }
    @Override
    public void format() {
        for (var r: this.resultMatrix) {
            if (!this.resultText.isEmpty()) {
                this.resultText += "\n---\n";
            }
            this.resultText +=  r.toString();
        }
    }

    public static int det(int[][] mat){
        if (mat.length == 1)
            return mat[0][0];
        if (mat.length == 2)
            return mat[0][0] * mat[1][1] - mat[1][0] * mat[0][1];
        int sum = 0, sign = 1;
        int newN = mat.length - 1;
        int[][] temp = new int[newN][newN];
        for (int t = 0; t < newN; t++) {
            int q = 0;
            for (int i = 0; i < newN; i++) {
                for (int j = 0; j < newN; j++) {
                    temp[i][j] = mat[1 + i][q + j];
                }
                if (q == i)
                    q = 1;
            }
            sum += sign * mat[0][t] * det(temp);
            sign *= -1;
        }
        return sum;
    }
}
