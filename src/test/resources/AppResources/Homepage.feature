Feature: Home page functionality
Scenario: validate title of page
Given user is at the amazonhome page
Then page title should contains "Shopping"

Scenario: Validate cart icon
Given user is at the amazonhome page
Then cart icon should get display

Scenario: Validate search mobile
Given user is at the amazonhome page
When user search "mobile" from text field
Then user should see mobiles
When user click on mobile
Then mobile page should get open