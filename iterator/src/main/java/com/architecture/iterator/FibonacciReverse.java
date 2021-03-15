package com.architecture.iterator;

import java.util.Iterator;

public class FibonacciReverse extends Fibonacci implements Iterator<Integer>, FibonacciReverseInterface {
    public FibonacciReverse(Integer start, Integer end, String output) {
        super(start, end, output);
        generate();
    }

    @Override
    protected void generate() {
        var n = start;
        for (var i = end; i >= start; i--) {
            this.items[n] = FibonacciHelper.getValueByNum(i);
            n++;
        }
    }
}