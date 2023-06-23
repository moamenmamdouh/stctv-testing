Feature: STCtv - Subscription packages validation
  As a customer who wants to subscribe to STCtv
  I want to check available subscription packages
  So that I can decide what is suitable for me

  Background: Navigate to STCtv subscription page
    Given customer navigates to "KSA" subscription page

  Scenario Outline: KSA subscription packages validation
    When verify package "<name>"
    Then verify package "<name>" "<price>"
    And verify package "<name>" currency is "SAR"

    Examples:
    | name    | price |
    | lite    | 15    |
    | classic | 25    |
    | premium | 60    |