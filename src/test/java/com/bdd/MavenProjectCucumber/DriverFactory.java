package com.bdd.MavenProjectCucumber;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	
	// Customized Browser Factory
	
public static  WebDriver driver;
	
	public DriverFactory(){			
		if( driver==null){
		intitalize();	
		
		}
	}	
	
	

		private static void intitalize() {		
			
   String browser = new PropertyReader().readProperty("browser");	        
      navigatebrowser(browser);
		
	}

		private static void navigatebrowser(String br){
	
			
	//Browser Initialization		
		if(br.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Repository\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5000l, TimeUnit.SECONDS);	
		}
		
		if(br.equals("ie")){			
		
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Repository\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5000l, TimeUnit.SECONDS);						
			
		}
		if(br.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Repository\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5000l, TimeUnit.SECONDS);
			
		}
		}
		
		
		public WebDriver getDriver(){
			
			return driver;
			
		}
		public void destroyDriver(){
			
			driver.quit();
		}
		
			
		public void getscreenshot(String e){
			
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Now you can do whatever you need to do with it, for example copy somewhere
			try {
				FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshots\\"+e+".png"));
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			
		}
	
		


}
