package com.example.pages.projectone;

import com.example.LocatorLoader;
import com.example.base.BasePage;
import com.example.locators.HomeLocators;
import com.example.pages.HomePage;
import com.microsoft.playwright.Page;


public class HomePageProjectone extends HomePage {
    private HomeLocators locator;
    public HomePageProjectone(Page page, String projectName) {
        super(page, projectName);
        this.locator = LocatorLoader.getLocators(HomeLocators.class, projectName);
    }
    
    public void searchFor(String term) {
        System.out.println("[SubClass] HomePageProjectone Class: Searching for: " + term);
        page.fill(locator.SEARCH_FIELD_INPUT, term);
    }
}