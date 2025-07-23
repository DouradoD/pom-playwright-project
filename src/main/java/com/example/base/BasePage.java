package com.example.base;

import com.microsoft.playwright.Page;

public abstract class BasePage {
    protected final Page page;
    
    public BasePage(Page page) {
        this.page = page;
    }
    
    // Common page methods can go here
}
    
