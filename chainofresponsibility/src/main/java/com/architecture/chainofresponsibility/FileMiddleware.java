package com.architecture.chainofresponsibility;

import java.io.IOException;
import java.util.logging.Logger;

public abstract class FileMiddleware {
    protected Logger logger = Logger.getLogger(getClass().getName());
    protected FileMiddleware next;

    public FileMiddleware setNext(FileMiddleware next) {
        this.next = next;
        return this.next;
    }

    protected String getMessage(String filename) {
        return "Обработчик " + getClass().getSimpleName() + " получил файл " + filename + ";";
    }

    public abstract String process(String filename) throws IOException;
}

