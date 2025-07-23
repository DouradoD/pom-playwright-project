package com.example.runner;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.core.cli.Main;

public class DebugRunner {


    public static void main(String[] args) {
        // Set System Properties directly (equivalent to Surefire systemPropertyVariables)
        System.setProperty("project", "projectone");
        System.setProperty("executionMode", "local");
        // IMPORTANT: Set Allure results directory. This is how Allure knows where to write its files.
        // This must match what you configure in allure-maven plugin.
        // It's usually target/allure-results
        //System.setProperty("allure.results.directory", "target/allure-results");




        List<String> cucumberArgs = new ArrayList<>();


        // Glue path (equivalent to GLUE_PROPERTY_NAME)
        cucumberArgs.add("--glue");
        cucumberArgs.add("com.example.stepdefinitions");


        // Plugins (equivalent to PLUGIN_PROPERTY_NAME)
        cucumberArgs.add("--plugin");
        cucumberArgs.add("pretty");
        cucumberArgs.add("--plugin");
        cucumberArgs.add("html:tmp/reports/cucumber-report.html");
        // Add the Allure Cucumber JVM plugin
        //cucumberArgs.add("--plugin");
        //cucumberArgs.add("io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm");
        // Set plugin.publish.quiet to true if you don't want the publish message
        //cucumberArgs.add("--plugin");
        //cucumberArgs.add("message:target/cucumber-messages.ndjson"); // Recommended for Allure, captures more data




        // Parallel execution (equivalent to PARALLEL_EXECUTION_ENABLED_PROPERTY_NAME etc.)
        // Note: For Main.run, --threads refers to parallel scenario execution
        cucumberArgs.add("--threads");
        cucumberArgs.add("1"); // Set to 4 threads as per your JUnit Platform runner


        // Tags (equivalent to FILTER_TAGS_PROPERTY_NAME)
        // If you want to filter specific tags, uncomment and set the value
        //cucumberArgs.add("--tags");
        //cucumberArgs.add("@reports");
        // If you want to run all tests, remove or comment out the --tags line, or leave as empty string "" if used as a parameter


        // Feature path (equivalent to SelectClasspathResource)
        cucumberArgs.add("classpath:features");


        // Convert the list of arguments to an array and run Cucumber Main
        String[] argsArray = cucumberArgs.toArray(new String[0]);
        Main.run(argsArray);
    }
}
