package com.example.assertions;

import com.example.demo.service.SmartPhoneService;
import com.example.demo.service.SmartPhoneServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    SmartPhoneService service = new SmartPhoneServiceImpl();

    @Test
    void countNotNullTest() {
        // Ejecutar el SUT: comportamiento a testear
        Integer count = service.count();
        // Comprobaciones con Assertions
        assertNotNull(count);
    }

    @Test
    void countTest() {
        Integer count = service.count();
        assertTrue(count > 0);
        assertEquals(3, count);
        assertEquals(3, count, "No hay 3 smartphones por defecto como se espera");
    }

    @Test
    void countAssertAllTest() {
        Integer count = service.count();

        // Con los assert individuales, si uno falla, los que están después
        // no se ejecutan
//        assertTrue(count > 0);
//        assertEquals(3, count);
//        assertEquals(3, count, "No hay 3 smartphones por defecto como se espera");

        assertAll(
                () -> assertTrue(count == 0),
                () -> assertEquals(4, count),
                () -> assertEquals(4, count, "No hay 3 smartphones por defecto como se espera")
        );

    }

}
