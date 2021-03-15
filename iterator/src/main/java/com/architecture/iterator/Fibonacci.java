package com.architecture.iterator;

import java.io.IOException;
import java.util.Iterator;

public abstract class Fibonacci implements Iterator<Integer> {
    protected int[] items;
    protected int current;
    protected int start;
    protected int end;
    protected String output;

    public Fibonacci(Integer start, Integer end, String output) {
        this.start = start;
        this.end = end;
        this.output = output;
        this.current = start;
        this.items = new int[end+1];
    }

    protected abstract void generate();

    public void write() throws IOException {
        // Демонстрация итератора
        var builder = new StringBuilder();
        while (this.hasNext()) {
            var i = this.next();
            if (builder.length() > 0) {
                builder.append(";");
            }
            builder.append(i);
        }
        FibonacciHelper.write(builder.toString(), this.output);
    }

    @Override
    public boolean hasNext() {
        return this.current <= this.end;
    }

    @Override
    public Integer next() {
        return this.items[this.current++];
    }
}
