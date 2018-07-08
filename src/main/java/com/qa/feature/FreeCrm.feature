Feature: FreeCRM Application test

Scenario: FreeCrm Homepage testing

Given User launch browser
Then user is on the login page
Then user enters Username and Password
Then Validate the title of the home page
Then validate the login username
Then click on the new contact