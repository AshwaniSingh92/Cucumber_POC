package com.bdd.MavenProjectCucumber;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class FlightsSelectionPage  {
	
	
	static WebDriver driver;
	
	public FlightsSelectionPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
         this.driver = driver;

	}
	
	//  Populating the flight rates
	
	@FindAll(@FindBy(how= How.XPATH,using=".//*[@id='flightForm']//table"))
	static List<WebElement> allElements;
	
	public  static void populate(){
		
			
		
		
		 HashMap<Integer, String> outerMap = new HashMap<Integer, String>();
		  
		    int i = 1;
		    
		    String Flight ;
		    String Price ;
		  
		    
		    
		    for(int j=1 ; j<=allElements.size();j++){
		    	
		    	if (j==6){
		    		 j++;
		    		 
		    		 	}
		    	if(j==16){
	    			 break;
	    		 }
		    	
		    	Flight = driver.findElement(By.xpath(".//*[@id='flightForm']//ul//li["+j+"]//th[1]//small")).getText();
		    	Price = driver.findElement(By.xpath(".//*[@id='flightForm']//ul//li["+j+"]//th[6]")).getText();
	    		String FP = Flight+":"+Price ;		    	
		    	outerMap.put(j, FP);		    		    	
		    	System.out.println(outerMap.get(j)); 
		    	
		    	if (j == 7)break;
		    	
		    }
		    
		    
		    
		return;
		
			
		
	}
	
	
	
	@FindBy(xpath=".//*[@id='ResultContainer_1_1']/section[2]/section/aside[1]/div/div[1]/p[2]/a/strong")WebElement farealert;

	public WebElement getFarealert() {
		return farealert;
	}



	private void setFarealert(WebElement farealert) {
		this.farealert = farealert;
	}
	
	
	
	
	
	

	

}
