package com.example.setup;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;

public class TestContext {
        private PageManager pages;
        private BrowserContext context;
        public  Page page;
        private Browser browser;

    
    public TestContext() {
        browser = DriverManager.getBrowser();
        context = browser.newContext();
        page = context.newPage();
        // Initialize the PageManager with the WebDriver instance
    
        initializePages(page);
    }
    
    private void initializePages(Page page) {
        System.out.println("Initializing pages");
        pages = new PageManager(page);

    }
    
    // Getters for pages
    public PageManager getPages() { return pages; }
    public Browser getBrowser() { return browser; }
}
