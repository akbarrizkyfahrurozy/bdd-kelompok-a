Feature: Form Authentication in the-internet.herokuapp.com

  Scenario: I want to login in the-internet.herokuapp.com
    Given I Open browser chromedriver
    And Open website the-internet.herokuapp.comm
    And Located on the-internet.herokuapp.comm
    When I click Form Authentication
    And Open Form Authentication
    Then Showing result related with Form Authentication