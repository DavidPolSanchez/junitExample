package com.example.conditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

/*
org.junit.jupiter.api.condition proporciona anotaciones para ejecutar los test condicionalmente en base a:
JRE, OS, variables entorno, propiedades de sistema

 */
public class ConditionalTest {

    @Test
    void test1() {
        System.getenv().forEach(
                (k, v) -> System.out.println("k: " + k + ", " + v)
        );

        System.getProperties().forEach(
                (k, v) -> System.out.println("k: " + k + ", " + v)
        );

    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void test2() {
        System.out.println("test2");
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_17)
    void test3() {
        System.out.println("test3");
    }

    @EnabledOnOs(OS.LINUX)
    @Test
    void test4() {
        System.out.println("test4");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "OS", matches = "Ubuntu-20.4")
    void test5() {
        System.out.println("test5");
    }


    @Test
    @EnabledIfSystemProperty(named = "user.language", matches = "es")
    void test6() {
        System.out.println("test6");
    }
    @Test
    @EnabledIf("isEncryptionSupported")
    void test7() {

        System.out.println("test7");
    }

    /*
    Utilizamos nuestras propias condiciones cuando no nos alcanza con las que hay por defecto: JRE, OS, variables entorno, propiedades de sistema
     */
    private boolean isEncryptionSupported(){
        return false;
    }


}
