Feature: Get Wheater data

  Scenario: Get Current Wheater data
    Given Get current wheater with valid parameter
    When Send request current wheater data
    Then Should return status code 200 OK
    And Validate json schema current wheater data

  Scenario: Get forecast hourly data
    Given Get forecast hourly wheater with valid parameter
    When Send request forecast hourly data
    Then Should return status code 200 OK
    And Validate json schema forecast hourly data