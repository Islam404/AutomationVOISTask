#Author: Islam Magdy

 Feature: Registration 
 @Selenium
  Scenario Outline: Register User
    When user click on sign in to start Registration process
    And Provide valid <Email> to start the signup process
    Then SignUp Page is loaded 
    And User Fill All The manadatory fields in the signup page like <firstName>, <lastName>, <password>, <adress>, <adressLastName>, <adressLine>, <city>, <state>, <zipCode>, <country>, <phone>, <adress2>
    Then Validate for Welcome Text Message 
    Then select blouse from women section
    Then user proceed to checkout
    Then Validate the reference is the same reference from checkout page
Examples: 

| Email         |firstName | lastName  | password  | adress  |  adressLastName  |  adressLine  |   city   |   state   |   zipCode   |  country      |  phone  |  adress2  |
|Islam|  Islam   |   Magdy   | abcdef    | Islam   |      Magdy       |   adressline | City     |   Alaska  |   12345    |United States  | 123456  | adress    |
     
      
