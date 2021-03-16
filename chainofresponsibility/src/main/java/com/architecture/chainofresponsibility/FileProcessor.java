package com.architecture.chainofresponsibility;

import java.io.IOException;

public class FileProcessor {
    private final String input;
    private final String output;
    private final FileMiddleware chain;

    public FileProcessor(String input, String output, FileMiddleware chain) {
        this.input = input;
        this.output = output;
        this.chain = chain;
    }

    public void process() throws IOException {
        var files = FileHelper.readFiles(input);
        var response = new StringBuilder();
        for (var file : files) {
            var data = chain.process(file);
            response.append(data).append("\n---\n");
        }
        FileHelper.write(this.output, response.toString());
    }
}
