Feature: feature to test google search functionality

Scenario: Validate Google Search is working

Given browser is open
And user is on google Search page
When user enters a text in search box
And hits enter
Then user is navigated search results
