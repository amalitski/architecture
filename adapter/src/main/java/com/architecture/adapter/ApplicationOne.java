package com.architecture.adapter;

import lombok.Getter;

import java.io.IOException;

public class ApplicationOne implements ApplicationInterface {
    @Getter
    private String input;
    @Getter
    private String output;

    public ApplicationOne(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() throws IOException {
        var mInput = MatrixHelper.readMatrices(input);
        var r = MatrixHelper.product(mInput.getA(), mInput.getB());
        MatrixHelper.writeMatrix(r, output);
    }
}
