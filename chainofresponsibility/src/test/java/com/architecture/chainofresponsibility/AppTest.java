package com.architecture.chainofresponsibility;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AppTest {
    @Test
    public void xmlTest() throws IOException {
        var file = "file.xml";
        var chain = createChain();
        var msg = chain.process(file);

        Assert.assertEquals(msg, FileHelper.readResource(file));
    }

    @Test
    public void jsonTest() throws IOException {
        var file = "file.json";
        var chain = createChain();
        var msg = chain.process(file);

        Assert.assertEquals(msg, FileHelper.readResource(file));
    }
    @Test
    public void csvTest() throws IOException {
        var file = "file.csv";
        var chain = createChain();
        var msg = chain.process(file);

        Assert.assertEquals(msg, FileHelper.readResource(file));
    }
    @Test
    public void txtTest() throws IOException {
        var file = "file.txt";
        var chain = createChain();
        var msg = chain.process(file);

        Assert.assertEquals(msg, FileHelper.readResource(file));
    }


    @Test
    public void appTest() throws IOException {
        var input = "input.txt";
        var output = "output.txt";
        App.main(new String[]{input, output});

        Assert.assertTrue(Files.exists(Paths.get(output)));
    }

    public FileMiddleware createChain(){
        FileMiddleware middleware = new XmlFileMiddleware();
        var jsonMiddleware = new JsonFileMiddleware();
        var csvMiddleware = new CsvFileMiddleware();
        var txtMiddleware = new TxtFileMiddleware();
        middleware.setNext(jsonMiddleware);
        jsonMiddleware.setNext(csvMiddleware);
        csvMiddleware.setNext(txtMiddleware);
        return middleware;
    }
}
