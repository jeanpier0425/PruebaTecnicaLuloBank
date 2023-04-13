Feature: Lulo Bank Api testing - Technical Test

  @GetList
    @HappyPath
  Scenario Outline: Get Users List
    Given the endpoint is prepared with <path>
    When  a request type get is executed
    Then  status <statusService>
    And validate <field> and in the response

    Examples:
      | path | statusService | field |
      | user | 200           | total |

  @GetUserById
    @HappyPath
  Scenario Outline:Get user by id
    Given the endpoint is prepared with <path>/<id>
    When a request type get is executed
    Then status <statusService>
    And validate user
      | id   | firstName   | lastName   | email   | registerDate   | updatedDate   |
      | <id> | <firstName> | <lastName> | <email> | <registerDate> | <updatedDate> |

    Examples:
      | path | statusService | id                       | firstName | lastName | email                           | registerDate             | updatedDate              |
      | user | 200           | 64378477965c6daf8813a3f7 | Albert    | thrump   | testautomationpro@correo.com.co | 2023-04-13T04:26:31.125Z | 2023-04-13T04:26:31.125Z |

  @CreateUser
    @HappyPath
  Scenario Outline:Create user
    Given the endpoint is prepared with <path>
    When the service is type post with request <request>
    Then status <statusService>
    And validate create response type post

    Examples:
      | path        | request                                                                                      | statusService |
      | user/create | {"firstName":"testAutoNewName","lastName":"Cruise","email":"testEmailNewAuto@correo.com.co"} | 200           |


  @UpdateUser
    @HappyPath
  Scenario Outline:Update user
    Given the endpoint is prepared with <path>/<id>
    When the service is type put with request <request>
    Then status <statusService>
    And validate update response type put

    Examples:
      | path | id                       | request                                            | statusService |
      | user | 64378477965c6daf8813a3f7 | {"firstName":"testNameProAd","lastName":"Myers J"} | 200           |

  @DeleteUserById
    @HappyPath
  Scenario Outline:Delete user
    Given the endpoint is prepared with <path>/<id>
    When  the service is type delete
    Then status <statusService>
    And validate delete response with <id>

    Examples:
      | path | id                       | statusService |
      | user | 6435beb929e65537a8aa5834 | 200           |

  @UnHappyPath
    @unhappyAppId
  Scenario Outline: Unhappy tests for AppId
    Given the endpoint is prepared with <path>/<id>
    When a wrong request <typeErrorKey>
    Then status <statusService>
    And validate error message with <messageError>


    Examples:
      | path | statusService | id                       | typeErrorKey | messageError     |
      | user | 403           | 6435beb929e65537a8aa5834 | NOT_EXIST    | APP_ID_NOT_EXIST |
      | user | 403           | 6435beb929e65537a8aa5834 | KEY_MISSING  | APP_ID_MISSING   |

  @UnHappyPath
    @parameternotvalid
  Scenario Outline: Parameters not valid by id
    Given the endpoint is prepared with <path>/<id>
    When a request type get is executed
    Then status <statusService>
    And validate error message with <messageError>


    Examples:
      | path | statusService | id          | messageError     |
      | user | 400           | notvalid741 | PARAMS_NOT_VALID |

  @UnHappyPath
    @bodyNotValid
  Scenario Outline: Body not valid
    Given the endpoint is prepared with <path>
    When the service is type post with request <request>
    Then status <statusService>
    And validate error message with <messageError>

    Examples:
      | path        | request                                                                                       | statusService | messageError   |
      | user/create | {"firstName":"testNewName","nickname":"Obama","email":"testEmailNew@correo.com.co","age":200} | 400           | BODY_NOT_VALID |
