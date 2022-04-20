#Author: Islam Magdy

 Feature: GET COLOR LOVERS 
 @RestAssured
  Scenario Outline: GET numViews
    When user try to GET Correct URL
    Then user gets  total numviews to be greater than <number>
    
    Examples: 
    
    |number|
    |4000|
    
