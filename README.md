# API Automation Project

## Overview

This project is designed to automate testing of the ReqRes API using Rest Assured and TestNG. Allure is used for
generating detailed test reports.

## Prerequisites

- Java JDK 17 or higher
- Maven
- Internet connection to download dependencies

## Setup Instructions

1. **Clone the Repository**:
    ```sh
    git clone https://github.com/KareemZafan/cyshield-api-automation-task
    cd cyshield-api-automation-task
    ```

2. **Run Tests**:
    ```sh
    mvn clean -DxmlFile=testng.xml test
    ```

3. **Generate Allure Report**:
    ```sh
      allure generate --clean
    ```

4. **Open Allure Report**:
    ```sh
      allure open 
    ```

## Project Structure

- `pom.xml`: Maven configuration file with dependencies.
- `testng.xml`: TestNG configuration file.
- `src/main/java/base_specs`: Contains pre-requisites for sending api requests such as URI, some headers.
- `src/main/java/config`: Contains constants such requests' endpoints and some generic variables can be shared across services.
- `src/test/java/user_crud_integeration_tests`: Contains test cases for the APIs.
- `src/main/java/services/user_cruds`: Contains requests for apis such crud operations requests.
- `Readme.txt`: Instructions on how to set up and run the project.

## Test Cases

1. **List Users**: Validates the user listing on page 2.
2. **Create User**: Tests the creation of a new user.
3. **Update User**: Tests updating an existing user.

## Reports

Allure is used to generate detailed reports. Follow the setup instructions to generate and view the report.
