package com.architecture.chainofresponsibility;

import java.io.IOException;

public class XmlFileMiddleware extends FileMiddleware {
    public String process(String filename) throws IOException {
        if (filename.endsWith(".xml")) {
            var msg = getMessage(filename);
            logger.info(msg);
            return FileHelper.readResource(filename);
        }
        return next.process(filename);
    }
}
