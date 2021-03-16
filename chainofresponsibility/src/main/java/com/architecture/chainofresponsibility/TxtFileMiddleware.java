package com.architecture.chainofresponsibility;

import java.io.IOException;

public class TxtFileMiddleware extends FileMiddleware {
    public String process(String filename) throws IOException {
        if (filename.endsWith(".txt")) {
            var msg = getMessage(filename);
            logger.info(msg);
            return FileHelper.readResource(filename);
        }
        return next.process(filename);
    }
}
