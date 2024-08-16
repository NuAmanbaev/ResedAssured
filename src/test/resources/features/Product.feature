@creatProduct
Feature: create a product

  Scenario: Validate the create a product endpoint
    Given user hits base url "https://backend.cashwise.us"
    When I provide valid authorization new  "token"
    And user provides catogories name "Nuasga"
    And user provides categories description "Nuraadsga"
    And user provides true flag
    Then user hits endpoint "/api/myaccount/categories"
    And user hits base url "https://backend.cashwise.us"
    And user provides product title
    And user provides price
    And user provides service type id
    And user provides category id
    And useur provides product description
    And user provides date of payment
    And user provides remind before date
    And user provides do remind every month "REPEAT_EVERY_MONTH"
    Then user hits endpoint with "/api/myaccount/products"
#





