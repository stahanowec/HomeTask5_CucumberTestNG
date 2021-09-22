Feature: Negative Testing of Feedback Page
  In order to receive from customer necessary estimation of new feedback form of seller
  User must check obligatory points on Feedback Page

  Background: Feedback page is opened
    Given User opens 'https://connect.ebay.com/srv/survey/a/feedback.profile' page

  Scenario: to try send feedback without point of value level
    And User clicks on Yes or No radiobutton in second point
    When User clicks on Send button
    Then Warning about necessary pointing of value level should be displayed


  Scenario: to try send feedback without point of Yes or No radiobutton
    And User clicks on value level in first point
    When User clicks on Send button
    Then Warning about necessary pointing Yes or No in second point should be displayed

  Scenario: to try send feedback only with text without other points
    And User clicks on textbox
    And User enter 'some' text
    When User clicks on Send button
    Then Warning about necessary pointing Yes or No in second point should be displayed
    And Warning about necessary pointing of value level should be displayed
