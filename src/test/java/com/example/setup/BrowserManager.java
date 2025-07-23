package com.example.setup;


public class BrowserManager {
    private static final ThreadLocal<TestContext> testContext = new ThreadLocal<>();

    public static void initialize() {
        testContext.set(new TestContext());
    }

    public static TestContext getTestContext() {
        return testContext.get();
    }

    public static void close() {
        if (testContext.get() != null) {
            testContext.get().closeAndCleanUpLocalThreads();
            testContext.remove();
        }
    }
}