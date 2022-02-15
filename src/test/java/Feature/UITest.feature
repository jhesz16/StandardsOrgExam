@Feature
Feature: UI Test for Standards Org
  Scenario:Submit a Call Back form
    Given The user go to Nab Website
    And User to view all home loans
    And User Requests a call back
    And User clicks New Home Loans
    And user click Next for first form
    And User is Buying a property
    And user click Next for second form
    When User fills up the call back form with valid data
    Then User should be able to submit the form
    And Received page should be displayed
