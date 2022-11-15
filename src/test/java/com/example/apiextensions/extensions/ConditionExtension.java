package com.example.apiextensions.extensions;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConditionExtension implements ExecutionCondition {
    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        System.out.println("ConditionExtension evaluateExecutionCondition");
        /*
        Permitir (enabled) o no permitir (disabled) el caso de test
         */
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/application.properties"));
            String environment = properties.getProperty("environment");

            if(environment.equals("production")){
                return ConditionEvaluationResult.disabled("production can't run tests!");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return ConditionEvaluationResult.enabled("Test enabled!");
    }
}
