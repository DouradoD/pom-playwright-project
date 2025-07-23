Feature: Google Search
  Scenario Outline: Search for a term on Google
    Given the user opens the Google URL
    When he inputs a "<value>" value
    Then the "<value>" value input should be inside the field
    Examples:
      | value       |
      | Playwright  |
      | Cucumber    |
      | Java        |
      | Selenium    |
      | TestNG      |
      | JUnit       |
      | Allure      |
      | Maven       |
      | Gradle      |
      | IntelliJ    |
      | Eclipse     |
      | Visual Studio Code |
      | NetBeans    |
      | Atom        |
      | Sublime Text |
      | Notepad++   |
      | Vim         |   