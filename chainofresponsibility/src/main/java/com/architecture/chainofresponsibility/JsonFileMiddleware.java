package com.architecture.chainofresponsibility;

import java.io.IOException;

public class JsonFileMiddleware extends FileMiddleware {
    public String process(String filename) throws IOException {
        if (filename.endsWith(".json")) {
            var msg = getMessage(filename);
            logger.info(msg);
            return FileHelper.readResource(filename);
        }
        return next.process(filename);
    }
}
