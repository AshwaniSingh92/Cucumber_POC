package com.bdd.MavenProjectCucumber;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import junit.framework.Assert;




public class AppTest  
{
	
	
	static WebDriver driver;
	public static Logger logit = Logger.getLogger(AppTest.class);
	
	@Before
	public void setup(){
		
	
		this.driver = new DriverFactory().getDriver();		
		driver.manage().timeouts().implicitlyWait(50000l, TimeUnit.SECONDS);
		
		//Logger Object Configuration
		PropertyConfigurator.configure("src/test/java/resources/logprop.properties");	
		
		
	}
	

	

	
	@Given("^I want to load the browser \"(.*?)\"$")
	public void i_want_to_load_the_browser(String arg1) throws Throwable {
	   
		
		
		logit.info("################### New Session Initiated #########################");		
		logit.info("Browser Initiated");
		
		
		
	}

	@When("^I enter the url \"(.*?)\" in step$")
	public void i_enter_the_url_in_step(String arg1) throws Throwable {
	
		
		logit.info("Navigating to Cleartrip");
	driver.get(arg1);
	  
	}

	@Then("^I verify the the Pass in step with the loaded url$")
	public void i_verify_the_the_Pass_in_step_with_the_loaded_url() throws Throwable {
		
		
				
		Assert.assertTrue("Assert fails", ("https://www.cleartrip.com/").equals(driver.getCurrentUrl()));
		
		logit.info("Login Successful");
	   
	}

	
	


	@SuppressWarnings("deprecation")
	@Then("^I start my journey from city \"(.*?)\" to City \"(.*?)\"$")
	public void i_start_my_journey_from_city_to_City(String arg1, String arg2) throws Throwable {
		
		WebElement frm = new SearchPage(driver).getFromcity();
		
		logit.info("Entering Boarding Point ");
		
		frm.sendKeys(arg1);
		Thread.sleep(3000l);		
		
		
		
		Assert.assertTrue("Assert fails", frm.getAttribute("value").equals(arg1));
		
		WebElement to = new SearchPage(driver).getTocity();	
		to.sendKeys(arg2);
		
		logit.info("Entering Destination Point");
		
		Assert.assertTrue("Assert fails", to.getAttribute("value").equals(arg2));
		
		
		Assert.assertTrue("Assert fails", to.getAttribute("value").equals(arg2));
		
		Thread.sleep(3000l);
		
		logit.info("Entering Date");
		
		to.sendKeys(Keys.TAB);
		
		
	}

	@Then("^I click Enter the date$")
	public void i_click_Enter_the_date() throws Throwable {
		
		Thread.sleep(3000l);
		//new SearchPage(driver).getDatebox().click();
		
		driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[3]/td[3]/a")).click();
		Thread.sleep(3000l);
		
		
		logit.info("Selecting Adult Passengers");
		new SearchPage(driver).getSeladultcount().selectByIndex(2);
		Thread.sleep(3000l);	
		
	}
	   
	
	@Then("^I click the search button$")
	public void i_click_the_search_button() throws Throwable {
		
		
		logit.info("Clicking  Search");
		new SearchPage(driver).getSearch().click();
		//new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(new FlightsSelectionPage(driver).getFarealert()));
		
		
	    
	}

	
	
	
	/****************************************************************************************/
	
	@Given("^I want to populate FlightRates$")
	public void i_want_to_populate_FlightRates() throws Throwable {
	   
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(new FlightsSelectionPage(driver).getFarealert()));
		
		logit.info("Populating Flight rates");
		new FlightsSelectionPage(driver).populate();
		Thread.sleep(3000l);
		
		logit.info("Flight rates Populated");
		
	}

	@When("^the fare seems high$")
	public void the_fare_seems_high() throws Throwable {
	   
		logit.info("Navigating to Fare Alert");
		new FlightsSelectionPage(driver).getFarealert().click();
		Thread.sleep(3000l);
		
		
		
	}

	
	@Then("^I close the fare alert$")
	public void i_close_the_fare_alert() throws Throwable {
		
		logit.info("Attempting to close Frame");
		
		Thread.sleep(3000l);
		try{
			new FareAlert(driver).getClosebutn().click(); //Willingly creating an exception scenario clicking without switching to it
			logit.info("Frame Closed");
			}catch(Throwable e){
				
				logit.info("Closing frame ended in exception retrying to Close Frame");
				driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
				driver.switchTo().parentFrame();
				logit.info("Frame closed ");
				
				
				
			}
		
		
		
		
	}




	

	
