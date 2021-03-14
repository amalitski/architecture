package com.architecture.template;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AppTest {
    @Test
    public void sumTest() throws IOException {
        var input = "src/main/resources/input.csv";
        var output = "output.csv";
        var type = "sum";

        App.main(new String[]{input, output, type});

        var m = MatrixHelper.readMatrices(output).get(0);
        Assert.assertArrayEquals(m, new int[][]{{17, 1}, {-16, 2}});
    }

    @Test
    public void transposeTest() throws IOException {
        var input = "src/main/resources/input.csv";
        var output = "output.csv";
        var type = "transpose";

        App.main(new String[]{input, output, type});

        var m = MatrixHelper.readMatrices(output);
        Assert.assertArrayEquals(m.get(0), new int[][]{{3, -4}, {1, 2}});
        Assert.assertArrayEquals(m.get(1), new int[][]{{5, 2}, {0, 1}});
    }

    @Test
    public void determinantTest() throws IOException {
        var input = "src/main/resources/input.csv";
        var output = "output.csv";
        var type = "determinant";

        App.main(new String[]{input, output, type});

        var m = MatrixHelper.readInts(output);
        Assert.assertEquals(m.get(0).intValue(), 10);
        Assert.assertEquals(m.get(1).intValue(), 5);
    }
}
