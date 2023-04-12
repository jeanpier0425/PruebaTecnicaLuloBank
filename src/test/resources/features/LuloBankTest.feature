Feature: Lulo Bank Api testing - Technical Test

  Scenario Outline: Get Users List
    Given the endpoint is prepared with <path>
    When  a request type get is executed
    Then  status <statusService>
    And validate <field> and in the response


    Examples:
      | path | statusService | field   |
      | user | 200           | success |

  Scenario Outline:Get user by id
    Given the endpoint is prepared with <path>/<id>
    When a request type get is executed
    Then status <statusService>
    And validate user
      | id   | firstName   | lastName   | email   | registerDate   | updatedDate   |
      | <id> | <firstName> | <lastName> | <email> | <registerDate> | <updatedDate> |

    Examples:
      | path | id | statusService | id                       | firstName | lastName | email                 | registerDate             | updatedDate              |
      | user | 1  | 200           | 6435beb929e65537a8aa5834 | Michael   | Page     | testpro@correo.com.co | 2023-04-11T20:10:33.937Z | 2023-04-11T20:13:33.441Z |

  Scenario Outline:Create user
    Given the endpoint is prepared with <path>
    When the service is type post with request <request>
    Then status <statusService>
    And validate create response type post

    Examples:
      | path        | request                                                                          | statusService |
      | user/create | {"firstName":"testName","lastName":"Myers","email":"testEmailPro@correo.com.co"} | 200           |


  Scenario Outline:Update user
    Given the endpoint is prepared with <path>/<id>
    When the service is type put with request <request>
    Then status <statusService>
    And validate update response type put

    Examples:
      | path | id                       | request                                        | statusService |
      | user | 6435beb929e65537a8aa5834 | {"firstName":"testNamePro","lastName":"Myers"} | 200           |

  Scenario Outline:Delete employee
    Given the endpoint is prepared with <path>/<id>
    When  the service is type delete
    Then status <statusService>
    And validate delete response with <id>

    Examples:
      | path   | id                       | statusService |
      | delete | 6435beb929e65537a8aa5834 | 200           |

