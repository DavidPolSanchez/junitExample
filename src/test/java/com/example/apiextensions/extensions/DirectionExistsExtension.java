package com.example.apiextensions.extensions;

import com.example.demo.extensions.DirectionExistsException;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DirectionExistsExtension implements TestExecutionExceptionHandler {


    Logger logger = LoggerFactory.getLogger(DirectionExistsExtension.class);

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {

        if (throwable instanceof DirectionExistsException) {
            logger.error("direction already exists", throwable);
        }
        throw throwable;

    }
}
