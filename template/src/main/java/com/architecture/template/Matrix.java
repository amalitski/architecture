package com.architecture.template;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Matrix {
    private final String inputFile;
    private final String outputFile;
    protected List<int[][]> matrices = new ArrayList<>();
    protected List<int[][]> resultMatrix = new ArrayList<>();
    protected String resultText = "";


    public Matrix(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public void load() throws IOException {
        this.matrices = MatrixHelper.readMatrices(this.inputFile);
    }

    public abstract void execute();

    public void format() {
        for (var r : this.resultMatrix) {
            var n = this.resultMatrix.get(0)[0].length;
            var body = new StringBuilder();
            for (var i = 0; i < n; i++) {
                var row = Arrays.stream(r[i]).mapToObj(String::valueOf).collect(Collectors.joining(";")) + "\n";
                body.append(row);
            }
            if (!this.resultText.isEmpty()) {
                this.resultText += "\n---\n";
            }
            this.resultText += body.toString();
        }
    }

    public void write() throws IOException {
        var file = Paths.get(this.outputFile);
        Files.write(file, this.resultText.getBytes());
    }
}
