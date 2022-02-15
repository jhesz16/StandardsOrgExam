Feature: API Test for Standards Org
  Scenario: GET /current?lat={lat}&lon={lon}for values {lat} as 40.730610 and {lon} as -73.935242
    Given Lat as 40.730610 and Lon as -73.935242
    When User sends GET request
    Then It should parse the response and get the value of the "data/state_code"

  Scenario: GET /forecast/3hourly?postal_code={postal_code}
    Given Data for 3 hour forecast postal_code is "4102" and country is "ph"
    When User sends GET request
    Then It should parse the response and get the value of the timestamp_utc, weather for all the data entries