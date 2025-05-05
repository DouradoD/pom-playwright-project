package com.example.setup;


import java.util.Arrays;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class DriverManager {
    static Browser browser;
    static Playwright playwright;

    public static Browser getBrowser() {
       return browser;
    }

    public static Browser initializeBrowser() {
        if (browser == null) {
            Playwright playwright = Playwright.create();
            browser = playwright.chromium().launch(getOptions());
            return browser;
        }
        return browser;
    }

    public static void closeBrowser() {
        if (browser != null) {
            browser.close();
            browser = null;
        }
    }

    public static void closePlaywright() {
        if (playwright != null) {
            playwright.close();;
        }
    }

    public static List<String> getArgs() {
        String argLine = System.getProperty("argLine", "");
        return argLine.isEmpty() ? List.of() : List.of(argLine.split(","));
    }

    public static  BrowserType.LaunchOptions getOptions() {
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
        options.setHeadless(false);
        options.setSlowMo(50);
        options.setIgnoreDefaultArgs(Arrays.asList("--enable-automation", "--disable-infobars"));
        options.setArgs(Arrays.asList("--start-maximized"));
        options.setTimeout(30000);
        return options;
    }
}