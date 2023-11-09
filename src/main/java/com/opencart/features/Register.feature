@run
Feature: Register Flow Test Suite

  Background:
    Given "/index.php?route=account/register&language=en-gb" endpoint is accessed

  Scenario: Register Page can be accessed from the Home Page
    Given "/" endpoint is accessed
    When registerLink from Header menu is clicked
    Then the current Url contains "route=account/register" keyword

  Scenario: The Account Page URL is opened when the registration is successful
    When the register form is populated with valid random data
    And Continue button is clicked
    Then the current Url contains "route=account/success" keyword

  Scenario: User remains on registerPage when the continue button is not Clicked
    When the register form is populated with valid random data
    Then the current Url contains "route=account/register" keyword

  @run
  Scenario: An error message is displayed when invalid First Name is used for Register Flow
    Given "/index.php?route=account/register&language=en-gb" endpoint is accessed
    When the Register Form is populated with the following data:
      | firstName | 1234567468461646156845616546546461165455555555555454 |
      | lastName  | Secu                                                 |
      | email     | andrei.s3c22u@gmail.com                              |
      | password  | Andrei123!                                           |
    And Continue button is clicked
    Then the following list of error messages is displayed:
      | First Name must be between 1 and 32 characters! |

  @run
  Scenario Outline: An error message is displayed when invalid <impacted attribute> is used for Register Flow
    Given "/index.php?route=account/register" endpoint is accessed
    When the Register Form is populated with the following data:
      | firstName | <firstName>    |
      | lastName  | <lastName>     |
      | email     | <emailData>    |
      | password  | <passwordData> |
    And Continue button is clicked
    Then the following list of error messages is displayed:
      | <impacted attribute> must be between 1 and 32 characters! |
    Examples:
      | impacted attribute | firstName                                        | lastName                                    | emailData | passwordData |
      | First Name         | 15165464653464654654654645556464546546466464     | Random                                      | Random    | Random       |
      | Last Name          | Andrei                                           | 54646jklj5464hhhhhhhhhhhhhhhhhggggf56454646 | Random    | Random       |
      | First Name         | 15165464653464654654654645556464546546466464     | Random                                      | Random    | Random       |
      | Last Name          | Andrei                                           | 54646jklj5464hhhhhhhhhhhhhhhhhggggf56454646 | Random    | Random       |
      | First Name         | 15165fdfg464653464654654654645556464546546466464 | Random                                      | Random    | Random       |
      | Last Name          | Andrei                                           | 54646jklj5464hhhhhhhhhhhhhhhhhggggf56454646 | Random    | Random       |
      | First Name         | 15165464653464654654654645556464546546466464     | Random                                      | Random    | Random       |
      | Last Name          | Andrei                                           | 54646jklj5464hhhhhhhhhhhhhhhhhggggf56454646 | Random    | Random       |
      | First Name         | 15165464653464654654654645556464546546466464     | Random                                      | Random    | Random       |
      | Last Name          | Andrei                                           | 54646jklj5464hhhhhhhhhhhhhhhhhggggf56454646 | Random    | Random       |
