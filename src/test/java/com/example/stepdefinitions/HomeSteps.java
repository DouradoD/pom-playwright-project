package com.example.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.setup.TestContext;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {
    
    TestContext context;

    // World is injected automatically by Picocontainer
    public HomeSteps(TestContext context) {
        this.context = context;
    }
    

    @When("he accesses the URL {string}")
    public void he_accesses_the_url(String string) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        context.page.navigate(string);
    }
    @Then("he should see the title {string}")
    public void he_should_see_the_title(String string) {
        assertEquals(true , context.getPages().getHome().IsHomeScreenVisible());
        
    }

}