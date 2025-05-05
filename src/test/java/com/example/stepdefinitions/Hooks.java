package com.example.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;

import com.example.setup.DriverManager;

public class Hooks {

    @Before
    public void setup() {
        System.out.println("Setting up the browser");
        DriverManager.initializeBrowser();
    }
    
    @After
    public void closeBrowser() {
        DriverManager.closeBrowser();
        System.out.println("Browser closed");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("All tests completed");
        DriverManager.closePlaywright();
    }
}