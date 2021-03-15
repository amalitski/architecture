package com.architecture.iterator;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AppTest {
    @Test
    public void directTest() throws IOException {
        var start = "5";
        var end = "10";
        var type = "direct";
        var output = "output.csv";

        App.main(new String[]{start, end, type, output});

        /**
         * Числа Фибоначчи: https://ru.wikipedia.org/wiki/%D0%A7%D0%B8%D1%81%D0%BB%D0%B0_%D0%A4%D0%B8%D0%B1%D0%BE%D0%BD%D0%B0%D1%87%D1%87%D0%B8
         * Для номеров с 5 по 10: 5,8,13,21,34,55
         */
        var data = FibonacciHelper.read(output);
        Assert.assertArrayEquals(data, new int[]{5, 8, 13, 21, 34, 55});
    }

    @Test
    public void reverseTest() throws IOException {
        var start = "5";
        var end = "10";
        var type = "reverse";
        var output = "output.csv";

        App.main(new String[]{start, end, type, output});

        /**
         * Числа Фибоначчи: https://ru.wikipedia.org/wiki/%D0%A7%D0%B8%D1%81%D0%BB%D0%B0_%D0%A4%D0%B8%D0%B1%D0%BE%D0%BD%D0%B0%D1%87%D1%87%D0%B8
         * Для номеров с 5 по 10 в обратном порядке: 55,34,21,13,8,5
         */
        var data = FibonacciHelper.read(output);
        Assert.assertArrayEquals(data, new int[]{55, 34, 21, 13, 8, 5});
    }
}
