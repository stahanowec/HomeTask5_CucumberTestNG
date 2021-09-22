Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check correct work of search functionality
    Given User opens '<homePage>' page
    And User checks visibility of search field
    And User checks visibility of search button
    When User type '<keyword>' in search field
    And User clicks search button
    Then User checks that all products in search results page contain '<keyword>'
    And User checks that URL contains '<keyword>'

    Examples:
      |       homePage      |keyword|
      |https://www.ebay.com/|iphone |
      |https://www.ebay.com/|ipad   |
      |https://www.ebay.com/|redmi  |

  Scenario Outline: Check add product to cart
    Given User opens '<homePage>' page
    And User checks cart icon visibility
    When User type '<keyword>' in search field
    And User clicks search button
    And User clicks on first product
    And User clicks Add to Cart button in product page
    Then User checks that amount of products in cart are '<amountOfProducts>'

    Examples:
      |      homePage       |keyword|amountOfProducts|
      |https://www.ebay.com/|ipad   |        1       |
      |https://www.ebay.com/|iphone |        1       |

  Scenario: Check site main functions
    Given User opens 'https://www.ebay.com/' page
    And User checks visibility of header
    And User checks visibility of footer
    And User checks visibility of search field
    And User checks visibility of search button
    And User checks cart icon visibility
    When User clicks catalog of category
    Then User checks visibility of catalog