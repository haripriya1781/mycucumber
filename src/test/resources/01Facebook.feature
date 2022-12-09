Feature: To validate the Login functionality in fb application
Background:
Given user has to launch the chrome bowser and max the window


  Scenario: To Validate with invalid username and invalid pasword
    
    When user has to launch the fb application in browser
    When user has to enter invalid username in email field
    When user has to enter invalid password in password field
    When user has to click the login button
    Then user has to close the browser

  Scenario Outline: To Validate with positive and negative combination
   
    When user has to launch the url
    When user has to enter  username "<emailfield>"in email field
    When user has to enter  password in password field"<passfield>"
    When  click the login button
    Then  close the browser

    Examples: 
      | emailfield       | passfield |
      | abc@gmail.com    | j12vcgjh  |
      | java@gmail.com   | hgy152jgh |
      | python@gmail.com | 1vhvc25   |
      | sql@gmail.com    | ghfgz14   |
