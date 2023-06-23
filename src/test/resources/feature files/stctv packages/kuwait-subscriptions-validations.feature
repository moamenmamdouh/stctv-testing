Feature: STCtv - Subscription packages validation
  As a Kuwait customer who wants to subscribe to STCtv
  I want to check available subscription packages
  So that I can decide what is suitable for me

  Background: Navigate to STCtv subscription page
    Given customer navigates to "Kuwait" subscription page

  Scenario Outline: Kuwait subscription packages validation
    When verify package "<name>"
    Then verify package "<name>" "<price>"
    And verify package "<name>" currency is "KWD"

    Examples:
      | name    | price |
      | lite    | 1.2   |
      | classic | 2.5   |
      | premium | 4.8   |