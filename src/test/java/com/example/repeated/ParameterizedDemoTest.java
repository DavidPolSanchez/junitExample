package com.example.repeated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

public class ParameterizedDemoTest {



    @ParameterizedTest
    @CsvSource({
            "1, Empleado 1, 30000",
            "2, Empleado 2, 40000",
            "3, Empleado 3, 50000",
            "4, Empleado 4, 60000"
    })
    void test1(Long id, String name, Integer salary) {
        System.out.println("id: " + id + ", name: " + name + ", salary: " + salary);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/users.csv", numLinesToSkip = 1)
    void test2(Long id, String name, Integer salary) {
        System.out.println("id: " + id + ", name: " + name + ", salary: " + salary);
    }

    @ParameterizedTest
    @EnumSource(Role.class)
    void test3(Role role) {
        System.out.println("role: " + role);
    }

    @ParameterizedTest
    @MethodSource("namesProvider")
    void test4(String name) {
        System.out.println("name: " + name);
    }

    @ParameterizedTest
    @MethodSource("com.example.demo.repository.SalaryProvider#salaryProvider")
    void test5(Double salary) {
        System.out.println("name: " + salary);
    }

    public static List<String> namesProvider() {
        return List.of("name1", "name2", "name3", "name4");
    }

    public static Stream<String> namesProvider2() {
        return Stream.of("name1", "name2", "name3", "name4");
    }
}
