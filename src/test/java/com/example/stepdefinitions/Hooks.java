package com.example.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;

import com.example.setup.BrowserManager;

import io.cucumber.java.*;

public class Hooks {
    @Before
    public void beforeScenario() {
        BrowserManager.initialize();
    }

    @AfterStep
    public void afterStep() {
        // Add any step-level logic if needed
    }

    @After
    public void tearDown() {
        BrowserManager.close();
    }
}