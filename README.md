<!-- Just fill in the brackets -->
# Magento Automation Test Framework


This is a **Selenium + Java + Cucumber + TestNG** automation framework
designed to test the [Magento demo website](https://magento.softwaretestingboard.com/). 
It supports both desktop and mobile execution

Tech Stack
-----------

- Java 17.0.11
- Maven 3.9.9 (Build & dependencies)
- Cucumber (BDD) and report
- TestNG (Runer)
- WebDriverManager

Features
--------

- Tests placing an order and completing the shipping process
- Page Object Model (POM) structure

## Run tests 
 - all test run in cmd : mvn clean test
- To run a specific test add the tag to the test scenario and run in cmd  mvn clean test "-Dcucumber.filter.tags=<tag>" ( mvn clean test "-Dcucumber.filter.tags=@regression")       
   
