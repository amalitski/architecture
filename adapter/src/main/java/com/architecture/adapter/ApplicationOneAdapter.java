package com.architecture.adapter;

import lombok.Getter;

import java.io.IOException;
import java.nio.file.Files;

public class ApplicationOneAdapter implements ApplicationInterface {
    private final ApplicationOne app;
    @Getter
    private int[][] a;
    @Getter
    private int[][] b;

    public ApplicationOneAdapter(ApplicationOne app) {
        this.app = app;
    }

    @Override
    public void run() throws IOException {
        var path = MatrixHelper.writeMatrices(a, b, this.app.getInput());
        this.app.run();
        Files.deleteIfExists(path);
    }

    public void setMatrix(int[][] a, int[][] b) {
        this.a = a;
        this.b = b;
    }
}
