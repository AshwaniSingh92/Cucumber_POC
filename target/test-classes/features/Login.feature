Feature: Logon to the browser with url



  @Login
  Scenario Outline: Create a Travel plan on cleartrip.com
    Given I want to load the browser <browser>
    When I enter the url <url> in step
    Then I verify the the <status> in step with the loaded url
    Then I start my journey from city <FromCity> to City <ToCity>
    Then I click Enter the date
    Then I click the search button

    Examples: 
      | url                          | browser  | status | FromCity | ToCity      |
      | "https://www.cleartrip.com/" | "chrome" | Pass   | "Goa"    | "Hyderabad" |
