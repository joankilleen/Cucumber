Feature: Checkout

  Scenario Outline: Checkout bananas
    Given the price of a "banana" is 40c 
    When I checkout <count> "banana"
    Then the total price should be <total>c

    Examples:
    | count | total | 
    | 1     | 40    | 
    | 2     | 80    |
    | 10    | 400   |
    
  
  Scenario: A banana and an apple
    Given the price of a "banana" is 40c 
    And the price of a "apple" is 25c 
    When I checkout 1 "banana"65
    And I checkout 1 "apple"
    Then the total price should be c

    