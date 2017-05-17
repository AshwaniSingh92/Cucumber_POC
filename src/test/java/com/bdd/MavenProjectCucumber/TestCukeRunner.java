package com.bdd.MavenProjectCucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
        tags={"@Login,@SearchFlight,@Setalert"})
		

public class TestCukeRunner 
{
   
	
	
	
}
