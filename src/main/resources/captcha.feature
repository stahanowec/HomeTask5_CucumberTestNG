Feature: Captcha Functionality
  In order to test correct performance protection from bot
  I want to check the existence of captcha

  Scenario: to try sign in via automated program
    Given User opens 'https://www.ebay.com/' page
    When User clicks on text: Sign in
    Then User checks visibility of captcha