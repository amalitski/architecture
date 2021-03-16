package com.architecture.chainofresponsibility;

import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {
        var input = args[0]; // имя входного файла
        var output = args[1]; // имя выходного файла

        FileMiddleware middleware = new XmlFileMiddleware();
        var jsonMiddleware = new JsonFileMiddleware();
        var csvMiddleware = new CsvFileMiddleware();
        var txtMiddleware = new TxtFileMiddleware();
        middleware.setNext(jsonMiddleware);
        jsonMiddleware.setNext(csvMiddleware);
        csvMiddleware.setNext(txtMiddleware);

        var processor = new FileProcessor(input, output, middleware);
        processor.process();
    }
}
