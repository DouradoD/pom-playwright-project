package com.example;

import com.example.base.BasePage;
import com.example.helpers.StringHelper;
import com.example.pages.*;
import com.microsoft.playwright.Page;

import io.cucumber.core.logging.Logger;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.WeakHashMap;

public class PageFactory {
    // Thread-local storage for page instances
    private final ThreadLocal<Map<Class<?>, Object>> pageCache = ThreadLocal.withInitial(WeakHashMap::new);

    // Shared immutable fields
    private final String projectName;
    private final Page page;

    public PageFactory(Page page) {

        this.page = page;

        // Initialize project name with thread-safe resolution
        String project = System.getProperty("project");
        if (project == null || project.isEmpty()) {
            project = System.getenv("project");
        }
        this.projectName = (project != null) ? project : "";
    }

    @SuppressWarnings("unchecked")
    public <T extends BasePage> T getPage(Class<T> pageClass) {
        // Check if we already have an instance for this thread
        if (pageCache.get().containsKey(pageClass)) {
            return (T) pageCache.get().get(pageClass);
        }

        // Synchronize on the class object to prevent duplicate creation
        synchronized (pageClass) {
            // Double-check after synchronization
            if (pageCache.get().containsKey(pageClass)) {
                return (T) pageCache.get().get(pageClass);
            }

            T instance = createPageInstance(pageClass);
            pageCache.get().put(pageClass, instance);
            return instance;
        }
    }

    @SuppressWarnings("unchecked")
    private <T extends BasePage> T createPageInstance(Class<T> pageClass) {
        try {
            // Try project-specific implementation first
            if (!projectName.isEmpty()) {
                String customClassName = buildCustomClassName(pageClass);
                try {
                    Class<?> customClass = Class.forName(customClassName);
                    Constructor<?> constructor = customClass.getConstructor(Page.class, String.class);

                    T instance = (T) constructor.newInstance(page, projectName);

                    System.out.println("Created custom page: " + customClassName);
                    return instance;
                } catch (ClassNotFoundException e) {
                    System.out.println("Custom page not found: " + customClassName + ", falling back to default");
                }
            }

            // Default implementation
            Constructor<T> constructor = pageClass.getConstructor(
                    Page.class, String.class);

            T instance = constructor.newInstance(page, projectName);

            System.out.println("Created default page:" + pageClass.getName());
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create page instance: " + pageClass.getSimpleName(), e);
        }
    }

    private String buildCustomClassName(Class<?> pageClass) {
        String defaultPackage = pageClass.getPackage().getName();
        return defaultPackage + "." + projectName.toLowerCase() + "." +
                pageClass.getSimpleName() + StringHelper.capitalizeString(projectName);
    }

    public void cleanup() {
        // Clear the cache for the current thread
        pageCache.get().clear();
        System.out.println("Cleared page cache for thread "+ Thread.currentThread().getName());
    }

    public void remove() {
        pageCache.remove();
    }
}
