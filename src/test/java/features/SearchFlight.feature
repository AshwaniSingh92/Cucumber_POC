Feature: Create a Travel Plan
	

@SearchFlight

Scenario: Search for flights on cleartrip.com
    Given I want to populate FlightRates
     When the fare seems high
     Then I close the fare alert
     
  
      
@Setalert
Scenario Outline: Set alert feature
	Given I start looking at the page
		When I directly click on the setalert button
		Then I verify that it asks me for entering the emailid
		Then I enter the email id<email> and phone number<phn>
		Then I confirm the alert is set with <email> and <phn>

 Examples: 
      |email| phn|      
      |jhs7845@a3juhtbcc.com|7845877849|
  