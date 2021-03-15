package com.architecture.iterator;

public class FibonacciDirect extends Fibonacci implements FibonacciDirectInterface {
    public FibonacciDirect(Integer start, Integer end, String output) {
        super(start, end, output);
        generate();
    }

    @Override
    protected void generate() {
        var n = start;
        for (var i = start; i <= end; i++) {
            this.items[n] = FibonacciHelper.getValueByNum(i);
            n++;
        }
    }
}
