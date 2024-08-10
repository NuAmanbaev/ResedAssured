@GetAllClietns
  Feature: getting a clients

    Scenario:
      Given user hits base url "https://backend.cashwise.us"
      When user hits get all clients with endpoint "/api/myaccount/clients"
      Then user validates that status code is 200
      Then user validates that list is not empty
