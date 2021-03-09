package com.architecture.abstractfactory;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class AppTest {

    @Test
    public void sortMergeTest() {
        var array = new int[]{5, 2, 2, 9, 1, 1, 3, 4, 7, 9, 0, 2, 4, 1, 5, 2, 2, 4, 9, 3, 8, 3, 2, 8, 1, 0, 6, 2, 2, 1, 1, 0, 8, 2, 9, 7, 8, 8, 4, 9, 9, 2, 5, 0, 5, 2, 9, 7, 2, 0};

        var factory = new SortFactory();
        var method = factory.sortMerge(array);
        var result = method.sort();

        Arrays.sort(array);
        Assert.assertArrayEquals(array, result);
    }

    @Test
    public void sortSelectionTest() {
        var array = new int[]{5, 2, 2, 9, 1, 1, 3, 4, 7, 9, 0, 2, 4, 1, 5, 2, 2, 4, 9, 3, 8, 3, 2, 8, 1, 0, 6, 2, 2, 1, 1, 0, 8, 2, 9, 7, 8, 8, 4, 9, 9, 2, 5, 0, 5, 2, 9, 7, 2, 0};

        var factory = new SortFactory();
        var method = factory.sortSelection(array);
        var result = method.sort();

        Arrays.sort(array);
        Assert.assertArrayEquals(array, result);
    }

    @Test
    public void sortInsertionTest() {
        var array = new int[]{5, 2, 2, 9, 1, 1, 3, 4, 7, 9, 0, 2, 4, 1, 5, 2, 2, 4, 9, 3, 8, 3, 2, 8, 1, 0, 6, 2, 2, 1, 1, 0, 8, 2, 9, 7, 8, 8, 4, 9, 9, 2, 5, 0, 5, 2, 9, 7, 2, 0};

        var factory = new SortFactory();
        var method = factory.sortInsertion(array);
        var result = method.sort();

        Arrays.sort(array);
        Assert.assertArrayEquals(array, result);
    }

    @Test
    public void mainTest() throws IOException {
        var args = new String[]{"selection", "input.csv", "output.csv"};
        App.main(args);
    }
}
