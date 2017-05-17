package com.bdd.MavenProjectCucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FareAlert {
	
	
	WebDriver driver;
	
public FareAlert(WebDriver driver) {		
		
	this.driver = driver;
	
	//This initializes the Page Objects for the Frames
		PageFactory.initElements(driver, this);		
		driver.manage().timeouts().implicitlyWait(5000l, TimeUnit.SECONDS);
		
		
	}


	
public WebElement getSetalert() {
		return setalert;
	}

 

private void setSetalert(WebElement setalert) {
		this.setalert = setalert;
	}


	public WebElement getEmailrequired() {
		return emailrequired;
	}


	private void setEmailrequired(WebElement emailrequired) {
		this.emailrequired = emailrequired;
	}


	public WebElement getMailboxid() {
		return mailboxid;
	}


	private void setMailboxid(WebElement mailboxid) {
		this.mailboxid = mailboxid;
	}


	public WebElement getPhnnum() {
		return phnnum;
	}


	private void setPhnnum(WebElement phnnum) {
		this.phnnum = phnnum;
	}


	public WebElement getClosebutn() {
		return closebutn;
	}


	private void setClosebutn(WebElement closebutn) {
		this.closebutn = closebutn;
	}


	public WebElement getEnteredmail() {
		return enteredmail;
	}


	private void setEnteredmail(WebElement enteredmail) {
		this.enteredmail = enteredmail;
	}


	public WebElement getEnterednum() {
		return enterednum;
	}


	private void setEnterednum(WebElement enterednum) {
		this.enterednum = enterednum;
	}


	public WebElement getConfirmation() {
		return confirmation;
	}


	private void setConfirmation(WebElement confirmation) {
		this.confirmation = confirmation;
	}



@FindBy(xpath=".//*[@id='ResultContainer_1_1']/section[2]/section/aside[1]/div/div[1]/p[2]/a/strong")WebElement setalert;



//Initializing frame Objects
@FindBy(id="sfa_form_btn")
@CacheLookup
WebElement salrt;


@FindBy(xpath=".//div[@id='ContentFrame clearfix']")private WebElement frame;

public WebElement getFrame() {
	return frame;
}



public void setFrame(WebElement frame) {
	this.frame = frame;
}



public WebElement getSalrt() {
	return salrt;
}


private void setSalrt(WebElement salrt) {
	this.salrt = salrt;
}


@FindBy(xpath=".//*[@id='email-error']")WebElement emailrequired;


@FindBy(xpath=".//*[@id='email']") WebElement mailboxid;


@FindBy(xpath= ".//*[@id='mobile']")WebElement phnnum;


@FindBy(xpath=".//*[@id='close']")WebElement closebutn;

@FindBy(xpath=".//*[@id='sfa_text']/dl/dd[1]")WebElement enteredmail;

@FindBy(xpath= ".//*[@id='sfa_text']/dl/dd[2]")WebElement enterednum;


@FindBy(xpath = ".//*[@id='alertStatus']/div[1]/h3")WebElement confirmation;

@FindBy(xpath=".//*[@id='close-modal']")WebElement closealert;

public WebElement getClosealert() {
	return closealert;
}


private void setClosealert(WebElement closealert) {
	this.closealert = closealert;
}












	

}
