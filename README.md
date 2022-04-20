# VOIS Automation Testing Task


## Installation
```maven
mvn clean install
```
## Run

### Automation RestAssured Project
```java
Go to src/test/java/cucumberOptions/RestAssuredRunner.java Run as TestNg.
```

### Automation Selenium Project
```java
Go to src/test/java/cucumberOptions/TestRunner.java Run as TestNg.
```

## Project Description:

### restAssuredTask:
“Create a cucumber BDD solution utilising RestAssured framework to accomplish the following. 
“Make a GET request to colourlovers api http://www.colourlovers.com/api/patterns and write an assertion for <numViews> (from response) to be greater than 4000” 

### AutomationTask:
 implementation for Automation Task 
I Covered the high level scenarios to achieve the below 
1.	Create a new account user
2.	Authenticate as new user
3.	Select “Blouses” Subcategory in “Women” Category
4.	Select resulted product
5.	Follow checkout procedure
6.	Confirm order by selecting bank wire option
7.	Validate order was placed from order history page.



## Author
Islam Magdy