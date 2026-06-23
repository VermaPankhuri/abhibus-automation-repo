Feature: Abhibus Bus Search

Scenario: Search cheapest AC bus

Given user opens abhibus website
When user enters source city
And user enters destination city
And user selects journey date
And user clicks search button
Then user applies AC filter
And user gets cheapest bus details