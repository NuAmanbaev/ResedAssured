Feature: user should be able to use tags
  @createTag
  Scenario Outline: verify user can create a tag
    Given base url "https://backend.cashwise.us/"
    When I provide valid authorization token
    And I provide "name_tag" with "<name_tag>"
    And I provide "description" with "<description>"
    And I hit POST endpoint "api/myaccount/tags"
    Then verify status code is 201
    And verify response body contains "name_tag" with "<name_tag>"
    And I retrieve id "id"
    And I hit DELETE endpoint "api/myaccount/tags/"
    Then verify status code is 200
    Examples:
      | name_tag | description           |
      | Nurgazwq | apple tag             |
      | Gazwwe   | short tag description |
      | Azwe     |                       |


  Scenario Outline: verify tag cannot be created without required field name_tag
    Given base url "https://backend.cashwise.us/"
    When I provide valid authorization token
    And I provide "name_tag" with "<name_tag>"
    And I provide "description" with "benas tag description"
    And I hit POST endpoint "api/myaccount/tags"
    Then verify status code is 400
    And verify response body contains "error" with "<error_message>"
    Examples:
      |name_tag| error_message    |
      |        | missing name_tag |
#      | null   | missing name_tag |
#      |#$BRB   | wrong name_tag, please make sure no digits and special chars are used |
#      |bena2   | wrong name_tag, please make sure no digits and special chars are used |
#      |extra long name tag | wrong name_tag, size limit is 25 chars|
#      |name with spaces| wrong name_tag, no spaces allowed |


  @workWithClient
    Scenario: verify user can create a client
    Given base url "https://backend.cashwise.us/"
    When I provide valid authorization token
    And I provide company name "API Company"
    And I provide client name "APIBEK"
    And I provide email "Api@gmail.com"
    And I provide phone number "3124385566"
    And I provide address "5455 N East River Road"
    And I retrieve id "id"
    Then verify status code is 201
