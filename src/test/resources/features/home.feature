Feature: Google Search
  Scenario: Search for a term on Google
    Given the user opens the Google URL
    When he inputs a "Playwright" value
    Then the "Playwright" value input should be inside the field