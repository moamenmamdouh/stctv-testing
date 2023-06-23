Feature: STCtv - Subscription packages validation
  As a Bahrain customer who wants to subscribe to STCtv
  I want to check available subscription packages
  So that I can decide what is suitable for me

  Background: Navigate to STCtv subscription page
    Given customer navigates to "Bahrain" subscription page

  Scenario Outline: Bahrain subscription packages validation
    When verify package "<name>"
    Then verify package "<name>" "<price>"
    And verify package "<name>" currency is "BHD"

    Examples:
      | name    | price |
      | lite    | 2     |
      | classic | 3     |
      | premium | 6     |