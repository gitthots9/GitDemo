package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resource.base;

public class validateNavigationBar extends base {
	
	public WebDriver driver;//created local copy for parallel execution
	public static  Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void Initialise() throws IOException
	{
		//below method returns a driver 
				driver=initialiseDriver();
				
				driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void landingtoHomePage() throws IOException
	{
		
		
		LandingPage l=new LandingPage(driver);
		

		
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("navigation happening");

	}
	

	@AfterTest
	public void TearDown()
	{
		driver.close();
	}
}