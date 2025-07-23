package com.example.pages;

import com.example.LocatorLoader;
import com.example.base.BasePage;
import com.example.locators.HomeLocators;
import com.microsoft.playwright.Page;


public class HomePage extends BasePage {
    private HomeLocators locator;
    public HomePage(Page page, String projectName) {
        super(page);
        this.locator = LocatorLoader.getLocators(HomeLocators.class, projectName);
    }
    
    public void navigateToGoogle() {
        page.navigate("https://www.google.com");
    }
    
    public void searchFor(String term) {
        System.out.println("[SuperClass] HomePage Class: Searching for: " + term);
        page.fill(locator.SEARCH_FIELD_INPUT, term);
    }
    
    public String getSearchFieldValue() {
        System.out.println(locator.getClass().getSimpleName() + " - SEARCH_FIELD_INPUT: " + locator.SEARCH_FIELD_INPUT);
        return page.inputValue(locator.SEARCH_FIELD_INPUT);
    }
}