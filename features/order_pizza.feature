Feature: Order pizza

  Scenario:
    Given the base price for a pizza is 5 €
    And the following toppings are available for ordering:
      | Basil    | 1 € |
      | Cheese   | 1 € |
      | Cucumber | 2 € |
      | Tomato   | 1 € |

    When I order a pizza with:
      | Cheese   |
      | Cucumber |

    Then the total price should be 8 €
