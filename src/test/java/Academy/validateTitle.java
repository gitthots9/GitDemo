package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Loggers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resource.base;

public class validateTitle extends base {
	
	public WebDriver driver;//created local copy for parallel execution
	public static  Logger log=LogManager.getLogger(base.class.getName());
	LandingPage l;
	
	@BeforeTest
	public void Initialise() throws IOException
	{
		//below method returns a driver 
				driver=initialiseDriver();
				log.info("initialised the DRIVER");
				
				driver.get(prop.getProperty("url"));
				log.info("launching the URL");
	}
	
	@Test
	public void landingtoHomePage() throws IOException
	{
		
		l=new LandingPage(driver);
		l.getTitle().getText();
		
		Assert.assertEquals(l.getTitle().getText(), "FEATUREDaaa COURSES123");
		log.info("Comparing");
		
		

	}
	
	
	@Test
	public void validateHeader() throws IOException
	{
		//not needed now--l as it is declared globally and got its lyf
	//	l=new LandingPage(driver);   
		l.getHeader().getText();
		
		Assert.assertEquals(l.getHeader().getText(), "An Academy to learn Everything about Testing");
		log.info("Validating");
		
		

	}
	
	@AfterTest
	public void TearDown()
	{
		driver.close();
	}
	
}