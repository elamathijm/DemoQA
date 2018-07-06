Feature: Demoqa registration page

Scenario: Verify fname field
Given The user is in demoqa reg page
When The user enters the firstname
Then The user validate the firstname

Scenario: Verify lname field
Given The user is in demoqa reg page
When The user enters the lastname
Then The user validate the lastname

Scenario: Verify Country
Given The user is in demoqa reg page
When The user selects the country as india
Then The user validate the selected country