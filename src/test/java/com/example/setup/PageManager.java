package com.example.setup;

import com.example.pages.HomePage;
import com.microsoft.playwright.Page;

public class PageManager {
    // Define the WebDriver instance
    private Page page;

    // Define the pages
    private HomePage home;
    // Other pages...

    // Constructor now expects a WebDriver
    public PageManager(Page page) {
        this.page = page;
        initializePages();
    }

    private void initializePages() {
        home = new HomePage(this.page);
        // Initialize other pages...
    }

    // Getters for pages
    public HomePage getHome() { return home; }
    // Other getters for other pages...
}
