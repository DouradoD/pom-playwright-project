package com.example.base;

import com.microsoft.playwright.Page;

public class BasePage {
        protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public boolean isElementVisible(String selector) {
        return page.locator(selector).isVisible();
    }

    public void clickElement(String selector) {
        page.locator(selector).click();
    }

    public String getText(String selector) {
        return page.locator(selector).textContent();
    }
}
