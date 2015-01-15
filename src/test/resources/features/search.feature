Feature: As a viewer of the BBC webpage I should be able to search for news on the opening page

  @webdriver
  Scenario: Search for news on the main page
    Given I am on the BBC main page
    Then I can see the terms and conditions link in the footer
    When I search for "London"
    Then I can see results on the search page