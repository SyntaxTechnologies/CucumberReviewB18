Feature:Login Functionality

  Background:
    Given the user navigate to the website

  Scenario: the user is able to log in the SyntaxHRMS Application with correct credentials
    When user enters the username and password
    And clicks on login Button
    Then the user is logged in


@smoke
  Scenario: the user is not able to login with incorrect credentials
    When user enters the incorrect username and password
    And clicks on login Button
    Then the user is not logged

  Scenario: the user is able to login using correct credentials
    When user enters the username "Admin" and the password "Hum@nhrm123"
    And user clicks login Button
    Then the user sees the message "Welcome Admin"


    Scenario Outline: login With incorrect Credentials
      When the user enters the username "<username>"  and the password "<password>"
      And user clicks login Button
      Then the user sees the error message "<errorMessage>"
      Examples:
      | username | password | errorMessage |
      |admin     |vnddd     |Invalid credentialsp|
      |vvnnfnf   |Hum@nhrm123|Invalid credentials|
      |          |Hum@nhrm123|Username cannot be empty|
      |admin     |           |Password cannot be empty|

