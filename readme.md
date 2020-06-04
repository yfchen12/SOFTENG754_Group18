# SOFTENG 754 Assignment 5 Group 18

## Table of Content
* [Technologies](#technologies)
* [Installation](#allure-2-installation)
* [Usage](#usage)


## Technologies
* Spring-boot: 2.3.0.RELEASE
* Maven: 3.6.1
* Java: 8
* Cucumber: 4.2.3
* Selenium: 3.13
* Allure 2

## Allure 2 Installation 
* Install Allure 2 on Windows, run `scoop install allure` in cmd.
* Install Allure 2 on Mac, run `brew install allure` in terminal.
* Manual installation refer to https://docs.qameta.io/allure/

## Usage
Open terminal/cmd, navigate to the project folder, run `mvn spring-boot:run` to start the application.

Open another terminal/cmd, navigate to the project folder, run `mvn clean test` to start the test.

When test complete, run `allure serve target/allure-results` to generate and host the report.
   