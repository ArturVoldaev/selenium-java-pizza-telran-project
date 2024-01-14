# Selenium Java Pizza Telran Project

Welcome to the Selenium Java Pizza Telran Project! This project serves as a demonstration of Selenium WebDriver and Java
for automated and API testing of a pizza ordering. [The link to web application](http://pizza.telran-edu.de:2222)  .

## Overview

This Selenium Java project showcases the implementation of automated tests for interacting with a pizza ordering website. It utilizes the Selenium WebDriver library along with Java and TestNG for test automation.

## Features

- **Selenium WebDriver:** Harness the power of Selenium to automate web interactions.
- **TestNG:** Leverage TestNG for structured and efficient test management.
- **Page Object Model (POM):** Implement a scalable and maintainable test structure.
- **Logging (Log4j):** Capture and organize detailed logs for better debugging.

## Getting Started

Follow the instructions in the [**Getting Started section**](#getting-started) of the [**README.md**](./README.md) file to clone the repository, set up the project, and run the automated tests.

## Project Structure

The project is organized to promote readability, maintainability, and scalability. The main components include:

- **src/main/java:** Java source code for the project.
- **src/main/resources:** Configuration files and resources.
- **src/test/java:** Test source code for automated scenarios.
- **target:** Compiled code and test reports.

## How to Run Tests

Execute the automated tests using Maven with the following command:

```bash
mvn test
```

Run tests with specific browser. Chrome and Edge browsers are availiable as an option (chrome or edge). 

```bash
mvn test -Dbrowser=firefox 
```

## How to serve report after tests?

1.You can generate a report using one of the following command:
```bash
mvn allure:report
```

2.Report will be generated into temp folder. Web server with results will start.
```bash
mvn allure:serve
```

## Configuration

Customize the project settings and test configurations by modifying the files in the `src/main/resources` directory.

## Test Cases
The Test cases are hold on this [link](https://docs.google.com/spreadsheets/d/1PkvqTf8GQZ8JwaInG-lv_mVugR7i5nDd/edit?usp=sharing&ouid=109249197436436788411&rtpof=true&sd=true)

## Bug Reports
The bug reports are hold on this [link](https://docs.google.com/spreadsheets/d/14K9v5ff9GZGnVQt63JmJySNuo5f7vcGj/edit?usp=sharing&ouid=109249197436436788411&rtpof=true&sd=true)

## Contributing

Contributions, bug reports, and feature requests are welcome! Feel free to open issues and submit pull requests to improve this project.
