Feature: Login functionality on Automation Exercise site

  @DDT
  Scenario Outline: Verify login with valid and invalid credentials
    Given User navigates to the login page
    When User enters email "<email>" and password "<password>"
    And clicks on the login button
    Then User should see message "<expectedTitle>"

    Examples: 
      | email                    | password  | expectedTitle                        |
      | ytkunalpatil@gmail.com  | 12345678  | Automation Exercise                   |
      | invaliduser@test.com    | wrongpass | Automation Exercise - Signup / Login |
      | validuser@test.com      | somepass  | Automation Exercise - Signup / Login |
