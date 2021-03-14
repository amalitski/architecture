package com.architecture.template;

public class MatrixTranspose extends Matrix {
    public MatrixTranspose(String inputFile, String outputFile) {
        super(inputFile, outputFile);
    }

    @Override
    public void execute() {
        for (var m : this.matrices) {
            int[][] temp = new int[m[0].length][m.length];
            for (int i = 0; i < m.length; i++)
                for (int j = 0; j < m[0].length; j++)
                    temp[j][i] = m[i][j];

            this.resultMatrix.add(temp);
        }
    }
}
