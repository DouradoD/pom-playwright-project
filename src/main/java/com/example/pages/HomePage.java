package com.example.pages;

import com.example.mappings.HomeMapping;
import com.microsoft.playwright.Page;
import com.example.base.BasePage; // Import the BasePage class

public class HomePage extends BasePage {
    // Define the WebDriver instance
    private HomeMapping mapping;
    private Page page;


    
    // Constructor to initialize the WebDriver
    public HomePage(Page page) {
        super(page);
        // Initialize the WebDriver instance
        // and other necessary components
        this.mapping = new HomeMapping();
        this.page = page;

    }

    public HomeMapping getMapping() {
        return mapping;
    }

    // Abstract method to be implemented by subclasses
    public Boolean IsHomeScreenVisible(){
        return isElementVisible(mapping.LOGO);
    }

}