Feature: To validate login functionality of amazon apllicatiom

  Scenario: To validate with valid username and invalid password
    Given To launch the browser and maximize the window
    When To launch the Amazon login page
    When To enter the  valid username in the email field
      | hari@gmail.com | priya@gmail.com | abc@gmail.com | oracle@gmail.com | java@gmail.com |
    When click the continue button
    When To enter the invalid password in the password field
      |  12456345 | Asdf@123 | 122@#!@   |
      | hastg123  | kgd89765 | 1245lje67 |
      | dadiad124 | 1245sdsd | sdh7872d@ |
    And click the signin button
    Then close the browser
