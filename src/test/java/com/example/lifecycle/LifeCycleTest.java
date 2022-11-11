package com.example.lifecycle;

import com.example.demo.domain.SmartPhone;
import org.junit.jupiter.api.*;

public class LifeCycleTest {

    SmartPhone smartPhone = new SmartPhone();

    @BeforeEach // se ejecuta antes de cada test
    void setUp() {
//        smartPhone = new SmartPhone();
        smartPhone.setId(1L);
        System.out.println("Hola desde @BeforeEach setUp");
    }

    @AfterEach // se ejecuta después de cada test
    void tearDown() {
        System.out.println("Hola desde @AfterEach tearDown");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Hola desde @BeforeAll beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Hola desde @AfterAll afterAll");
    }

    @Test
    void test1() {
        System.out.println(smartPhone.getId());
        smartPhone.setId(999L);
        System.out.println("Hola desde test1");
    }

    @Test
    void test2() {
        System.out.println(smartPhone.getId());
        System.out.println("Hola desde test2");
    }

}
