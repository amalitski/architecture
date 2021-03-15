package com.architecture.iterator;

public class FibonacciFactory implements GenerateFactory {
    protected Integer start;
    protected Integer end;
    protected String output;

    public FibonacciFactory(Integer start, Integer end, String output) {
        this.start = start;
        this.end = end;
        this.output = output;
    }

    @Override
    public FibonacciDirect createDirect() {
        return new FibonacciDirect(this.start, this.end, this.output);
    }

    @Override
    public FibonacciReverse createReverse() {
        return new FibonacciReverse(this.start, this.end, this.output);
    }
}
