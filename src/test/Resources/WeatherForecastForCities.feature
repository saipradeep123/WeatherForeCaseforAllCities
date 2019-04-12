@validateWeatherForeCast
Feature: Validating weather forecast for different cities

  Scenario Outline: I check the different weather forecast factors in ui
    Then I enter city name "<city>" in application
    Then I validate all the weatherforecast factors displayed in ui

    Examples:
      |  Browser          |   url                       |city         |
      |       chrome      |http://localhost:3000/       |  aberdeen   |
      |       chrome      |http://localhost:3000/       |  dundee   |
      |       chrome      |http://localhost:3000/       |  edinburgh   |
      |       chrome      |http://localhost:3000/       |  glasgow   |
      |       chrome      |http://localhost:3000/       |  perth     |
      |       chrome      |http://localhost:3000/       |  stirling   |


