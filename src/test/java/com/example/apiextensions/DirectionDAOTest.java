package com.example.apiextensions;

import com.example.apiextensions.extensions.ConditionExtension;
import com.example.apiextensions.extensions.DatabaseOperationsExtension;
import com.example.apiextensions.extensions.DirectionExistsExtension;
import com.example.apiextensions.extensions.DirectionInjectionExtension;
import com.example.demo.extensions.Direction;
import com.example.demo.extensions.DirectionDAO;
import com.example.demo.extensions.DirectionExistsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(DirectionInjectionExtension.class)
@ExtendWith(DatabaseOperationsExtension.class)
@ExtendWith(ConditionExtension.class)
@ExtendWith(DirectionExistsExtension.class)
public class DirectionDAOTest {

    DirectionDAO directionDAO; // interfaz

    // DirectionInjectionExtension inyecta la implementación DirectionDAOImpl
    public DirectionDAOTest(DirectionDAO directionDAO) {
        this.directionDAO = directionDAO;
    }

    @Test
    void insertDirectionTest() throws DirectionExistsException {
        Direction direction = new Direction("street", "2324" ,"madrid" ,"spain");
        directionDAO.insert(direction);
        Direction directionDB = directionDAO.getById(1L);
        assertEquals(1, directionDB.getId());
    }

    @Test
    void insertAlreadyExists() throws DirectionExistsException {

        Direction direction = new Direction("street", "2324" ,"madrid" ,"spain");
        directionDAO.insert(direction);

        Direction directionDB = directionDAO.getById(1L);
        directionDAO.insert(directionDB);

    }
}
