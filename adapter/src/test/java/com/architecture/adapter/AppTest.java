package com.architecture.adapter;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AppTest {
    @Test
    public void appOneTest() throws IOException {
        var input = "src/main/resources/input.csv";
        var output = "output.csv";
        var app = new ApplicationOne(input, output);
        app.run();

        var mInput = MatrixHelper.readMatrices(input);
        var mOutput = MatrixHelper.readMatrix(output);
        var r = MatrixHelper.product(mInput.getA(), mInput.getB());
        var n = mOutput[0].length;
        Assert.assertTrue(n > 0);
        for (var i = 0; i < n; i++) {
            Assert.assertArrayEquals(r[i], mOutput[i]);
        }
    }

    @Test
    public void adapterTest() throws IOException {
        var output = "output2.csv";
        var app2 = new ApplicationTwo(output);
        app2.run();

        var mOutput = MatrixHelper.readMatrix(output);
        var r = MatrixHelper.product(app2.getAdaptor().getA(), app2.getAdaptor().getB());
        var n = mOutput[0].length;
        Assert.assertTrue(n > 0);
        for (var i = 0; i < n; i++) {
            Assert.assertArrayEquals(r[i], mOutput[i]);
        }
    }
}
