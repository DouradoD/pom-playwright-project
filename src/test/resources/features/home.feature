Feature: Access the Selenium initial Screen

    @smoke
    Scenario: Access the Selenium initial Screen - Smoke
        When he accesses the URL "https://www.selenium.dev/"
        Then he should see the title "SeleniumHQ Browser Automation"
    
    
    @regression
    Scenario: Access the Selenium initial Screen - Regression
        When he accesses the URL "https://www.selenium.dev/"
        Then he should see the title "SeleniumHQ Browser Automation"

    @test
    Scenario: Access the Selenium initial Screen - Tets
        When he accesses the URL "https://www.selenium.dev/"
        Then he should see the title "SeleniumHQ Browser Automation"