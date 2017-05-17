package com.bdd.MavenProjectCucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class SearchPage {

	WebDriver driver;
	
	public SearchPage(WebDriver driver) {		
		
		
		//Initialising the POM elements
		PageFactory.initElements(driver, this);		
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(5000l, TimeUnit.SECONDS);
	}

	@FindBy(xpath=".//input[@id='FromTag']")	
	@CacheLookup
	private  WebElement fromcity;
	
	@FindBy(xpath=".//input[@id='ToTag']")
	@CacheLookup
	private  WebElement tocity;
	
	
	@FindBy(id=".//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[3]/td[3]/a")
	@CacheLookup
	private  WebElement datebox;
	
	
	@FindBy(xpath=".//*[@id='Adults']")
	@CacheLookup
	private WebElement seladultcount;
	
	
	@FindBy(xpath=".//*[@id='SearchBtn']")
	@CacheLookup
	private  WebElement search;

	public WebDriver getDriver() {
		return driver;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	public  WebElement getFromcity() {
		return fromcity;
	}


	public void setFromcity(WebElement fromcity) {
		this.fromcity = fromcity;
	}


	public  WebElement getTocity() {
		return tocity;
	}


	public void setTocity(WebElement tocity) {
		this.tocity = tocity;
	}


	public  WebElement getDatebox() {
		return datebox;
	}


	public void setDatebox(WebElement datebox) {
		this.datebox = datebox;
	}


	public Select getSeladultcount() {
		
		Select ab = new Select(seladultcount);		
		return ab;
	}


	public void setSeladultcount(WebElement seladultcount) {
		
		
		this.seladultcount = seladultcount;
	}


	public  WebElement getSearch() {
		return search;
	}


	public void setSearch(WebElement search) {
		this.search = search;
	}

	

	
	
	
	
	
	
	
	
	
	
}