/*****************************************************************************************/
	
	 @Given("^I start looking at the page$")
	    public void i_start_looking_at_the_page() throws Throwable {
	       
		 Thread.sleep(3000l);
		 driver.switchTo().parentFrame();
		 logit.info("Reopening the Fare Click");
		 new FlightsSelectionPage(driver).getFarealert().click();
		 logit.info("Clicked on Setting up Fare");   
		 Thread.sleep(3000l);
	    }

	    @When("^I directly click on the setalert button$")
	    public void i_directly_click_on_the_setalert_button() throws Throwable {

	    	
	    	
	    	logit.info("Switched to frame");
	    	driver.switchTo().frame("modal_window");
	    	
	    	logit.info("Clicking on Set Alert");
	    	driver.switchTo().activeElement();
	    	
	    	
	    	new FareAlert(driver).getSalrt().click();
	    	
	    	
	    	
	    	
	    	 Thread.sleep(3000l);
	    	
	    	
	    	
	    }

	    @Then("^I verify that it asks me for entering the emailid$")
	    public void i_verify_that_it_asks_me_for_entering_the_emailid() throws Throwable {


	    	logit.info("Asserting email is required");
	    	
	    	Assert.assertTrue("Assert fails", new FareAlert(driver).getEmailrequired().getText().equals("Email is a required field"));
	    	
	     	Thread.sleep(3000l);
	    	
	    }

	    @Then("^I enter the email id(.+) and phone number(.+)$")
	    public void i_enter_the_email_id_and_phone_number(String email, String phn) throws Throwable {


	    	logit.info("Entering Email ID");
	    	new FareAlert(driver).getMailboxid().sendKeys(email);
	    	Thread.sleep(3000l);
	    	logit.info("Entering Phone Number");
	    	new FareAlert(driver).getPhnnum().sendKeys(phn);
	    	Thread.sleep(3000l);
	    	
	    	
	    	
	    }
		
	   
	    
	    @Then("^I confirm the alert is set with (.+) and (.+)$")
	    public void i_confirm_the_alert_is_set_with_and(String email, String phn) throws Throwable {
	        
	    	 logit.info("Clicking on SetAlert");  
	    	new FareAlert(driver).getSalrt().click();
	    	Thread.sleep(3000l);
	    	
	    	Assert.assertTrue("Assert fails", new FareAlert(driver).getConfirmation().getText().equals("Great, we've set your alert"));
	    	
	    	logit.info("Confirmation Message:"+new FareAlert(driver).getConfirmation().getText());
	    	
	    	
	    	Thread.sleep(3000l);
	    	
	    	logit.info("Asserting EmailID");
	    	Assert.assertTrue("Assert fails", new FareAlert(driver).getEnteredmail().getText().equals(email));
	    	
	    	logit.info("Entered Mail ID:"+email+": Received Mail Id From Frame:"+new FareAlert(driver).getEnteredmail().getText());
	    	
	    	
	    	logit.info("Asserting Phone Num");
	    	Thread.sleep(3000l);
	    	Assert.assertTrue("Assert fails", new FareAlert(driver).enterednum.getText().equals(phn));
	    	
	    	logit.info("Entered Phone:"+phn+": Received Phone number:"+new FareAlert(driver).enterednum.getText());
	    	
	    	logit.info("Alert Set Successfully");
	    	
	    	Thread.sleep(3000l);
	    	
	    	logit.info("Closing the Frame");
	    	new FareAlert(driver).getClosealert().click();
	    	Thread.sleep(3000l);    	
	    	
	    	logit.info("Switching to Parent Frame");
	    	driver.switchTo().parentFrame();    	
	    	
	    	
	    	logit.info("Quitting Driver");
		    new DriverFactory().destroyDriver();
	    	
	      	
	    }  
	    
	   


	
    
    }
    

	

