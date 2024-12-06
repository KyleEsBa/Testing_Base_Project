# <p style="text-align: center;">Java Test Automation Framework</p>
This Java based Test Automation Framework is designed for scalability, maintainability, and ease of use. 
It follows conventions and structured design patterns that supports Gherkin language for writing user friendly, 
test scenarios. Built with widely supported open source tools, it ensures reliability and flexibility 
for diverse testing needs.

## Purpose
Implementation of automated test scripts

## Features
- Automated execution of test cases.
- Supports multiple test environments.
- Generates detailed test reports, logs and screenshots.
- Modular and scalable.
- Supports Gherkin language.

## Project Structure
```plaintext
├── src/test/
│   ├── java/com/test/
│   │   ├── step_definition/        # Test steps
│   │   ├── pages/                  # Page Object Models
│   │   ├── utilities/              # Customized methods
│   │   ├── runner/                 # Run configurations              
│   ├── resources/features/         # Test Scenarios
├── target                          # Test execution reports + temporal files
├── pom.xml                         # Dependencies
├── Configuration.properties        # Configuration files
```
## Stack of tools
- Selenium
- JUnit
- Cucumber
- Maven

## Design patterns
- Singleton
- Page Object Model
- DDT (Data Driven Testing)
- BDD (Behavioral Driven Development)

## Pre requirements
- JDK 11 to above

## Installation
1. Clone the repository
2. Reload the pom.xml to get the dependencies

## Execution of tests
1. Change the config of the Configuration.properties (the URL of the page to test)
2. Write a Gherkin scenario on a .feature file under resources/features (optional: define a tag over the scenario e.g. @regression)
3. On the CukesRunner class change the value of dryRun = true (if a new tag was made update the value of the tag parameter e.g. @regression)
4. Execute to generate the snippets
5. Generate a class to paste the snippets and implement the test steps
6. Set the locators of the test in a page class
7. Execute on the CukesRunner class


***Happy Testing!***