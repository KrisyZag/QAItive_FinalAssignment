Feature: Sorting

  Scenario Outline: Sort by price appending
    Given I am on products page
    When I click sort by <by>
    Then I should see products sort by
    Examples:
      | by      |
      | rastuce |