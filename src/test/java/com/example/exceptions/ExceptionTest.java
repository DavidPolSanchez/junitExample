package com.example.exceptions;

import com.example.demo.domain.SmartDevice;
import com.example.demo.domain.SmartPhone;
import com.example.demo.service.SmartPhoneService;
import com.example.demo.service.SmartPhoneServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTest {

    SmartPhoneService service = new SmartPhoneServiceImpl();

    @Test
    void findOne1Test() {

        // Opcion 1: trabajar directamente con Optional
        assertTrue(service.findOne(1L).isPresent());
        service.findOne(1L).ifPresent(
                smartphone -> assertEquals(1L, smartphone.getId())
        );

        assertTrue(service.findOne(1L).map(
                smartphone -> smartphone.getCamera()
        ).isPresent());

        // Opción 2: sacar el objeto del Optional y trabajar directamente con el objeto
        Optional<SmartPhone> smartPhoneOptional = service.findOne(1L);
        assertTrue(smartPhoneOptional.isPresent());

        SmartPhone smartPhone = smartPhoneOptional.get();
        assertAll(
                () -> assertEquals(1L, smartPhone.getId()),
                () -> assertNotNull(smartPhone.getCamera())
        );
    }

    @Test
    @DisplayName("Se lanza una excepción cuando se busca un smartphone nulo")
    void findOneExceptionTest() {

        // forma no recomendable
//        boolean check = false;
//        try{
//            SmartPhone smartPhone1 = service.findOne(null);
//        } catch(Exception e){
//            check = true;
//        }
//        assertTrue(check);

        // forma recomendable

        assertThrows(IllegalArgumentException.class, () -> service.findOne(null));
    }

    @Test
    void findOneNotExistsTest() {

        Optional<SmartPhone> smartPhoneOptional = service.findOne(999L);
        assertTrue(smartPhoneOptional.isEmpty());
    }
}
