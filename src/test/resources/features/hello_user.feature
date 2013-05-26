Feature: Hello User

  Background: start up the application
    Given the application is running

  Scenario: When no last name entered
    When I enter "toto" as first name
    And I press the submit button
    Then it should see the greeting with "Hello toto"

  Scenario: When no first name entered
    When I enter "YOYO" as last name
    And I press the submit button
    Then it should see the greeting with "Hello YOYO"

  Scenario: When first name and last name empty
    When I leave the first name and last name fieds empty
    And I press the submit button
    Then it should see the greeting for the uknown person
