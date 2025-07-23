package com.example.stepdefinitions;


import com.example.pages.HomePage;
import com.example.setup.BrowserManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {
    
    @Given("the user opens the Google URL")
    public void openGoogle() {
        BrowserManager.getTestContext().getPages().getPage(HomePage.class).navigateToGoogle();
    }
    
    @When("he inputs a {string} value")
    public void inputValue(String value) {
        BrowserManager.getTestContext().getPages().getPage(HomePage.class).searchFor(value);
    }
    
    @Then("the {string} value input should be inside the field")
    public void verifyInputValue(String expectedValue) {
        String actualValue = BrowserManager.getTestContext()
            .getPages()
            .getPage(HomePage.class)
            .getSearchFieldValue();
        
        assert actualValue.equals(expectedValue) : 
            "Expected input value '" + expectedValue + "' but found '" + actualValue + "'";
    }
}