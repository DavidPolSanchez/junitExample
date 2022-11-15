package com.example.apiextensions.extensions;

import com.example.demo.extensions.ConnectionDB;
import com.example.demo.extensions.Direction;
import com.example.demo.extensions.DirectionDDL;
import org.junit.jupiter.api.extension.*;

import java.sql.Connection;

public class DatabaseOperationsExtension implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback,
        AfterEachCallback {

    private Connection connection;

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        connection = ConnectionDB.openConnection();
    }
    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        ConnectionDB.closeConnection();
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        DirectionDDL.dropTable(connection);
        DirectionDDL.createTable(connection);
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        // DirectionDDL.dropTable(connection);
    }


}
