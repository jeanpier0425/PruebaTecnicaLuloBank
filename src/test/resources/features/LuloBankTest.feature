Feature: Lulo Bank Api testing - Technical Test

  Scenario Outline: Get Users List
    Given the endpoint is prepared with <path>
    When  a request type get is executed
    Then  status <statusService>
    And validate status and message
      | status   | message   |
      | <status> | <message> |

    Examples:
      | path | statusService | status  | message |
      | user | 200           | success |         |