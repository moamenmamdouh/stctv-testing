Feature: STCtv - Subscription packages validation
  As a customer who wants to subscribe to STCtv
  I want to check available subscription packages
  So that I can decide what is suitable for me

  Background: Navigate to STCtv subscription page
    Given customer navigates to STCtv subscription page

  Scenario Outline: KSA subscription packages validation
    When customer navigates to "KSA" subscription page
    Then verify package "<name>"
    And verify package "<name>" "<price>"
    And verify package "<name>" currency is "SAR"

    Examples:
    | name    | price |
    | lite    | 15    |
    | classic | 25    |
    | premium | 60    |

  Scenario Outline: Kuwait subscription packages validation
    When customer navigates to "Kuwait" subscription page
    Then verify package "<name>"
    And verify package "<name>" "<price>"
    And verify package "<name>" currency is "KWD"

    Examples:
      | name    | price |
      | lite    | 1.2   |
      | classic | 2.5   |
      | premium | 4.8   |

  Scenario Outline: Bahrain subscription packages validation
    When customer navigates to "Bahrain" subscription page
    Then verify package "<name>"
    And verify package "<name>" "<price>"
    And verify package "<name>" currency is "BHD"

    Examples:
      | name    | price |
      | lite    | 2     |
      | classic | 3     |
      | premium | 6     |
