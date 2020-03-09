Feature: IFSC Service

  Background:
    Given  User has "IFSC" endpoint

  Scenario: User can get the Bank information using valid endpoint & valid IFSC code.
    Given  User has valid IFSC code
    When User make "GET" request
    Then Status code is "200"
    And Content Type is "application/json"
    And Response matches by "IFSC.json" json scheme

  Scenario: User can get the HTML page when IFSC code is not specified
    When User make "GET" request
    Then Status code is "200"
    And Content Type is "text/html;charset=utf-8"

  Scenario: User can get Not Found message & 404 response code when IFSC code is invalid
    Given  User set invalid IFSC code
    When User make "GET" request
    Then Status code is "404"
    And Content Type is "application/json"
    And Request body is "\"Not Found\""

  Scenario Outline: User get 404 response & html Content Type (HTML page) for all http methods except GET
    Given  User has "IFSC" endpoint
    And  User has valid IFSC code
    When User make "<Method>" request
    Then Status code is "404"
    And Content Type is "text/html;charset=utf-8"

    Examples:
      | Method  |
      | POST    |
      | DELETE  |
      | PUT     |
      | PATCH   |
      | OPTIONS |
      | PUT     |


  Scenario Outline: Check that we have redirect in case of HTTP protocol for all HTTP methods except GET
    Given User set http protocol in endpoint
    And  User has valid IFSC code
    When User make "<Method>" request
    Then Status code is "301"
    And Content Type is "text/html"

    Examples:
      | Method  |
      | POST    |
      | DELETE  |
      | PUT     |
      | PATCH   |
      | OPTIONS |
      | PUT     |

  Scenario: User can get the Bank information by HTTP, using valid endpoint & valid IFSC code .
    Given User set http protocol in endpoint
    And  User has valid IFSC code
    When User make "GET" request
    Then Status code is "200"
    And Content Type is "application/json"
    And Response matches by "IFSC.json" json scheme
