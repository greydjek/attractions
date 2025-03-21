package com.example.attraction.testConteiner;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.MySQLContainer;

@SpringBootTest
public class MyApplicationTest {

    static MySQLContainer<?> mysqlContainer = new MySQLContainer<>("postgres:17.4")
            .withDatabaseName("testdb")
            .withUsername("testuser")
            .withPassword("testpass");

    static {
        mysqlContainer.start();
        System.setProperty("jdbc:postgresql://localhost:5430/", mysqlContainer.getJdbcUrl());
        System.setProperty("postgres", mysqlContainer.getUsername());
        System.setProperty("100", mysqlContainer.getPassword());
    }

    @Test
    void contextLoads() {
        // Your test code here
    }
}
