package com.example.tag;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("database")
public class EmployeeRepositoryTest {

    @Tag("insert")
    @Test
    void save() throws InterruptedException {
        Thread.sleep(3000L);
        System.out.println("save");
    }


    @Test
    void delete() {
        System.out.println("delete");
    }
}
