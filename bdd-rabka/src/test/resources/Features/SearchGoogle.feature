Feature: Search Google

  Scenario: I want to open the-internet.herokuapp.com
    Given I Open browser
    And Open website the-internet.herokuapp.com
    And Located on the-internet.herokuapp.com
    When I click "status-code"
    And Open status code
    Then Showing result related with "status-code"