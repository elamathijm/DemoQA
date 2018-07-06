Feature: Demoqa registration page

Scenario Outline: Verify the firstname,lastname,phonenumber,username,email,password,confirmpassword
Given The user is in demoqa registration page
When The user enters the firstname "<fname>",lastname "<lname>",phonenumber "<phno>",username "<uname>",email "<email>",password "<pwd>",confirmpassword "<conpwd>"
Then The user validates the entered firstname "<fname>",lastname "<lname>", phonenumber "<phno>", username "<uname>", email "<email>",password "<pwd>",confirmpassword "<conpwd>"

Examples:
|fname|lname|phno|uname|email|pwd|conpwd|
|elamathi|manoharan|9500307566|elamathi|ela@gmail.com|456jm|456jm|
|sangavi|chandran|7845678900|sangavi|san@gmail.com|895rt|895rt|


@smoke
Scenario: Verify the marital status
Given The user is in demoqa registration page
When The user clicks the marital status
|Single|
Then The user validates the selected marital status


Scenario: Verify the hobby
Given The user is in demoqa registration page
When The user clicks the hobby
|Dance|Reading|
Then The user validates the selected hobbies


Scenario Outline: Verify the country,dateofbirth
Given The user is in demoqa registration page
When The user selects the country name "<country>" and dateofbirth month "<month>" , day "<day>" and year "<year>"
Then The user validates the selected country  "<country>" and dateofbirth month "<month>" , day "<day>" and year "<year>"

Examples:
|country|month|day|year|
|India|10|6|2000|
|Australia|11|22|1986|
