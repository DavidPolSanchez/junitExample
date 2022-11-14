package com.example.tag;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("controller")
public class EmployeeControllerTest {

    @Test
    void findAll() {
        System.out.println("findAll");
    }
}
