package com.example.setup;

import com.example.PageFactory;
import com.microsoft.playwright.*;

public class TestContext {
    private static final ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> browserContext = new ThreadLocal<>();
    private static final ThreadLocal<Page> playwrightPage = new ThreadLocal<>();
    private final PageFactory pageFactory;

    public TestContext() {
        initializePlaywrightResources();
        this.pageFactory = new PageFactory(playwrightPage.get());
    }

    private void initializePlaywrightResources() {
        playwright.set(Playwright.create());
        browser.set(playwright.get().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
        browserContext.set(browser.get().newContext());
        playwrightPage.set(browserContext.get().newPage());
    }

    public PageFactory getPages() {
        return pageFactory;
    }

    public void closeAndCleanUpLocalThreads() {
        if (playwrightPage.get() != null) {
            playwrightPage.get().close();
            playwrightPage.remove();
        }
        if (browserContext.get() != null) {
            browserContext.get().close();
            browserContext.remove();
        }
        if (browser.get() != null) {
            browser.get().close();
            browser.remove();
        }
        if (playwright.get() != null) {
            playwright.get().close();
            playwright.remove();
        }
    }
}
