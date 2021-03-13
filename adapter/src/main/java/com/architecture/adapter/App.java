package com.architecture.adapter;

import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {
        // Example 1. Without adaptor
        var app = new ApplicationOne("input.csv", "output.csv");
        app.run();

        // Example 2. With adaptor
        var app2 = new ApplicationTwo("output2.csv");
        app2.run();
    }
}
