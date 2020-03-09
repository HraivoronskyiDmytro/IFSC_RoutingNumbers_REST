Feature: Routing Numbers Service

  Background:
    Given  User has "Routing Numbers" endpoint


  Scenario Outline: User can get the Bank name by routing number using POST or GET request
    And  User has valid Routing number
    When User make "<Method>" request
    Then Status code is "200"
    And Response matches by "RN-Valid.json" json scheme
    Examples:
      | Method |
      | GET    |
      | POST   |

  Scenario: User can get the Bank name by routing number in case of http GET protocol
    Given User set http protocol in endpoint
    And  User has valid Routing number
    When User make "GET" request
    Then Status code is "200"
    And Response matches by "RN-Valid.json" json scheme

  Scenario: User can get correct response if the mandatory "rn" parameter is missing
    When User make "GET" request
    Then Status code is "200"
    And Response matches by "RN-Missing.json" json scheme

  Scenario:  User can get correct response if routing number is invalid
    And  User set invalid Routing number
    When User make "GET" request
    Then Status code is "200"
    And Response matches by "RN-Invalid.json" json scheme

  Scenario Outline: User get 405 & Content Type text/html for all http methods except GET, POST & OPTIONS
    And  User has valid Routing number
    When User make "<Method>" request
    Then Status code is "405"
    And Content Type is "text/html"

    Examples:
      | Method |
      | DELETE |
      | PUT    |
      | PATCH  |
      | PUT    |


  Scenario Outline: Check that we have redirect in case of http protocol for all http methods except GET
    Given User set http protocol in endpoint
    And  User has valid Routing number
    When User make "<Method>" request
    Then Status code is "301"

    Examples:
      | Method  |
      | POST    |
      | DELETE  |
      | PUT     |
      | PATCH   |
      | OPTIONS |
      | PUT     |







