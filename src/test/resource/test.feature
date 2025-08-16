Feature: Login Functionality

@test
Scenario Outline: Login in the site
  Given agent enters "<username>" and "<password>" and logins
  Then agent performs tasks on practice page

Examples:
  | username | password |
  | test@email.com   | abcabc   |

@test
Scenario: Test e-commerse website of lets code it
Given agent enters "test@email.com" and "abcabc" and logins
Then enter into ecom website

  
  

 